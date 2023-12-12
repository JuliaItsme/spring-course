package ru.goryacheva.homeworktwo;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component("rockMusicHWT")
public class RockMusic implements Music {
    private final List<String> listSongs = new ArrayList<>();

    {
        listSongs.add("Wind cries Mary");
        listSongs.add("Highway the hell");
        listSongs.add("Carry On My Wayward Son");
    }

    @Override
    public List<String> getListSongs() {
        return listSongs;
    }
}
