package ejb;

import entity.*;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class SessionFactoryUtil {
    private static SessionFactory sessionFactory;

    public SessionFactoryUtil() {
    }

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration().configure();
                configuration.addAnnotatedClass(Category.class);
                configuration.addAnnotatedClass(Department.class);
                configuration.addAnnotatedClass(Incident.class);
                configuration.addAnnotatedClass(IncStatus.class);
                configuration.addAnnotatedClass(Priority.class);
                configuration.addAnnotatedClass(Users.class);
                configuration.addAnnotatedClass(UsersGroup.class);

                StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
                sessionFactory = configuration.buildSessionFactory(builder.build());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }
}
