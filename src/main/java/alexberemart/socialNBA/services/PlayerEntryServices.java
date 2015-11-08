package alexberemart.socialNBA.services;

import Alexberemart.core.util.ApplicationContextProvider;
import alexberemart.socialNBA.model.dao.PlayerEntryDAO;
import alexberemart.socialNBA.model.factories.basketReference.PlayerEntryFactory;
import alexberemart.socialNBA.model.vo.PlayerEntry;
import alexberemart.socialNBA.model.vo.basketReference.Match;
import alexberemart.socialNBA.model.vo.basketReference.PlayerStats;
import alexberemart.socialNBA.model.vo.basketReference.TeamStats;
import alexberemart.socialNBA.services.basketReference.BasketReferenceServices;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.List;

public class PlayerEntryServices {

    @Autowired
    PlayerEntryFactory playerEntryFactory;

    @Autowired
    PlayerEntryDAO playerEntryDAO;

    public static PlayerEntryServices getInstance() {
        return (PlayerEntryServices) ApplicationContextProvider.getInstance().getBean("playerEntryServices");
    }

    private PlayerEntry createPlayerEntry(PlayerStats playerStats) {
        return playerEntryFactory.createPlayerEntry(playerStats);
    }

    private void savePlayerEntry(PlayerEntry playerEntry){
        playerEntryDAO.makePersistent(playerEntry);
    }

    public void getBasketReferenceInfo() throws IOException {
        List<Match> matchList = BasketReferenceServices.getInstance().getMatches();
        for (Match match : matchList){
            for (TeamStats teamStats : match.getTeamEntries()){
                for (PlayerStats playerStats : teamStats.getPlayerStatsList()){
                    PlayerEntry playerEntry = createPlayerEntry(playerStats);
                    savePlayerEntry(playerEntry);
                }
            }
        }
    }
}
