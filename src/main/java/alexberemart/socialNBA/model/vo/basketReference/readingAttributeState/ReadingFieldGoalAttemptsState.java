package alexberemart.socialNBA.model.vo.basketReference.readingAttributeState;

import alexberemart.socialNBA.model.vo.basketReference.PlayerStats;

public class ReadingFieldGoalAttemptsState extends ReadingAttributeState{
    @Override
    public void gotToNextState(PlayerStats playerStats, String attributeValue) {
        playerStats.setFieldGoalAttempts(attributeValue);
        playerStats.setState(new ReadingFieldGoalPercentageState());
    }
}
