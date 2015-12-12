package alexberemart.socialNBA.model.vo;

import Alexberemart.core.model.vo.base.BaseEntity;
import org.codehaus.jackson.annotate.JsonBackReference;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@org.hibernate.annotations.Entity(dynamicUpdate = true)
@Table(name = "players")
@Entity
public class Player extends BaseEntity{

    protected String idImported;
    protected String name;

    protected List<PlayerEntry> playerEntryList = new ArrayList<>();

    public String getIdImported() {
        return idImported;
    }

    public void setIdImported(String idImported) {
        this.idImported = idImported;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToMany(mappedBy = "player")
    @Cascade(CascadeType.ALL)
    @JsonBackReference("player")
    public List<PlayerEntry> getPlayerEntryList() {
        return playerEntryList;
    }

    public void setPlayerEntryList(List<PlayerEntry> playerEntryList) {
        this.playerEntryList = playerEntryList;
    }

}
