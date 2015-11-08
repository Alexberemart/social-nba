package alexberemart.socialNBA.model.vo.basketReference;

import java.util.ArrayList;
import java.util.List;

public class Match {

    List<TeamStats> teamEntries = new ArrayList<>();

    public List<TeamStats> getTeamEntries() {
        return teamEntries;
    }

    public void setTeamEntries(List<TeamStats> teamEntries) {
        this.teamEntries = teamEntries;
    }
}
