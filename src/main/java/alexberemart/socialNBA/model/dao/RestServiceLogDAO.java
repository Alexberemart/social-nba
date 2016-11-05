package alexberemart.socialNBA.model.dao;

import com.alexberemart.core.model.dao.base.hibernate.GenericHibernateDAO;
import alexberemart.socialNBA.model.vo.RestServiceLog;
import org.springframework.context.annotation.Bean;

import java.util.List;

public interface RestServiceLogDAO extends GenericHibernateDAO<RestServiceLog, String> {

    List<RestServiceLog> findWithFiltersPaginated(String orderBy, Integer offset, Integer limit, Boolean asc, String search);

    Number countSearchResultsWithFilters(String search);
}
