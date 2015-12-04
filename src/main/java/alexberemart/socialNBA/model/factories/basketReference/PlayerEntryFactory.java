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
        playerEntry.setRebounds(numberFactory.parseToInteger(playerStats.getTotalRebounds()));
        playerEntry.setAssists(numberFactory.parseToInteger(playerStats.getAssists()));
        playerEntry.setBlocks(numberFactory.parseToInteger(playerStats.getBlocks()));
        playerEntry.setSteals(numberFactory.parseToInteger(playerStats.getSteals()));
        playerEntry.setTurnovers(numberFactory.parseToInteger(playerStats.getTurnovers()));
        playerEntry.setPersonalFouls(numberFactory.parseToInteger(playerStats.getPersonalFouls()));
        playerEntry.setFieldGoals(numberFactory.parseToInteger(playerStats.getFieldGoals()));
        playerEntry.setFieldGoalAttempts(numberFactory.parseToInteger(playerStats.getFieldGoalAttempts()));
        playerEntry.setFreeThrows(numberFactory.parseToInteger(playerStats.getFreeThrows()));
        playerEntry.setFreeThrowAttempts(numberFactory.parseToInteger(playerStats.getFreeThrowAttempts()));
        playerEntry.setMatch(match);
        return playerEntry;

    }
}
