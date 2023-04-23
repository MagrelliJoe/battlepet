import model.data.abstracted.LevelWindow;
import model.data.implementation.LevelWindowOne;
import model.entities.*;
import model.services.ServiceForBattle;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.io.IOException;
import java.util.Random;


public class StartJFrame {

    public static void main(String[] args) throws UnsupportedAudioFileException, IOException, LineUnavailableException {

        Person per = new Person(Constant.allenatoreMy,"io", Levels.BASE);
        Person per1 = new Person(Constant.allenatore6Lotta,"pippo",Levels.BASE);
        Person per2 = new Person(Constant.allenatore7Lotta,"ciccio",Levels.BASE);

        per.addPet(0,ConstantPet.pepita);
        per.addPet(1,ConstantPet.mia);
        per.addPet(2,ConstantPet.tex);

        per1.addPet(0,ConstantPet.mewcat);

        per2.addPet(0,ConstantPet.pulce);
        per2.addPet(2,ConstantPet.donny);

        Random r = new Random();
           int n = r.nextInt(2);
           if (n == 0) {
               //ServiceForBattle battle1 = new ServiceForBattle(per, per1, new BattleWindow(Constant.sfondoLotta1, Constant.musicalotta2, Constant.messaggio));
           }else {
               //ServiceForBattle battle = new ServiceForBattle(per, per2, new BattleWindow(Constant.sfondoLotta1, Constant.musicalotta2, Constant.messaggio));

           }


        LevelWindow levelWindow = new LevelWindowOne(Constant.sfondoBronze,Constant.musica4,Constant.musica2);
        levelWindow.updateTeamShow(per);



    }
}
