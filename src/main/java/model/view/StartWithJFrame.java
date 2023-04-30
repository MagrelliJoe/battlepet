package model.view;

import model.data.abstracted.LevelWindow;
import model.data.entities.*;
import model.data.implementation.WindowChoosePet;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class StartWithJFrame {
    public static void main(String[] args) throws UnsupportedAudioFileException, LineUnavailableException, IOException {

        Person myTrainer = new Person(Constant.allenatoreMy, "Alycia", Levels.BASE);
        myTrainer.addPet(0, ConstantPet.mia);
        myTrainer.setVictory(4);

        //LevelWindow levelWindow = new LevelWindowOne(Constant.sfondoInit, Constant.musica1, Constant.messaggio, 3, 1000, 333,"F", myTrainer);
        //LevelWindow levelWindow1 = new LevelWindowZero("images/Sfondi/home.jpg", "images/audio/homeMusic.wav", Constant.messaggio, 2,580 , 440,"M",myTrainer);
        LevelWindow levelWindow2 = new WindowChoosePet(Constant.sfondoInit,Constant.musicaInit,Constant.musica1,0,500,300,"M",myTrainer);
    }
}

