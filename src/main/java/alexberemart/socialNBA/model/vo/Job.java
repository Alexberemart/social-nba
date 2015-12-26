package alexberemart.socialNBA.model.vo;

import Alexberemart.core.model.vo.base.BaseEntity;
import alexberemart.socialNBA.model.enums.JobType;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonManagedReference;
import org.codehaus.jackson.annotate.JsonProperty;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@org.hibernate.annotations.Entity(dynamicUpdate = true)
@Table(name = "jobs")
@Entity
public class Job extends BaseEntity {

    protected Integer type;
    protected Integer priority;
    protected List<JobParameter> parameters = new ArrayList<>();

    public JobType getType() {
        return JobType.parse(this.type);
    }

    //USAR CUANDO ENUMS
    @JsonProperty
    public void setType(JobType jobType) {
        if(jobType == null) {
            this.type = null;
        } else {
            this.type = jobType.getValue();
        }
    }

    //USAR CUANDO ENUMS
    @JsonIgnore
    public void setType(Integer jobType) {
        JobType parse = JobType.parse(jobType);
        if (parse != null) {
            this.type = jobType;
        }
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    @OneToMany(mappedBy = "job", fetch = FetchType.EAGER)
    @Cascade(CascadeType.ALL)
    @JsonManagedReference("job")
    public List<JobParameter> getParameters() {
        return parameters;
    }

    public void setParameters(List<JobParameter> parameters) {
        this.parameters = parameters;
    }

}
