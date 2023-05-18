package model.view;
import model.data.entities.*;
import model.data.implementation.*;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
public class StartWithJFrame {
    public static void main(String[] args) throws UnsupportedAudioFileException, LineUnavailableException, IOException {

        Person myTrainer = new Person(Constant.allenatoreMyLottaMale, "Alycia", Levels.MEDIUM);
        //myTrainer.setVictory(15);
        //myTrainer.setLevels();
        myTrainer.addPet(1, ConstantPet.leonard);
        myTrainer.addPet(0, ConstantPet.micky);
        //ConstantPet.mia.getAttackSet().remove(0);
        //ConstantPet.mia.getAttackSet().add(Attack.colpoCodaVigoroso);


        Person myTrainer1 = new Person(Constant.allenatore3Lotta, "Aly",Levels.BASE);
        myTrainer1.addPet(0,ConstantPet.donny);
        myTrainer1.addPet(1,ConstantPet.crissy);
        //System.out.println(myTrainer1.getPetList().get(0).getAttackSet().get(3).getName());
        //new LevelWindowOne(Constant.sfondoInit, Constant.musica1, Constant.messaggio,1000, 333,"F", myTrainer);
        //new LevelWindowZero("images/Sfondi/home.jpg", "images/audio/homeMusic.wav", Constant.messaggio,580 , 440,"M",myTrainer);
        //new WindowChoosePet(Constant.sfondoLotta1,Constant.fineLivello,Constant.musica1,500,300,"M",myTrainer);
        //new WindowTitle(Constant.sfondoInitGame,Constant.fineLivello,Constant.messaggio,500,300);
        //new LevelWindowsTwo(Constant.sfondoWoofyCity,Constant.musicaRoute1,Constant.messaggio,1000,700,"F",myTrainer);
        //new BattleWindow(Constant.sfondoBronze,Constant.musica2);
        //new LevelWindowThree(Constant.sfondoInit2, Constant.musicaRoute2, Constant.messaggio,1000, 333,"M", myTrainer);
        //new LevelWindowFour(Constant.sfondoMeowCity,Constant.musicaMeowCity,Constant.messaggio,1000,700,"F",myTrainer);
        new LevelWindowsFive(Constant.sfondoRoute3,Constant.musicaRoute3,Constant.messaggio,1000,333,"F",myTrainer);
        //new ServiceForBattle(myTrainer,myTrainer1,new BattleWindow(Constant.sfondoBronze,Constant.musicalotta2));
        //WindowLeader leader = new WindowLeader();
    }
}

