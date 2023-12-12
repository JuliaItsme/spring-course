package ru.goryacheva.homeworktwo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Julia Goryacheva
 */

public class TestSpring {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "applicationContext.xml");

        MusicPlayer musicPlayer = context.getBean("musicPlayerHWT", MusicPlayer.class);
        musicPlayer.playMusicList(MusicEnum.ROCK);
        context.close();
    }
}
