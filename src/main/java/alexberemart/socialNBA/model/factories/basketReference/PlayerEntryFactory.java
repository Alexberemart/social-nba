package alexberemart.socialNBA.model.factories.basketReference;

import alexberemart.socialNBA.model.vo.PlayerEntry;
import alexberemart.socialNBA.model.vo.basketReference.PlayerStats;
import org.springframework.beans.factory.annotation.Autowired;

public class PlayerEntryFactory {

    @Autowired
    MinutesFactory minutesFactory;

    @Autowired
    NumberFactory numberFactory;

    public PlayerEntry createPlayerEntry(PlayerStats playerStats) {
        PlayerEntry playerEntry = new PlayerEntry();
        playerEntry.setName(playerStats.getName());
        playerEntry.setTimePlayed(minutesFactory.parseToInteger(playerStats.getMinutesPlayed()));
        playerEntry.setPoints(numberFactory.parseToInteger(playerStats.getPoints()));
        return playerEntry;

    }
}
