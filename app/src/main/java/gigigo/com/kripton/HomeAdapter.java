package gigigo.com.kripton;

import android.view.View;
import android.view.ViewGroup;

import gigigo.com.kmvp.KHeaderFooterAdapter;
import gigigo.com.kmvp.KViewHolder;

/**
 * @author Juan Godínez Vera - 5/2/2017.
 */
public class HomeAdapter
        extends KHeaderFooterAdapter<String, KViewHolder<String>> {

    @Override
    public KViewHolder<String> onCreateViewHolderHeaderFooter(ViewGroup parent, int viewType) {
        View view = getView(parent, R.layout.item_home);
        HomeViewHolder viewHolder = new HomeViewHolder(view);
        return viewHolder;
    }
}