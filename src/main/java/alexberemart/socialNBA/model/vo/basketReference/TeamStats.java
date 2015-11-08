package alexberemart.socialNBA.model.vo.basketReference;

import java.util.ArrayList;
import java.util.List;

public class TeamStats {

    List<PlayerStats> playerStatsList = new ArrayList<>();

    public List<PlayerStats> getPlayerStatsList() {
        return playerStatsList;
    }

    public void setPlayerStatsList(List<PlayerStats> playerStatsList) {
        this.playerStatsList = playerStatsList;
    }
}
