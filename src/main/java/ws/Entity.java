package ws;

import com.fasterxml.jackson.databind.ObjectMapper;
import ejb.SessionFactoryUtil;
import entity.Category;
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
     * TODO: Logger в каждом методе с записью в поле Journal INM.INCIDENT
     */
    @Context
    UriInfo context;

    @POST
    @Consumes("application/json")
    public void addIncident(String incidentJson) {
        int id = 0;
        try {
            Session session = SessionFactoryUtil.getSessionFactory().openSession();
            session.beginTransaction();

            Incident incident = new Incident();
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.readValue(incidentJson, Incident.class);

            Long longId = (Long) session.save(incident);
            id = longId.intValue();
            session.getTransaction().commit();
            session.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
//        return id;
    }

    @GET
    @Path("{id}")
    @Produces("application/json")
    public String getIncident(@QueryParam("id") int id) {
        String incidentJson = null;

        try {
            Session session = SessionFactoryUtil.getSessionFactory().openSession();
            session.beginTransaction();

            Incident incident = session.get(Incident.class, id);
            ObjectMapper objectMapper = new ObjectMapper();
            StringWriter s = new StringWriter();
            objectMapper.writeValue(s, incident);
            incidentJson = s.toString();
            session.getTransaction().commit();
            session.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return incidentJson;
    }

    @PUT
    @Consumes("application/json")
    public void updateIncident(int id, String incidentJson) {
        try {

            Session session = SessionFactoryUtil.getSessionFactory().openSession();
            session.beginTransaction();

            Incident incident = session.get(Incident.class, id);

            ObjectMapper objectMapper = new ObjectMapper();
            StringWriter s = new StringWriter();
            objectMapper.readValue(incidentJson, Incident.class);

            session.update(incident);
            session.getTransaction().commit();
            session.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @GET
    @Produces("application/json")
    public String getAllIncident() {
        String incidentJson = null;

        try {
            Session session = SessionFactoryUtil.getSessionFactory().openSession();
            session.beginTransaction();
            CriteriaBuilder builder = session.getCriteriaBuilder();

            CriteriaQuery<Incident> incidentQuery = builder.createQuery(Incident.class);
            Root<Incident> incidentRoot = incidentQuery.from(Incident.class);
            incidentQuery.select(incidentRoot);
            List<Incident> incidents = session.createQuery(incidentQuery).getResultList();

            ObjectMapper objectMapper = new ObjectMapper();
            StringWriter s = new StringWriter();
            objectMapper.writeValue(s, incidents);
            incidentJson = s.toString();
            session.getTransaction().commit();
            session.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return incidentJson;
    }
}
