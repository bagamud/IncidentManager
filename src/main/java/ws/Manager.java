package ws;

import entity.Incident;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import java.sql.Timestamp;
import java.util.Date;

@Path("manager")
public class Manager {
    /**
     * TODO: SessionFactory вынести в Stateful класс
     */
    @Context
    UriInfo context;

    @POST
    @Path("/add{category},{priority},{rd},{requester},{rc},{ip},{duration},{description},{engineer},{operator},{status}")
    @Produces("text/html")
    public int addIncident(@PathParam("category") int category, @PathParam("priority") int priority,
                           @PathParam("rd") int requesterDepartment, @PathParam("requester") String requester,
                           @PathParam("rc") String requesterContacts, @PathParam("ip") String ipAddress, @PathParam("duration") Integer duration,
                           @PathParam("description") String description, @PathParam("engineer") Integer engineer,
                           @PathParam("operator") int operator, @PathParam("status") int status) {

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Incident incident = new Incident();
        incident.setDate(new Timestamp(new Date().getTime()));
        incident.setCategory(category);
        incident.setPriority(priority);
        incident.setRequesterDepartment(requesterDepartment);
        incident.setRequester(requester);
        incident.setIpAddress(ipAddress);
        incident.setDuration(duration);
        incident.setDescription(description);
        incident.setEngineer(engineer);
        incident.setOperator(operator);
        incident.setStatus(status);

        Long id = (Long) session.save(incident);
        session.getTransaction().commit();
        session.close();
        sessionFactory.close();

        return id.intValue();
    }

    @GET
    @Path("{id}")
    @Produces("text/html")
    public Incident getIncident(@QueryParam("id") int id) {

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Incident incident = session.get(Incident.class, id);

        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
        return incident;
    }

    @PUT
    @Path("/put{id},{category},{priority},{rd},{requester},{rc},{ip},{duration},{description},{engineer},{operator},{status}")
    @Produces("text/html")
    public void updateIncident(@QueryParam("id") int id, @PathParam("category") int category, @PathParam("priority") int priority,
                               @PathParam("rd") int requesterDepartment, @PathParam("requester") String requester,
                               @PathParam("rc") String requesterContacts, @PathParam("ip") String ipAddress, @PathParam("duration") Integer duration,
                               @PathParam("description") String description, @PathParam("engineer") Integer engineer,
                               @PathParam("operator") int operator, @PathParam("status") int status) {

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Incident incident = session.get(Incident.class, id);

        incident.setCategory(category);
        incident.setPriority(priority);
        incident.setRequesterDepartment(requesterDepartment);
        incident.setRequester(requester);
        incident.setIpAddress(ipAddress);
        incident.setDuration(duration);
        incident.setDescription(description);
        incident.setEngineer(engineer);
        incident.setOperator(operator);
        incident.setStatus(status);

        session.update(incident);
        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
    }
}
