package alexberemart.socialNBA.model.vo;

import Alexberemart.core.model.vo.base.BaseEntity;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@org.hibernate.annotations.Entity(dynamicUpdate = true)
@Table(name = "matches")
@javax.persistence.Entity
public class Match extends BaseEntity{

    protected String idImported;
    protected List<PlayerEntry> playerEntryList = new ArrayList<>();

    public String getIdImported() {
        return idImported;
    }

    public void setIdImported(String idImported) {
        this.idImported = idImported;
    }

    @OneToMany(mappedBy = "match")
    @Cascade(CascadeType.ALL)
    public List<PlayerEntry> getPlayerEntryList() {
        return playerEntryList;
    }

    public void setPlayerEntryList(List<PlayerEntry> playerEntryList) {
        this.playerEntryList = playerEntryList;
    }
}
