package alexberemart.socialNBA.model.vo;

import Alexberemart.core.model.vo.base.BaseEntity;

import javax.persistence.Table;
import java.util.Date;

@org.hibernate.annotations.Entity(dynamicUpdate = true)
@Table(name = "rest_service_log")
@javax.persistence.Entity
public class RestServiceLog extends BaseEntity{

    protected Date date;
    protected String restServiceName;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getRestServiceName() {
        return restServiceName;
    }

    public void setRestServiceName(String restServiceName) {
        this.restServiceName = restServiceName;
    }
}
