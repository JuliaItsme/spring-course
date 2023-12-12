package ru.goryacheva.springcourse;

import org.springframework.stereotype.Component;

//@Component("rockMusicBean")
//@Component
public class RockMusic implements Music {

    @Override
    public String getSong() {
        return "Wind cries Mary";
    }
}
