package gigigo.com.kripton;

import gigigo.com.kmvp.KPresenter;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;


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
            this.interactor.refreshData();
        }

        String message = this.interactor.execute();

        getView().showMessage(message);


//        this.interactor.getMessage("Juan")
//                .observeOn(AndroidSchedulers.mainThread())
    }
}
