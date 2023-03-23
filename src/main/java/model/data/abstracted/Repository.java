package model.data.abstracted;
import model.entities.Person;
import model.entities.Pet;

public interface Repository {
    Person createTrainer(Person person);
    Pet createPet(Pet pet);

}
