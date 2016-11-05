package alexberemart.socialNBA.rest;

import com.alexberemart.core.rest.AbstractRestService;
import alexberemart.socialNBA.model.vo.RestServiceLog;
import alexberemart.socialNBA.services.PlayerEntryServices;
import alexberemart.socialNBA.services.RestServiceLogServices;
import alexberemart.socialNBA.util.BootstrapTableUtils;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Path("restServiceLog")
public class RestServiceLogService extends AbstractRestService {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getBasketReferenceInfo(
            @QueryParam("sort") String orderBy,
            @QueryParam("order") String order,
            @QueryParam("offset") Integer offset,
            @QueryParam("limit") Integer perPage,
            @QueryParam("search") String search
    ) throws IOException {

        Boolean asc = BootstrapTableUtils.getBooleanOrder(order);

        List<RestServiceLog> restServiceLogList = RestServiceLogServices.getInstance().findWithFiltersPaginated(orderBy, offset, perPage, asc, search);
        Map<String, Object> result = new HashMap<>();
        result.put("rows", restServiceLogList);
        result.put("total", RestServiceLogServices.getInstance().countSearchResults(search));
        return ok(result);
    }
}
