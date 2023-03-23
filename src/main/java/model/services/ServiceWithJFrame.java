package model.services;

import model.data.abstracted.Repository;
import model.data.abstracted.RepositoryBattle;
import model.entities.BattleWindows;
import model.entities.Levels;
import model.entities.Person;
import model.entities.Pet;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class ServiceWithJFrame {
    private RepositoryBattle repositoryBattle;
    private Repository repository;
    private Random random;
    private  BattleWindows battle;



    public ServiceWithJFrame(RepositoryBattle repo , Repository repository) {

        this.repositoryBattle = repo;
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
             battle = new BattleWindows();
             setAttacktoChoose(pet);
             repositoryBattle.setAttackDefenseByLevels(pet);
             repositoryBattle.setAttackDefenseByLevels(pet_);
             while(done) {
                 battle.getShowLife().setText(repositoryBattle.viewLifeRemain(pet));
                 battle.getShowLifeEnemy().setText(repositoryBattle.viewLifeRemain(pet_));
                 Pet petMostSpeed = repositoryBattle.whoAttackFirst(pet,pet_);
                 if(petMostSpeed.equals(pet)) {
                     repositoryBattle.turnMy(pet,pet_,repositoryBattle.chooseAttack(pet));
                     repositoryBattle.waiting("Clicca per continuare!");
                     repositoryBattle.turnEnemy(pet_, pet);
                     repositoryBattle.waiting("Clicca per continuare!");
                 }else{
                     String choose = repositoryBattle.chooseAttack(pet);
                     repositoryBattle.turnEnemy(pet_, pet);
                     repositoryBattle.waiting("Clicca per continuare!");
                     repositoryBattle.turnMy(pet,pet_,choose);
                     repositoryBattle.waiting("Clicca per continuare!");
                 }
                 if(repositoryBattle.isDead(pet) || repositoryBattle.isDead(pet_)){
                     if(repositoryBattle.isDead(pet)){
                         System.out.println("Il tuo Pet è stato sconfitto!");
                         numOfMyPet++;
                         if(trainer1.getPetList().get(numOfMyPet) != null) {
                             pet = trainer1.getPetList().get(numOfMyPet);
                             repositoryBattle.setAttackDefenseByLevels(pet);
                             System.out.println("Mandi in campo un'altro Pet->" + pet.getName());
                             repositoryBattle.waiting("Clicca per continuare!");
                         }else{
                             System.out.println("Hai perso la sfida!");
                             done = false;
                         }
                     }else{
                         System.out.println("Il Pet nemico è stato sconfitto!");
                         numOfPetEnemy++;
                         if(trainer2.getPetList().get(numOfPetEnemy) != null) {
                             pet_ = trainer2.getPetList().get(numOfPetEnemy);
                             repositoryBattle.setAttackDefenseByLevels(pet_);
                             System.out.println(trainer2.getName() + " "+ "Manda in campo un'altro Pet->" + pet_.getName());
                             repositoryBattle.waiting("Clicca per continuare!");
                         }else{
                             System.out.println("Hai vinto lo scontro!");
                             trainer1.setVictory(1);
                             if(trainer1.getLevels() != actuallyLevel){
                                 repositoryBattle.addNewAttack(pet,repositoryBattle.newAttackByType(pet));
                             }
                             done = false;
                         }
                     }
                 }
             }
         }
         private void setAttacktoChoose(Pet pet){


             for(int i=0; i<battle.getOpzioni().length; i++) {
               battle.getOpzioni()[i].setText(pet.getAttackSet().get(i).getName());
             }
         }
    }
