package alexberemart.socialNBA.model.vo;

import Alexberemart.core.model.vo.base.BaseEntity;

import javax.persistence.Table;

@org.hibernate.annotations.Entity(dynamicUpdate = true)
@Table(name = "player_entries")
@javax.persistence.Entity
public class PlayerEntry extends BaseEntity{

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
}
