package alexberemart.socialNBA.rest;

import Alexberemart.core.rest.AbstractRestService;
import alexberemart.socialNBA.services.SocialNBAServices;
import twitter4j.TwitterException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.sql.SQLException;

@Path("Twit")
public class TwitService extends AbstractRestService {

    @GET
    @Path("loadAll")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUserFinancialEntries() throws IOException, TwitterException, SQLException {

        SocialNBAServices.getInstance().GetPlayerTwits();
        return ok("ok");

    }
}
