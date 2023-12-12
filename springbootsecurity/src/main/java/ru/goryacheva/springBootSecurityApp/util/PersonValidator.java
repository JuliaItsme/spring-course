package ru.goryacheva.springBootSecurityApp.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.goryacheva.springBootSecurityApp.model.Person;
import ru.goryacheva.springBootSecurityApp.service.PersonService;

import java.util.Optional;

@Component
public class PersonValidator implements Validator {
    private final PersonService personService;

    @Autowired
    public PersonValidator(PersonService personService) {
        this.personService = personService;
    }

    @Override

    public boolean supports(Class<?> clazz) {
        return Person.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Person person = (Person) target;
        Optional<Person> returnPerson = personService.findUserByUsername(person.getUsername());
        if (returnPerson.isPresent())
            errors.rejectValue("username", "", "Человек с таким именем пользователя уже существует");
    }
}
