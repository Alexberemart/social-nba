package alexberemart.socialNBA.model.vo.basketReference.readingAttributeState;

import alexberemart.socialNBA.model.vo.basketReference.PlayerStats;

public class ReadingFieldGoalsState extends ReadingAttributeState{
    @Override
    public void gotToNextState(PlayerStats playerStats, String attributeValue) {
        playerStats.setFieldGoals(attributeValue);
        playerStats.setState(new ReadingFieldGoalAttemptsState());
    }
}
