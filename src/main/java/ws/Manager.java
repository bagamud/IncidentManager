package ws;

import com.fasterxml.jackson.databind.ObjectMapper;
import entity.Incident;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import java.io.IOException;
import java.io.StringWriter;

@Path("manager")
public class Manager {
    /**
     * TODO: SessionFactory вынести в Stateful класс
     * TODO: Logger в каждом методе с записью в поле Journal INM.INCIDENT
     */
    @Context
    UriInfo context;

    @POST
    @Path("/add{incidentJson}")
    @Produces("text/html")
    public int addIncident(@PathParam("incidentJson") String incidentJson) {
        int id = 0;
        try {
            SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
            Session session = sessionFactory.openSession();
            session.beginTransaction();

            Incident incident = new Incident();
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.readValue(incidentJson, Incident.class);

            Long longId = (Long) session.save(incident);
            id = longId.intValue();
            session.getTransaction().commit();
            session.close();
            sessionFactory.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return id;
    }

    @GET
    @Path("{id}")
    @Produces("text/html")
    public String getIncident(@QueryParam("id") int id) {
        String incidentJson = null;

        try {
            SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
            Session session = sessionFactory.openSession();
            session.beginTransaction();

            Incident incident = session.get(Incident.class, id);
            ObjectMapper objectMapper = new ObjectMapper();
            StringWriter s = new StringWriter();
            objectMapper.writeValue(s, incident);
            incidentJson = s.toString();
            session.getTransaction().commit();
            session.close();
            sessionFactory.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return incidentJson;
    }

    @PUT
    @Path("/put{id},{incidentJson}")
    @Produces("text/html")
    public void updateIncident(@QueryParam("id") int id, @PathParam("incidentJson") String incidentJson) {
        try {

            SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
            Session session = sessionFactory.openSession();
            session.beginTransaction();

            Incident incident = session.get(Incident.class, id);

            ObjectMapper objectMapper = new ObjectMapper();
            StringWriter s = new StringWriter();
            objectMapper.readValue(incidentJson, Incident.class);

            session.update(incident);
            session.getTransaction().commit();
            session.close();
            sessionFactory.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
