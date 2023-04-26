package model.data.abstracted;
import model.data.entities.Person;
import model.data.entities.Pet;

public interface Repository {
    Person createTrainer(Person person);
    Pet createPet(Pet pet);

}
