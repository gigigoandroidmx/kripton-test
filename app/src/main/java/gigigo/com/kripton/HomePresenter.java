package gigigo.com.kripton;

import gigigo.com.kmvp.KPresenter;

/**
 * @author Juan Godínez Vera - 4/28/2017.
 */
public class HomePresenter
        extends KPresenter<IViewHome> {

    public void getMessage() {
        getView().showMessage("Hello Kripton 2.0!");
    }
}
