package alexberemart.socialNBA.services;

import Alexberemart.core.util.ApplicationContextProvider;
import alexberemart.socialNBA.model.dao.RestServiceLogDAO;
import alexberemart.socialNBA.model.vo.RestServiceLog;
import org.springframework.beans.factory.annotation.Autowired;

public class RestServiceLogServices {

    @Autowired
    RestServiceLogDAO restServiceLogDAO;

    public static RestServiceLogServices getInstance() {
        return (RestServiceLogServices) ApplicationContextProvider.getInstance().getBean("restServiceLogServices");
    }

    public void saveRestServiceLog(RestServiceLog restServiceLog) {
        restServiceLogDAO.makePersistent(restServiceLog);
    }

}
