package gigigo.com.kripton;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

import gigigo.com.kmvp.IPredicate;
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
        presenter.forceUpdate(true);
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

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),
                LinearLayoutManager.VERTICAL,
                false));

        adapter = new HomeAdapter();
        recyclerView.setAdapter(adapter);

        //add header
        View headerView = LayoutInflater.from(getActivity()).inflate(R.layout.item_home_header, recyclerView, false);
        adapter.setHeaderView(headerView);

        View footerrView = LayoutInflater.from(getActivity()).inflate(R.layout.item_home_footer, recyclerView, false);
        adapter.setFooterView(footerrView);
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

       String[] sdata = { "Hello", "World!", "How", "Are", "You" };
       adapter.set(sdata);


        //adapter.addRange(Arrays.asList("Hello", "World!", "How", "Are", "You", "Hello2", "World!2", "How2", "Are2", "You2"));

        Iterable<String> s = adapter.where(new IPredicate<String>() {
            @Override
            public boolean apply(String type) {
                return type.contains("H");
            }
        });

        if(s != null) {

        }

        ArrayList<String> arrayList = new ArrayList<>();
        for (int i= 0; i < 50; i++) {
            arrayList.add(String.valueOf(i));
        }

        adapter.addRange(arrayList);
    }

    @Override
    public void showError(Throwable exception) {

    }

    @Override
    public void showProgressIndicator(boolean active) {

    }
}
