package ru.goryacheva.homework;

import ru.goryacheva.springcourse.Music;

public class RapMusic implements Music {

    @Override
    public String getSong() {
        return "Lost yourself";
    }
}
