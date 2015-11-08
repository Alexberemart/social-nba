package alexberemart.socialNBA.model.vo.basketReference.readingAttributeState;

import alexberemart.socialNBA.model.vo.basketReference.PlayerStats;

public class ReadingThreePointFieldGoalPercentageState extends ReadingAttributeState{
    @Override
    public void gotToNextState(PlayerStats playerStats, String attributeValue) {
        playerStats.setThreePointFieldGoalPercentage(attributeValue);
        playerStats.setState(new ReadingFreeThrowsState());
    }
}
