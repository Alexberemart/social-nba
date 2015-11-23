package alexberemart.socialNBA.model.vo.basketReference;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Match {

    protected String key;
    protected Date date;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
