package utilities;

/**
 * Created by Kiran on 3/5/18.
 */
public enum API {
    SCHEDULE("8210","/slate/v1/schedules");

    private String port;
    private String path;
    API(String port, String path) {
        this.port = port;
        this.path = path;
    }

    public String getPort() {
        return port;
    }

    public String getPath() {
        return path;
    }
}
