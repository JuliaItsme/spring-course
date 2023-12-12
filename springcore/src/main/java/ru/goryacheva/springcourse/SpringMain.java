package ru.goryacheva.springcourse;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext
import ru.goryacheva.springcourse.config.SpringConfig;

public class SpringMain {
    public static void main(String[] args) {
        //конфигурация через java код
        AnnotationConfigApplicationContext context2 = new AnnotationConfigApplicationContext(SpringConfig.class);

//для конфигурации через xml и xml+annotation
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

//@predestroy, @postcontract, @scope, @value
        MusicPlayer musicPlayer = context.getBean("musicPlayer", MusicPlayer.class);
        System.out.println(musicPlayer.getName());
        System.out.println(musicPlayer.getVolume());

        ClassicalMusic classicalMusicOne = context.getBean("classicalMusic", ClassicalMusic.class);
        ClassicalMusic classicalMusicTwo = context.getBean("classicalMusic", ClassicalMusic.class);
        System.out.println(classicalMusicOne == classicalMusicTwo);

// аннотация @Autowired
        Computer computer = context.getBean("computer", Computer.class);
        System.out.println(computer);

        MusicPlayer musicPlayer1 = context.getBean("musicPlayer", MusicPlayer.class);
        musicPlayer1.playMusic();


//аннотации ("@Component") ч.1
        //Music music = context.getBean("rockMusicBean", Music.class);
        Music music = context.getBean("rockMusic", Music.class);
        MusicPlayer musicPlayer2 = new MusicPlayer(music);
        musicPlayer2.playMusic();

        Music music1 = context.getBean("classicalMusic", Music.class);
        MusicPlayer classicalMusicPlayer = new MusicPlayer(music1);
        classicalMusicPlayer.playMusic();

//lifecycle, init, destroy и factory method
        ClassicalMusic classicalMusic1 = context.getBean("musicBeanOne", ClassicalMusic.class);
        System.out.println(classicalMusic1.getSong());
        ClassicalMusic classicalMusic2 = context.getBean("musicBeanOne", ClassicalMusic.class);
        System.out.println(classicalMusic2.getSong());
        ClassicalMusic classicalMusic3 = context.getBean("musicBeanOne", ClassicalMusic.class);
        System.out.println(classicalMusic3.getSong());

//scope
        MusicPlayer firstMusicPlayer = context.getBean("musicPlayer", MusicPlayer.class);
        MusicPlayer secondMusicPlayer = context.getBean("musicPlayer", MusicPlayer.class);
        boolean comparison = firstMusicPlayer == secondMusicPlayer;
        System.out.println(comparison);
        System.out.println(firstMusicPlayer);
        System.out.println(secondMusicPlayer);
        firstMusicPlayer.setVolume(10);
        System.out.println(firstMusicPlayer.getVolume());
        System.out.println(secondMusicPlayer.getVolume());

//DI ч.2
        Music music3 = context.getBean("classicalMusic", Music.class);
        MusicPlayer musicPlayer3 = new MusicPlayer();
        musicPlayer3.setMusic(music);
        musicPlayer3.playMusic();

        MusicPlayer musicPlayer4 = context.getBean("musicPlayer", MusicPlayer.class);
        musicPlayer4.playMusic();
        System.out.println(musicPlayer4.getName());
        System.out.println(musicPlayer4.getVolume());

//DI ч.1
        MusicPlayer musicPlayer5 = context.getBean("musicPlayer", MusicPlayer.class);
        musicPlayer5.playMusic();

//IoC
        Music music4 = context.getBean("musicBeanOne", Music.class);
        MusicPlayer musicPlayer6 = new MusicPlayer(music4);
        musicPlayer6.playMusic();

//test
        TestBean testBean = context.getBean("testBean", TestBean.class);
        System.out.println(testBean.getName());

        context.close();
    }
}
