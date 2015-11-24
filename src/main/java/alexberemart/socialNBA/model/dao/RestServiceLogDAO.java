package alexberemart.socialNBA.model.dao;

import Alexberemart.core.model.dao.base.hibernate.GenericHibernateDAO;
import alexberemart.socialNBA.model.vo.RestServiceLog;
import org.springframework.context.annotation.Bean;

public interface RestServiceLogDAO extends GenericHibernateDAO<RestServiceLog, String> {

}
