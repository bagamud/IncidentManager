package ws;

import ejb.SessionFactoryUtil;
import entity.Users;
import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import java.util.List;

@Path("authorization")
public class Authorization {
    /**
     * TODO: Õ‎רסמכü םא ןאנמכü
     */
    @Context
    UriInfo context;

    @GET
    @Path("")
    @Produces("text/html")
    public String logIn(@QueryParam("login") String login, @QueryParam("password") String password) {
        boolean isLogin = false;

        Session session = SessionFactoryUtil.getSessionFactory().openSession();
        session.beginTransaction();

        Query query = session.createQuery("FROM USERS");
        List<Users> users = query.getResultList();
        for (Users user : users) {
            if (user.getLogin().equals(login)) {
                if (user.getPassword().equals(password)) {
                    isLogin = true;
                    break;
                }
            }
        }

        session.getTransaction().commit();
        session.close();

        return String.valueOf(isLogin);
    }
}
