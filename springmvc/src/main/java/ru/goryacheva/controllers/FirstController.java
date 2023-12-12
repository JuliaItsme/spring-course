package ru.goryacheva.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;


@Controller
@RequestMapping("/first")
public class FirstController {

    @GetMapping("/hello")
    public String helloPage(@RequestParam(value = "name", required = false) String name,
                            @RequestParam(value = "age", required = false) Integer age,
                            Model model) {
        model.addAttribute("message", "Hello, " + name + ", you age is " + age);
        //System.out.println("Hello, " + name + ", you age is " + age);
        return "first/hello";
    }

    @GetMapping("/goodbye")
    public String goodbyePage(){
        return "first/goodbye";
    }

    @GetMapping("/calculator")
    public String calculator(@RequestParam(value = "a", required = false) Integer a,
                             @RequestParam(value = "b", required = false) Integer b,
                             @RequestParam(value = "action", required = false) String action,
                             Model model){
        try {
            if (action.equals("division") && b == 0)
                model.addAttribute("result", "Can't divide by zero");
            else
                model.addAttribute("result", "The result is " + resultCalc(a, b, action));
        } catch (Exception e) {
            model.addAttribute("result", "Wrong parameters");
        }
        return "first/calculator";
    }


    private Object resultCalc(int a, int b, String action) {
        switch (action) {
            case "multiplication":
                return a * b;
            case "addition":
                return a + b;
            case "subtraction":
                return a - b;
            case "division":
                return a / (double)b;
        }
        return null;
    }
}
