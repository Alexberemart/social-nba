package alexberemart.socialNBA.services;

import Alexberemart.core.util.ApplicationContextProvider;
import alexberemart.socialNBA.model.dao.MatchDAO;
import alexberemart.socialNBA.model.factories.MatchFactory;
import alexberemart.socialNBA.model.vo.Match;
import org.springframework.beans.factory.annotation.Autowired;

public class MatchServices {

    @Autowired
    MatchDAO matchDAO;

    @Autowired
    MatchFactory matchFactory;

    public static MatchServices getInstance() {
        return (MatchServices) ApplicationContextProvider.getInstance().getBean("matchServices");
    }

    public void saveMatch(Match match){
        matchDAO.makePersistent(match);
    }

    public Boolean ExistByKey(String key){
        return matchDAO.ExistByKey(key);
    }

    public Match createMatch(alexberemart.socialNBA.model.vo.basketReference.Match match) {
        return matchFactory.createMatchFromBasketballReference(match);
    }
}
