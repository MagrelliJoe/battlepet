package model.data.implementation;
import model.data.abstracted.Repository;
import model.data.entities.Person;
import model.data.entities.Pet;
import java.util.HashMap;
import java.util.Map;

public class RepositoryInMemory  implements Repository {

    private Map<Integer,Pet> pets = new HashMap<>();
    private Map<Integer,Person> trainers = new HashMap<>();

    int petID = 0;
    int trainersID = 0;

    @Override
    public Person createTrainer(Person person) {
        trainers.put(trainersID,person);
        trainersID++;
        return person;
    }

    @Override
    public Pet createPet(Pet pet) {
        pets.put(petID,pet);
        petID++;
        return pet;
    }

    public Map<Integer, Pet> getPets() {
        return pets;
    }

    public void setPets(Map<Integer, Pet> pets) {
        this.pets = pets;
    }

    public Map<Integer, Person> getTrainers() {
        return trainers;
    }

    public void setTrainers(Map<Integer, Person> trainers) {
        this.trainers = trainers;
    }

    public int getPetID() {
        return petID;
    }

    public void setPetID(int petID) {
        this.petID = petID;
    }

    public int getTrainersID() {
        return trainersID;
    }

    public void setTrainersID(int trainersID) {
        this.trainersID = trainersID;
    }
}
