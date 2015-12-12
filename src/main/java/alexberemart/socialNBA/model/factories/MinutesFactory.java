package alexberemart.socialNBA.model.factories;

public class MinutesFactory {

    public Integer parseToInteger(String minutes) {
        if (minutes == null){
            return 0;
        }
        String[] timePlayed = minutes.split(":");
        Integer timePlayedInMilliseconds = Integer.parseInt(timePlayed[0]) * 60;
        timePlayedInMilliseconds += Integer.parseInt(timePlayed[1]);
        return timePlayedInMilliseconds;
    }
}
