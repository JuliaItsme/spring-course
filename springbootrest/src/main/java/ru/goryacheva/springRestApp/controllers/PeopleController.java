package ru.goryacheva.springRestApp.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.goryacheva.springRestApp.dto.PersonDTO;
import ru.goryacheva.springRestApp.model.Person;
import ru.goryacheva.springRestApp.service.PeopleService;
import ru.goryacheva.springRestApp.util.PersonErrorResponse;
import ru.goryacheva.springRestApp.util.PersonNotCreatedException;
import ru.goryacheva.springRestApp.util.PersonNotFoundException;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController // @Controller + @ResponseBody над каждым методом
@RequestMapping("/people")
public class PeopleController {
    private final PeopleService peopleService;

    private final ModelMapper modelMapper;

    @Autowired
    public PeopleController(PeopleService peopleService, ModelMapper modelMapper) {
        this.peopleService = peopleService;
        this.modelMapper = modelMapper;
    }

    @GetMapping
    public List<PersonDTO> getPeople() {
        return peopleService.findAll().stream().map(this::mappingModelInDto).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public PersonDTO getPerson(@PathVariable("id") int id) {
        return mappingModelInDto(peopleService.findOne(id));
    }

    @PostMapping()
    public ResponseEntity<HttpStatus> create(@RequestBody @Valid PersonDTO personDTO, BindingResult error) {
        if (error.hasErrors()) {
            StringBuilder errorMessage = new StringBuilder();
            List<FieldError> listErrors = error.getFieldErrors();
            listErrors.forEach(e -> errorMessage.append(e).append(" - ").append(e.getDefaultMessage()).append("; "));
            throw new PersonNotCreatedException(errorMessage.toString());
        }
        peopleService.save(mappingDtoInModel(personDTO));
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @ExceptionHandler
    private ResponseEntity<PersonErrorResponse> handlerException(PersonNotFoundException e) {
        PersonErrorResponse response = new PersonErrorResponse(
                "Person with id not found!",
                System.currentTimeMillis()
        );
        // в HTTP ответе тело ответа(response) и статус заголовка
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND); // NOT_FOUND - 404 статус
    }

    @ExceptionHandler
    private ResponseEntity<PersonErrorResponse> handlerException(PersonNotCreatedException e) {
        PersonErrorResponse response = new PersonErrorResponse(
                e.getMessage(),
                System.currentTimeMillis()
        );
        // в HTTP ответе тело ответа(response) и статус заголовка
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
    private Person mappingDtoInModel(PersonDTO personDTO){
        return modelMapper.map(personDTO,Person.class);
    }

    private PersonDTO mappingModelInDto(Person person){
        return modelMapper.map(person,PersonDTO.class);
    }
}
