package alexberemart.socialNBA.model.dao.impl;

import Alexberemart.core.model.dao.base.hibernate.spring.impl.GenericHibernateSpringDAOImpl;
import alexberemart.socialNBA.model.dao.JobDAO;
import alexberemart.socialNBA.model.dao.PlayerDAO;
import alexberemart.socialNBA.model.vo.Job;
import alexberemart.socialNBA.model.vo.Player;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class JobDAOImpl extends GenericHibernateSpringDAOImpl<Job, String> implements JobDAO {

    public JobDAOImpl() {
        super(Job.class);
    }
}
