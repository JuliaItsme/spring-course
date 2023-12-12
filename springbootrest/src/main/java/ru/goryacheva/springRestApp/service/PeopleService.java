package ru.goryacheva.springRestApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.goryacheva.springRestApp.model.Person;
import ru.goryacheva.springRestApp.repository.PeopleRepository;
import ru.goryacheva.springRestApp.util.PersonNotFoundException;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class PeopleService {

    private final PeopleRepository repository;

    @Autowired
    public PeopleService(PeopleRepository repository) {
        this.repository = repository;
    }

    public List<Person> findAll() {
        return repository.findAll();
    }

    public Person findOne(int id) {
        Optional<Person> person = repository.findById(id);
        return person.orElseThrow(PersonNotFoundException::new);
    }

    @Transactional
    public void save(Person person) {
        enrichPerson(person);
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

    private void enrichPerson(Person person){
        person.setCreatedAt(LocalDateTime.now());
        person.setUpdatedAt(LocalDateTime.now());
        person.setCreatedWho("ADMIN");
    }
}
