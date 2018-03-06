package utilities;

import static utilities.Constant.*;

/**
 * Created by Kiran on 3/5/18.
 */
public class Environment {

    private String env;
    private String host;
    private String contentType;
    private int tenant;
    private String username;
    private String authorization;

    public Environment() {
    }

    public Environment(String env) {
        this.env = env;
        this.contentType = "application/json";
        this.username = "Kiran-Automation";
        if (env.equalsIgnoreCase("QA")) {
            this.host = qaHost;
            this.authorization = qaGrToken;
        }
    }

    public Environment(String env, int tenant) {
        this.env = env;
        this.contentType = "application/json";
        this.username = "Kiran-Automation";
        this.tenant = tenant;
        this.host = qaHost;
        this.authorization = qaGrToken;
    }

    public String getURL(API api)
    {
        if (this.env.equalsIgnoreCase("QA")) {
            return host + api.getPath();
        }
        return null;
    }

    public String getEnv() {
        return env;
    }

    public String getHost() {
        return host;
    }

    public String getContentType() {
        return contentType;
    }

    public int getTenant() {
        return tenant;
    }

    public String getUsername() {
        return username;
    }

    public String getAuthorization() {
        return authorization;
    }
}
