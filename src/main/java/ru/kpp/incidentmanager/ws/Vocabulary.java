package ru.kpp.incidentmanager.ws;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import java.io.IOException;

@Path("vocabulary")
public class Vocabulary {

    /**
     * Веб-метод отвечающий за загрузку справочников для отображения на сайте
     */

    @GET
    @Produces("application/json")
    public String getSource(@QueryParam("source") String source) throws IOException {

        return null;
    }
}
