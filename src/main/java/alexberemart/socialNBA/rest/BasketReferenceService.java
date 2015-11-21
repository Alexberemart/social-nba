package alexberemart.socialNBA.rest;

import Alexberemart.core.rest.AbstractRestService;
import alexberemart.socialNBA.services.PlayerEntryServices;
import alexberemart.socialNBA.services.basketReference.BasketReferenceServices;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.List;

@Path("basketReference")
public class BasketReferenceService extends AbstractRestService {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public Response getBasketReferenceInfo() throws IOException {

        BasketReferenceServices.getInstance().saveMatchesFiles();
        return ok("ok");

    }

    @POST
    @Produces(MediaType.TEXT_PLAIN)
    public Response postBasketReferenceInfo() throws Exception {

        PlayerEntryServices.getInstance().processBasketReferenceInfo();
        return ok("ok");

    }

    @POST
    @Path("files")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getFiles(String input) throws Exception {

        System.out.println("hola php, he recibido tu petición en breve te envio los partidos que me tienes que enviar");
        List<String> result =BasketReferenceServices.getInstance().processMainFile(input);
        System.out.println("Los partidos que me tienes que enviar son estos " + result);
        return ok(result);
    }

    @POST
    @Path("files2/{fileName}")
    @Produces(MediaType.TEXT_PLAIN)
    public Response getFiles2(@PathParam("fileName") String fileName, String input) throws Exception {

        System.out.println("proceso partido " + fileName);
        BasketReferenceServices.getInstance().parseBasketReferenceHTML(fileName, input);
        return ok("");
    }
}
