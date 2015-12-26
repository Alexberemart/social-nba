package alexberemart.socialNBA.services;

import Alexberemart.core.util.ApplicationContextProvider;
import alexberemart.socialNBA.model.dao.JobDAO;
import alexberemart.socialNBA.model.vo.Job;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class JobServices {

    @Autowired
    JobDAO jobDAO;

    public static JobServices getInstance() {
        return (JobServices) ApplicationContextProvider.getInstance().getBean("jobServices");
    }

    public List<Job> findAll(){
        return jobDAO.findAll();
    }

    public void saveJob(Job job){
        jobDAO.makePersistent(job);
    }

}
