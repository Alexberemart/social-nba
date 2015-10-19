package alexberemart.socialNBA.services;

import alexberemart.socialNBA.model.vo.OauthCredentials;
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
import java.net.URL;
import java.text.ParseException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
        "classpath:/alexberemart/socialNBA/context.xml"
})
@Transactional
public class socialNBAServicesTest
        extends AbstractTransactionalJUnit4SpringContextTests {

    OauthCredentials credentials = new OauthCredentials();

    @Before
    public void setUp() throws ParseException, MalformedURLException, URISyntaxException {


        credentials.setConsumerKey("AJQS4PJAKWPxfTTgT1Zq6a");
        credentials.setConsumerSecretKey("dBSy7HNAs4X4UnSeBUlqiAr5hYLLZNtwLIFmZHQ5Nul");
        credentials.setAccessToken("INNCqCBhXuG8pNST");
        credentials.setAccessSecretToken("95CbS1jPb4hdHJ2d");
    }

    @Test
    public void sendProtectedRequest() throws ParseException, MalformedURLException, URISyntaxException, TwitterException {
        URL url = new URL("https://twitter.com/search?q=%40twitterapi");
        SocialNBAServices.getInstance().sendProtectedRequest(url, credentials);
    }
}
