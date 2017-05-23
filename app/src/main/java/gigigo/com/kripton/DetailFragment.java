package gigigo.com.kripton;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import gigigo.com.kmvp.IPresenter;
import gigigo.com.kmvp.IView;
import gigigo.com.kmvp.KFragment;
import gigigo.com.kmvp.KSimpleFragment;

/**
 * Created by ajea on 10/05/17.
 */

public class DetailFragment extends KSimpleFragment {

    public static DetailFragment newInstance(){
        DetailFragment fragment = new DetailFragment();
        return fragment;
    }

    @Override
    protected int getLayoutResourceId() {
        return R.layout.detail_fragment;
    }

    @Override
    protected void onBindView(View root) {

    }

    @Override
    protected void onUnbindView() {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View mView = inflater.inflate(getLayoutResourceId(), container, false);

        return mView;
    }


}
