package ru.goryacheva.homework;

import ru.goryacheva.springcourse.Music;

public class RockMusic implements Music {

    @Override
    public String getSong() {
        return "Wind cries Mary";
    }
}
