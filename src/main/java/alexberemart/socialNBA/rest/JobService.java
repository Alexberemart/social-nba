package alexberemart.socialNBA.rest;

import com.alexberemart.core.rest.AbstractRestService;
import alexberemart.socialNBA.model.vo.Job;
import alexberemart.socialNBA.services.JobServices;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.InjectableValues;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.*;

@Path("job")
@Produces(MediaType.APPLICATION_JSON)
public class JobService extends AbstractRestService {

    @GET
    public Response getJobs(
            @QueryParam("sort") String orderBy,
            @QueryParam("order") String order,
            @QueryParam("offset") Integer offset,
            @QueryParam("limit") Integer perPage,
            @QueryParam("search") String search
    ) throws Exception {

        List<Job> jobList = JobServices.getInstance().findAll();

        if (jobList == null) {
            jobList = new ArrayList<>();
        }

        Map<String, Object> result = new HashMap<>();
        result.put("rows", jobList);
        result.put("total", jobList.size());
        return ok(result);

    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response saveJob(JsonNode jsonNode) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        Job job = mapper.readValue(jsonNode, Job.class);
        JobServices.getInstance().saveJob(job);
        return ok(job);
    }
}
