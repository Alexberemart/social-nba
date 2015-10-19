package alexberemart.socialNBA.model.vo;

public class OauthCredentials {

    protected String consumerKey;
    protected String consumerSecretKey;
    protected String accessToken;
    protected String accessSecretToken;

    public String getConsumerKey() {
        return consumerKey;
    }

    public void setConsumerKey(String consumerKey) {
        this.consumerKey = consumerKey;
    }

    public String getConsumerSecretKey() {
        return consumerSecretKey;
    }

    public void setConsumerSecretKey(String consumerSecretKey) {
        this.consumerSecretKey = consumerSecretKey;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getAccessSecretToken() {
        return accessSecretToken;
    }

    public void setAccessSecretToken(String accessSecretToken) {
        this.accessSecretToken = accessSecretToken;
    }
}