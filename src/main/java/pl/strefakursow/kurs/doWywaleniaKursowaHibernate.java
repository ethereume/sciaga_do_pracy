package pl.strefakursow.kurs;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import pl.strefakursow.kurs.model.Department;

public class doWywaleniaKursowaHibernate {

    public static void main(String[] args) {
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        configuration.addAnnotatedClass(Department.class);

        SessionFactory factory = configuration.buildSessionFactory();
        Session session = factory.getCurrentSession();

        session.beginTransaction();

        //Query query = session.createQuery("select id from cos where id=:id");
        //query.setParameter("id",20);
        session.persist("as");

       // query.executeUpdate();

        session.getTransaction().commit();

        session.close();
    }

}
