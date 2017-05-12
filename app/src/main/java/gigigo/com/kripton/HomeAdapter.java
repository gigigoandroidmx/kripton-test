package gigigo.com.kripton;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import gigigo.com.kmvp.KAdapterHF;
import gigigo.com.kmvp.KViewHolder;

/**
 * @author Juan Godínez Vera - 5/2/2017.
 */
public class HomeAdapter
        extends KAdapterHF<String> {

    public HomeAdapter(Context context) {
        super(context);
    }

    /**
     * Called when RecyclerView needs a new item of the given type.
     */

    @Override
    public KViewHolder<String> onCreateViewHolderHF(ViewGroup parent, int viewType) {
        View view = getView(parent, R.layout.item_home);
        HomeViewHolder viewHolder = new HomeViewHolder(view);
        return viewHolder;
    }
}
