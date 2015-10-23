package alexberemart.socialNBA.model.dao;

import Alexberemart.core.model.dao.base.hibernate.GenericHibernateDAO;
import alexberemart.socialNBA.model.vo.Twit;

import java.util.List;

public interface TwitDAO extends GenericHibernateDAO<Twit, String> {

    public Twit getLastTwitById(String playerName);

    public List getPlayerTwitsWithPositiveAndNegativeCount();
}
