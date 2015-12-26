package alexberemart.socialNBA.model.dao.impl;

import Alexberemart.core.model.dao.base.hibernate.spring.impl.GenericHibernateSpringDAOImpl;
import alexberemart.socialNBA.model.dao.JobDAO;
import alexberemart.socialNBA.model.dao.JobParameterDAO;
import alexberemart.socialNBA.model.vo.Job;
import alexberemart.socialNBA.model.vo.JobParameter;

public class JobParameterDAOImpl extends GenericHibernateSpringDAOImpl<JobParameter, String> implements JobParameterDAO {

    public JobParameterDAOImpl() {
        super(JobParameter.class);
    }
}
