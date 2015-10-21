package alexberemart.socialNBA.model.vo;

import Alexberemart.core.model.vo.base.BaseEntity;

import javax.persistence.Table;
import java.util.Date;

@org.hibernate.annotations.Entity(dynamicUpdate = true)
@Table(name = "sn_twit")
@javax.persistence.Entity
public class Twit extends BaseEntity{

    protected long twitId;
    protected String playerName;
    protected String text;
    protected Date date;
    protected String lang;
    protected Integer positiveWords;
    protected Integer negativeWords;

    public long getTwitId() {
        return twitId;
    }

    public void setTwitId(long twitId) {
        this.twitId = twitId;
    }

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

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public Integer getPositiveWords() {
        return positiveWords;
    }

    public void setPositiveWords(Integer positiveWords) {
        this.positiveWords = positiveWords;
    }

    public Integer getNegativeWords() {
        return negativeWords;
    }

    public void setNegativeWords(Integer negativeWords) {
        this.negativeWords = negativeWords;
    }
}
