package alexberemart.socialNBA.model.dao;

import com.alexberemart.core.model.dao.base.hibernate.GenericHibernateDAO;
import alexberemart.socialNBA.model.vo.Match;

public interface MatchDAO extends GenericHibernateDAO<Match, String> {

    Boolean ExistByKey(String key);

}
