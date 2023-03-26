package model.data.implementation;
import model.data.abstracted.RepositoryBattle;
import model.entities.*;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import model.entities.Attack;

public class RepositotyBattleInMemory implements RepositoryBattle {
    Scanner scanner = new Scanner(System.in);
    Random random = new Random();

    @Override
    public void viewCommentAttack(Pet pet,int damage, int shelter) {
        if(damage > 1 && shelter > 0){
            if(damage > 1 && damage < 50){
                System.out.println(pet.getName() + " " + "infligge un buon danno!");
                System.out.println(pet.getName() + " " + "inoltre" + " " + "aumenta");
                System.out.println("la sua difesa di " + " " + shelter + " " + "punti difensivi!");
            }else if(damage > 50 && damage < 100){
                System.out.println(pet.getName() + " " + "infligge un ottimo danno!");
                System.out.println(pet.getName() + " " + "inoltre" + " " + "aumenta");
                System.out.println("la sua difesa di " + " " + shelter + " " + "punti difensivi!");
            }else{
                System.out.println(pet.getName() + " " + "infligge un danno importante!");
                System.out.println(pet.getName() + " " + "inoltre" + " " + "aumenta");
                System.out.println("la sua difesa di " + " " + shelter + " " + "punti difensivi!");
            }
        }
        else if(damage > 0 && shelter == 0) {
            if(damage < 50){
                System.out.println(pet.getName() + " " + "usa"+ "infligge un buon danno!");
            }else if(damage > 50 && damage < 100){
                System.out.println(pet.getName() + " "+ "infligge un ottimo danno!");
            }else{
                System.out.println(pet.getName() + " "+ "infligge un danno importante!");
            }
        }else if(damage == 0 && shelter > 0){
            System.out.println(pet.getName() + " " + "aumenta");
            System.out.println("la sua difesa di " + " " + shelter + " " + "punti difensivi!");
        }
    }
    @Override
    public void turnMy(Pet petMy,Pet petEnemy,String choose){
        boolean done = true;
        while(done) {
            String finalChoose = choose;
            if (petMy.getAttackSet().stream().anyMatch(d -> d.getName().equalsIgnoreCase(finalChoose)) == true) {
                if(numOfAvailabilityIsFinish(petMy.getAttackSet().stream().filter(e -> e.getName().equalsIgnoreCase(finalChoose)).findAny().get()) == false) {
                    //isDamageOrShelter(seeDamage(petMy, choose), seeShelter(petMy, choose), petMy, petEnemy);
                    viewCommentAttack(petMy,isDamageOrShelter(seeDamage(petMy,choose),seeShelter(petMy,choose),petMy,petEnemy), seeShelter(petMy, choose));
                    for(Attack attack : petMy.getAttackSet()){
                        if(attack.getName().equalsIgnoreCase(finalChoose)){
                            attack.setNumOfAvailability(1);
                        }
                    }
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
        if(pet.getLife() < 0) {
            return true;
        }
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
        waiting("Il tuo Pet può imparare un nuovo attacco");
        System.out.println(attack.getName() + ":" + attack.getDescription() + "," +
                "possibile danno inflitto->" + attack.getDamage() + ",possibile " +
                "aumento difensivo->" + attack.getShelter());
        waiting("Scegli quale attacco rimuovere!Inserire NO se si vuole mantenere questi attacchi!"
        +" "+"Premi invio per Continuare");
        seeAttack(pet);
        boolean done = true;
        String choose = scanner.nextLine();
        while(done){
            String finalChoose = choose;
            if(pet.getAttackSet().stream().anyMatch(d -> d.getName().equalsIgnoreCase(finalChoose)) == true) {
                pet.removeAttack(pet.getAttackSet().stream().filter(d->d.getName().equalsIgnoreCase(finalChoose)).findAny().get());
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
    public Attack newAttackByType(Pet pet) {
        Attack attack = null;
        Levels levels = pet.getLevels();
        switch(pet.getType()){
           case CAT:
               switch (levels){
                   case START:attack = Attack.zampata;
                   break;
                   case MEDIUM:attack = Attack.lacerazione;
                   break;
                   case ADVANCE:attack = Attack.arruffarsiGraffiando;
                   break;
                   case GREAT:attack = Attack.pallaDiPelo;
                   break;
                   case PERFECT:attack = Attack.rogodenti;
                   break;
               }
               break;
            case BIRD:
                switch (levels){
                    case START:attack = Attack.alata;
                    break;
                    case MEDIUM:attack = Attack.raffica;
                    break;
                    case ADVANCE:attack = Attack.alataProtettrice;
                    break;
                    case GREAT:attack = Attack.perforbecco;
                    break;
                    case PERFECT:attack = Attack.doppiaAlata;
                    break;
                }
                break;
            case DOG:
                switch (levels){
                    case START:attack = Attack.supermorso;
                    break;
                    case MEDIUM:attack = Attack.elettrodenti;
                    break;
                    case ADVANCE:attack = Attack.colpoCodaVigoroso;
                    break;
                    case GREAT:attack = Attack.ipermorso;
                    break;
                    case PERFECT:attack = Attack.elettroGeloDenti;
                    break;
                }
                break;
            case RABBIT:
                switch (levels){
                    case START:attack = Attack.doppioGraffio;
                    break;
                    case MEDIUM:attack = Attack.sgranocchio;
                    break;
                    case ADVANCE:attack = Attack.corsaSpietata;
                    break;
                    case GREAT:attack = Attack.triploGraffio;
                    break;
                    case PERFECT:attack = Attack.iperSgranocchio;
                    break;
                }
                break;
            case TURTLE:
                switch (levels){
                    case START:attack = Attack.rotolamento;
                    break;
                    case MEDIUM:attack = Attack.doppioRotolamento;
                    break;
                    case ADVANCE:attack = Attack.sgusciataReparo;
                    break;
                    case GREAT:attack = Attack.doppioColpoDiGuscio;
                    break;
                    case PERFECT:attack = Attack.triploRotolamento;
                    break;
                }
                break;
        }
        return attack;
       }
    @Override
    public Person createTeam(int numOfPets, Person person, List<Pet> petList){
        int numRandom=0;
        for(int i = 0; i < numOfPets ; i++){
            numRandom = random.nextInt(petList.size());
            person.addPet(i,petList.get(numRandom));
        }
        return person;
    }

    @Override
    public String waiting(String s) {
        System.out.print(s);
        return scanner.nextLine();
    }

    @Override
    public void setAttackDefenseByLevels(Pet pet) {
        pet.setDefense();
        pet.setPower();
    }

    @Override
    public String chooseAttack(Pet petMy) {
        showYourAttack(petMy);
        String choose = scanner.nextLine();
        return choose;
    }

    @Override
    public Pet whoAttackFirst(Pet pet_att, Pet pet_def) {
        pet_att.setSpeed();
        pet_att.setSpeed();
        if(pet_att.getSpeed() > pet_def.getSpeed()){
            return pet_att;
        }else{
            return pet_def;
        }
    }

    @Override
    public String viewLifeRemain(Pet pet) {
        String view = pet.getName() + " " +  pet.getLife();
        return view;
    }

    @Override
    public String viewLevelPet(Pet pet) {
        return pet.viewLevels();
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
                //isDamageOrShelter(seeDamage(pet, choose), seeShelter(pet, choose), pet, petEnemy);
                viewCommentAttack(pet,isDamageOrShelter(seeDamage(pet,choose),seeShelter(pet,choose),pet,petEnemy),seeShelter(pet, choose));
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

    private int isDamageOrShelter(int damage, int shelter, Pet pet, Pet petEnemy) {
        if (damage > 0) {
                int finalDamage = (damage + pet.getPower()) - petEnemy.getDefense();
                if(finalDamage >= 0){
                    petEnemy.setLife(finalDamage);
                    return finalDamage;
                }else{
                    finalDamage=1;
                    petEnemy.setLife(finalDamage);
                    return finalDamage;
                }
            }else {
                pet.maxDefense(shelter);
                return shelter;
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
                        "aumento difensivo->" + attack.getShelter() + " " + "numero di utilizzi a disposizione:" +
                        " " + attack.getNumOfAvailability());
            }
        }

}