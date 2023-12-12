package ru.goryacheva.util;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.goryacheva.dao.PersonDaoJdbcTemplate;
import ru.goryacheva.service.PersonService;
import ru.goryacheva.model.Person;

@Component
public class PersonValidator implements Validator {
    private final PersonDaoJdbcTemplate personDAO;

    private final PersonService service;

    @Autowired
    public PersonValidator(PersonDaoJdbcTemplate personDAO, PersonService service) {
        this.personDAO = personDAO;
        this.service = service;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return Person.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Person person = (Person) target;

        //посмотреть если ли человек с таким же email в БД
        if(personDAO.show(person.getEmail()).isPresent()) {
            // поле, код ошибки, сообщение ошибки
            errors.rejectValue("email", "", "This email is already taken");
        }

        if (!Character.isUpperCase(person.getName().codePointAt(0)))
            errors.rejectValue("name", "", "Name should be start with a capital letter");

    }
}

