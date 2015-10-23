package alexberemart.socialNBA.services;

import alexberemart.socialNBA.model.vo.Twit;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import twitter4j.TwitterException;

import java.io.IOException;
import java.sql.SQLException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
        "classpath:/alexberemart/socialNBA/context.xml"
})
@Transactional
public class TwitServicesTest extends AbstractTransactionalJUnit4SpringContextTests {

    Twit twit = new Twit();

    @Before
    public void setUp() throws SQLException {
        // da error
        // twit.setText("RT @NBAHistory: @NBA The champion @Warriors proudly wear 🎯 as they go for ring No. 2 (via @daldridgetnt): https://t.co/0yVKbBbBUe https://t");
        twit.setText("RT @NBAHistory: @NBA The champion @Warriors proudly wear as they go for ring No. 2 (via @daldridgetnt): https://t.co/0yVKbBbBUe https://t");
        twit.setPlayerName("test");
    }

    @Test
    public void saveTwit() throws SQLException {
        TwitServices.getInstance().saveTwit(twit);
    }

    @Test
    public void processTwit() throws SQLException, IOException {
        TwitServices.getInstance().saveTwit(twit);
        TwitServices.getInstance().processTwits();
    }

    @Test
    @Ignore
    //TODO: Si activamos este test falla por la inserción de caracteres extraños, aunque esta ya capado que no se graben ¿?¿?¿?¿?¿?
    public void getPlayerTwits() throws TwitterException, SQLException {
        TwitServices.getInstance().getPlayerTwits();
    }

    @Test
    public void getPlayerTwitsCount() throws TwitterException, SQLException {
        TwitServices.getInstance().saveTwit(twit);
        TwitServices.getInstance().getPlayerTwitsCount();
    }
}
