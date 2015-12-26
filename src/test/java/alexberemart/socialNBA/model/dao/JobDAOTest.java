package alexberemart.socialNBA.model.dao;

import alexberemart.socialNBA.model.enums.JobType;
import alexberemart.socialNBA.model.vo.Job;
import alexberemart.socialNBA.model.vo.JobParameter;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import twitter4j.TwitterException;

import java.sql.SQLException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
        "classpath:/alexberemart/socialNBA/context.xml",
        "classpath:/alexberemart/socialNBA/testContext.xml"
})
public class JobDAOTest extends AbstractTransactionalJUnit4SpringContextTests {

    @Autowired
    JobDAO jobDAO;

    Job job = new Job();

    @Before
    public void setUp(){

        JobParameter jobParameter = new JobParameter();
        jobParameter.setJob(job);
        jobParameter.setOrderParameter(1);
        jobParameter.setParameter("hola");

        job.setPriority(100);
        job.setType(JobType.BASKETBALL_REFERENCE_GAMES);
        job.getParameters().add(jobParameter);
    }

    @Test
    public void makePersistent() throws TwitterException, SQLException {
        jobDAO.makePersistent(job);
    }
}
