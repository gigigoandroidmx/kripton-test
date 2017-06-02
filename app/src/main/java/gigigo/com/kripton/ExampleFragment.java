package gigigo.com.kripton;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import gigigo.com.kmvp.KSimpleFragment;

/**
 * Created by ajea on 02/06/17.
 */

public class ExampleFragment extends KSimpleFragment implements View.OnClickListener{

    public static ExampleFragment newInstance(){
        ExampleFragment mFragment = new ExampleFragment();
        return mFragment;
    }

    private Button mButtomDetail;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View mView = inflater.inflate(getLayoutResourceId(), container, false);
        mButtomDetail = (Button) mView.findViewById(R.id.bt_home_detail);
        mButtomDetail.setOnClickListener(this);
        return mView;
    }

    @Override
    protected int getLayoutResourceId() {
        return R.layout.example_fragment;
    }

    @Override
    protected void onBindView(View root) {

    }

    @Override
    protected void onUnbindView() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.bt_home_detail:
                if (mNavigationFragmentListener != null){
                    mNavigationFragmentListener.addFragmentBackstack(HomeFragmentTest.newInstance());
                }
                break;
        }
    }
}
