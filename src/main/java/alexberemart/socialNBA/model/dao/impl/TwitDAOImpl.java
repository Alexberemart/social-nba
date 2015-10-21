package alexberemart.socialNBA.model.dao.impl;

import Alexberemart.core.model.dao.base.hibernate.spring.impl.GenericHibernateSpringDAOImpl;
import alexberemart.socialNBA.model.dao.TwitDAO;
import alexberemart.socialNBA.model.vo.Twit;

public class TwitDAOImpl extends GenericHibernateSpringDAOImpl<Twit, String> implements TwitDAO {

    public TwitDAOImpl() {
        super(Twit.class);
    }

}
