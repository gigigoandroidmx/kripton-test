package gigigo.com.kripton;

import gigigo.com.kmvp.IExecutor;
import gigigo.com.kmvp.KInteractor;

/**
 * @author Juan Godínez Vera - 5/2/2017.
 */
public class HomeInteractor
        extends KInteractor {

    private String data;
    private IExecutor executor;


    @Override
    public void run() {

    }

    public String getMessage() {
        return "Hello Kripton 2.0!!!";
    }
}
