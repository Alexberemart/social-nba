package alexberemart.socialNBA.services;

import com.alexberemart.core.util.ApplicationContextProvider;
import alexberemart.socialNBA.model.dao.RestServiceLogDAO;
import alexberemart.socialNBA.model.vo.RestServiceLog;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class RestServiceLogServices {

    @Autowired
    RestServiceLogDAO restServiceLogDAO;

    public static RestServiceLogServices getInstance() {
        return (RestServiceLogServices) ApplicationContextProvider.getInstance().getBean("restServiceLogServices");
    }

    public void saveRestServiceLog(RestServiceLog restServiceLog) {
        restServiceLogDAO.makePersistent(restServiceLog);
    }

    public List<RestServiceLog>findWithFiltersPaginated(String orderBy, Integer offset, Integer perPage, Boolean asc, String search){
        return restServiceLogDAO.findWithFiltersPaginated(orderBy, offset, perPage, asc, search);
    }

    public Number countSearchResults(String search){
        return restServiceLogDAO.countSearchResultsWithFilters(search);
    }

}
