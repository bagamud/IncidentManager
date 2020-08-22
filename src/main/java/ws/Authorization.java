//package ws;
//
//import ejb.SessionFactoryUtil;
//import entity.Users;
//import org.hibernate.Session;
//
//import javax.persistence.criteria.CriteriaBuilder;
//import javax.persistence.criteria.CriteriaQuery;
//import javax.persistence.criteria.Root;
//import javax.ws.rs.GET;
//import javax.ws.rs.Path;
//import javax.ws.rs.Produces;
//import javax.ws.rs.QueryParam;
//import javax.ws.rs.core.Context;
//import javax.ws.rs.core.UriInfo;
//import java.util.List;
//
///**
// * Веб-служба авторизации по паре логин/пароль, проверяющая совпадение в SQL аблице USERS
// *
// * @author Ponkratov K.
// */
//
//@Path("authorization")
//public class Authorization {
//    /*
//     TODO: Хэшсоль на пароль
//     */
//    @Context
//    UriInfo context;
//
//    @GET
//    @Produces("application/json")
//    public boolean logIn(@QueryParam("login") String login, @QueryParam("password") String password) {
//        boolean isLogin = false;
//
//        Session session = SessionFactoryUtil.getSessionFactory().openSession();
//        session.beginTransaction();
//        CriteriaBuilder builder = session.getCriteriaBuilder();
//
//        CriteriaQuery<Users> usersQuery = builder.createQuery(Users.class);
//        Root<Users> usersRoot = usersQuery.from(Users.class);
//        usersQuery.select(usersRoot);
//        List<Users> users = session.createQuery(usersQuery).getResultList();
//        for (Users user : users) {
//            if (user.getLogin().equals(login)) {
//                if (user.getPassword().equals(password)) {
//                    isLogin = true;
//                    break;
//                }
//            }
//        }
//
//        session.getTransaction().commit();
//        session.close();
//
//        return isLogin;
//    }
//}
