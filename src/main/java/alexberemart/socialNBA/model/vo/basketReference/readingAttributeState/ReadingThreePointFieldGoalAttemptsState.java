package alexberemart.socialNBA.model.vo.basketReference.readingAttributeState;

import alexberemart.socialNBA.model.vo.basketReference.PlayerStats;

public class ReadingThreePointFieldGoalAttemptsState extends ReadingAttributeState{
    @Override
    public void gotToNextState(PlayerStats playerStats, String attributeValue) {
        playerStats.setThreePointFieldGoalAttempts(attributeValue);
        playerStats.setState(new ReadingThreePointFieldGoalPercentageState());
    }
}
