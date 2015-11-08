package alexberemart.socialNBA.model.vo.basketReference.readingAttributeState;

import alexberemart.socialNBA.model.vo.basketReference.PlayerStats;

public class ReadingTotalReboundsState extends ReadingAttributeState{
    @Override
    public void gotToNextState(PlayerStats playerStats, String attributeValue) {
        playerStats.setTotalRebounds(attributeValue);
        playerStats.setState(new ReadingAssistsState());
    }
}
