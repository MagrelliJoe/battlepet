package model.data.implementation;
import model.data.abstracted.Battle;
import model.entities.*;
import java.util.List;
import java.util.Random;
public class BattleJFrame implements Battle {
    private BattleWindows battle;

    public BattleJFrame(BattleWindows battle) {
        this.battle = battle;
    }

    @Override
    public void viewCommentAttack(Pet pet,int damage, int shelter) {
        if (damage > 1 && shelter > 0) {
            if (damage > 1 && damage < 50) {
                battle.getTx().setText(pet.getName() + " "+ "infligge un buon danno!" + "\n");
                battle.getTx().append(pet.getName() + " " + "inoltre" + " " + "aumenta" + "\n");
                battle.getTx().append("la sua difesa di " + " " + shelter + " " + "punti difensivi!");
            }else if (damage > 50 && damage < 100) {
                battle.getTx().setText(pet.getName() + " "+ "infligge un ottimo danno!" + "\n");
                battle.getTx().append(pet.getName() + " " + "inoltre" + " " + "aumenta" + "\n");
                battle.getTx().append("la sua difesa di " + " " + shelter + " " + "punti difensivi!");
            }else{
                battle.getTx().setText(pet.getName() + " " + "infligge un danno importante!" + "\n");
                battle.getTx().append(pet.getName() + " " + "inoltre" + " " + "aumenta" + "\n");
                battle.getTx().append("la sua difesa di " + " " + shelter + " " + "punti difensivi!");
            }
        }else if (damage > 0 && shelter == 0) {
                if (damage < 50) {
                    battle.getTx().setText(pet.getName() + " "+ "infligge un buon danno!");
                } else if (damage > 50 && damage < 100) {
                    battle.getTx().setText(pet.getName() + " "+ "infligge un ottimo danno!");
                } else {
                    battle.getTx().setText(pet.getName() + " "+ "infligge un danno importante!");
                }
            }else if (damage == 0 && shelter > 0) {
               battle.getTx().setText(pet.getName() + " "+ "aumenta" + "\n");
               battle.getTx().append("la sua difesa di " + " " + shelter + " " + "punti difensivi!");
            }
        }

    @Override
    public String chooseAttack(Pet pet) {
        return null;
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
    public void turnEnemy(Pet pet, Pet pet_) {
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
                viewCommentAttack(pet, isDamageOrShelter(seeDamage(pet, finalChoose), seeShelter(pet, finalChoose), pet, pet_), seeShelter(pet, finalChoose));
                done = false;
            }else{
                n = random.nextInt(3);
            }
        }
    }
    @Override
    public void showYourAttack(Pet pet) {}

    @Override
    public void turnMy(Pet petMy, Pet petEnemy, String choose) {

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
    public void addNewAttack(Pet pet, Attack attack) {
        /*
        getOpzioni()[3].setText("NO");
        getOpzioni()[3].setEnabled(true);
        tx.setText("Il tuo Pet può imparare un nuovo attacco");
        tx.append(attack.getName() + ":" + attack.getDescription() + "\n" +
                "possibile danno inflitto->" + attack.getDamage() + ",possibile " +
                "aumento difensivo->" + attack.getShelter() + "\n");
        tx.append("Clicca su un attacco tra quelli presenti per rimuoverlo e far" + "\n"
                + "spazio a quello nuovo.Clicca NO per mantenere quelli già presenti.");
        getOpzioni()[0].addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    tx.setText("");
                    pet.getAttackSet().remove(0);
                    pet.setAttack(attack);
                    tx.append("Il tuo Pet ha imparato:" + attack.getName());
                    getOpzioni()[3].setText("No Use So Far");
                    getOpzioni()[3].setEnabled(false);
                }
            }
        });
        getOpzioni()[1].addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    tx.setText("");
                    pet.getAttackSet().remove(1);
                    pet.setAttack(attack);
                    tx.append("Il tuo Pet ha imparato:" + attack.getName());
                    getOpzioni()[3].setText("No Use So Far");
                    getOpzioni()[3].setEnabled(false);
                }
            }
        });
        getOpzioni()[2].addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    tx.setText("");
                    pet.getAttackSet().remove(2);
                    pet.setAttack(attack);
                    tx.append("Il tuo Pet ha imparato:" + attack.getName());
                    getOpzioni()[3].setText("No Use So Far");
                    getOpzioni()[3].setEnabled(false);
                }
            }
        });
        getOpzioni()[3].addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                tx.setText("");
                tx.append("Il tuo Pet ha mantenuto le sue mosse attuali!");
                getOpzioni()[3].setText("No Use So Far");
                getOpzioni()[3].setEnabled(false);
            }
        });

         */
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
                case BIRD: switch (levels){
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
    public Person createTeam(int numOfPets, Person person, List<Pet> petList) {
        return null;
    }

    @Override
    public String waiting(String s) {
        return null;
    }

    @Override
    public void setAttackDefenseByLevels(Pet pet) {
        pet.setDefense();
        pet.setPower();
    }
    public void setLifeForFrame(Pet pet,String trainer){
        if(trainer.equalsIgnoreCase("Enemy")){
            battle.getShowLifeEnemy().setText(pet.getName().toUpperCase() + "\n"
            + pet.getLife());
        }else{
            battle.getShowLife().setText(pet.getName().toUpperCase() + "\n"
                    + pet.getLife());
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
    public int seeDamage(Pet pet,int index){
        int damage = pet.getAttackSet().get(index).getDamage();
        return damage;
    }

    public BattleWindows getBattle() {
        return battle;
    }

    public void setBattle(BattleWindows battle) {
        this.battle = battle;
    }

    public int isDamageOrShelter(int damage, int shelter, Pet pet, Pet petEnemy) {
        if (damage > 0) {
            int finalDamage = (damage + pet.getPower()) - petEnemy.getDefense();
            if(finalDamage > 1){
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

}
