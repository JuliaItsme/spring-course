package ru.goryacheva.springBootSecurityApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.goryacheva.springBootSecurityApp.model.Person;
import ru.goryacheva.springBootSecurityApp.repository.PeopleRepository;

import java.util.Optional;

@Service
public class PersonService {
    private PeopleRepository repository;

    @Autowired
    public PersonService(PeopleRepository repository) {
        this.repository = repository;
    }

    public Optional<Person> findUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Person> person = repository.findByUsername(username);
        return person;
    }
}
