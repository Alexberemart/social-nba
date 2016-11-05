package alexberemart.socialNBA.model.dao;

import com.alexberemart.core.model.dao.base.hibernate.GenericHibernateDAO;
import alexberemart.socialNBA.model.vo.Player;

public interface PlayerDAO extends GenericHibernateDAO<Player, String> {

    Boolean existByKey(String key);

    Player findByKey(String key);
}
