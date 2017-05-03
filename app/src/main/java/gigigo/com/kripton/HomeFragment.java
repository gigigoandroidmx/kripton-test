package gigigo.com.kripton;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import java.util.Arrays;
import java.util.Iterator;

import gigigo.com.kmvp.IPredicate;
import gigigo.com.kmvp.KAdapter;
import gigigo.com.kmvp.KFragment;


public class HomeFragment
        extends KFragment<IViewHome, HomePresenter>
        implements IViewHome {

    TextView textViewMessage;
    RecyclerView recyclerView;
    HomeAdapter adapter;

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
        recyclerView = (RecyclerView) root.findViewById(R.id.recyclerview);

        adapter = new HomeAdapter();
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),
                LinearLayoutManager.VERTICAL,
                false));
        recyclerView.setAdapter(adapter);
    }

    @Override
    protected void onUnbindView() { }

    @Override
    protected HomePresenter createPresenter() {
        return new HomePresenter(new HomeInteractor());
    }

    @Override
    public void showMessage(String message) {
        textViewMessage.setText(message);
        adapter.clear();
        adapter.addRange(Arrays.asList("Hello", "World!", "How", "Are", "You", "Hello2", "World!2", "How2", "Are2", "You2"));

        Iterable<String> s = adapter.where(new IPredicate<String>() {
            @Override
            public boolean apply(String type) {
                return type.contains("H");
            }
        });

        if(s != null) {

        }
    }
}
