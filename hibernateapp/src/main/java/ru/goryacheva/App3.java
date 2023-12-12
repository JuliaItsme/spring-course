package ru.goryacheva;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.goryacheva.model.Principal;
import ru.goryacheva.model.School;

public class App3 {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().addAnnotatedClass(Principal.class)
                .addAnnotatedClass(School.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        try (sessionFactory) {
            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();

//2
            /*Principal p = session.get(Principal.class, 3);
            School s = p.getSchool();
            System.out.println(p +", school=" + s.getSchoolNumber());*/

//3
            /*School school = session.get(School.class, 4);
            Principal p = school.getPrincipal();
            System.out.println(school + ", " + p);*/

//4
           /* Principal newP = new Principal("Katrin", 49);
            School newS = new School(387);
            newP.setSchool(newS);
            session.save(newP);*/

//5
            /*Principal newP = session.get(Principal.class, 6);
            School school = session.get(School.class, 5);
            newP.setSchool(school);*/

//6
            School newS = new School(122);
            session.save(newS);
            Principal newP = session.get(Principal.class, 6);
            newP.setSchool(newS);

            session.getTransaction().commit();
        }
        System.out.println("Good day, Julia!");
    }
}
