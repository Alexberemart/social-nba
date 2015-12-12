package alexberemart.socialNBA.model.factories;

import alexberemart.socialNBA.model.vo.Player;
import alexberemart.socialNBA.model.vo.basketReference.PlayerStats;
import org.springframework.beans.factory.annotation.Autowired;

public class PlayerFactory {

    @Autowired
    MinutesFactory minutesFactory;

    @Autowired
    NumberFactory numberFactory;

    public Player createPlayerFromBasketballReferencePlayerStats(PlayerStats playerStats) {
        Player player = new Player();
        player.setIdImported(playerStats.getPlayerKey());
        player.setName(playerStats.getName());
        return player;
    }
}
