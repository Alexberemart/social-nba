package alexberemart.socialNBA.model.dao.impl;

import Alexberemart.core.model.dao.base.hibernate.spring.impl.GenericHibernateSpringDAOImpl;
import alexberemart.socialNBA.model.dao.RestServiceLogDAO;
import alexberemart.socialNBA.model.vo.RestServiceLog;

public class RestServiceLogDAOImpl extends GenericHibernateSpringDAOImpl<RestServiceLog, String> implements RestServiceLogDAO {

    public RestServiceLogDAOImpl() {
        super(RestServiceLog.class);
    }

}
