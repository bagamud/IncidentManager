package ru.kpp.incidentmanager.ws;

import javax.ws.rs.*;
import java.io.IOException;


@Path("manager")
public class Entity {

    /*
      Веб-методы реализующие основное взаимодействие с записями об инцидентах, построенные по принципу RESTful
      веб-службы CRUD (Create, Read, Update, Delete). Внешнее взаимодействие организовано в формате JSON.

      @author Ponkratov K.
     */

    /*
    TODO: Logger в каждом методе с записью в поле Journal INM.INCIDENT
     */

    /**
     * Веб-метод добавления записи об инцидентев базу данных
     *
     * @param incidentJson - передаваемый экземпляр класса Incident в формате String
     * @return - возвращается ID записи, добавленной в базу данных
     * @throws IOException - общее исключение
     */

    @POST
    @Consumes("application/json")
    public int addIncident(String incidentJson) throws IOException {

        return 0;
    }

    /**
     * Веб-метод получения записи об инциденте из базы данных по ID номеру записи
     *
     * @param id - номер запрашиваемой записи
     * @return - возвращается экземпляр класса Incident в формате JSON
     */

    @GET
    @Produces("application/json")
    public String getIncident(@QueryParam("id") int id) {

        return null;
    }

    /**
     * Веб-метод обновления записи об инциденте в базе данных
     *
     * @param id           - номер обновляемой записи
     * @param incidentJson - экземпляр класса Incident в формате JSON передаваемый для обновления
     */

    @PUT
    @Consumes("application/json")
    public void updateIncident(int id, String incidentJson) {


    }

    /**
     * Веб-метод получения всех записей об инцидентах из базы данных
     *
     * @return - возвращается массив записей об инцидентах в формате JSON
     */

    @GET
    @Path("/all")
    @Produces("application/json")
    public String getAllIncident() {

        return null;
    }
}
