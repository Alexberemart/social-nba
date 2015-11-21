package alexberemart.socialNBA.services.basketReference;

import Alexberemart.core.util.ApplicationContextProvider;
import alexberemart.socialNBA.model.vo.basketReference.Match;
import alexberemart.socialNBA.model.vo.basketReference.PlayerStats;
import alexberemart.socialNBA.model.vo.basketReference.TeamStats;
import alexberemart.socialNBA.model.vo.basketReference.readingAttributeState.ReadingMinutesState;
import alexberemart.socialNBA.services.MatchServices;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BasketReferenceServices {

    public static BasketReferenceServices getInstance() {
        return (BasketReferenceServices) ApplicationContextProvider.getInstance().getBean("basketReferenceServices");
    }

    public List<String> processMainFile(String htmlText) throws IOException {
        List<String> result = new ArrayList<>();
        Document doc = Jsoup.parse(htmlText);
        Element tableElement = doc.select("table")
                .select(".sortable")
                .select(".stats_table")
                .select("[id=games]")
                .get(0);
        Elements urlElements = tableElement.select("td[align=center]")
                .select("a")
                .select("[href^=/boxscores/]");
        final Integer numberOfmatches = 10;
        Integer matchesCounter = 0;
        for (Element urlElement : urlElements){
            if (matchesCounter <= numberOfmatches) {
                String fileKey = urlElement.attr("href");
                String keyMatch = getMatchKey(fileKey);
                if (MatchServices.getInstance().ExistByKey(keyMatch) == Boolean.FALSE) {
                    result.add(fileKey);
                    matchesCounter += 1;
                }
            }
        }
        return result;
    }

    public Match parseBasketReferenceHTML(String fileName, String fileText) throws IOException {
        Document doc = Jsoup.parse(fileText);
        Match match = new Match();
        List<PlayerStats> playerEntries = new ArrayList<>();
        String keyMatch = getMatchKey(fileName);
        match.setKey(keyMatch);
        if (MatchServices.getInstance().ExistByKey(keyMatch) == Boolean.TRUE) {
            return null;
        }
        Elements tableElements = doc.select("table")
                .select(".sortable")
                .select(".stats_table")
                .select("[id~=basic]");
        for (Element tableElement : tableElements) {
            TeamStats teamStats = new TeamStats();
            Elements rowElements = tableElement.select("tbody > tr")
                    .select("tr:not(.no_ranker)");
            for (Element rowElement : rowElements) {
                PlayerStats playerStats = new PlayerStats();
                playerStats.setState(new ReadingMinutesState());
                Element nameCellElement = rowElement.select("td")
                        .select("[align=left]")
                        .get(0);
                playerStats.setName(nameCellElement.text());
                Elements dataCellElements = rowElement.select("td")
                        .select("[align=right]");
                for (Element dataCellElement : dataCellElements) {
                    playerStats.getState().gotToNextState(playerStats, dataCellElement.text());
                }
                playerEntries.add(playerStats);
            }
            teamStats.setPlayerStatsList(playerEntries);
            match.getTeamEntries().add(teamStats);
        }
        MatchServices.getInstance().saveMatch(MatchServices.getInstance().createMatch(match));
        return match;
    }

    private String getMatchKey(String url) {
        Integer position = url.indexOf(".html");
        return url.substring(position - 12, position);
    }
}
