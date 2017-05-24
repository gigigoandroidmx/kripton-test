package gigigo.com.kripton;

import gigigo.com.kmvp.KPresenter;


/**
 * @author Juan Godínez Vera - 4/28/2017.
 */
public class HomePresenter
        extends KPresenter<IViewHome> {


    private final HomeInteractor interactor;

    public HomePresenter(HomeInteractor interactor) {
        this.interactor = interactor;
    }

    public void getMessage() {
        if(!isViewAttached()) return;

        getView().showProgressIndicator(true);

        if(isForceUpdate()) {
            interactor.refreshData();
        }

        getView().showMessage(interactor.getMessage());

    }
}
