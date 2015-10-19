package alexberemart.socialNBA.services;

import Alexberemart.core.util.ApplicationContextProvider;
import alexberemart.socialNBA.model.vo.OauthCredentials;
import oauth.signpost.OAuthConsumer;
import oauth.signpost.basic.DefaultOAuthConsumer;
import oauth.signpost.exception.OAuthCommunicationException;
import oauth.signpost.exception.OAuthExpectationFailedException;
import oauth.signpost.exception.OAuthMessageSignerException;
import org.jdom.Document;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import twitter4j.*;
import twitter4j.conf.ConfigurationBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class SocialNBAServices {

    @Autowired
    protected OauthCredentials oauthCredentials;

    public static SocialNBAServices getInstance() {
        return (SocialNBAServices) ApplicationContextProvider.getInstance().getBean("socialNBAServices");
    }

    public void sendProtectedRequest(URL url, OauthCredentials credentials) throws TwitterException {

        // The factory instance is re-useable and thread safe.
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
                .setOAuthConsumerKey(oauthCredentials.getConsumerKey())
                .setOAuthConsumerSecret(oauthCredentials.getConsumerSecretKey())
                .setOAuthAccessToken(oauthCredentials.getAccessToken())
                .setOAuthAccessTokenSecret(oauthCredentials.getAccessSecretToken());
        TwitterFactory tf = new TwitterFactory(cb.build());
        Twitter twitter = tf.getInstance();
        Query query = new Query("Pau Gasol");
        query.setCount(100);
        //query.setSince("2015-10-19");
        QueryResult result = twitter.search(query);
        //for (Status status : result.getTweets()) {
        //    System.out.println("@" + status.getUser().getScreenName() + ":" + status.getText());
        //}
        System.out.println("recogidos un total de " + result.getCount() + " twits");
    }

}
