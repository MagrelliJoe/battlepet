import model.entities.*;
import model.services.ServiceForBattle;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.util.Random;

public class StartJFrame {

    public static void main(String[] args) throws UnsupportedAudioFileException, IOException, LineUnavailableException {

        Person per = new Person(Constant.allenatoreMy,"io", Levels.GREAT);
        Person per1 = new Person(Constant.allenatore6Lotta,"pippo",Levels.GREAT);
        Person per2 = new Person(Constant.allenatore7Lotta,"ciccio",Levels.GREAT);


        per.addPet(0,ConstantPet.pettyRed);
        per.addPet(1,ConstantPet.crissy);
        per.addPet(2,ConstantPet.mewcat);

        per1.addPet(0,ConstantPet.pepita);

        per2.addPet(0,ConstantPet.piumino);
        per2.addPet(1,ConstantPet.gomitolo);
        per2.addPet(2,ConstantPet.leo);

        Random r = new Random();
           int n = r.nextInt(2);
           if (n == 0) {
               ServiceForBattle battle1 = new ServiceForBattle(per, per1, new BattleWindows(Constant.sfondoLotta1, Constant.musicalotta2, Constant.messaggio));
           }else {
               ServiceForBattle battle = new ServiceForBattle(per, per2, new BattleWindows(Constant.sfondoLotta1, Constant.musicalotta2, Constant.messaggio));

           }







    }
}
