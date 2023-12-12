package ru.goryacheva.springcourse;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
@Scope("prototype")
public class ClassicalMusic implements Music{

    public ClassicalMusic() {
    }

/*
    // factory method
    public static ClassicalMusic getClassicalMusic(){
        return new ClassicalMusic();
    }
*/

    @PostConstruct
    public void doInit(){
        System.out.println("Doing my initialization");
    }

    @PreDestroy
    public void doDestroy(){
        System.out.println("Doing my destruction");
    }

    @Override
    public String getSong() {
        return "Hungarian rhapsody";
    }

}
