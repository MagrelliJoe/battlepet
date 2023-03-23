import model.data.implementation.RepositoryInMemory;
import model.data.implementation.RepositotyBattleInMemory;
import model.entities.Levels;
import model.entities.Person;
import model.entities.Pet;
import model.entities.Type;
import model.services.ServiceWithJFrame;

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

        per2.addPet(0,p6);
        per2.addPet(1,p7);

        ServiceWithJFrame service = new ServiceWithJFrame(new RepositotyBattleInMemory(),new RepositoryInMemory());
        service.fight(per,per2);


    }
}
