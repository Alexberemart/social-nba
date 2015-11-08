package alexberemart.socialNBA.model.vo.basketReference.readingAttributeState;

import alexberemart.socialNBA.model.vo.basketReference.PlayerStats;

public class ReadingStealsState extends ReadingAttributeState{
    @Override
    public void gotToNextState(PlayerStats playerStats, String attributeValue) {
        playerStats.setSteals(attributeValue);
        playerStats.setState(new ReadingBlocksState());
    }
}
