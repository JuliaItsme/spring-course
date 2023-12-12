package ru.goryacheva.springcourse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

//@Component
public class MusicPlayer {
    @Autowired
    @Qualifier("classicalMusic")
    private Music music;

    private Music classicalMusic;
    private Music rockMusic;

    @Value("${musicPlayer.name}")
    private String name;

    @Value("${musicPlayer.volume}")
    private int volume;

    public MusicPlayer() {
    }

    //Inversion of control
    //@Autowired
    public MusicPlayer(@Qualifier("classicalMusic")Music classicalMusic,
                       @Qualifier("rockMusic")Music rockMusic) {
        this.classicalMusic = classicalMusic;
        this.rockMusic = rockMusic;
    }

    public String getName() {
        return name;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public void setMusic(Music music) {
        this.music = music;
    }

    public String playMusic() {
        return "Playing: " + classicalMusic.getSong() + ", " + rockMusic.getSong();
        //return "Playing: " + music.getSong();
    }
}
