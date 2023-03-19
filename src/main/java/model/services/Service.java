package model.services;
import model.data.abstracted.Repository;
import model.data.implementation.RepositotyPet;
import model.entities.*;

import java.util.List;
import java.util.Random;

public class Service {
    Random random = new Random();
    Repository repo = new RepositotyPet();
    public void fight(Person trainer1,Person trainer2){
        boolean done = true;
        int numOfMyPet = 0;
        int numOfPetEnemy = 0;
        Pet pet = trainer1.getPetList().get(numOfMyPet);
        Pet pet_ = trainer2.getPetList().get(numOfPetEnemy);
        while(done) {
            repo.viewLifeRemain(pet);
            repo.viewLifeRemain(pet_);
            Pet petMostSpeed = repo.whoAttackFirst(pet,pet_);
            if(petMostSpeed.equals(pet)) {
                repo.turnMy(pet,pet_,repo.chooseAttack(pet));
                System.out.println(repo.waiting("Clicca per continuare!"));
                repo.turnEnemy(pet_, pet);
                System.out.println(repo.waiting("Clicca per continuare!"));
            }else{
                String choose = repo.chooseAttack(pet);
                repo.turnEnemy(pet_, pet);
                System.out.println(repo.waiting("Clicca per continuare!"));
                repo.turnMy(pet,pet_,choose);
                System.out.println(repo.waiting("Clicca per continuare!"));
            }
            if(repo.isDead(pet) || repo.isDead(pet_)){
                if(repo.isDead(pet)){
                    System.out.println("Il tuo Pet è stato sconfitto!");
                    System.out.println(repo.waiting("Clicca per continuare!"));
                    numOfMyPet++;
                    if(trainer1.getPetList().get(numOfMyPet) != null) {
                        pet = trainer1.getPetList().get(numOfMyPet);
                        System.out.println("Mandi in campo un'altro Pet->" + pet.getName());
                        System.out.println(repo.waiting("Clicca per continuare!"));
                    }else{
                        System.out.println("Hai perso la sfida!");
                        done = false;
                    }
                }else{
                    System.out.println("Il Pet nemico è stato sconfitto!");
                    System.out.println(repo.waiting("Clicca per continuare!"));
                    numOfPetEnemy++;
                    if(trainer2.getPetList().get(numOfPetEnemy) != null) {
                        pet_ = trainer2.getPetList().get(numOfPetEnemy);
                        System.out.println("Manda in campo un'altro Pet->" + pet_.getName());
                        System.out.println(repo.waiting("Clicca per continuare!"));
                    }else{
                        System.out.println("Hai vinto lo scontro!");
                        done = false;
                    }
                }
            }
        }
    }
    public Person createTeam(int numOfPets, Person person, List<Pet> petList){
      int numRandom=0;
      for(int i = 0; i < numOfPets ; i++){
         numRandom = random.nextInt(petList.size());
         person.addPet(i,petList.get(numRandom));
      }
        return person;
    }

}
