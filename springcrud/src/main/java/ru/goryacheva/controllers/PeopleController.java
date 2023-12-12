package ru.goryacheva.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.goryacheva.model.Person;
import ru.goryacheva.service.ItemService;
import ru.goryacheva.service.PersonService;
import ru.goryacheva.util.PersonValidator;

import javax.validation.Valid;


@Controller
@RequestMapping("/people")
public class PeopleController {

    private final PersonService people;

    private final ItemService itemService;

    private final PersonValidator personValidator;

    @Autowired
    public PeopleController(PersonService people, ItemService item, PersonValidator personValidator) {
        this.people = people;
        this.itemService = item;
        this.personValidator = personValidator;
    }

//Получаем все записи.
    @GetMapping
    public String index(Model model) {
        model.addAttribute("people", people.findAll());
        return "people/index";
    }
/*
* Получаем одну запись по id.
* "/{id}" когда запустится приложение, вместо id можно поместить любое число
*/
    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("person", people.findOne(id));
        return "people/show";
    }

/*
* Форма создания записи.
* Нажатие на кнопку "create new person" вызывает этот метод -> приходит форма создания записи
*/
    @GetMapping("/new")
    public String newPerson(@ModelAttribute("person") Person person) {
        //model.addAttribute("person", new Person());
        return "people/new";
    }

/*
* Создание новой записи.
* Этот метод нужен, чтобы получить данные, которые пришли из формы (метод "newPerson").
* Создать новый объект, положить в него данные, которые пришли, и добавить этот объект в БД.
* Метод вызывается нажатием на кнопку "create" в форме создания записи.
* Никакой адрес не передаем в @PostMapping. Попадаем в этот метод по адресу ("/people")
*/
    @PostMapping
    public String create(@Valid @ModelAttribute("person") Person person,
                         BindingResult result) {
        personValidator.validate(person, result);
        if (result.hasErrors()) {
            return "people/new";
        } else {
            people.save(person);
            return "redirect:/people";
        }
    }

/*
* Форма редактирования записи.
* Вызывается после нажатия кнопки "edit". В этой форме данные будут обновляться.
*/
    @GetMapping("/{id}/edit")
    public String edit(@PathVariable("id") int id, Model model) {
        model.addAttribute("person", people.findOne(id));
        return "people/edit";
    }
/*
* Обновляем запись по id.
* Срабатывает после того, как мы исправили данные и нажали кнопку "update".
* Идет после метода "edit".
*/
    @PatchMapping("/{id}")
    public String update(@ModelAttribute("person") @Valid Person person,
                         @PathVariable("id") int id,
                         BindingResult result) {
        personValidator.validate(person, result);
        if (result.hasErrors())
            return "people/edit";

        people.update(id, person);
        return "redirect:/people";
    }

//Удаляем запись по id.
    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        people.delete(id);
        return "redirect:/people";
    }
}
