package model.view;
import model.data.abstracted.LevelWindow;
import model.data.entities.*;
import model.data.implementation.LevelWindowOne;
import model.data.implementation.LevelWindowsTwo;
import model.data.implementation.WindowTitle;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
public class StartWithJFrame {
    public static void main(String[] args) throws UnsupportedAudioFileException, LineUnavailableException, IOException {

        Person myTrainer = new Person(Constant.allenatoreMy, "Alycia",Levels.BASE);
        myTrainer.addPet(1, ConstantPet.bianchina);
        myTrainer.addPet(0, ConstantPet.mia);
        //ConstantPet.mia.getAttackSet().remove(0);
        //ConstantPet.mia.getAttackSet().add(Attack.colpoCodaVigoroso);


        Person myTrainer1 = new Person(Constant.allenatore3Lotta, "Aly",Levels.BASE);
        myTrainer1.addPet(0,ConstantPet.donny);
        myTrainer1.addPet(1,ConstantPet.crissy);
        //System.out.println(myTrainer1.getPetList().get(0).getAttackSet().get(3).getName());
        //LevelWindow levelWindow = new LevelWindowOne(Constant.sfondoInit, Constant.musica1, Constant.messaggio,1000, 333,"F", myTrainer);
        //LevelWindow levelWindow1 = new LevelWindowZero("images/Sfondi/home.jpg", "images/audio/homeMusic.wav", Constant.messaggio,580 , 440,"M",myTrainer);
        //LevelWindow levelWindow2 = new WindowChoosePet(Constant.sfondoLotta1,Constant.fineLivello,Constant.musica1,500,300,"M",myTrainer);
        //LevelWindow levelWindow = new WindowTitle("images/logoInit.jpg",Constant.fineLivello,Constant.messaggio,500,300);
        LevelWindow levelWindow3 = new LevelWindowsTwo(Constant.sfondoBronze,Constant.musica2,Constant.messaggio,1000,700,"M",myTrainer);
        //BattleWindow battleWindow = new BattleWindow(Constant.sfondoBronze,Constant.musica2);

        //ServiceForBattle battle = new ServiceForBattle(myTrainer,myTrainer1,new BattleWindow(Constant.sfondoBronze,Constant.musica2));
        //WindowLeader leader = new WindowLeader();
    }
}

