package alexberemart.socialNBA.services;

import Alexberemart.core.util.ApplicationContextProvider;
import alexberemart.socialNBA.model.vo.OauthCredentials;
import alexberemart.socialNBA.model.vo.Twit;
import org.springframework.beans.factory.annotation.Autowired;
import twitter4j.*;
import twitter4j.conf.ConfigurationBuilder;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SocialNBAServices {

    @Autowired
    protected OauthCredentials oauthCredentials;

    public static SocialNBAServices getInstance() {
        return (SocialNBAServices) ApplicationContextProvider.getInstance().getBean("socialNBAServices");
    }

    public void GetPlayerTwits() throws TwitterException, SQLException {

        List<String> players = new ArrayList<>();
        players.add("Pau Gasol");
        players.add("Boris Diaw");
        players.add("Lebron James");
        players.add("Ian Mahimi");
        players.add("Alejandro Berenguer");

        // The factory instance is re-useable and thread safe.
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
                .setOAuthConsumerKey(oauthCredentials.getConsumerKey())
                .setOAuthConsumerSecret(oauthCredentials.getConsumerSecretKey())
                .setOAuthAccessToken(oauthCredentials.getAccessToken())
                .setOAuthAccessTokenSecret(oauthCredentials.getAccessSecretToken());
        TwitterFactory tf = new TwitterFactory(cb.build());
        Twitter twitter = tf.getInstance();

        for (String playerName : players) {
            Long start = new Date().getTime();
            Query query = new Query(playerName);
            query.setCount(100);
            query.setSince("2015-10-19");
            QueryResult result = twitter.search(query);
            for (Status status : result.getTweets()) {
                //System.out.println(status.getCreatedAt());
                //System.out.println("@" + status.getUser().getScreenName() + ":" + status.getText());
                Twit twit = new Twit();
                twit.setDate(status.getCreatedAt());
                twit.setPlayerName(playerName);
                twit.setText(status.getText());
                TwitServices.getInstance().saveTwit(twit);
            }
            Long end = new Date().getTime();
            Long gap = end - start;
            System.out.println("Query Gap " + gap);
            System.out.println("recogidos un total de " + result.getTweets().size() + " twits para el jugador " + playerName);
        }
    }

}
