package model.data.abstracted;
import model.entities.Person;
import model.entities.Pet;

public interface Repository {

    void attack(Pet pet_att,Pet pet_def);

    void chooseAttack(Pet pet_att,Pet pet_def);






}
