import model.data.implementation.RepositoryInMemory;
import model.data.implementation.BattleInMemory;
import model.entities.*;
import model.services.Service;
import java.util.ArrayList;
import java.util.List;

public class RepositoryBattleInMemoryTest {

    public static void main(String[] args) {
        Pet p = new Pet("Billy", Type.BIRD,150,20,40,15, Levels.START);
        Pet p1 = new Pet("Trilly", Type.BIRD,150,20,40,14,Levels.START);
        Pet p2 = new Pet("Mia", Type.DOG,150,20,40,30, Levels.PERFECT);
        Pet p3 = new Pet("Pepita", Type.DOG,150,20,40,20,Levels.START);
        Pet p4 = new Pet("Gomitolo", Type.CAT,150,20,40,10, Levels.PERFECT);
        Pet p5 = new Pet("Baffo", Type.CAT,150,20,40,14,Levels.PERFECT);
        Pet p6 = new Pet("Pulce",Type.RABBIT,100,30,40,20,Levels.BASE);
        Pet p7 = new Pet("Raffa",Type.TURTLE,180,10,10,10,Levels.BASE);

       List<Pet> petList = new ArrayList<>();
       petList.add(p);
       petList.add(p1);
       petList.add(p2);
       petList.add(p3);

        Person per = new Person("io",Levels.ADVANCE);
        Person per2 = new Person("ciccio",Levels.START);
        per.setVictory(69);
        per.addPet(0,p6);
        per.addPet(1,p7);
        Service service = new Service(new BattleInMemory(),new RepositoryInMemory());
        //repo.addNewAttack(p,repo.newAttackByType(p));
        //service.fight(per,service.createTeam(2,per2,petList));
        //service.fight(per,repo.createTeam(2,per,petList));
        //service.fight(per,repo.createTeam(2,per,petList));
        //service.fightTrainer(per,per2);

    }
}
