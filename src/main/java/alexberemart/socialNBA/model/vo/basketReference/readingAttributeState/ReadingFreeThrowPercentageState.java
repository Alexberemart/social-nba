package alexberemart.socialNBA.model.vo.basketReference.readingAttributeState;

import alexberemart.socialNBA.model.vo.basketReference.PlayerStats;

public class ReadingFreeThrowPercentageState extends ReadingAttributeState{
    @Override
    public void gotToNextState(PlayerStats playerStats, String attributeValue) {
        playerStats.setFreeThrowPercentage(attributeValue);
        playerStats.setState(new ReadingOffensiveReboundsState());
    }
}
