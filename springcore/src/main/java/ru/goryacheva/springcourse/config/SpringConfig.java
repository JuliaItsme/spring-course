package ru.goryacheva.springcourse.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import ru.goryacheva.springcourse.ClassicalMusic;
import ru.goryacheva.springcourse.Computer;
import ru.goryacheva.springcourse.MusicPlayer;
import ru.goryacheva.springcourse.RockMusic;

@Configuration
@ComponentScan("ru.goryacheva.springcourse")
@PropertySource("classpath:musicPlayer.properties")
public class SpringConfig {

    @Bean
    public ClassicalMusic classicalMusic(){
        return  new ClassicalMusic();
    }

    @Bean
    public RockMusic rockMusic(){
        return  new RockMusic();
    }

    @Bean
    public MusicPlayer musicPlayer(){
        return  new MusicPlayer(classicalMusic(), rockMusic());
    }

    @Bean
    public Computer computer(){
        return new Computer(musicPlayer());
    }
}
