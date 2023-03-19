import model.data.implementation.RepositotyPet;
import model.entities.*;
import model.services.Service;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Pet p = new Pet("Billy", Type.BIRD,150,20,40,15, Levels.START);
        Pet p1 = new Pet("Trilly", Type.BIRD,150,20,40,14,Levels.START);
        Pet p2 = new Pet("Mia", Type.DOG,150,20,40,30, Levels.PERFECT);
        Pet p3 = new Pet("Pepita", Type.DOG,150,20,40,20,Levels.START);
        Pet p4 = new Pet("Gomitolo", Type.CAT,150,20,40,10, Levels.PERFECT);
        Pet p5 = new Pet("Baffo", Type.CAT,150,20,40,14,Levels.PERFECT);

       List<Pet> petList = new ArrayList<>();
       petList.add(p);
       petList.add(p1);
       petList.add(p2);
       petList.add(p3);

        Person per = new Person("io",Levels.START);
        Person per2 = new Person("ciccio",Levels.START);
        per.setVictory(5);
        per.addPet(0,p);
        per.addPet(1,p3);

        RepositotyPet repo = new RepositotyPet();
        repo.create(p);
        Service service = new Service();
        //service.createTeam(2,per,petList);
        //service.createTeam(4,per2,petList);
        per2.addPet(0,p3);
        per2.addPet(1,p2);
        service.fight(per,per2);
        //service.createTeam(4,per2,petList);
        //service.fightTrainer(per,per2);

    }
}
