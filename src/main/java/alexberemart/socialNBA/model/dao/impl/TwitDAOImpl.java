package alexberemart.socialNBA.model.dao.impl;

import Alexberemart.core.model.dao.base.hibernate.spring.impl.GenericHibernateSpringDAOImpl;
import alexberemart.socialNBA.model.dao.TwitDAO;
import alexberemart.socialNBA.model.vo.Twit;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class TwitDAOImpl extends GenericHibernateSpringDAOImpl<Twit, String> implements TwitDAO {

    public TwitDAOImpl() {
        super(Twit.class);
    }

    @Override
    public Twit getLastTwitById(String playerName) {
        final DetachedCriteria criteria = DetachedCriteria
                .forClass(Twit.class)
                .add(Restrictions.eq("playerName", playerName))
                .addOrder(Order.desc("twitId"));

        final List<Twit> byCriteria = this.getHibernateTemplate().findByCriteria(criteria);

        if (byCriteria.size() == 0) {
            return null;
        }

        return byCriteria.get(0);
    }

}
