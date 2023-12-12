package ru.goryacheva.homework;

import ru.goryacheva.springcourse.Music;

public class ClassicalMusic implements Music {

    public ClassicalMusic() {
    }

    // factory method
    public static ClassicalMusic getClassicalMusic() {
        return new ClassicalMusic();
    }

    public void doInit() {
        System.out.println("Doing my initialization");
    }

    public void doDestroy() {
        System.out.println("Doing my destruction");
    }

    @Override
    public String getSong() {
        return "Hungarian rhapsody";
    }

}
