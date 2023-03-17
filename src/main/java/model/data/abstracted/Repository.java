package model.data.abstracted;
import model.entities.Attack;
import model.entities.Person;
import model.entities.Pet;

public interface Repository {

    void viewCommentAttack(Pet pet,String choose,int damage, int shelter);
    String chooseAttack(Pet pet);
    Pet whoAttackFirst(Pet pet_att, Pet pet_def);
    void viewLifeRemain(Pet pet);
    void turnEnemy(Pet pet,Pet pet_);
    void showYourAttack(Pet pet);
    void turnMy(Pet petMy,Pet petEnemy);
    boolean isDead(Pet pet);
    boolean numOfAvailabilityIsFinish(Attack attack);
    void addNewAttack(Pet pet,Attack attack);

}
