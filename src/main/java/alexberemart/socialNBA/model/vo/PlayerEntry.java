package alexberemart.socialNBA.model.vo;

import Alexberemart.core.model.vo.base.BaseEntity;
import org.codehaus.jackson.annotate.JsonAutoDetect;
import org.codehaus.jackson.annotate.JsonBackReference;
import org.codehaus.jackson.annotate.JsonManagedReference;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.deser.std.StdDeserializer;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;

@org.hibernate.annotations.Entity(dynamicUpdate = true)
@Table(name = "player_entries")
@javax.persistence.Entity
public class PlayerEntry extends BaseEntity{

    protected Match match;
    protected String name;
    protected Integer timePlayed;
    protected Integer points;
    protected Integer rebounds;
    protected Integer assists;
    protected Integer steals;
    protected Integer blocks;
    protected Integer turnovers;
    protected Integer personalFouls;
    protected Integer fieldGoals;
    protected Integer fieldGoalAttempts;
    protected Integer threePointFieldGoals;
    protected Integer threePointFieldGoalAttempts;
    protected Integer freeThrows;
    protected Integer freeThrowAttempts;
    protected Integer ranking;

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
    @JsonManagedReference("match")
    public Match getMatch() {
        return match;
    }

    public void setMatch(Match match) {
        this.match = match;
    }

    public Integer getRebounds() {
        return rebounds;
    }

    public void setRebounds(Integer rebounds) {
        this.rebounds = rebounds;
    }

    public Integer getAssists() {
        return assists;
    }

    public void setAssists(Integer assits) {
        this.assists = assits;
    }

    public Integer getRanking() {
        return ranking;
    }

    protected void setRanking(Integer value) {
        this.ranking = value;
    }

    public void calculateRanking() {
        this.ranking = points + rebounds + assists + steals + blocks - turnovers - personalFouls + fieldGoals - fieldGoalAttempts + freeThrows - freeThrowAttempts;
    }

    public Integer getSteals() {
        return steals;
    }

    public void setSteals(Integer steals) {
        this.steals = steals;
    }

    public Integer getBlocks() {
        return blocks;
    }

    public void setBlocks(Integer blocks) {
        this.blocks = blocks;
    }

    public Integer getTurnovers() {
        return turnovers;
    }

    public void setTurnovers(Integer turnovers) {
        this.turnovers = turnovers;
    }

    public Integer getPersonalFouls() {
        return personalFouls;
    }

    public void setPersonalFouls(Integer personalFouls) {
        this.personalFouls = personalFouls;
    }

    public Integer getFieldGoals() {
        return fieldGoals;
    }

    public void setFieldGoals(Integer fieldGoals) {
        this.fieldGoals = fieldGoals;
    }

    public Integer getFieldGoalAttempts() {
        return fieldGoalAttempts;
    }

    public void setFieldGoalAttempts(Integer fieldGoalAttempts) {
        this.fieldGoalAttempts = fieldGoalAttempts;
    }

    public Integer getThreePointFieldGoals() {
        return threePointFieldGoals;
    }

    public void setThreePointFieldGoals(Integer threePointFieldGoals) {
        this.threePointFieldGoals = threePointFieldGoals;
    }

    public Integer getThreePointFieldGoalAttempts() {
        return threePointFieldGoalAttempts;
    }

    public void setThreePointFieldGoalAttempts(Integer threePointFieldGoalAttempts) {
        this.threePointFieldGoalAttempts = threePointFieldGoalAttempts;
    }

    public Integer getFreeThrows() {
        return freeThrows;
    }

    public void setFreeThrows(Integer freeThrows) {
        this.freeThrows = freeThrows;
    }

    public Integer getFreeThrowAttempts() {
        return freeThrowAttempts;
    }

    public void setFreeThrowAttempts(Integer freeThrowAttempts) {
        this.freeThrowAttempts = freeThrowAttempts;
    }
}
