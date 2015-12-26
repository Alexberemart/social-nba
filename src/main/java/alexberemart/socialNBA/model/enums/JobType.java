package alexberemart.socialNBA.model.enums;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonValue;

import java.util.HashMap;
import java.util.Map;

public enum JobType {

    BASKETBALL_REFERENCE_GAMES(0, "Basketball Reference Games");

    protected Integer value;
    protected String description;

    JobType(Integer code, String description) {
        this.value = code;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @JsonValue
    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    @JsonCreator
    public static JobType parse(Integer id) {
        JobType homeType = null; // Default
        for (JobType item : JobType.values()) {
            if (item.getValue().equals(id)) {
                homeType = item;
                break;
            }
        }
        return homeType;
    }

    public static Map asMap() {
        JobType[] values = JobType.values();
        Map<Integer, String> result = new HashMap();
        for (JobType value1 : values) {
            result.put(value1.getValue(), value1.getDescription());
        }

        return result;
    }
}
