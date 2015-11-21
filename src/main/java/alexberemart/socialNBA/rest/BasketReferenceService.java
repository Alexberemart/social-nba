package alexberemart.socialNBA.rest;

import Alexberemart.core.rest.AbstractRestService;
import alexberemart.socialNBA.services.basketReference.BasketReferenceServices;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("basketReference")
public class BasketReferenceService extends AbstractRestService {

    @POST
    @Path("getFilesToDownload")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getFilesToDownload(String input) throws Exception {

        System.out.println("hola php, he recibido tu petición en breve te envio los partidos que me tienes que enviar");
        List<String> result =BasketReferenceServices.getInstance().processMainFile(input);
        System.out.println("Los partidos que me tienes que enviar son estos " + result);
        return ok(result);
    }

    @POST
    @Path("fileRegister/{fileName}")
    @Produces(MediaType.TEXT_PLAIN)
    public Response fileRegister(@PathParam("fileName") String fileName, String input) throws Exception {

        System.out.println("proceso partido " + fileName);
        BasketReferenceServices.getInstance().parseBasketReferenceHTML(fileName, input);
        return ok("");
    }
}
