import model.data.implementation.RepositotyP;
import model.entities.*;
import model.services.Fight;
import model.entities.Attack;
import org.checkerframework.checker.units.qual.A;

public class Main {

    public static void main(String[] args) {
        Pet p = new Pet("Billy", Type.BIRD,150,20,40,15, Levels.START);
        Pet p1 = new Pet("Trilly", Type.BIRD,120,20,40,14,Levels.START);
        Pet p2 = new Pet("Mia", Type.DOG,150,50,10,30, Levels.PERFECT);
        Pet p3 = new Pet("Pepita", Type.DOG,180,30,20,20,Levels.PERFECT);
        Pet p4 = new Pet("Gomitolo", Type.CAT,100,30,50,10, Levels.PERFECT);
        Pet p5 = new Pet("Baffo", Type.CAT,110,10,60,14,Levels.PERFECT);



        Person per = new Person("io",Levels.ADVANCE);
        per.addPet(0,p);

        Fight f = new Fight();
        //f.Fight(p3,p4);
        RepositotyP repo = new RepositotyP();
        repo.addNewAttack(p, new Attack("morsone",30,0,"null",1));
    }
}
