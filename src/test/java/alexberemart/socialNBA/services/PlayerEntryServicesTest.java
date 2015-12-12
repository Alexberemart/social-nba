package alexberemart.socialNBA.services;

import alexberemart.socialNBA.model.vo.Match;
import alexberemart.socialNBA.model.vo.basketReference.PlayerStats;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
        "classpath:/alexberemart/socialNBA/context.xml",
        "classpath:/alexberemart/socialNBA/testContext.xml"
})
@Transactional
public class PlayerEntryServicesTest extends AbstractTransactionalJUnit4SpringContextTests {

    PlayerStats playerStats = new PlayerStats();
    Match match = new Match();

    @Before
    public void setUp() throws SQLException {
    }

    @Test
    public void createPlayerEntryFromBasketballReference() throws SQLException {
        PlayerEntryServices.getInstance().createPlayerEntryFromBasketballReference(playerStats, match);
    }
}
