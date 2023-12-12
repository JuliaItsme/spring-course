package ru.goryacheva.controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import ru.goryacheva.dao.PersonDaoJdbcTemplate;
import ru.goryacheva.model.Person;


public class AdminController {
    private final PersonDaoJdbcTemplate personDAO;


    public AdminController(PersonDaoJdbcTemplate personDAO) {
        this.personDAO = personDAO;
    }


    public String adminPage(@ModelAttribute("person") Person person, Model model){
        model.addAttribute("people", personDAO.index());
        return "adminPage";
    }

    public String makeAdmin(@ModelAttribute("person") Person person){
        System.out.println(person.getId());
        return "redirect:/people";
    }
}
