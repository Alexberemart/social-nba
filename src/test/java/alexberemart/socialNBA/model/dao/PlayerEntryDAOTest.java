package alexberemart.socialNBA.model.dao;

import alexberemart.socialNBA.model.vo.Match;
import alexberemart.socialNBA.model.vo.Player;
import alexberemart.socialNBA.model.vo.PlayerEntry;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import twitter4j.TwitterException;

import java.sql.SQLException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
        "classpath:/alexberemart/socialNBA/context.xml",
        "classpath:/alexberemart/socialNBA/testContext.xml"
})
@Transactional
public class PlayerEntryDAOTest extends AbstractTransactionalJUnit4SpringContextTests {

    @Autowired
    PlayerEntryDAO playerEntryDAO;

    @Autowired
    MatchDAO matchDAO;

    @Autowired
    PlayerDAO playerDAO;

    PlayerEntry playerEntry = new PlayerEntry();

    @Before
    public void setUp(){

        Match match = new Match();
        match.setIdImported("id");
        matchDAO.makePersistent(match);

        Player player = new Player();
        player.setIdImported("id");
        playerDAO.makePersistent(player);

        playerEntry.setMatch(match);
        playerEntry.setPlayer(player);
        playerEntry.setAssists(10);
    }

    @Test
    public void findWithFiltersPaginated() throws TwitterException, SQLException {
        playerEntryDAO.findWithFiltersPaginated("", 0, 0, Boolean.FALSE, "", new Long("111"), new Long("111"));
    }

    @Test
    public void countSearchResultsWithFilters() throws TwitterException, SQLException {
        playerEntryDAO.countSearchResultsWithFilters("", new Long("111"), new Long("111"));
    }

    @Test
    public void makePersistent() throws TwitterException, SQLException {
        playerEntryDAO.makePersistent(playerEntry);
    }
}
