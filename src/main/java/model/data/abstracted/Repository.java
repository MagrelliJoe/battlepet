package model.data.abstracted;
import model.entities.Attack;
import model.entities.Person;
import model.entities.Pet;

import java.util.List;

public interface Repository {

    void viewCommentAttack(Pet pet,String choose,int damage, int shelter);
    String chooseAttack(Pet pet);
    Pet whoAttackFirst(Pet pet_att, Pet pet_def);
    void viewLifeRemain(Pet pet);
    void turnEnemy(Pet pet,Pet pet_);
    void showYourAttack(Pet pet);
    void turnMy(Pet petMy,Pet petEnemy,String choose);
    boolean isDead(Pet pet);
    boolean numOfAvailabilityIsFinish(Attack attack);
    void addNewAttack(Pet pet,Attack attack);
    Attack newAttackByType(Pet pet);

    Person createTeam(int numOfPets, Person person, List<Pet> petList);

    Object create (Object object);
    String waiting(String s);

}
