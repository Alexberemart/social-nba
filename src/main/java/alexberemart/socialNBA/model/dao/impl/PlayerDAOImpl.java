package alexberemart.socialNBA.model.dao.impl;

import com.alexberemart.core.model.dao.base.hibernate.spring.impl.GenericHibernateSpringDAOImpl;
import alexberemart.socialNBA.model.dao.PlayerDAO;
import alexberemart.socialNBA.model.vo.Player;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class PlayerDAOImpl extends GenericHibernateSpringDAOImpl<Player, String> implements PlayerDAO {

    public PlayerDAOImpl() {
        super(Player.class);
    }

    @Override
    public Boolean existByKey(String key){
        final DetachedCriteria criteria = DetachedCriteria
                .forClass(Player.class)
                .add(Restrictions.eq("idImported", key));

        final List<Player> byCriteria = this.getHibernateTemplate().findByCriteria(criteria);

        if (byCriteria.size() == 0) {
            return Boolean.FALSE;
        }

        return Boolean.TRUE;
    }

    @Override
    public Player findByKey(String key){
        final DetachedCriteria criteria = DetachedCriteria
                .forClass(Player.class)
                .add(Restrictions.eq("idImported", key));

        final List<Player> byCriteria = this.getHibernateTemplate().findByCriteria(criteria);

        if (byCriteria.size() == 0) {
            return null;
        }

        return byCriteria.get(0);
    }
}
