package alexberemart.socialNBA.services;

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
public class SocialNBAServicesTest extends AbstractTransactionalJUnit4SpringContextTests {

    @Test
    public void sendProtectedRequest() throws TwitterException, SQLException {
        SocialNBAServices.getInstance().GetPlayerTwits();
    }

    //RT @NBAHistory: @NBA The champion @Warriors proudly wear 🎯 as they go for ring No. 2 (via @daldridgetnt): https://t.co/0yVKbBbBUe https://t…
}
