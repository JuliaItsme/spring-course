package ru.goryacheva.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.goryacheva.model.Mood;
import ru.goryacheva.model.Person;
import ru.goryacheva.repository.PersonRepository;

import java.util.Date;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class PersonService {

    private final PersonRepository repository;

    @Autowired
    public PersonService(PersonRepository repository) {
        this.repository = repository;
    }

    public List<Person> findAll() {
        return repository.findAll();
    }

    public Person findOne(int id) {
        return repository.findById(id).orElse(null);
    }

    @Transactional
    public void save(Person person) {
        person.setCreatedAt(new Date());
        person.setMood(Mood.CALM);

        repository.save(person);
    }

    @Transactional
    public void update(int id, Person updatePerson) {
        updatePerson.setId(id);
        repository.save(updatePerson);
    }

    @Transactional
    public void delete(int id) {
        repository.deleteById(id);
    }
}
