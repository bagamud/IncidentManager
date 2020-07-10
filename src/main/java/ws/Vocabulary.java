package ws;

import com.fasterxml.jackson.databind.ObjectMapper;
import entity.Category;
import entity.Department;
import entity.Users;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import java.io.IOException;
import java.io.StringWriter;
import java.util.List;

@Path("vocabulary")
public class Vocabulary {
    /**
     * TODO: SessionFactory вынести в Stateful класс
     */
    @Context
    UriInfo context;
    @GET
    @Path("")
    @Produces("text/html")
    public String getSource(@QueryParam("source") String source) throws IOException {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        ObjectMapper objectMapper = new ObjectMapper();
        StringWriter res = new StringWriter();
        Query query;

        switch (source) {
            case "category":
                query = session.createQuery("FROM CATEGORY");
                List<Category> categories = query.getResultList();
                objectMapper.writeValue(res, categories);
                break;
            case "department":
                query = session.createQuery("FROM DEPARTMENT");
                List<Department> departments = query.getResultList();
                objectMapper.writeValue(res, departments);
                break;
            case "users":
                query = session.createQuery("FROM USERS");
                List<Users> users = query.getResultList();
                objectMapper.writeValue(res, users);
                break;
            default:
                break;
        }

        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
        return res.toString();
    }
}
