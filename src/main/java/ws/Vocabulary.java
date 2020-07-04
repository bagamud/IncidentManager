package ws;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;

@Path("/vocabulary")
public class Vocabulary {
    /**
     * TODO: SessionFactory вынести в Stateful класс
     */
    @Context
    UriInfo context;

    @GET
    @Produces("text/html")
    public String getData() {
        return "Hello World";
    }
}
