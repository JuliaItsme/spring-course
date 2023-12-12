package ru.goryacheva.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.goryacheva.model.Person;

import java.util.List;
import java.util.Optional;

@Component
public class PersonDaoHibernate {

    private final SessionFactory sessionFactory;

    @Autowired
    public PersonDaoHibernate(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional(readOnly = true)
    public List<Person> index() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("select p from Person p", Person.class).getResultList();
    }

    @Transactional(readOnly = true)
    public Person show(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Person.class, id);
    }

    @Transactional(readOnly = true)
    public Optional<Person> show(String email) {
        Session session = sessionFactory.getCurrentSession();
        return Optional.of(session.createQuery(
                "select p from Person p where p.email =:paramName", Person.class)
                .setParameter("paramName", email).getResultList().get(0));
    }

    @Transactional
    public void save(Person person) {
        Session session = sessionFactory.getCurrentSession();
        session.save(person);
    }

    @Transactional
    public void update(int id, Person person) {
        Session session = sessionFactory.getCurrentSession();
        Person newPerson = session.get(Person.class, id);

        newPerson.setName(person.getName());
        newPerson.setAge(person.getAge());
        newPerson.setEmail(person.getEmail());
    }

    @Transactional
    public void delete(int id) {
        Session session = sessionFactory.getCurrentSession();
        session.remove(session.get(Person.class, id));
    }
}
