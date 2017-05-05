package gigigo.com.kripton;

import gigigo.com.kmvp.IView;

/**
 * @author Juan Godínez Vera - 5/5/2017.
 */
public interface IViewBase
        extends IView {
    void showError(Throwable exception);
    void showProgressIndicator(boolean active);
}
