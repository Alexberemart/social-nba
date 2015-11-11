package alexberemart.socialNBA.model.vo;

import Alexberemart.core.model.vo.base.BaseEntity;

import javax.persistence.Table;

@org.hibernate.annotations.Entity(dynamicUpdate = true)
@Table(name = "matches")
@javax.persistence.Entity
public class Match extends BaseEntity{

    protected String idImported;

    public String getIdImported() {
        return idImported;
    }

    public void setIdImported(String idImported) {
        this.idImported = idImported;
    }
}
