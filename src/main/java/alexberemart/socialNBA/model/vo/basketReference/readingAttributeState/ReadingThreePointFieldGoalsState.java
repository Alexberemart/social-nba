package alexberemart.socialNBA.model.vo.basketReference.readingAttributeState;

import alexberemart.socialNBA.model.vo.basketReference.PlayerStats;

public class ReadingThreePointFieldGoalsState extends ReadingAttributeState{
    @Override
    public void gotToNextState(PlayerStats playerStats, String attributeValue) {
        playerStats.setThreePointFieldGoals(attributeValue);
        playerStats.setState(new ReadingThreePointFieldGoalAttemptsState());
    }
}
