package alexberemart.socialNBA.model.dao.impl;

import Alexberemart.core.model.dao.base.hibernate.spring.impl.GenericHibernateSpringDAOImpl;
import alexberemart.socialNBA.model.dao.PlayerEntryDAO;
import alexberemart.socialNBA.model.dao.TwitDAO;
import alexberemart.socialNBA.model.vo.PlayerEntry;
import alexberemart.socialNBA.model.vo.Twit;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PlayerEntryDAOImpl extends GenericHibernateSpringDAOImpl<PlayerEntry, String> implements PlayerEntryDAO {

    public PlayerEntryDAOImpl() {
        super(PlayerEntry.class);
    }

}
