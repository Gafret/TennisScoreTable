package tennis_score.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import tennis_score.models.Match;
import tennis_score.models.Player;

public class DbSessionFactory {
    private static SessionFactory instance;

    public SessionFactory getSessionFactory() {
        if (instance == null) {
            Configuration configuration = new Configuration();
            configuration.addAnnotatedClass(Player.class);
            configuration.addAnnotatedClass(Match.class);
            configuration.configure();

            configuration.setProperty("hibernate.connection.username", System.getenv("DB_USER"));
            configuration.setProperty("hibernate.connection.password", System.getenv("DB_PASS"));

            SessionFactory sessionFactory = configuration.buildSessionFactory();
            instance = sessionFactory;
            return sessionFactory;
        }
        return instance;
    }
}
