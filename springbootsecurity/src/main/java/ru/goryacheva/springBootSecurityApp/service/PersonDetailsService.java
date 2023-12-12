package ru.goryacheva.springBootSecurityApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.goryacheva.springBootSecurityApp.model.Person;
import ru.goryacheva.springBootSecurityApp.repository.PeopleRepository;
import ru.goryacheva.springBootSecurityApp.security.PersonDetails;

import java.util.Optional;

@Service
public class PersonDetailsService implements UserDetailsService {
    private PeopleRepository repository;

    @Autowired
    public PersonDetailsService(PeopleRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Person> person = repository.findByUsername(username);
        if(person.isEmpty())
            throw new UsernameNotFoundException("User: " + username + ", not found!");
        return new PersonDetails(person.get());
    }
}
