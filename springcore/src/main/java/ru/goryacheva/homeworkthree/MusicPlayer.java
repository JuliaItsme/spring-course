package ru.goryacheva.homeworkthree;

import org.springframework.beans.factory.annotation.Value;

import java.util.List;
import java.util.Random;

public class MusicPlayer {

    @Value("${musicPlayer.name}")
    private String name;

    @Value("${musicPlayer.volume}")
    private int volume;
    private final List<Music> listMusic;

    public MusicPlayer(List<Music> listMusic) {
        this.listMusic = listMusic;
    }

    public String getName() {
        return name;
    }

    public int getVolume() {
        return volume;
    }

    public String playMusic() {
        final Random random = new Random();
        return "Playing: " + listMusic.get(random.nextInt(listMusic.size())).getSong()
                + ", with volume: " + this.volume;
    }
}
