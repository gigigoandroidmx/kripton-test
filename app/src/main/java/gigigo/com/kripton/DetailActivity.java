package gigigo.com.kripton;

import android.os.Bundle;
import android.support.annotation.Nullable;

import gigigo.com.kmvp.KActivity;
import gigigo.com.kmvp.KNavigationManager;

/**
 * Created by ajea on 02/06/17.
 */

public class DetailActivity extends KActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResourceId());

        //Initialize KNavigationManager and id container
        setNavigationManager(new KNavigationManager(getSupportFragmentManager()));

        getNavigationManager().replaceFragment(ExampleFragment.newInstance(), getIdFragmentContainer());
    }

    @Override
    protected int getLayoutResourceId() {
        return R.layout.detail_fragment;
    }

    @Override
    protected void onInitilize() {

    }

    @Override
    protected void onBindView() {

    }

    @Override
    protected void onUnbindView() {

    }

    @Override
    protected void initToolbar() {

    }

    @Override
    protected int getFragmentContainerId() {
        return R.id.detail_content;
    }
}
