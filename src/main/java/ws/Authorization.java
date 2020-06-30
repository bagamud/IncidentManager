package ws;

import entity.Users;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import java.util.List;

@Path("/authorization")
public class Authorization {

    @GET
    @Path("{login},{password}")
    @Produces("text/plain")
    public boolean logIn(@QueryParam("login") String login, @QueryParam("password") String password) {
        boolean isLogin = false;

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Query query = session.createQuery("FROM Users");
        List<Users> users = query.getResultList();
        for (Users user : users) {
            if (user.getLogin().equals(login)) {
                if (user.getPassword().equals(password)) {
                    isLogin = true;
                }
            } else isLogin = false;
        }

        session.getTransaction().commit();
        session.close();
        sessionFactory.close();

        return isLogin;
    }
}
