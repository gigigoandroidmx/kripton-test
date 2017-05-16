package gigigo.com.kmvp;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

/**
 * Defines the Activity with base functionality, must be inherited from {@link AppCompatActivity}
 *
 * @author Juan Godínez Vera - 15/05/2017
 * @version 2.0.0
 * @since 2.0.0
 */
public abstract class KActivity
        extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, FragmentManager.OnBackStackChangedListener{

    private DrawerLayout drawer;
    private Toolbar mToolbar;
    private ActionBarDrawerToggle toggle;
    private NavigationManager mNavigationManager;
    private int idFragmentContainer = 0;
    private InputMethodManager inputMethodManager;
    private NavigationView mNavigationView;

    @LayoutRes
    protected abstract int getLayoutResourceId();
    protected abstract void onBindView();
    protected abstract void onUnbindView();

    protected abstract void initToolbar();
    protected abstract int getFragmentContainerId();

    //region Handling the Activity Lifecycle

    // -------------------------------------------------------
    // ----------------------- Created -----------------------
    // -------------------------------------------------------
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResourceId());
        setIdFragmentContainer(getFragmentContainerId());
        onBindView();

        inputMethodManager = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        getSupportFragmentManager().addOnBackStackChangedListener(this);
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        onUnbindView();
    }

    //Onbackpressed method from back listener
    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            closeDrawer();
        } else {
            super.onBackPressed();
        }
    }


    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here
        return true;
    }

    @Override
    public void onBackStackChanged() {
        if(getSupportFragmentManager().getBackStackEntryCount() > 0){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }else {
            getSupportActionBar().setDisplayHomeAsUpEnabled(false);
            toggle.syncState();
        }
    }

    public void closeDrawer(){
        if (drawer != null){
            drawer.closeDrawer(GravityCompat.START);
        }
    }

    public void hidekeyboard() {
        if (mToolbar != null)
            inputMethodManager.hideSoftInputFromWindow(mToolbar.getWindowToken(), 0);
    }

    public void initDrawerToggle (DrawerLayout drawerLayout, NavigationView navigationView){
        this.mNavigationView = navigationView;
        mNavigationView.setNavigationItemSelectedListener(this);

        drawer = drawerLayout;
        toggle = new ActionBarDrawerToggle(this, drawer, mToolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(getSupportFragmentManager().getBackStackEntryCount() > 0){
                    getSupportFragmentManager().popBackStack();
                }else {
                    drawer.openDrawer(GravityCompat.START);
                }
            }
        });
    }

    /**
     * Getter and Setter Methods
     * **/

    public NavigationManager getNavigationManager() {
        return mNavigationManager;
    }

    public void setNavigationManager(NavigationManager mNavigationManager) {
        this.mNavigationManager = mNavigationManager;
    }

    public int getIdFragmentContainer() {
        return idFragmentContainer;
    }

    public void setToolbar(Toolbar toolbar){
        this.mToolbar = toolbar;
        setSupportActionBar(mToolbar);
    }

    public Toolbar getToolbar(){
        return mToolbar;
    }

    public void setIdFragmentContainer(@IdRes int idFragmentContainer) {
        this.idFragmentContainer = idFragmentContainer;
    }

    public DrawerLayout getDrawer() {
        return drawer;
    }

    public void setDrawer(DrawerLayout drawer) {
        this.drawer = drawer;
    }

    public ActionBarDrawerToggle getToggle() {
        return toggle;
    }

    public void setToggle(ActionBarDrawerToggle toggle) {
        this.toggle = toggle;
    }

    public void setNavigationView(NavigationView navigationView){
        this.mNavigationView = navigationView;
        mNavigationView.setNavigationItemSelectedListener(this);
    }

    //endregion
}
