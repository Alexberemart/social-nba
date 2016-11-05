package alexberemart.socialNBA.model.dao.impl;

import com.alexberemart.core.model.dao.base.hibernate.spring.impl.GenericHibernateSpringDAOImpl;
import com.alexberemart.core.util.StringUtils;
import alexberemart.socialNBA.model.dao.RestServiceLogDAO;
import alexberemart.socialNBA.model.vo.RestServiceLog;
import alexberemart.socialNBA.util.IntegerUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;

import java.util.List;

public class RestServiceLogDAOImpl extends GenericHibernateSpringDAOImpl<RestServiceLog, String> implements RestServiceLogDAO {

    public RestServiceLogDAOImpl() {
        super(RestServiceLog.class);
    }

    @Override
    public List<RestServiceLog> findWithFiltersPaginated(String orderBy, Integer offset, Integer perPage, Boolean asc, String search) {

        DetachedCriteria detachedCriteria = DetachedCriteria
                .forClass(RestServiceLog.class);

        if (StringUtils.isNotBlank(orderBy)) {
            if (asc) {
                detachedCriteria.addOrder(Order.asc(orderBy));
            } else {
                detachedCriteria.addOrder(Order.desc(orderBy));
            }
        }

        offset = IntegerUtils.boundsChecking(offset);
        perPage = IntegerUtils.boundsChecking(perPage);

        final List<RestServiceLog> byCriteria = this.getHibernateTemplate().findByCriteria(detachedCriteria, offset, perPage);

        if (byCriteria.size() == 0) {
            return null;
        }

        return byCriteria;
    }

    @Override
    public Number countSearchResultsWithFilters(String search){
        DetachedCriteria detachedCriteria = DetachedCriteria
                .forClass(RestServiceLog.class)
                .setProjection(Projections.rowCount());

        Number totalResults;

        try {
            totalResults = (Number) this.getHibernateTemplate().findByCriteria(detachedCriteria).get(0);
        } catch (Exception e) {
            totalResults = null;
            System.out.println(e);
        }

        return totalResults;
    }

}
