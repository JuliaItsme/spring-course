package ru.goryacheva.homeworkthree;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Configuration
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
    public JazzMusic jazzMusic(){
        return  new JazzMusic();
    }

    @Bean
    public List<Music> listMusic(){
        // Этот лист неизменяемый (immutable)
        return Arrays.asList(classicalMusic(), rockMusic(), jazzMusic());
    }

    @Bean
    public MusicPlayer musicPlayer(){
        return  new MusicPlayer(listMusic());
    }
}
