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
import java.util.ArrayList;
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
            @QueryParam("search") String search,
            @QueryParam("dateFilter") Long dateFilter
    ) throws Exception {

        Boolean asc = Boolean.TRUE;

        switch (order) {
            case "asc":
                asc = Boolean.TRUE;
                break;
            case "desc":
                asc = Boolean.FALSE;
                break;
        }

        if (dateFilter == 0){
            dateFilter = null;
        }

        List<PlayerEntry> playerEntries = PlayerEntryServices.getInstance().findWithFiltersPaginated(orderBy, offset, perPage, asc, search, dateFilter);

        if (playerEntries == null){
            playerEntries = new ArrayList<>();
        }

        Map<String, Object> result = new HashMap<>();
        result.put("rows", playerEntries);
        result.put("total", PlayerEntryServices.getInstance().countSearchResults(search));
        return ok(result);

    }
}
