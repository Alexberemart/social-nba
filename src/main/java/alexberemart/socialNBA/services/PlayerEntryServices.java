package alexberemart.socialNBA.services;

import Alexberemart.core.util.ApplicationContextProvider;
import alexberemart.socialNBA.model.dao.PlayerEntryDAO;
import alexberemart.socialNBA.model.factories.basketReference.PlayerEntryFactory;
import alexberemart.socialNBA.model.vo.Match;
import alexberemart.socialNBA.model.vo.PlayerEntry;
import alexberemart.socialNBA.model.vo.basketReference.PlayerStats;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class PlayerEntryServices {

    @Autowired
    PlayerEntryFactory playerEntryFactory;

    @Autowired
    PlayerEntryDAO playerEntryDAO;

    public static PlayerEntryServices getInstance() {
        return (PlayerEntryServices) ApplicationContextProvider.getInstance().getBean("playerEntryServices");
    }

    public PlayerEntry createPlayerEntryFromBasketballReference(PlayerStats playerStats, Match match) {
        return playerEntryFactory.createPlayerEntryFromBasketballReference(playerStats, match);
    }

    public List<PlayerEntry>findWithFiltersPaginated(String orderBy, Integer offset, Integer perPage, Boolean asc, String search, Long dateFilter){
        return playerEntryDAO.findWithFiltersPaginated(orderBy, offset, perPage, asc, search, dateFilter);
    }

    public Number countSearchResults(String search){
        return playerEntryDAO.countSearchResultsWithFilters(search);
    }
}
