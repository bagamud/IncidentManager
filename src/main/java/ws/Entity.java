package ws;

import com.fasterxml.jackson.databind.ObjectMapper;
import ejb.SessionFactoryUtil;
import entity.Incident;
import org.hibernate.Session;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import java.io.IOException;
import java.io.StringWriter;
import java.util.List;


@Path("manager")
public class Entity {

    /**
     * Веб-методы реализующие основное взаимодействие с записями об инцидентах, построенные по принципу RESTful
     * веб-службы CRUD (Create, Read, Update, Delete). Внешнее взаимодействие организовано в формате JSON.
     *
     * @author Ponkratov K.
     */

    /*
    TODO: Logger в каждом методе с записью в поле Journal INM.INCIDENT
     */

    @Context
    UriInfo context;

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
        int id = 0;
        Session session = SessionFactoryUtil.getSessionFactory().openSession();
        session.beginTransaction();

        ObjectMapper objectMapper = new ObjectMapper();
        Incident incident = objectMapper.readValue(incidentJson, Incident.class);
        id = (int) session.save(incident);
//        id = longId.intValue();
        session.getTransaction().commit();
        session.close();

        return id;
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

        Session session = SessionFactoryUtil.getSessionFactory().openSession();
        session.beginTransaction();

        Incident incident = session.get(Incident.class, id);

        ObjectMapper objectMapper = new ObjectMapper();
        StringWriter s = new StringWriter();
        try {
            objectMapper.writeValue(s, incident);
        } catch (IOException e) {
            e.printStackTrace();
        }

        session.getTransaction().commit();
        session.close();

        return s.toString();
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

        Session session = SessionFactoryUtil.getSessionFactory().openSession();
        session.beginTransaction();

        Incident incident = session.get(Incident.class, id);

        session.update(incident);
        session.getTransaction().commit();
        session.close();

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
        String incidentJson;
        Session session = SessionFactoryUtil.getSessionFactory().openSession();
        session.beginTransaction();
        CriteriaBuilder builder = session.getCriteriaBuilder();

        CriteriaQuery<Incident> incidentQuery = builder.createQuery(Incident.class);
        Root<Incident> incidentRoot = incidentQuery.from(Incident.class);
        incidentQuery.select(incidentRoot);
        List<Incident> incidents = session.createQuery(incidentQuery).getResultList();

        ObjectMapper objectMapper = new ObjectMapper();
        StringWriter s = new StringWriter();
        try {
            objectMapper.writeValue(s, incidents);
        } catch (IOException e) {
            e.printStackTrace();
        }
        incidentJson = s.toString();
        session.getTransaction().commit();
        session.close();

        return incidentJson;
    }
}
