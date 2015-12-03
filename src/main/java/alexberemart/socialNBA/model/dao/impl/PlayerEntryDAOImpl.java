package alexberemart.socialNBA.model.dao.impl;

import Alexberemart.core.model.dao.base.hibernate.spring.impl.GenericHibernateSpringDAOImpl;
import alexberemart.socialNBA.model.dao.PlayerEntryDAO;
import alexberemart.socialNBA.model.vo.PlayerEntry;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.FetchMode;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import java.util.Date;
import java.util.List;

public class PlayerEntryDAOImpl extends GenericHibernateSpringDAOImpl<PlayerEntry, String> implements PlayerEntryDAO {

    public PlayerEntryDAOImpl() {
        super(PlayerEntry.class);
    }

    @Override
    public List<PlayerEntry> findWithFiltersPaginated(String orderBy, Integer offset, Integer perPage, Boolean asc, String search, Long dateFilter) {

        DetachedCriteria detachedCriteria = DetachedCriteria
                .forClass(PlayerEntry.class)
                .setFetchMode("match", FetchMode.JOIN)
                .createAlias("match", "match");

        if (StringUtils.isNotEmpty(search)) {
            detachedCriteria.add(Restrictions.like("name", "%" + search + "%"));
        }

        if (dateFilter != null) {
            detachedCriteria.add(Restrictions.eq("match.date", dateFilter));
        }

        if (StringUtils.isNotBlank(orderBy)) {
            if (asc) {
                detachedCriteria.addOrder(Order.asc(orderBy));
            } else {
                detachedCriteria.addOrder(Order.desc(orderBy));
            }
        }

        offset = boundsChecking(offset);
        perPage = boundsChecking(perPage);

        final List<PlayerEntry> byCriteria = this.getHibernateTemplate().findByCriteria(detachedCriteria, offset, perPage);

        if (byCriteria.size() == 0) {
            return null;
        }

        return byCriteria;
    }

    @Override
    public Number countSearchResultsWithFilters(String search) {
        DetachedCriteria detachedCriteria = DetachedCriteria
                .forClass(PlayerEntry.class)
                .setProjection(Projections.rowCount());

        if (StringUtils.isNotEmpty(search)) {
            detachedCriteria.add(Restrictions.like("name", "%" + search + "%"));
        }

        Number totalResults;

        try {
            totalResults = (Number) this.getHibernateTemplate().findByCriteria(detachedCriteria).get(0);
        } catch (Exception e) {
            totalResults = null;
            System.out.println(e);
        }

        return totalResults;
    }

    protected Integer boundsChecking(Integer value) {

        if ((value == null) || (value < 0)) {
            value = 0;
        }

        return value;
    }
}
