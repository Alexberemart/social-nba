package alexberemart.socialNBA.model.vo.basketReference;

import alexberemart.socialNBA.model.vo.basketReference.readingAttributeState.ReadingAttributeState;

public class PlayerStats {

    protected ReadingAttributeState state;

    protected String playerKey;
    protected String name;
    protected String minutesPlayed;
    protected String fieldGoals;
    protected String fieldGoalAttempts;
    protected String fieldGoalPercentage;
    protected String threePointFieldGoals;
    protected String threePointFieldGoalAttempts;
    protected String threePointFieldGoalPercentage;
    protected String freeThrows;
    protected String freeThrowAttempts;
    protected String freeThrowPercentage;
    protected String offensiveRebounds;
    protected String defensiveRebounds;
    protected String totalRebounds;
    protected String assists;
    protected String steals;
    protected String blocks;
    protected String turnovers;
    protected String personalFouls;
    protected String points;
    protected String plusMinus;

    public String getPlayerKey() {
        return playerKey;
    }

    public void setPlayerKey(String playerKey) {
        this.playerKey = playerKey;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMinutesPlayed() {
        return minutesPlayed;
    }

    public void setMinutesPlayed(String minutesPlayed) {
        this.minutesPlayed = minutesPlayed;
    }

    public ReadingAttributeState getState() {
        return state;
    }

    public void setState(ReadingAttributeState state) {
        this.state = state;
    }

    public String getFieldGoals() {
        return fieldGoals;
    }

    public void setFieldGoals(String fieldGoals) {
        this.fieldGoals = fieldGoals;
    }

    public String getFieldGoalAttempts() {
        return fieldGoalAttempts;
    }

    public void setFieldGoalAttempts(String fieldGoalAttempts) {
        this.fieldGoalAttempts = fieldGoalAttempts;
    }

    public String getFieldGoalPercentage() {
        return fieldGoalPercentage;
    }

    public void setFieldGoalPercentage(String fieldGoalPercentage) {
        this.fieldGoalPercentage = fieldGoalPercentage;
    }

    public String getThreePointFieldGoals() {
        return threePointFieldGoals;
    }

    public void setThreePointFieldGoals(String threePointFieldGoals) {
        this.threePointFieldGoals = threePointFieldGoals;
    }

    public String getThreePointFieldGoalAttempts() {
        return threePointFieldGoalAttempts;
    }

    public void setThreePointFieldGoalAttempts(String threePointFieldGoalAttempts) {
        this.threePointFieldGoalAttempts = threePointFieldGoalAttempts;
    }

    public String getThreePointFieldGoalPercentage() {
        return threePointFieldGoalPercentage;
    }

    public void setThreePointFieldGoalPercentage(String threePointFieldGoalPercentage) {
        this.threePointFieldGoalPercentage = threePointFieldGoalPercentage;
    }

    public String getFreeThrows() {
        return freeThrows;
    }

    public void setFreeThrows(String freeThrows) {
        this.freeThrows = freeThrows;
    }

    public String getFreeThrowAttempts() {
        return freeThrowAttempts;
    }

    public void setFreeThrowAttempts(String freeThrowAttempts) {
        this.freeThrowAttempts = freeThrowAttempts;
    }

    public String getFreeThrowPercentage() {
        return freeThrowPercentage;
    }

    public void setFreeThrowPercentage(String freeThrowPercentage) {
        this.freeThrowPercentage = freeThrowPercentage;
    }

    public String getOffensiveRebounds() {
        return offensiveRebounds;
    }

    public void setOffensiveRebounds(String offensiveRebounds) {
        this.offensiveRebounds = offensiveRebounds;
    }

    public String getDefensiveRebounds() {
        return defensiveRebounds;
    }

    public void setDefensiveRebounds(String defensiveRebounds) {
        this.defensiveRebounds = defensiveRebounds;
    }

    public String getTotalRebounds() {
        return totalRebounds;
    }

    public void setTotalRebounds(String totalRebounds) {
        this.totalRebounds = totalRebounds;
    }

    public String getAssists() {
        return assists;
    }

    public void setAssists(String assists) {
        this.assists = assists;
    }

    public String getSteals() {
        return steals;
    }

    public void setSteals(String steals) {
        this.steals = steals;
    }

    public String getBlocks() {
        return blocks;
    }

    public void setBlocks(String blocks) {
        this.blocks = blocks;
    }

    public String getTurnovers() {
        return turnovers;
    }

    public void setTurnovers(String turnovers) {
        this.turnovers = turnovers;
    }

    public String getPersonalFouls() {
        return personalFouls;
    }

    public void setPersonalFouls(String personalFouls) {
        this.personalFouls = personalFouls;
    }

    public String getPoints() {
        return points;
    }

    public void setPoints(String points) {
        this.points = points;
    }

    public String getPlusMinus() {
        return plusMinus;
    }

    public void setPlusMinus(String plusMinus) {
        this.plusMinus = plusMinus;
    }
}
