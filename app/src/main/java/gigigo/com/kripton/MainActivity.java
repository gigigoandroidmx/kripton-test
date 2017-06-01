package gigigo.com.kripton;

import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import gigigo.com.kmvp.KActivity;
import gigigo.com.kmvp.KNavigationManager;

public class MainActivity
        extends KActivity {

    private DrawerLayout mDrawer;
    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResourceId());
        initToolbar();

        mDrawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        initDrawerToggle(mDrawer, navigationView);

        //Initialize KNavigationManager and id container
        setNavigationManager(new KNavigationManager(getSupportFragmentManager()));

        //Select First menu position
        navigationView.getMenu().getItem(0).setChecked(true);
        onNavigationItemSelected(navigationView.getMenu().getItem(0));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.nav_camera:
                getNavigationManager().openAsRoot(HomeFragmentTest.newInstance(), getIdFragmentContainer());
                break;
            case R.id.nav_gallery:
                break;
            case R.id.nav_slideshow:
                break;
            case R.id.nav_manage:
                break;
            case R.id.nav_share:
                break;
            case R.id.nav_send:
                break;
        }

        closeDrawer();

        return true;
    }

    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_main_test;
    }

    @Override
    protected void onInitilize() { }

    @Override
    protected void onBindView() {

    }

    @Override
    protected void onUnbindView() {

    }

    @Override
    public void initToolbar() {
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setToolbar(mToolbar);
    }

    @Override
    protected int getFragmentContainerId() {
        return R.id.content_main;
    }
}
