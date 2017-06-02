package gigigo.com.kripton;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import gigigo.com.kmvp.KSimpleFragment;

/**
 * Created by ajea on 10/05/17.
 */

public class HomeFragmentTest extends KSimpleFragment implements View.OnClickListener{

    public static HomeFragmentTest newInstance(){
        HomeFragmentTest mFragment = new HomeFragmentTest();
        return mFragment;
    }

    private Button mButtomDetail;

    @Override
    protected int getLayoutResourceId() {
        return R.layout.home_fragment;
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
        mButtomDetail = (Button) mView.findViewById(R.id.bt_home_detail);
        mButtomDetail.setOnClickListener(this);

        return mView;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.bt_home_detail:
                if (mNavigationFragmentListener != null){
//                    mNavigationFragmentListener.addFragmentBackstack(DetailFragment.newInstance());
                    mNavigationFragmentListener.showActivity(DetailActivity.class);
                }
//                getNavigationManager().addFragmentToBackStack(DetailFragment.newInstance(), getFragmentIdContainer());
                break;
        }
    }

}
