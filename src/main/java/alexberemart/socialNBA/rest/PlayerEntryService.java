package alexberemart.socialNBA.rest;

import Alexberemart.core.rest.AbstractRestService;
import alexberemart.socialNBA.model.vo.PlayerEntry;
import alexberemart.socialNBA.services.PlayerEntryServices;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Path("playerEntry")
public class PlayerEntryService extends AbstractRestService {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getBasketReferenceInfo(
            @QueryParam("sort") String orderBy,
            @QueryParam("order") String order,
            @QueryParam("offset") Integer offset,
            @QueryParam("limit") Integer perPage,
            @QueryParam("search") String search
    ) throws Exception {

        boolean asc = true;

        switch (order) {
            case "asc":
                asc = true;
                break;
            case "desc":
                asc = false;
                break;
        }

        List<PlayerEntry> playerEntries = PlayerEntryServices.getInstance().findWithFiltersPaginated(orderBy, offset, perPage, asc, search);

        Map<String, Object> result = new HashMap<>();
        result.put("rows", playerEntries);
        result.put("total", PlayerEntryServices.getInstance().countSearchResults());
        return ok(result);

    }
}
