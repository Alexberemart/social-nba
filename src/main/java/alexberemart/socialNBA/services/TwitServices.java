package alexberemart.socialNBA.services;

import Alexberemart.core.util.ApplicationContextProvider;
import alexberemart.socialNBA.model.dao.TwitDAO;
import alexberemart.socialNBA.model.factories.TwitFactory;
import alexberemart.socialNBA.model.vo.OauthCredentials;
import alexberemart.socialNBA.model.vo.Twit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateJdbcException;
import twitter4j.*;
import twitter4j.conf.ConfigurationBuilder;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TwitServices {

    @Autowired
    TwitDAO twitDAO;

    @Autowired
    TwitFactory twitFactory;

    @Autowired
    protected OauthCredentials oauthCredentials;

    public static TwitServices getInstance() {
        return (TwitServices) ApplicationContextProvider.getInstance().getBean("twitServices");
    }

    public void saveTwit(Twit twit) {
        //TODO: ver como evitar el error por caracteres extraños
        try {
            twitDAO.makePersistent(twit);
        } catch (HibernateJdbcException e) {
            System.out.println("No se ha podido cargar la línea de texto : " + twit.getText());
            //e.printStackTrace();
        }
    }

    public void processTwits() throws IOException {

        //TODO: parametrizar las rutas de ficheros
        List<String> negativeWords = getNegativeOrPositiveWords("C:/Users/aberenguer/Software_Development/Bitbucket/core/src/main/conf/SciSentiment-master/negative-words.txt");
        List<String> positiveWords = getNegativeOrPositiveWords("C:/Users/aberenguer/Software_Development/Bitbucket/core/src/main/conf/SciSentiment-master/positive-words.txt");

        List<Twit> twitList = twitDAO.findAll();
        for (Twit twit : twitList) {

            Integer positiveWordsCount = 0;
            Integer negativeWordsCount = 0;

            String[] splitTwit = twit.getText().split(" ");
            for (String word : splitTwit) {
                if (negativeWords.contains(word)) {
                    System.out.println("match negative " + word);
                    negativeWordsCount += 1;
                }
                if (positiveWords.contains(word)) {
                    System.out.println("match positive " + word);
                    positiveWordsCount += 1;
                }
            }

            twit.setNegativeWords(negativeWordsCount);
            twit.setPositiveWords(positiveWordsCount);
            saveTwit(twit);
        }
    }

    protected List<String> getNegativeOrPositiveWords(String fileName) throws IOException {

        List<String> words = new ArrayList<>();

        BufferedReader br = new BufferedReader(new FileReader(fileName));
        String line;
        while ((line = br.readLine()) != null) {
            words.add(line);
        }
        return words;
    }

    public void createTwit(Status status, String playerName){
        Twit twit = twitFactory.createTwit(status);
        twit.setPlayerName(playerName);
        saveTwit(twit);
    }

    public void getPlayerTwits() throws TwitterException, SQLException {

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
                TwitServices.getInstance().createTwit(status, playerName);
            }
            Long end = new Date().getTime();
            Long gap = end - start;
            System.out.println("Query Gap " + gap);
            System.out.println("recogidos un total de " + result.getTweets().size() + " twits para el jugador " + playerName);
        }
    }
}
