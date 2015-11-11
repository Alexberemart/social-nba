package alexberemart.socialNBA.rest;

import Alexberemart.core.rest.AbstractRestService;
import alexberemart.socialNBA.services.PlayerEntryServices;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;

@Path("playerEntry")
public class PlayerEntryService extends AbstractRestService {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getBasketReferenceInfo() throws Exception {

        PlayerEntryServices.getInstance().processBasketReferenceInfo();

        return ok("ok");

    }
}
