import model.data.abstracted.LevelWindow;
import model.data.entities.Constant;
import model.data.entities.ConstantPetTrainer;
import model.data.entities.Levels;
import model.data.entities.Person;
import model.data.implementation.LevelWindowOne;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.util.Random;


public class StartJFrame {

    public static void main(String[] args) throws UnsupportedAudioFileException, IOException, LineUnavailableException {

        Person per = new Person(Constant.allenatoreMyLotta1,"io", Levels.BASE);
        Person per1 = new Person(Constant.allenatore6Lotta,"pippo",Levels.BASE);
        Person per2 = new Person(Constant.allenatore7Lotta,"ciccio",Levels.BASE);

        per.addPet(0, ConstantPetTrainer.pepita);
        per.addPet(1, ConstantPetTrainer.pettyRed);
        per.addPet(2, ConstantPetTrainer.pulce);

        per1.addPet(0, ConstantPetTrainer.mewcat);

        per2.addPet(0, ConstantPetTrainer.pulce);
        per2.addPet(2, ConstantPetTrainer.donny);

        Random r = new Random();
           int n = r.nextInt(2);
           if (n == 0) {
               //ServiceForBattle battle1 = new ServiceForBattle(per, per1, new BattleWindow(Constant.sfondoLotta1, Constant.musicalotta2, Constant.messaggio));
           }else {
               //ServiceForBattle battle = new ServiceForBattle(per, per2, new BattleWindow(Constant.sfondoLotta1, Constant.musicalotta2, Constant.messaggio));

           }

    }
}
