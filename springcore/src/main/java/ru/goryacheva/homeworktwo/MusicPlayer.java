package ru.goryacheva.homeworktwo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component("musicPlayerHWT")
public class MusicPlayer {

    private Music classicalMusic;

    private Music rockMusic;

    public MusicPlayer() {
    }

    @Autowired
    public MusicPlayer(@Qualifier("classicalMusicHWT")Music classicalMusic,
                       @Qualifier("rockMusicHWT")Music rockMusic) {
        this.classicalMusic = classicalMusic;
        this.rockMusic = rockMusic;
    }

    public void playMusicList(MusicEnum music){
        final Random random = new Random();
        int number = random.nextInt(3);
        switch(music) {
            case CLASSICAL:
                System.out.println(classicalMusic.getListSongs().get(number));
                break;

            case ROCK:
                System.out.println(rockMusic.getListSongs().get(number));
                break;
        }
    }
}
