import model.entities.*;
import model.services.ServiceForBattle;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class StartJFrame {

    public static void main(String[] args) throws UnsupportedAudioFileException, IOException, LineUnavailableException {

        Person per = new Person(Constant.allenatoreMy,"io", Levels.START);
        Person per2 = new Person(Constant.allenatore7Lotta,"ciccio",Levels.START);

        per.addPet(0,ConstantPet.pettyRed);
        per.addPet(1,ConstantPet.crissy);
        per.addPet(2,ConstantPet.mewcat);

        per2.addPet(0,ConstantPet.piumino);
        per2.addPet(1,ConstantPet.gomitolo);


        ServiceForBattle battle = new ServiceForBattle(per,per2,new BattleWindows(Constant.sfondoLotta1,Constant.musicalotta2,Constant.messaggio));



    }
}
