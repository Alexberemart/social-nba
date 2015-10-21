package alexberemart.socialNBA.model.factories;

import alexberemart.socialNBA.model.vo.Twit;
import twitter4j.Status;

public class TwitFactory {

    public Twit createTwit(Status status)
    {
        Twit twit = new Twit();
        twit.setTwitId(status.getId());
        twit.setDate(status.getCreatedAt());
        twit.setText(status.getText());
        twit.setLang(status.getLang());
        return twit;
    }
}
