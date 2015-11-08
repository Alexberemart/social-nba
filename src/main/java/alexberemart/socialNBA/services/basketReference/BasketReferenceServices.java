package alexberemart.socialNBA.services.basketReference;

import Alexberemart.core.util.ApplicationContextProvider;
import alexberemart.socialNBA.model.vo.basketReference.Match;
import alexberemart.socialNBA.model.vo.basketReference.PlayerStats;
import alexberemart.socialNBA.model.vo.basketReference.TeamStats;
import alexberemart.socialNBA.model.vo.basketReference.readingAttributeState.ReadingMinutesState;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.List;

public class BasketReferenceServices {

    public static BasketReferenceServices getInstance() {
        return (BasketReferenceServices) ApplicationContextProvider.getInstance().getBean("basketReferenceServices");
    }

    public List<Match> getMatches() throws IOException {
        List<Match> matchList = new ArrayList<>();
        List<String> urlList = getUrlMatches();
        Integer loopNumber = 0;
        System.out.println("Total Number of matches: " + urlList.size());
        for (String url : urlList) {
            Match match = parseBasketReferenceHTML("http://www.basketball-reference.com" + url);
            if (match != null){
                matchList.add(match);
            }
            loopNumber += 1;
            System.out.println("Load " + loopNumber + " of " + urlList.size());
        }
        return matchList;
    }

    private List<String> getUrlMatches() throws IOException {

        List<String> result = new ArrayList<>();
        Document doc = Jsoup.connect("http://www.basketball-reference.com/leagues/NBA_2016_games.html").get();
        Element tableElement = doc.select("table")
                .select(".sortable")
                .select(".stats_table")
                .select("[id=games]")
                .get(0);
        Elements urlElements = tableElement.select("td[align=center]")
                .select("a")
                .select("[href^=/boxscores/]");
        for (Element urlElement : urlElements) {
            result.add(urlElement.attr("href"));
        }
        return result;
    }

    private Match parseBasketReferenceHTML(String url) throws IOException {
        Match match = new Match();
        Document doc;
        try {
            doc = Jsoup.connect(url).get();
        } catch (SocketTimeoutException e) {
            e.printStackTrace();
            return null;
        }
        Elements tableElements = doc.select("table")
                .select(".sortable")
                .select(".stats_table")
                .select("[id~=basic]");
        for (Element tableElement : tableElements) {
            TeamStats teamStats = new TeamStats();
            List<PlayerStats> playerEntries = new ArrayList<>();
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
        return match;
    }
}
