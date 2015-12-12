package alexberemart.socialNBA.services;

import Alexberemart.core.util.ApplicationContextProvider;
import alexberemart.socialNBA.model.dao.PlayerDAO;
import alexberemart.socialNBA.model.factories.PlayerFactory;
import alexberemart.socialNBA.model.vo.Player;
import alexberemart.socialNBA.model.vo.basketReference.PlayerStats;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class PlayerServices {

    @Autowired
    PlayerFactory playerFactory;

    @Autowired
    PlayerDAO playerDAO;

    public static PlayerServices getInstance() {
        return (PlayerServices) ApplicationContextProvider.getInstance().getBean("playerServices");
    }

    public Boolean existByKey(String key) {
        return playerDAO.existByKey(key);
    }

    public Player savePlayer(Player player) {
        if (!existByKey(player.getIdImported())) {
            playerDAO.makePersistent(player);
            return player;
        } else {
            return playerDAO.findByKey(player.getIdImported());
        }
    }

    public Player createPlayerFromBasketballReference(PlayerStats playerStats) {
        return playerFactory.createPlayerFromBasketballReferencePlayerStats(playerStats);
    }
}
