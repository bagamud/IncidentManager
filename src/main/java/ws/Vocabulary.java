package ws;

import com.fasterxml.jackson.databind.ObjectMapper;
import ejb.SessionFactoryUtil;
import entity.*;
import org.hibernate.Session;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
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
     * Веб-метод отвечающий за загрузку справочников для отображения на сайте
     */
    @Context
    UriInfo context;

    @GET
    @Produces("application/json")
    public String getSource(@QueryParam("source") String source) throws IOException {
        Session session = SessionFactoryUtil.getSessionFactory().openSession();
        session.beginTransaction();
        ObjectMapper objectMapper = new ObjectMapper();
        StringWriter res = new StringWriter();
        CriteriaBuilder builder = session.getCriteriaBuilder();

        switch (source) {
            case "category":
                CriteriaQuery<Category> categoryQuery = builder.createQuery(Category.class);
                Root<Category> categoryRoot = categoryQuery.from(Category.class);
                categoryQuery.select(categoryRoot);
                List<Category> categories = session.createQuery(categoryQuery).getResultList();
                objectMapper.writeValue(res, categories);
                break;
            case "department":
                CriteriaQuery<Department> departmentQuery = builder.createQuery(Department.class);
                Root<Department> departmentRoot = departmentQuery.from(Department.class);
                departmentQuery.select(departmentRoot);
                List<Department> departments = session.createQuery(departmentQuery).getResultList();
                objectMapper.writeValue(res, departments);
                break;
            case "users":
                CriteriaQuery<Users> usersQuery = builder.createQuery(Users.class);
                Root<Users> usersRoot = usersQuery.from(Users.class);
                usersQuery.select(usersRoot);
                List<Users> users = session.createQuery(usersQuery).getResultList();
                objectMapper.writeValue(res, users);
                break;
            case "status":
                CriteriaQuery<IncStatus> statusQuery = builder.createQuery(IncStatus.class);
                Root<IncStatus> statusRoot = statusQuery.from(IncStatus.class);
                statusQuery.select(statusRoot);
                List<IncStatus> statuses = session.createQuery(statusQuery).getResultList();
                objectMapper.writeValue(res, statuses);
                break;
            case "priority":
                CriteriaQuery<Priority> priorityQuery = builder.createQuery(Priority.class);
                Root<Priority> priorityRoot = priorityQuery.from(Priority.class);
                priorityQuery.select(priorityRoot);
                List<Priority> priorities = session.createQuery(priorityQuery).getResultList();
                objectMapper.writeValue(res, priorities);
                break;
            default:
                break;
        }

        session.getTransaction().commit();
        session.close();
        return res.toString();
    }
}
