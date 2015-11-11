package alexberemart.socialNBA.model.vo.basketReference;

import java.util.ArrayList;
import java.util.List;

public class Match {

    protected String key;
    List<TeamStats> teamEntries = new ArrayList<>();

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public List<TeamStats> getTeamEntries() {
        return teamEntries;
    }

    public void setTeamEntries(List<TeamStats> teamEntries) {
        this.teamEntries = teamEntries;
    }
}
