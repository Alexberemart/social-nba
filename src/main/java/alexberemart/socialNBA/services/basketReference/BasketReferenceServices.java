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
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

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
            if (matchesCounter < numberOfmatches) {
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

    public void fileRegister(String fileName, String fileText) throws ParseException {
        String keyMatch = getMatchKey(fileName);
        if (MatchServices.getInstance().ExistByKey(keyMatch) == Boolean.TRUE) {
            return;
        }
        Match match = getMatchInfoFromHtml(fileText, keyMatch);
        MatchServices.getInstance().saveMatch(MatchServices.getInstance().createMatch(match));
    }

    private Match getMatchInfoFromHtml(String fileText, String keyMatch) throws ParseException {
        Match match = new Match();
        Document doc = Jsoup.parse(fileText);
        match.setKey(keyMatch);
        match.setDate(getMatchDate(keyMatch));
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
                teamStats.getPlayerStatsList().add(playerStats);
            }
            match.getTeamEntries().add(teamStats);
        }
        return match;
    }

    private String getMatchKey(String url) {
        Integer position = url.indexOf(".html");
        return url.substring(position - 12, position);
    }

    private Date getMatchDate(String keyMatch) throws ParseException {
        DateFormat format = new SimpleDateFormat("yyyyMMdd", Locale.ENGLISH);
        return format.parse(keyMatch.substring(0, 8));
    }
}
