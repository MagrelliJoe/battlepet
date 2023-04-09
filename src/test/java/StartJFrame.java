import model.entities.*;
import model.services.ServiceForBattle;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
public class StartJFrame {

    public static void main(String[] args) throws UnsupportedAudioFileException, IOException, LineUnavailableException {

        Person per = new Person(Constant.allenatoreMy,"io", Levels.START);
        Person per2 = new Person(Constant.allenatore1,"ciccio",Levels.START);

        Pet p = new Pet(Constant.crissy,"Crissy", Type.BIRD,100,20,40,15, Levels.START);
        Pet p1 = new Pet(Constant.pettyred,"PettyRed", Type.BIRD,150,20,40,14,Levels.START);
        //Pet p2 = new Pet(Constant.,"Mia", Type.DOG,150,20,40,30, Levels.PERFECT);
        Pet p3 = new Pet(Constant.pepita,"Pepita", Type.DOG,150,20,40,20,Levels.START);
        Pet p4 = new Pet(Constant.gomitolo,"Gomitolo", Type.CAT,150,20,40,10, Levels.PERFECT);
        Pet p5 = new Pet(Constant.mewcat,"MewCat", Type.CAT,150,20,40,14,Levels.PERFECT);
        Pet p6 = new Pet(Constant.pulce,"Pulce",Type.RABBIT,5,30,40,20,Levels.BASE);
        //Pet p7 = new Pet("Raffa",Type.TURTLE,180,10,10,10,Levels.BASE);

        per.addPet(0,p6);
        per.addPet(1,p3);

        per2.addPet(0,p);
        per2.addPet(1,p5);

        ServiceForBattle battle = new ServiceForBattle(per,per2,new BattleWindows(Constant.sfondoLotta1,Constant.musicalotta2,Constant.messaggio));


    }
}
