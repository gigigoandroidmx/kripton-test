package gigigo.com.kripton;

import gigigo.com.kmvp.KInteractor;

/**
 * @author Juan Godínez Vera - 5/2/2017.
 */
public class HomeInteractor
        extends KInteractor {

    private String data;

    @Override
    public void refreshData() {
        data = null;
    }

    public String getMessage() {
        return "Hello Kripton 2.0!!!";
    }
}
