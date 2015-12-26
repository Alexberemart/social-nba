package alexberemart.socialNBA.model.vo;

import Alexberemart.core.model.vo.base.BaseEntity;
import org.codehaus.jackson.annotate.JsonAutoDetect;
import org.codehaus.jackson.annotate.JsonBackReference;
import org.codehaus.jackson.annotate.JsonProperty;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@org.hibernate.annotations.Entity(dynamicUpdate = true)
@Table(name = "jobs_parameters")
@Entity
@JsonAutoDetect
public class JobParameter extends BaseEntity {

    protected Job job;
    protected Integer orderParameter;
    protected String parameter;

    @ManyToOne
    @JoinColumn(name = "jobId", nullable = false)
    @JsonBackReference("job")
    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    @JsonProperty(value = "order")
    public Integer getOrderParameter() {
        return orderParameter;
    }

    public void setOrderParameter(Integer orderParameter) {
        this.orderParameter = orderParameter;
    }

    public String getParameter() {
        return parameter;
    }

    public void setParameter(String parameter) {
        this.parameter = parameter;
    }
}
