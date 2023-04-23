package model.view;

import model.data.abstracted.LevelWindow;
import model.data.implementation.LevelWindowOne;
import model.entities.Constant;
import model.entities.Levels;
import model.entities.Person;
import model.services.ServiceForBattle;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class StartWithJFrame {
    public static void main(String[] args) throws UnsupportedAudioFileException, LineUnavailableException, IOException {

        LevelWindow levelWindow;
        ServiceForBattle service;

        Person per = new Person(Constant.allenatoreMy,"io", Levels.BASE);

        levelWindow = new LevelWindowOne(Constant.sfondoBronze,Constant.musica4,Constant.musica2);






    }
}
