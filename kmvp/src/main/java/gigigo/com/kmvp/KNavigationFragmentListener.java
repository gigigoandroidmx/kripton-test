package gigigo.com.kmvp;

import android.support.v4.app.Fragment;

/**
 * Created by ajea on 17/05/17.
 */

public interface KNavigationFragmentListener {
    public void addFragmentBackstack(Fragment fragment);
    public void replaceFragment(Fragment fragment);
}
