package alexberemart.socialNBA.model.vo.basketReference.readingAttributeState;

import alexberemart.socialNBA.model.vo.basketReference.PlayerStats;

public class ReadingFreeThrowsState extends ReadingAttributeState{
    @Override
    public void gotToNextState(PlayerStats playerStats, String attributeValue) {
        playerStats.setFreeThrows(attributeValue);
        playerStats.setState(new ReadingFreeThrowAttemptsState());
    }
}
