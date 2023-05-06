package model.data.entities;
import model.data.implementation.BattleJFrame;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Random;
public class ServiceForBattle implements ActionListener {
    private BattleJFrame battle;
    private Random random;
    private Person trainer1,trainer2;
    private Pet pet,pet_;
    private int numberOfChoose;
    private int[] attackAvaiabilityRemoved = new int[4];
    private int[] attackAvaiabilityRemovedEnemy = new int[4];

    public ServiceForBattle(Person trainer1, Person trainer2, BattleWindow battleWindow){
        this.battle = new BattleJFrame(battleWindow);
        this.random = new Random();
        this.trainer1 = trainer1;
        this.trainer2 = trainer2;
        setAttacktoChoose(trainer1.getPetList().get(0));
        assignPointForLevel(trainer1);
        assignPointForLevel(trainer2);
        battle.getBattle().getEnemyPet().setIcon(new ImageIcon(trainer2.getPetList()
                .get(battle.getBattle().getNextPetEnemy()).getFilePathImage()));
        battle.getBattle().getMyPet().setIcon(new ImageIcon(trainer1.getPetList()
                .get(battle.getBattle().getNextPet()).getFilePathImage()));
        battle.getBattle().getEnemyTrainer().setIcon(new ImageIcon(trainer2.getFilePathImage()));
        battle.getBattle().getMyTrainer().setIcon(new ImageIcon("images/logoBattlePet.png"));
        reloadMnemonic();
    }
    @Override
    public void actionPerformed(ActionEvent e) {

        if("option4".equals(e.getActionCommand())){
            if(battle.getBattle().getOpzioni()[4].getText().
                    equalsIgnoreCase("START FIGHT")){
                pet = trainer1.getPetList().get(battle.getBattle().getNextPet());
                switch (trainer1.getName()){
                    case"David":
                        setimagefight(Constant.allenatoreMyLotta1);
                        break;
                    case"Alycia":
                        setimagefight("images/MyTrainer/pg_f_lotta_1.jpg");
                        break;
                }
                pet_ = trainer2.getPetList().get(battle.getBattle().getNextPetEnemy());
                battle.setLifeForFrame(pet,"My");
                battle.getBattle().getOpzioni()[0].setEnabled(true);
                battle.getBattle().getOpzioni()[1].setEnabled(true);
                battle.getBattle().getOpzioni()[2].setEnabled(true);
                battle.getBattle().getOpzioni()[3].setEnabled(true);
                battle.setLifeForFrame(pet_,"Enemy");
                battle.getBattle().getOpzioni()[4].setEnabled(false);
                reloadMnemonic();

            }else if(battle.getBattle().getOpzioni()[4].getText().
                    equalsIgnoreCase("NO")){
                JOptionPane.showMessageDialog(null, "IL TUO PET HA MANTENUTO I SUOI ATTACCHI!");
                setimagefight(Constant.allenatoreMyLotta1);
                pet.getAttackSet().remove(4);
                battle.getBattle().getFrame().dispose();
                battle.getBattle().getMusic().stop();

            }else if(battle.getBattle().getOpzioni()[4].getText().
                    equalsIgnoreCase("YOUR TURN")){
                try {
                    switch (trainer1.getName()){
                        case"David":
                            setimagefight(Constant.allenatoreMyLotta2);
                            break;
                        case"Alycia":
                            setimagefight("images/MyTrainer/pg_f_lotta_2.jpg");
                            break;
                    }
                    battle.viewCommentAttack(pet, battle.isDamageOrShelter(battle.seeDamage(pet, numberOfChoose),
                            battle.seeShelter(pet, numberOfChoose),battle.seePowerUp(pet,numberOfChoose), pet, pet_,"my"), battle.seeShelter(pet, numberOfChoose),
                            pet.getAttackSet().get(numberOfChoose).getName().toString());
                    reloadMnemonic();
                } catch (UnsupportedAudioFileException | LineUnavailableException | IOException ex) {
                    throw new RuntimeException(ex);
                }
                battle.setLifeForFrame(pet_, "Enemy");
                battle.getBattle().getOpzioni()[0].setEnabled(true);
                battle.getBattle().getOpzioni()[1].setEnabled(true);
                battle.getBattle().getOpzioni()[2].setEnabled(true);
                battle.getBattle().getOpzioni()[3].setEnabled(true);
                battle.getBattle().getOpzioni()[4].setEnabled(false);

                if (pet.isDead() || pet_.isDead()) {
                    nextPet(pet, pet_);
                }

            }else{
                try {
                    switch (trainer1.getName()){
                        case"David":
                            setimagefight(Constant.allenatoreMyLotta1);
                            break;
                        case"Alycia":
                            setimagefight("images/MyTrainer/pg_f_lotta_1.jpg");
                            break;
                    }
                    attackAvaiabilityRemovedEnemy[battle.turnEnemy(pet_,pet)] +=1;
                    battle.setLifeForFrame(pet,"My");
                    battle.getBattle().getOpzioni()[4].setEnabled(false);
                    battle.getBattle().getOpzioni()[0].setEnabled(true);
                    battle.getBattle().getOpzioni()[1].setEnabled(true);
                    battle.getBattle().getOpzioni()[2].setEnabled(true);
                    battle.getBattle().getOpzioni()[3].setEnabled(true);

                    if (pet.isDead() || pet_.isDead()) {
                        nextPet(pet, pet_);
                    }
                } catch (UnsupportedAudioFileException | LineUnavailableException | IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        }
        if("option0".equals(e.getActionCommand())){
            if(battle.getBattle().getOpzioni()[4].getText().
                    equalsIgnoreCase("NO")){

                pet.getAttackSet().remove(0);
                JOptionPane.showMessageDialog(null, "IL TUO PET HA IMPARATO IL NUOVO ATTACCO");
                battle.getBattle().getFrame().dispose();
                battle.getBattle().getMusic().stop();

            }else{
                try {
                    if(!battle.numOfAvailabilityIsFinish(pet.getAttackSet().get(0))) {
                        attackAvaiabilityRemoved[0] += 1;
                        attackForBattle(pet, pet_, 0);
                    }else{
                        JOptionPane.showInternalConfirmDialog(null, "Non puoi più usare questa mossa!!!");
                        attackForBattle(pet, pet_, 1);
                    }
                } catch (UnsupportedAudioFileException | LineUnavailableException | IOException ex) {
                    throw new RuntimeException(ex);
                }
                if (pet.isDead() || pet_.isDead()) {
                    nextPet(pet, pet_);
                }
            }
        }
        if("option1".equals(e.getActionCommand())){

            if(battle.getBattle().getOpzioni()[4].getText().
                    equalsIgnoreCase("NO")){

                pet.getAttackSet().remove(1);
                JOptionPane.showMessageDialog(null, "IL TUO PET HA IMPARATO IL NUOVO ATTACCO");
                battle.getBattle().getFrame().dispose();
                battle.getBattle().getMusic().stop();

            }else{

                try {
                    if(!battle.numOfAvailabilityIsFinish(pet.getAttackSet().get(1))) {
                        attackAvaiabilityRemoved[1] += 1;
                        attackForBattle(pet, pet_, 1);
                    }else{
                        JOptionPane.showInternalConfirmDialog(null, "Non puoi più usare questa mossa!!!");
                        attackForBattle(pet, pet_, 2);
                    }
                } catch (UnsupportedAudioFileException | LineUnavailableException | IOException ex) {
                    throw new RuntimeException(ex);
                }
                if (pet.isDead() || pet_.isDead()) {
                    nextPet(pet, pet_);
                }
            }
        }
        if("option2".equals(e.getActionCommand())){

            if(battle.getBattle().getOpzioni()[4].getText().
                    equalsIgnoreCase("NO")){

                pet.getAttackSet().remove(2);
                JOptionPane.showMessageDialog(null, "IL TUO PET HA IMPARATO IL NUOVO ATTACCO");
                battle.getBattle().getFrame().dispose();
                battle.getBattle().getMusic().stop();

            }else{
                try {
                    if(!battle.numOfAvailabilityIsFinish(pet.getAttackSet().get(2))) {
                        attackAvaiabilityRemoved[2] += 1;
                        attackForBattle(pet, pet_, 2);
                }else{
                    JOptionPane.showInternalConfirmDialog(null, "Non puoi più usare questa mossa!!!");
                    attackForBattle(pet, pet_, 3);
                }
                } catch (UnsupportedAudioFileException | LineUnavailableException | IOException ex) {
                    throw new RuntimeException(ex);
                }
                if (pet.isDead() || pet_.isDead()) {
                    nextPet(pet, pet_);
                }
            }
        }
        if("option3".equals(e.getActionCommand())){

            if(battle.getBattle().getOpzioni()[4].getText().
                    equalsIgnoreCase("NO")){

                pet.getAttackSet().remove(3);
                JOptionPane.showMessageDialog(null, "IL TUO PET HA IMPARATO IL NUOVO ATTACCO");
                battle.getBattle().getFrame().dispose();
                battle.getBattle().getMusic().stop();

            }else{
                try {
                    if(!battle.numOfAvailabilityIsFinish(pet.getAttackSet().get(3))) {
                        attackAvaiabilityRemoved[3] += 1;
                        attackForBattle(pet, pet_, 3);
                    }else{
                        JOptionPane.showInternalConfirmDialog(null, "Non puoi più usare questa mossa!!!");
                        attackForBattle(pet, pet_, 0);
                    }
                } catch (UnsupportedAudioFileException | LineUnavailableException | IOException ex) {
                    throw new RuntimeException(ex);
                }
                if (pet.isDead() || pet_.isDead()) {
                    nextPet(pet, pet_);
                }
            }
        }
    }
    private void assignPointForLevel(Person trainer){
        for(Pet pet : trainer.getPetList().values()) {
            switch (pet.getLevels()) {
                case BASE:
                    pet.setPower(5);
                    pet.setDefense(5);
                    pet.setLifeForLevel(10);
                    pet.setSpeed(5);
                    break;
                case START:
                    pet.setPower(10);
                    pet.setDefense(10);
                    pet.setLifeForLevel(30);
                    pet.setSpeed(10);
                    break;
                case MEDIUM:
                    pet.setPower(20);
                    pet.setDefense(20);
                    pet.setLifeForLevel(50);
                    pet.setSpeed(20);
                    break;
                case GREAT:
                    pet.setPower(40);
                    pet.setDefense(40);
                    pet.setLifeForLevel(70);
                    pet.setSpeed(40);
                    break;
                case ADVANCE:
                    pet.setPower(60);
                    pet.setDefense(60);
                    pet.setLifeForLevel(90);
                    pet.setSpeed(60);
                    break;
                case PERFECT:
                    pet.setPower(80);
                    pet.setDefense(80);
                    pet.setLifeForLevel(100);
                    pet.setSpeed(80);
                    break;
            }
        }
    }

    private void removePointForLevel(Person trainer){
        for(Pet pet : trainer.getPetList().values()) {
            switch (pet.getLevels()) {
                case BASE:
                    pet.setPower(-5);
                    pet.setDefense(-5);
                    pet.setLifeForLevel(-10);
                    pet.setSpeed(-5);
                    break;
                case START:
                    pet.setPower(-10);
                    pet.setDefense(-10);
                    pet.setLifeForLevel(-30);
                    pet.setSpeed(-10);
                    break;
                case MEDIUM:
                    pet.setPower(-20);
                    pet.setDefense(-20);
                    pet.setLifeForLevel(-50);
                    pet.setSpeed(-20);
                    break;
                case GREAT:
                    pet.setPower(-40);
                    pet.setDefense(-40);
                    pet.setLifeForLevel(-70);
                    pet.setSpeed(-40);
                    break;
                case ADVANCE:
                    pet.setPower(-60);
                    pet.setDefense(-60);
                    pet.setLifeForLevel(-90);
                    pet.setSpeed(-60);
                    break;
                case PERFECT:
                    pet.setPower(-80);
                    pet.setDefense(-80);
                    pet.setLifeForLevel(-100);
                    pet.setSpeed(-80);
                    break;
            }
        }
    }
    private void attackForBattle(Pet pet, Pet pet_, int n) throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        Pet petMostSpeed = battle.whoAttackFirst(pet,pet_);
        numberOfChoose = n;
        if(petMostSpeed.equals(pet)) {
            switch(trainer1.getName().toLowerCase()){
                case "alycia":
                    setimagefight("images/MyTrainer/pg_f_lotta_2.jpg");
                    break;
                case "david":
                    setimagefight(Constant.allenatoreMyLotta2);
                    break;
            }
                battle.viewCommentAttack(pet, battle.isDamageOrShelter(battle.seeDamage(pet, n),
                        battle.seeShelter(pet, n),battle.seePowerUp(pet,n), pet, pet_,"my"), battle.seeShelter(pet, n), pet.getAttackSet().get(n).getName().toString());
                battle.setLifeForFrame(pet_, "Enemy");
                battle.getBattle().getOpzioni()[0].setEnabled(false);
                battle.getBattle().getOpzioni()[1].setEnabled(false);
                battle.getBattle().getOpzioni()[2].setEnabled(false);
                battle.getBattle().getOpzioni()[3].setEnabled(false);
                battle.getBattle().getOpzioni()[4].setEnabled(true);
                reloadMnemonic();
                battle.getBattle().getOpzioni()[4].setText("TURN ENEMY");
        }else{
            attackAvaiabilityRemovedEnemy[battle.turnEnemy(pet_,pet)] +=1;
            switch(trainer1.getName().toLowerCase()){
                case "alycia":
                    setimagefight("images/MyTrainer/pg_f_lotta_1.jpg");
                    break;
                case "david":
                    setimagefight(Constant.allenatoreMyLotta1);
                    break;
            }
            battle.setLifeForFrame(pet,"My");
            battle.getBattle().getOpzioni()[0].setEnabled(false);
            battle.getBattle().getOpzioni()[1].setEnabled(false);
            battle.getBattle().getOpzioni()[2].setEnabled(false);
            battle.getBattle().getOpzioni()[3].setEnabled(false);
            battle.getBattle().getOpzioni()[4].setEnabled(true);
            battle.getBattle().getOpzioni()[4].setText("YOUR TURN");
        }
    }
    private void setimagefight(String filePath){
        trainer1.setFilePathImage(filePath);
        battle.getBattle().getMyTrainer().setIcon(new ImageIcon(trainer1.getFilePathImage()));
    }

    private void nextPet(Pet pet,Pet pet_){
        for(int i=0;i<attackAvaiabilityRemoved.length;i++){
            System.out.println("avb usati da me:");
            System.out.println(attackAvaiabilityRemoved[i]);
        }

        if(pet.isDead()){
            battle.getBattle().setNextPet(1);
            battle.getBattle().getLife().setText("K.O.");
            battle.getBattle().getMyPet().setIcon(new ImageIcon(Constant.ko));
            if(trainer1.getPetList().get(battle.getBattle().getNextPet()) == null){
                JOptionPane.showMessageDialog(null, "HAI PERSO LO SCONTRO!");
                System.out.println("prima");
                for(Attack attack : pet.getAttackSet()){
                    System.out.println("pet ");
                    System.out.println(attack.getNumOfAvailability());
                }
                for(Attack attack : pet_.getAttackSet()){
                    System.out.println("pet nemico");
                    System.out.println(attack.getNumOfAvailability());
                }
                removePointForLevel(trainer1);
                removePointForLevel(trainer2);
                pet_.setLifeForLevel(battle.getLifeRemovedEnemy());
                pet.setLifeForLevel(battle.getLifeRemoved());
                pet.removePower(battle.getPowerUp());
                pet_.removePower(battle.getPowerUpEnemy());
                pet.removeDefense(battle.getDefeseUp());
                pet_.removeDefense(battle.getDefeseUpEnemy());
                pet.restoreNumOfAvb(attackAvaiabilityRemoved);
                pet_.restoreNumOfAvb(attackAvaiabilityRemovedEnemy);
                restoreArray(attackAvaiabilityRemoved);
                restoreArray(attackAvaiabilityRemovedEnemy);
                System.out.println("dopo");
                for(Attack attack : pet.getAttackSet()){
                    System.out.println("pet ");
                    System.out.println(attack.getNumOfAvailability());
                }
                for(Attack attack : pet_.getAttackSet()){
                    System.out.println("pet nemico");
                    System.out.println(attack.getNumOfAvailability());
                }
                battle.getBattle().getFrame().dispose();
                battle.getBattle().getMusic().stop();

            }else{
                System.out.println("prima");
                for(Attack attack : pet.getAttackSet()){
                    System.out.println("pet ");
                    System.out.println(attack.getNumOfAvailability());
                }
                for(Attack attack : pet_.getAttackSet()){
                    System.out.println("pet nemico");
                    System.out.println(attack.getNumOfAvailability());
                }
                pet.setLifeForLevel(battle.getLifeRemoved());
                pet.removePower(battle.getPowerUp());
                pet.removeDefense(battle.getDefeseUp());
                pet.restoreNumOfAvb(attackAvaiabilityRemoved);
                restoreArray(attackAvaiabilityRemoved);
                battle.setPowerUp(0);
                battle.setLifeRemoved(0);
                battle.setDefeseUp(0);
                System.out.println("dopo");
                for(Attack attack : pet.getAttackSet()){
                    System.out.println("pet ");
                    System.out.println(attack.getNumOfAvailability());
                }
                for(Attack attack : pet_.getAttackSet()){
                    System.out.println("pet nemico");
                    System.out.println(attack.getNumOfAvailability());
                }
                pet = trainer1.getPetList().get(battle.getBattle().getNextPet());
                setAttacktoChoose(pet);
                JOptionPane.showMessageDialog(null, "IL TUO PET è STATO SCONFITTO!");
                JOptionPane.showMessageDialog(null, "MANDI IN CAMPO UN'ALTRO PET!");
                battle.getBattle().getMyPet().setIcon(new ImageIcon(trainer1.getPetList()
                        .get(battle.getBattle().getNextPet()).getFilePathImage()));
                battle.getBattle().getMyTrainer().setIcon(new ImageIcon(trainer1.getFilePathImage()));
                battle.setLifeForFrame(pet,"My");
                battle.getBattle().getOpzioni()[4].setText("START FIGHT");
                battle.getBattle().getOpzioni()[0].setEnabled(false);
                battle.getBattle().getOpzioni()[1].setEnabled(false);
                battle.getBattle().getOpzioni()[2].setEnabled(false);
                battle.getBattle().getOpzioni()[3].setEnabled(false);
                battle.getBattle().getOpzioni()[4].setEnabled(true);
            }
        }else if(pet_.isDead()) {
            battle.getBattle().getLifeEnemy().setText("K.O.");
            battle.getBattle().getEnemyPet().setIcon(new ImageIcon(Constant.ko));
            battle.getBattle().setNextPetEnemy(1);
            if(trainer2.getPetList().get(battle.getBattle().getNextPetEnemy()) == null){
                JOptionPane.showMessageDialog(this.getBattle().frame, "HAI VINTO LO SCONTRO!");
                System.out.println("prima");
                for(Attack attack : pet.getAttackSet()){
                    System.out.println("pet ");
                    System.out.println(attack.getNumOfAvailability());
                }
                for(Attack attack : pet_.getAttackSet()){
                    System.out.println("pet nemico");
                    System.out.println(attack.getNumOfAvailability());
                }
                removePointForLevel(trainer1);
                removePointForLevel(trainer2);
                pet_.setLifeForLevel(battle.getLifeRemovedEnemy());
                pet.setLifeForLevel(battle.getLifeRemoved());
                pet.removePower(battle.getPowerUp());
                pet_.removePower(battle.getPowerUpEnemy());
                pet.removeDefense(battle.getDefeseUp());
                pet_.removeDefense(battle.getDefeseUpEnemy());
                pet.restoreNumOfAvb(attackAvaiabilityRemoved);
                pet_.restoreNumOfAvb(attackAvaiabilityRemovedEnemy);
                restoreArray(attackAvaiabilityRemoved);
                restoreArray(attackAvaiabilityRemovedEnemy);
                System.out.println("dopo");
                for(Attack attack : pet.getAttackSet()){
                    System.out.println("pet ");
                    System.out.println(attack.getNumOfAvailability());
                }
                for(Attack attack : pet_.getAttackSet()){
                    System.out.println("pet nemico");
                    System.out.println(attack.getNumOfAvailability());
                }
                Levels actuallyLevel = pet.getLevels();
                trainer1.setVictory(1);
                trainer1.setLevels();
                pet.setLevels(trainer1.getLevels());
                if(actuallyLevel != pet.getLevels()){
                    battle.getBattle().getOpzioni()[0].setEnabled(true);
                    battle.getBattle().getOpzioni()[1].setEnabled(true);
                    battle.getBattle().getOpzioni()[2].setEnabled(true);
                    battle.getBattle().getOpzioni()[3].setEnabled(true);
                    battle.getBattle().getOpzioni()[4].setText("NO");
                    battle.getBattle().getOpzioni()[4].setEnabled(true);
                    battle.addNewAttack(pet,battle.newAttackByType(pet));
                    }else{
                    battle.getBattle().getFrame().dispose();
                    battle.getBattle().getMusic().stop();
                }
                }else{
                System.out.println("prima");
                for(Attack attack : pet.getAttackSet()){
                    System.out.println("pet ");
                    System.out.println(attack.getNumOfAvailability());
                }
                for(Attack attack : pet_.getAttackSet()){
                    System.out.println("pet nemico");
                    System.out.println(attack.getNumOfAvailability());
                }
                pet_.setLifeForLevel(battle.getLifeRemovedEnemy());
                pet_.removePower(battle.getPowerUpEnemy());
                pet_.removeDefense(battle.getDefeseUpEnemy());
                pet_.restoreNumOfAvb(attackAvaiabilityRemovedEnemy);
                restoreArray(attackAvaiabilityRemovedEnemy);
                battle.setLifeRemovedEnemy(0);
                battle.setPowerUpEnemy(0);
                battle.setDefeseUpEnemy(0);
                System.out.println("dopo");
                for(Attack attack : pet.getAttackSet()){
                    System.out.println("pet ");
                    System.out.println(attack.getNumOfAvailability());
                }
                for(Attack attack : pet_.getAttackSet()){
                    System.out.println("pet nemico");
                    System.out.println(attack.getNumOfAvailability());
                }
                pet_ = trainer2.getPetList().get(battle.getBattle().getNextPetEnemy());
                JOptionPane.showMessageDialog(null, "IL PET NEMICO è STATO SCONFITTO!");
                JOptionPane.showMessageDialog(null, "MANDA IN CAMPO UN ALTRO PET!");
                battle.getBattle().getEnemyPet().setIcon(new ImageIcon(trainer2.getPetList()
                        .get(battle.getBattle().getNextPetEnemy()).getFilePathImage()));
                battle.getBattle().getEnemyTrainer().setIcon(new ImageIcon(trainer2.getFilePathImage()));
                battle.setLifeForFrame(pet_,"Enemy");
                battle.getBattle().getOpzioni()[4].setText("START FIGHT");
                battle.getBattle().getOpzioni()[0].setEnabled(false);
                battle.getBattle().getOpzioni()[1].setEnabled(false);
                battle.getBattle().getOpzioni()[2].setEnabled(false);
                battle.getBattle().getOpzioni()[3].setEnabled(false);
                battle.getBattle().getOpzioni()[4].setEnabled(true);

            }
        }
    }
    private void setAttacktoChoose(Pet pet){
        for(int i=0; i<=4; i++) {
            if(i==4){
                battle.getBattle().getOpzioni()[i].addActionListener(this);
                battle.getBattle().getOpzioni()[i].setActionCommand("option"+i);
            }else{
                battle.getBattle().getOpzioni()[i].addActionListener(this);
                battle.getBattle().getOpzioni()[i].setActionCommand("option"+i);
                battle.getBattle().getOpzioni()[i].setText(pet.getAttackSet().get(i).getName());
            }
        }
    }

    public BattleWindow getBattle() {
        return battle.getBattle();
    }

    private void restoreArray(int[] array){
        for(int i=0; i < attackAvaiabilityRemoved.length; i++){
            attackAvaiabilityRemoved[i] = 0;
        }
    }

    private void reloadMnemonic(){
        for(int i = 0; i < battle.getBattle().getOpzioni().length-1;i++){
            battle.getBattle().getOpzioni()[i].setToolTipText("DESCRIPTION-->"+trainer1.getPetList().get(getBattle().getNextPet()).getAttackSet().get(i).getDescription() +
                    "--DAMAGE-->"+trainer1.getPetList().get(getBattle().getNextPet()).getAttackSet().get(i).getDamage() +
                    "--SHELTER-->"+trainer1.getPetList().get(getBattle().getNextPet()).getAttackSet().get(i).getShelter() +
                    "--POWER_UP-->"+trainer1.getPetList().get(getBattle().getNextPet()).getAttackSet().get(i).getPowerUp() +
                    "--AVAILABILITY-->"+trainer1.getPetList().get(getBattle().getNextPet()).getAttackSet().get(i).getNumOfAvailability());
        }
    }
}

