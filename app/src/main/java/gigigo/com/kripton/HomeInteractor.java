package gigigo.com.kripton;

import gigigo.com.kmvp.Interactor;

/**
 * @author Juan Godínez Vera - 5/2/2017.
 */
public class HomeInteractor
        extends Interactor {

    private String data;

    /**
     * Defines the method to be called when the presenter invokes the data source
     *
     * @return the actual data type
     */
    @Override
    public <T> T execute() {
        if(data == null) {
            data = "Hello Kripton 2.0!!!";
        }
        return (T) data;
    }

    @Override
    public void refreshData() {
        data = null;
    }

    public String getMessage(String name) {
        String n = tryGetParamValueAs(String.class, 0);

        return "Hello Kripton 2.0!!!";
    }
}
