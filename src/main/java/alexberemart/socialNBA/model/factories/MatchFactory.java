package alexberemart.socialNBA.model.factories;

import alexberemart.socialNBA.model.vo.Match;
import alexberemart.socialNBA.model.vo.PlayerEntry;
import alexberemart.socialNBA.model.vo.basketReference.PlayerStats;
import alexberemart.socialNBA.model.vo.basketReference.TeamStats;
import alexberemart.socialNBA.services.PlayerEntryServices;

public class MatchFactory {

    public Match createMatchFromBasketballReference(alexberemart.socialNBA.model.vo.basketReference.Match basketReferenceMatch) {
        Match match = new Match();
        match.setIdImported(basketReferenceMatch.getKey());
        for (TeamStats teamStats : basketReferenceMatch.getTeamEntries()) {
            for (PlayerStats playerStats : teamStats.getPlayerStatsList()) {
                PlayerEntry playerEntry = PlayerEntryServices.getInstance().createPlayerEntryFromBasketballReference(playerStats, match);
                match.getPlayerEntryList().add(playerEntry);
            }
        }
        return match;
    }
}
