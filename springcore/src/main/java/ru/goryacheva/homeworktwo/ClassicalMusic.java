package ru.goryacheva.homeworktwo;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component("classicalMusicHWT")
public class ClassicalMusic implements Music {
    private final List<String> listSongs = new ArrayList<>();

    {
        listSongs.add("Hungarian rhapsody");
        listSongs.add("The Four Seasons");
        listSongs.add("Moonlight Sonata");
    }

    @Override
    public List<String> getListSongs() {
        return listSongs;
    }
}
