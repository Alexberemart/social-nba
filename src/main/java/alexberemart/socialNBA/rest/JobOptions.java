package alexberemart.socialNBA.rest;

import Alexberemart.core.rest.AbstractRestService;
import alexberemart.socialNBA.model.enums.JobType;
import com.google.inject.servlet.RequestScoped;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RequestScoped
@Path("job-options")
public class JobOptions extends AbstractRestService {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getOptions() throws IOException {
        HashMap<String, Map> result = new HashMap<>();
        result.put("jobType", JobType.asMap());

        return ok(result);
    }
}
