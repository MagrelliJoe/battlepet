
import model.data.implementation.BattleJFrame;
import model.entities.*;
import model.services.ServiceForBattle;

import java.awt.*;

public class StartJFrame {

    public static void main(String[] args) {

        Person per = new Person("io", Levels.ADVANCE);
        Person per2 = new Person("ciccio",Levels.START);

        Pet p = new Pet("Billy", Type.BIRD,150,20,40,15, Levels.START);
        Pet p1 = new Pet("Trilly", Type.BIRD,150,20,40,14,Levels.START);
        Pet p2 = new Pet("Mia", Type.DOG,150,20,40,30, Levels.PERFECT);
        Pet p3 = new Pet("Pepita", Type.DOG,150,20,40,20,Levels.START);
        Pet p4 = new Pet("Gomitolo", Type.CAT,150,20,40,10, Levels.PERFECT);
        Pet p5 = new Pet("Baffo", Type.CAT,150,20,40,14,Levels.PERFECT);
        Pet p6 = new Pet("Pulce",Type.RABBIT,100,30,40,20,Levels.BASE);
        Pet p7 = new Pet("Raffa",Type.TURTLE,180,10,10,10,Levels.BASE);

        per.addPet(0,p6);
        per.addPet(1,p7);

        per2.addPet(0,p);
        per2.addPet(1,p5);

        BattleJFrame frame = new BattleJFrame(new BattleWindows());
        ServiceForBattle service = new ServiceForBattle(frame,per,per2);
        //service.fight(per,per2);
        //RepositoryBattleJFrame frame = new RepositoryBattleJFrame();
        //frame.addNewAttack(p,Attack.triploRotolamento);
        //System.out.println(frame.getOpzioni().length);
        //BattleWindows battleWindows = new BattleWindows();

        //battleWindows.createBattleWindows();


    }
}
