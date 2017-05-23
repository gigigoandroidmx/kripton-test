package gigigo.com.kmvp;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Defines the Fragment with base functionality, must be inherited from {@link Fragment}
 *
 * @author Alan Espinosa - 16/05/2017
 * @version 2.0.0
 */
public abstract class KSimpleFragment
        extends Fragment {

    @LayoutRes
    protected abstract int getLayoutResourceId();
    protected abstract void onBindView(View root);
    protected abstract void onUnbindView();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(getLayoutResourceId(), container, false);
        onBindView(root);
        return root;
    }

    //region Handling Lifecycle Fragment

    // -------------------------------------------------------
    // ----------------------- Created -----------------------
    // -------------------------------------------------------
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }

    // -------------------------------------------------------
    // ---------------------- Destroyed ----------------------
    // -------------------------------------------------------
    @Override
    public void onDestroy() {
        super.onDestroy();

        onUnbindView();
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }


    public NavigationManager getNavigationManager(){
        return ((KActivity)getActivity()).getNavigationManager();
    }

    public int getFragmentIdContainer(){
        return ((KActivity)getActivity()).getIdFragmentContainer();
    }
    //endregion
}
