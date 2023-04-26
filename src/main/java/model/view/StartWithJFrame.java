package model.view;

import model.data.abstracted.LevelWindow;
import model.data.entities.*;
import model.data.implementation.LevelWindowOne;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class StartWithJFrame {
    public static void main(String[] args) throws UnsupportedAudioFileException, LineUnavailableException, IOException {

        Person myTrainer = new Person(Constant.allenatoreMy,"Leon", Levels.BASE);
        myTrainer.addPet(0,ConstantPetTrainer.mia);
        myTrainer.setVictory(4);

        LevelWindow levelWindow = new LevelWindowOne(Constant.sfondoInit,Constant.musica1,Constant.messaggio,3,myTrainer);
        levelWindow.updateTeamShow(myTrainer);

    }
}
