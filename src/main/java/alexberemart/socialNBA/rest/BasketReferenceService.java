package alexberemart.socialNBA.rest;

import Alexberemart.core.rest.AbstractRestService;
import alexberemart.socialNBA.services.PlayerEntryServices;
import alexberemart.socialNBA.services.basketReference.BasketReferenceServices;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;

@Path("basketReference")
public class BasketReferenceService extends AbstractRestService {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getBasketReferenceInfo() throws IOException {

        BasketReferenceServices.getInstance().saveMatchesFiles();
        return ok("ok");

    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response postBasketReferenceInfo() throws Exception {

        PlayerEntryServices.getInstance().processBasketReferenceInfo();
        return ok("ok");

    }
}
