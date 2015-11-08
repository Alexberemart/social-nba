package alexberemart.socialNBA.model.vo.basketReference.readingAttributeState;

import alexberemart.socialNBA.model.vo.basketReference.PlayerStats;

public class ReadingFieldGoalPercentageState extends ReadingAttributeState{
    @Override
    public void gotToNextState(PlayerStats playerStats, String attributeValue) {
        playerStats.setFieldGoalPercentage(attributeValue);
        playerStats.setState(new ReadingThreePointFieldGoalsState());
    }
}
