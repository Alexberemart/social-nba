package alexberemart.socialNBA.model.vo.basketReference.readingAttributeState;

import alexberemart.socialNBA.model.vo.basketReference.PlayerStats;

public class ReadingOffensiveReboundsState extends ReadingAttributeState{
    @Override
    public void gotToNextState(PlayerStats playerStats, String attributeValue) {
        playerStats.setOffensiveRebounds(attributeValue);
        playerStats.setState(new ReadingDefensiveReboundsState());
    }
}
