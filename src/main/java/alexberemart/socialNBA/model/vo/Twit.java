package alexberemart.socialNBA.model.vo;

import Alexberemart.core.model.vo.base.BaseEntity;

import javax.persistence.Table;
import java.util.Date;

@org.hibernate.annotations.Entity(dynamicUpdate = true)
@Table(name = "sn_twit")
@javax.persistence.Entity
public class Twit extends BaseEntity{

    String playerName;
    String text;
    Date date;

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
