package alexberemart.socialNBA.model.factories.basketReference;

import alexberemart.socialNBA.model.vo.Match;
import alexberemart.socialNBA.model.vo.PlayerEntry;
import alexberemart.socialNBA.model.vo.basketReference.PlayerStats;
import org.springframework.beans.factory.annotation.Autowired;

public class PlayerEntryFactory {

    @Autowired
    MinutesFactory minutesFactory;

    @Autowired
    NumberFactory numberFactory;

    public PlayerEntry createPlayerEntryFromBasketballReference(PlayerStats playerStats, Match match) {
        PlayerEntry playerEntry = new PlayerEntry();
        playerEntry.setName(playerStats.getName());
        playerEntry.setTimePlayed(minutesFactory.parseToInteger(playerStats.getMinutesPlayed()));
        playerEntry.setPoints(numberFactory.parseToInteger(playerStats.getPoints()));
        playerEntry.setMatch(match);
        return playerEntry;

    }
}
