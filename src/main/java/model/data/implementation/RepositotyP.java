package model.data.implementation;
import model.data.abstracted.Repository;
import model.entities.*;
import java.util.Random;
import java.util.Scanner;
import model.entities.Attack;

public class RepositotyP implements Repository {
    Scanner scanner = new Scanner(System.in);

    @Override
    public void viewCommentAttack(Pet pet,String choose,int damage, int shelter) {
        if(damage > 0) {
            System.out.println(pet.getName() + " " + "usa" + " " + choose + " " + "ed infligge");
            System.out.println("un danno di" + " " + damage + " " + "ps!");
        }else{
            System.out.println(pet.getName() + " " + "usa" + " " + choose + " " + "aumenta");
            System.out.println("la sua difesa di " + " " + shelter);
        }
    }
    @Override
    public void turnMy(Pet petMy,Pet petEnemy){
        String choose = chooseAttack(petMy);
        boolean done = true;
        while(done) {
            String finalChoose = choose;
            if (petMy.getAttackSet().stream().anyMatch(d -> d.getName().equalsIgnoreCase(finalChoose)) == true) {
                if(numOfAvailabilityIsFinish(petMy.getAttackSet().stream().filter(e -> e.getName().equalsIgnoreCase(finalChoose)).findAny().get()) == false) {
                    isDamageOrShelter(seeDamage(petMy, choose), seeShelter(petMy, choose), petMy, petEnemy);
                    viewCommentAttack(petMy, choose, seeDamage(petMy, choose), seeShelter(petMy, choose));
                    done = false;
                }else{
                    System.out.println("Non puoi più usare questa mossa per questa lotta!");
                    choose = chooseAttack(petMy);
                }
            }else{
                System.out.println("Errore nella scelta!");
                choose = chooseAttack(petMy);
            }
        }
    }

    @Override
    public boolean isDead(Pet pet) {
        if(pet.getLife() < 0) return true;
        return false;
    }

    @Override
    public boolean numOfAvailabilityIsFinish(Attack attack) {
        if(attack.getNumOfAvailability() == 0){
            return true;
        }
        return false;
    }
    @Override
    public void addNewAttack(Pet pet,Attack attack) {
        System.out.println(attack.getName() + ":" + attack.getDescription() + "," +
                "possibile danno inflitto->" + attack.getDamage() + ",possibile " +
                "aumento difensivo->" + attack.getShelter());
        System.out.println("Il tuo Pet può imparare un nuovo attacco,scegli quale attacco rimuovere!");
        seeAttack(pet);
        System.out.println("Inserire NO se si vuole mantenere questi attacchi!");
        boolean done = true;
        String choose = scanner.nextLine();
        while(done){
            String finalChoose = choose;
            if (pet.getAttackSet().stream().anyMatch(d -> d.getName().equalsIgnoreCase(finalChoose)) == true) {
                pet.getAttackSet().remove(pet.getAttackSet().stream().anyMatch(d -> d.getName().equalsIgnoreCase(finalChoose)));
                pet.setAttack(attack);
                System.out.println("Il tuo Pet ha imparato:" + attack.getName());
                done = false;
            }else{
                if (choose.equalsIgnoreCase("NO")) {
                    System.out.println("Il tuo Pet ha mantenuto le sue mosse correnti!");
                    break;
                }
                System.out.println("Errore nella scelta");
                choose = scanner.nextLine();
            }
        }
    }
    @Override
    public String chooseAttack(Pet petMy) {

        showYourAttack(petMy);
        String choose = scanner.nextLine();
        return choose;
    }

    @Override
    public Pet whoAttackFirst(Pet pet_att, Pet pet_def) {
        if(pet_att.getSpeed() > pet_def.getSpeed()){
            return pet_att;
        }else{
            return pet_def;
        }
    }

    @Override
    public void viewLifeRemain(Pet pet) {
        System.out.println(pet.getName() + ":" + pet.getLife());
    }

    @Override
    public void turnEnemy(Pet pet, Pet petEnemy) {
        Random random = new Random();
        int n = random.nextInt(3);
        boolean done = true;
        String choose="";
        while(done) {
            switch (n) {
                case 0:
                    choose = pet.getAttackSet().get(0).getName();
                    break;
                case 1:
                    choose = pet.getAttackSet().get(1).getName();
                    break;
                case 2:
                    choose = pet.getAttackSet().get(2).getName();
                    break;
            }
            String finalChoose = choose;
            if (numOfAvailabilityIsFinish(pet.getAttackSet().stream().filter(e -> e.getName().equalsIgnoreCase(finalChoose)).findAny().get()) == false) {
                isDamageOrShelter(seeDamage(pet, choose), seeShelter(pet, choose), pet, petEnemy);
                viewCommentAttack(pet, choose, seeDamage(pet, choose), seeShelter(pet, choose));
                done = false;
            } else {
                n = random.nextInt(3);
            }
        }
    }

    @Override
    public void showYourAttack(Pet pet) {
        System.out.println("Attacchi disponibili:");
        seeAttack(pet);
    }

    private void isDamageOrShelter(int damage, int shelter, Pet pet, Pet petEnemy) {
        if (damage > 0) {
                petEnemy.setLife((damage + pet.getPower()) - (pet.getDefense()/2) );
            } else {
                pet.setDefense(shelter);
            }
        }
        private int seeDamage(Pet pet,String choose){
            int damage = pet.getAttackSet().stream().filter(d -> d.getName().equalsIgnoreCase(choose)).findAny().get().getDamage();
            return damage;
        }
        private int seeShelter(Pet pet,String choose){
            int shelter = pet.getAttackSet().stream().filter(d -> d.getName().equalsIgnoreCase(choose)).findAny().get().getShelter();
            return shelter;
        }

        private void seeAttack(Pet pet){
            for(Attack attack : pet.getAttackSet()) {
                System.out.println(attack.getName() + ":" + attack.getDescription() + "," +
                        "possibile danno inflitto->" + attack.getDamage() + ",possibile " +
                        "aumento difensivo->" + attack.getShelter());
            }
            System.out.println("Scegli il tuo attacco:");
        }

}