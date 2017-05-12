package gigigo.com.kmvp;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by adan.gutierrez on 10/05/17.
 */

public  abstract class KBaseAdapterHF<T, VH extends KViewHolder<T>> extends KAdapter<T> {

    public KBaseAdapterHF(Context context) {
        super(context);
    }

    private static final int TYPE_HEADER = Integer.MAX_VALUE;
    private static final int TYPE_FOOTER = Integer.MAX_VALUE - 1;
    private static final int ITEM_MAX_TYPE = Integer.MAX_VALUE - 2;
    private KViewHolder<T> headerViewHolder;
    private KViewHolder<T> footerViewHolder;

    class HFViewHolder extends KViewHolder<T> {
        HFViewHolder(View v) {
            super(v);
        }
    }

    public void setHeaderView(View header){
        if (headerViewHolder == null || header != headerViewHolder.itemView) {
            headerViewHolder = new HFViewHolder(header);
            notifyDataSetChanged();
        }
    }

    public void setFooterView(View foot){
        if (footerViewHolder == null || foot != footerViewHolder.itemView) {
            footerViewHolder = new HFViewHolder(foot);
            notifyDataSetChanged();
        }
    }

    public void removeHeader(){
        if (headerViewHolder != null){
            headerViewHolder = null;
            notifyDataSetChanged();
        }
    }
    public void removeFooter(){
        if (footerViewHolder != null){
            footerViewHolder = null;
            notifyDataSetChanged();
        }
    }

    private boolean isHeader(int position){
        return hasHeader() && position == 0;
    }

    private boolean isFooter(int position){
        return hasFooter() && position == getDataItemCount() + (hasHeader() ? 1 : 0);
    }

    private int itemPositionInData(int rvPosition){
        return rvPosition - (hasHeader() ? 1 : 0);
    }

    private int itemPositionInRV(int dataPosition){
        return dataPosition + (hasHeader() ? 1 : 0);
    }

    @Override
    public void notifyItemInsertedHF(int itemPosition) {
        notifyItemInserted(itemPositionInRV(itemPosition));
    }
    @Override
    public void notifyItemRemovedHF(int itemPosition) {
        notifyItemRemoved(itemPositionInRV(itemPosition));
    }

    @Override
    public void notifyItemChangedHF(int itemPosition) {
        notifyItemChanged(itemPositionInRV(itemPosition));
    }

    @Override
    public KViewHolder<T> onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == TYPE_HEADER) {
            return headerViewHolder;
        } else if (viewType == TYPE_FOOTER) {
            return footerViewHolder;
        }
        return onCreateViewHolderHF(parent, viewType);
    }

    @Override
    public void onBindViewHolder(KViewHolder<T> holder, int position) {
        if (!isHeader(position) && !isFooter(position))
            onBindDataItemViewHolder((VH)holder, itemPositionInData(position));
    }

    @Override
    public int getItemCount() {
        int itemCount = getDataItemCount();
        if (hasHeader()) {
            itemCount += 1;
        }
        if (hasFooter()) {
            itemCount += 1;
        }
        return itemCount;
    }

    @Override
    public int getItemViewType(int position) {
        if (isHeader(position)) {
            return TYPE_HEADER;
        }
        if (isFooter(position)) {
            return TYPE_FOOTER;
        }
        int dataItemType = getDataItemType(itemPositionInData(position));
        if (dataItemType > ITEM_MAX_TYPE) {
            throw new IllegalStateException("getDataItemType() must be less than " + ITEM_MAX_TYPE + ".");
        }
        return dataItemType;
    }

    public int getDataItemCount() {
        return super.getItemCount();
    }

    /**
     * make sure your dataItemType < Integer.MAX_VALUE-1
     *
     * @param position item view position in rv
     * @return item viewType
     */
    public int getDataItemType(int position){
        return 0;
    }

    public boolean hasHeader(){
        return headerViewHolder != null;
    }

    public boolean hasFooter(){
        return footerViewHolder != null;
    }

    public abstract VH onCreateViewHolderHF(ViewGroup parent, int viewType);

    public abstract void onBindDataItemViewHolder(VH holder, int position);
}
