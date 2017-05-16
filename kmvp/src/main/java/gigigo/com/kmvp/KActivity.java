package gigigo.com.kmvp;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Defines the Activity with base functionality, must be inherited from {@link AppCompatActivity}
 *
 * @author Juan Godínez Vera - 15/05/2017
 * @version 2.0.0
 * @since 2.0.0
 */
public abstract class KActivity
        extends AppCompatActivity {

    @LayoutRes
    protected abstract int getLayoutResourceId();
    protected abstract void onBindView();
    protected abstract void onUnbindView();

    //region Handling the Activity Lifecycle

    // -------------------------------------------------------
    // ----------------------- Created -----------------------
    // -------------------------------------------------------
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResourceId());
        onBindView();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        onUnbindView();
    }

    //endregion
}
