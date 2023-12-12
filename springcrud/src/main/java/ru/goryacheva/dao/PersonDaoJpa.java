package ru.goryacheva.dao;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.goryacheva.model.Person;

import javax.persistence.EntityManager;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class PersonDaoJpa {
    private final EntityManager entityManager;

    @Autowired
    public PersonDaoJpa(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional(readOnly = true)
    public void testNPlus() {
        Session session = entityManager.unwrap(Session.class);

        //1 запрос
        List<Person> list = session.createQuery("select p from Person p", Person.class).getResultList();

        // N запросов
        for (Person p : list) {
            System.out.println("person " + p.getName() + "item: " + p.getItems());
        }

        //solution
        //sql: a left join b -.результирующая объединенная таблица
        Set<Person> people = new HashSet<>(session.createQuery("select p from Person p left join fetch p.items").getResultList());

        for (Person p : people) {
            System.out.println("person " + p.getName() + "item: " + p.getItems());
        }
    }
}
