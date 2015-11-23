package alexberemart.socialNBA.model.vo;

import Alexberemart.core.model.vo.base.BaseEntity;
import org.codehaus.jackson.annotate.JsonBackReference;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@org.hibernate.annotations.Entity(dynamicUpdate = true)
@Table(name = "player_entries")
@javax.persistence.Entity
public class PlayerEntry extends BaseEntity{

    protected Match match;
    protected String name;
    protected Integer timePlayed;
    protected Integer points;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getTimePlayed() {
        return timePlayed;
    }

    public void setTimePlayed(Integer timePlayed) {
        this.timePlayed = timePlayed;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    @ManyToOne
    @JoinColumn(name = "matchId", nullable = false)
    @JsonBackReference("match")
    public Match getMatch() {
        return match;
    }

    public void setMatch(Match match) {
        this.match = match;
    }
}
