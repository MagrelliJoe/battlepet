package model.services;
import model.data.abstracted.Repository;
import model.data.abstracted.Battle;
import model.entities.*;
import java.util.List;
import java.util.Random;

public class Service {
    Battle battle;
    Repository repository;
    GameOutput output;
    Random random;
    public Service(Battle repo , Repository repository){
        this.battle = repo;
        this.repository = repository;
        this.random = new Random();
    }

    public void fight(Person trainer1,Person trainer2){
        boolean done = true;
        int numOfMyPet = 0;
        int numOfPetEnemy = 0;
        Levels actuallyLevel = trainer1.getLevels();
        Pet pet = trainer1.getPetList().get(numOfMyPet);
        Pet pet_ = trainer2.getPetList().get(numOfPetEnemy);
        battle.setAttackDefenseByLevels(pet);
        battle.setAttackDefenseByLevels(pet_);
        while(done) {
            output.sendMessage(battle.viewLifeRemain(pet));
            System.out.println(battle.viewLifeRemain(pet));
            System.out.println(battle.viewLifeRemain(pet_));
            Pet petMostSpeed = battle.whoAttackFirst(pet,pet_);
            if(petMostSpeed.equals(pet)) {
                battle.turnMy(pet,pet_, battle.chooseAttack(pet));
                battle.waiting("Clicca per continuare!");
                battle.turnEnemy(pet_, pet);
                battle.waiting("Clicca per continuare!");
            }else{
                String choose = battle.chooseAttack(pet);
                battle.turnEnemy(pet_, pet);
                battle.waiting("Clicca per continuare!");
                battle.turnMy(pet,pet_,choose);
                battle.waiting("Clicca per continuare!");
            }
            if(battle.isDead(pet) || battle.isDead(pet_)){
                if(battle.isDead(pet)){
                    System.out.println("Il tuo Pet è stato sconfitto!");
                    numOfMyPet++;
                    if(trainer1.getPetList().get(numOfMyPet) != null) {
                        pet = trainer1.getPetList().get(numOfMyPet);
                        battle.setAttackDefenseByLevels(pet);
                        System.out.println("Mandi in campo un'altro Pet->" + pet.getName());
                        battle.waiting("Clicca per continuare!");
                    }else{
                        System.out.println("Hai perso la sfida!");
                        done = false;
                    }
                }else{
                    System.out.println("Il Pet nemico è stato sconfitto!");
                    numOfPetEnemy++;
                    if(trainer2.getPetList().get(numOfPetEnemy) != null) {
                        pet_ = trainer2.getPetList().get(numOfPetEnemy);
                        battle.setAttackDefenseByLevels(pet_);
                        System.out.println(trainer2.getName() + " "+ "Manda in campo un'altro Pet->" + pet_.getName());
                        battle.waiting("Clicca per continuare!");
                    }else{
                        System.out.println("Hai vinto lo scontro!");
                        trainer1.setVictory(1);
                        if(trainer1.getLevels() != actuallyLevel){
                            battle.addNewAttack(pet, battle.newAttackByType(pet));
                        }
                        done = false;
                    }
                }
            }
        }
    }

    public Person createTeam(int numOfPets, Person person, List<Pet> petList){
        return battle.createTeam(numOfPets,person,petList);
    }

}
