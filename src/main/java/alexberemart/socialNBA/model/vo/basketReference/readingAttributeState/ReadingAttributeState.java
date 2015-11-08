package alexberemart.socialNBA.model.vo.basketReference.readingAttributeState;

import alexberemart.socialNBA.model.vo.basketReference.PlayerStats;

public abstract class ReadingAttributeState {

    public abstract void gotToNextState(PlayerStats playerStats, String attributeValue);
}
