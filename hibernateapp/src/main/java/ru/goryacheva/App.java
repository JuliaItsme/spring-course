package ru.goryacheva;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.goryacheva.model.Item;
import ru.goryacheva.model.Person;

public class App {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().addAnnotatedClass(Person.class).addAnnotatedClass(Item.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        try (sessionFactory) {
            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();

            session.getTransaction().commit();

          /*  Person person = session.get(Person.class, 1);
            System.out.println("получили человека");

            //закрыли сессию
            session.getTransaction().commit();
            System.out.println("session close");

            //открыли новую сессию
            session = sessionFactory.getCurrentSession();
            session.beginTransaction();

            // перевели в состояние persistent
            person = (Person)session.merge(person);

            //явно подгружаем связанные ленивые сущности
            Hibernate.initialize(person.getItems());

            // or

            List<Item> listItems = session.createQuery("select i from Item i where i.owner.id=:personId", Item.class)
                    .setParameter("personId",person.getId()).getResultList();*/

        }
        System.out.println("Good day, Julia!");
    }
}
