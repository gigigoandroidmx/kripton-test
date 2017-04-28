package gigigo.com.kripton;

import android.view.View;
import android.widget.TextView;

import gigigo.com.kmvp.KFragment;


public class HomeFragment
        extends KFragment<IViewHome, HomePresenter>
        implements IViewHome {

    TextView textViewMessage;

    @Override
    public void onResume() {
        super.onResume();
        presenter.getMessage();
    }

    @Override
    protected int getLayoutResourceId() {
        return R.layout.fragment_home;
    }

    @Override
    protected void onBindView(View root) {
        textViewMessage = (TextView) root.findViewById(R.id.textview_message);
    }

    @Override
    protected void onUnbindView() { }

    @Override
    protected HomePresenter createPresenter() {
        return new HomePresenter();
    }

    @Override
    public void showMessage(String message) {
        textViewMessage.setText(message);
    }
}
