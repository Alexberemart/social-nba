package alexberemart.socialNBA.model.dao;

import alexberemart.socialNBA.model.vo.Twit;
import alexberemart.socialNBA.services.TwitServices;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
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
public class PlayerEntryDAOTest extends AbstractTransactionalJUnit4SpringContextTests {

    @Autowired
    PlayerEntryDAO playerEntryDAO;

    @Test
    public void findWithFiltersPaginated() throws TwitterException, SQLException {
        playerEntryDAO.findWithFiltersPaginated("", 0, 0, Boolean.FALSE, "", new Long("111"));
    }
}