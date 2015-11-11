package alexberemart.socialNBA.services;

import Alexberemart.core.util.ApplicationContextProvider;
import alexberemart.socialNBA.model.dao.MatchDAO;
import alexberemart.socialNBA.model.vo.Match;
import org.springframework.beans.factory.annotation.Autowired;

public class MatchServices {

    @Autowired
    MatchDAO matchDAO;

    public static MatchServices getInstance() {
        return (MatchServices) ApplicationContextProvider.getInstance().getBean("matchServices");
    }

    public void saveMatch(Match match){
        matchDAO.makePersistent(match);
    }

    public Boolean ExistByKey(String key){
        return matchDAO.ExistByKey(key);
    }
}
