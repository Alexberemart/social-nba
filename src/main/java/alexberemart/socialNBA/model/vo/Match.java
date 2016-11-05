package alexberemart.socialNBA.model.vo;

import com.alexberemart.core.model.vo.base.BaseEntity;
import org.codehaus.jackson.annotate.JsonAutoDetect;
import org.codehaus.jackson.annotate.JsonBackReference;
import org.codehaus.jackson.annotate.JsonManagedReference;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Fetch;

import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@org.hibernate.annotations.Entity(dynamicUpdate = true)
@Table(name = "matches")
@javax.persistence.Entity
public class Match extends BaseEntity{

    protected String idImported;
    protected Long date;
    protected List<PlayerEntry> playerEntryList = new ArrayList<>();

    public String getIdImported() {
        return idImported;
    }

    public void setIdImported(String idImported) {
        this.idImported = idImported;
    }

    @OneToMany(mappedBy = "match")
    @Cascade(CascadeType.ALL)
    @JsonBackReference("match")
    public List<PlayerEntry> getPlayerEntryList() {
        return playerEntryList;
    }

    public void setPlayerEntryList(List<PlayerEntry> playerEntryList) {
        this.playerEntryList = playerEntryList;
    }

    public Long getDate() {
        return date;
    }

    public void setDate(Long date) {
        this.date = date;
    }
}
