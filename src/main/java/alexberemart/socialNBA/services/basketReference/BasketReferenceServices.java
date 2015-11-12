package alexberemart.socialNBA.services.basketReference;

import Alexberemart.core.util.ApplicationContextProvider;
import alexberemart.socialNBA.model.vo.basketReference.Match;
import alexberemart.socialNBA.model.vo.basketReference.PlayerStats;
import alexberemart.socialNBA.model.vo.basketReference.TeamStats;
import alexberemart.socialNBA.model.vo.basketReference.readingAttributeState.ReadingMinutesState;
import alexberemart.socialNBA.services.MatchServices;
import org.apache.commons.io.FileUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.io.IOException;
import java.net.SocketTimeoutException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BasketReferenceServices {

    @Autowired
    protected String basketReferenceLocalStorage;

    @Autowired
    protected String basketReferenceRemoteStorage;

    public static BasketReferenceServices getInstance() {
        return (BasketReferenceServices) ApplicationContextProvider.getInstance().getBean("basketReferenceServices");
    }

    public List<Match> saveMatchesFiles() throws IOException {
        List<Match> matchList = new ArrayList<>();
        List<String> urlList = getUrlMatches();
        Integer loopNumber = 0;
        System.out.println("Total Number of matches: " + urlList.size());
        for (String url : urlList) {
            Document doc = downloadBasketReferenceHTML("http://www.basketball-reference.com" + url);
            final File f = new File(basketReferenceLocalStorage + url);
            if (doc != null) {
                FileUtils.writeStringToFile(f, doc.outerHtml(), "UTF-8");
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

    private Document downloadBasketReferenceHTML(String url) throws IOException {
        Document doc;
        try {
            doc = Jsoup.connect(url).get();
        } catch (SocketTimeoutException e) {
            e.printStackTrace();
            return null;
        }
        return doc;
    }

    public List<Match> processMatches() throws Exception {
        List<Match> matchList = new ArrayList<>();
        Path path = Paths.get(basketReferenceRemoteStorage);
        if (Files.notExists(path)) {
            throw new Exception("No existe el fichero de almacenamiento remoto");
        }
        List<File> fileList = listFilesForFolder(basketReferenceRemoteStorage);
        for (File file : fileList){
            Match match = parseBasketReferenceHTML(file);
            if (match != null) {
                matchList.add(match);
            }
        }
        return matchList;
    }

    private List<File> listFilesForFolder(String folderPath) {
        final File folder = new File(folderPath);
        List<File> fileList = new ArrayList<>();
        Collections.addAll(fileList, folder.listFiles());
        return fileList;
    }

    private Match parseBasketReferenceHTML(File file) throws IOException {
        Document doc = Jsoup.parse(file, "UTF-8", "http://example.com/");
        Match match = new Match();
        String keyMatch = getMatchKey(file.getName());
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

    private String getMatchKey(String url) {
        Integer position = url.indexOf(".html");
        return url.substring(position - 12, position);
    }
}
