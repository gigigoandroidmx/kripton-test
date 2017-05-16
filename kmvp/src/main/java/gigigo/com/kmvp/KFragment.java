package gigigo.com.kmvp;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.lang.reflect.ParameterizedType;

/**
 * Defines the Fragment with base functionality, must be inherited from {@link Fragment}
 *
 * @param <V> view interface, must be inherited from {@link IView}
 * @param <P> presenter interface, must be inherited from {@link IPresenter}
 *
 * @author Juan Godínez Vera - 28/04/2017
 * @version 2.0.0
 * @since 1.0.0
 */
public abstract class KFragment<V extends IView, P extends IPresenter<V>>
        extends Fragment {

    protected P presenter;

    @LayoutRes
    protected abstract int getLayoutResourceId();
    protected abstract void onBindView(View root);
    protected abstract void onUnbindView();
    protected abstract P createPresenter();

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

        if(presenter == null)
            presenter = createPresenter();

        if(!(this instanceof IView))
            throw new ClassCastException("The fragment must implement IView. This is required by the presenter.");

        presenter.attachView((V) this);
    }

    // -------------------------------------------------------
    // ---------------------- Destroyed ----------------------
    // -------------------------------------------------------
    @Override
    public void onDestroy() {
        super.onDestroy();

        if(presenter != null)
            presenter.detachView();

        onUnbindView();
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    //endregion
}
