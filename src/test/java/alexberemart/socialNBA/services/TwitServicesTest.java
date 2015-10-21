package alexberemart.socialNBA.services;

import alexberemart.socialNBA.model.vo.OauthCredentials;
import alexberemart.socialNBA.model.vo.Twit;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import twitter4j.TwitterException;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.text.ParseException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
        "classpath:/alexberemart/socialNBA/context.xml"
})
@Transactional
public class TwitServicesTest extends AbstractTransactionalJUnit4SpringContextTests {

    @Test
    public void saveTwit() throws SQLException {
        Twit twit = new Twit();
        twit.setText("RT @NBAHistory: @NBA The champion @Warriors proudly wear 🎯 as they go for ring No. 2 (via @daldridgetnt): https://t.co/0yVKbBbBUe https://t");
        TwitServices.getInstance().saveTwit(twit);
    }
}
