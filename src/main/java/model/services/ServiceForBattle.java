package model.services;
import model.data.implementation.BattleJFrame;
import model.entities.*;
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
    private int numberOfChoose;

    public ServiceForBattle(Person trainer1, Person trainer2, BattleWindow battleWindow){
        this.battle = new BattleJFrame(battleWindow);
        this.random = new Random();
        this.trainer1 = trainer1;
        this.trainer2 = trainer2;
        setAttacktoChoose(trainer1.getPetList().get(0));
        assignPointForLevel(trainer1.getPetList().get(0));
        assignPointForLevel(trainer2.getPetList().get(0));
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        Pet pet = trainer1.getPetList().get(battle.getBattle().getNextPet());
        Pet pet_ = trainer2.getPetList().get(battle.getBattle().getNextPetEnemy());
        battle.getBattle().getEnemyPet().setIcon(new ImageIcon(trainer2.getPetList()
                .get(battle.getBattle().getNextPetEnemy()).getFilePathImage()));
        battle.getBattle().getMyPet().setIcon(new ImageIcon(trainer1.getPetList()
                .get(battle.getBattle().getNextPet()).getFilePathImage()));
        battle.getBattle().getEnemyTrainer().setIcon(new ImageIcon(trainer2.getFilePathImage()));
        battle.getBattle().getMyTrainer().setIcon(new ImageIcon(trainer1.getFilePathImage()));

        if("option3".equals(e.getActionCommand())){
            if(battle.getBattle().getOpzioni()[3].getText().
                    equalsIgnoreCase("START FIGHT")){
                battle.setLifeForFrame(pet,"My");
                battle.getBattle().getOpzioni()[0].setEnabled(true);
                battle.getBattle().getOpzioni()[1].setEnabled(true);
                battle.getBattle().getOpzioni()[2].setEnabled(true);
                battle.setLifeForFrame(pet_,"Enemy");
                battle.getBattle().getOpzioni()[3].setEnabled(false);

            }else if(battle.getBattle().getOpzioni()[3].getText().
                    equalsIgnoreCase("NO")){

                JOptionPane.showMessageDialog(null, "IL TUO PET HA MANTENUTO I SUOI ATTACCHI!");
                pet.getAttackSet().remove(3);
                battle.getBattle().getFrame().dispose();

            }else if(battle.getBattle().getOpzioni()[3].getText().
                    equalsIgnoreCase("YOUR TURN")){

                try {
                    battle.viewCommentAttack(pet, battle.isDamageOrShelter(battle.seeDamage(pet, numberOfChoose),
                            battle.seeShelter(pet, numberOfChoose), pet, pet_), battle.seeShelter(pet, numberOfChoose), pet.getAttackSet().get(numberOfChoose).getName().toString());
                } catch (UnsupportedAudioFileException | LineUnavailableException | IOException ex) {
                    throw new RuntimeException(ex);
                }
                battle.setLifeForFrame(pet_, "Enemy");
                battle.getBattle().getOpzioni()[0].setEnabled(true);
                battle.getBattle().getOpzioni()[1].setEnabled(true);
                battle.getBattle().getOpzioni()[2].setEnabled(true);
                battle.getBattle().getOpzioni()[3].setEnabled(false);

                if (pet.isDead() || pet_.isDead()) {
                    nextPet(pet, pet_);
                }

            }else{
                try {
                    battle.turnEnemy(pet_,pet);
                    battle.setLifeForFrame(pet,"My");
                    battle.getBattle().getOpzioni()[3].setEnabled(false);
                    battle.getBattle().getOpzioni()[0].setEnabled(true);
                    battle.getBattle().getOpzioni()[1].setEnabled(true);
                    battle.getBattle().getOpzioni()[2].setEnabled(true);

                    if (pet.isDead() || pet_.isDead()) {
                        nextPet(pet, pet_);
                    }
                } catch (UnsupportedAudioFileException | LineUnavailableException | IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        }
        if("option0".equals(e.getActionCommand())){
            if(battle.getBattle().getOpzioni()[3].getText().
                    equalsIgnoreCase("NO")){

                pet.getAttackSet().remove(0);
                JOptionPane.showMessageDialog(null, "IL TUO PET HA IMPARATO IL NUOVO ATTACCO");
                battle.getBattle().getFrame().dispose();

            }else{

                try {
                    if(!battle.numOfAvailabilityIsFinish(pet.getAttackSet().get(0))) {
                        AttackForBattle(pet, pet_, 0);
                    }else{
                        JOptionPane.showInternalConfirmDialog(null, "Non puoi più usare questa mossa!!!");
                        AttackForBattle(pet, pet_, 1);
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

            if(battle.getBattle().getOpzioni()[3].getText().
                    equalsIgnoreCase("NO")){

                pet.getAttackSet().remove(1);
                JOptionPane.showMessageDialog(null, "IL TUO PET HA IMPARATO IL NUOVO ATTACCO");
                battle.getBattle().getFrame().dispose();

            }else{

                try {
                    if(!battle.numOfAvailabilityIsFinish(pet.getAttackSet().get(1))) {
                        AttackForBattle(pet, pet_, 1);
                    }else{
                        JOptionPane.showInternalConfirmDialog(null, "Non puoi più usare questa mossa!!!");
                        AttackForBattle(pet, pet_, 2);
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

            if(battle.getBattle().getOpzioni()[3].getText().
                    equalsIgnoreCase("NO")){

                pet.getAttackSet().remove(2);
                JOptionPane.showMessageDialog(null, "IL TUO PET HA IMPARATO IL NUOVO ATTACCO");
                battle.getBattle().getFrame().dispose();

            }else{

                try {
                    if(!battle.numOfAvailabilityIsFinish(pet.getAttackSet().get(2))) {
                    AttackForBattle(pet, pet_, 2);
                }else{

                    JOptionPane.showInternalConfirmDialog(null, "Non puoi più usare questa mossa!!!");
                    AttackForBattle(pet, pet_, 0);
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
    private void assignPointForLevel(Pet pet){
        switch(pet.getLevels()){
            case BASE :  pet.setPower(10);
                         pet.setDefense(10);
                         pet.setLifeForLevel(10);
                         pet.setSpeed(10);
                         break;
            case START:  pet.setPower(5);
                         pet.setDefense(5);
                         pet.setLifeForLevel(5);
                         pet.setSpeed(5);
                         break;
            case MEDIUM: pet.setPower(20);
                         pet.setDefense(20);
                         pet.setLifeForLevel(20);
                         pet.setSpeed(20);
                         break;
            case GREAT: pet.setPower(30);
                        pet.setDefense(30);
                        pet.setLifeForLevel(30);
                        pet.setSpeed(30);
                        break;
            case ADVANCE: pet.setPower(40);
                          pet.setDefense(40);
                          pet.setLifeForLevel(40);
                          pet.setSpeed(40);
                          break;
            case PERFECT: pet.setPower(50);
                          pet.setDefense(50);
                          pet.setLifeForLevel(50);
                          pet.setSpeed(50);
                          break;
            }
    }
    private void AttackForBattle(Pet pet,Pet pet_,int n) throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        Pet petMostSpeed = battle.whoAttackFirst(pet,pet_);
        numberOfChoose = n;
        if(petMostSpeed.equals(pet)) {
                battle.viewCommentAttack(pet, battle.isDamageOrShelter(battle.seeDamage(pet, n),
                        battle.seeShelter(pet, n), pet, pet_), battle.seeShelter(pet, n), pet.getAttackSet().get(n).getName().toString());
                battle.setLifeForFrame(pet_, "Enemy");
                battle.getBattle().getOpzioni()[0].setEnabled(false);
                battle.getBattle().getOpzioni()[1].setEnabled(false);
                battle.getBattle().getOpzioni()[2].setEnabled(false);
                battle.getBattle().getOpzioni()[3].setEnabled(true);
                battle.getBattle().getOpzioni()[3].setText("TURN ENEMY");
        }else{

            battle.turnEnemy(pet_,pet);
            battle.setLifeForFrame(pet,"My");
            battle.getBattle().getOpzioni()[0].setEnabled(false);
            battle.getBattle().getOpzioni()[1].setEnabled(false);
            battle.getBattle().getOpzioni()[2].setEnabled(false);
            battle.getBattle().getOpzioni()[3].setEnabled(true);
            battle.getBattle().getOpzioni()[3].setText("YOUR TURN");

        }

    }
    private void nextPet(Pet pet,Pet pet_){
        if(pet.isDead()){
            battle.getBattle().getLife().setText("K.O.");
            battle.getBattle().getMyPet().setIcon(new ImageIcon(Constant.ko));
            battle.getBattle().setNextPet(1);
            if(trainer1.getPetList().get(battle.getBattle().getNextPet()) == null){
                JOptionPane.showMessageDialog(null, "HAI PERSO LO SCONTRO!");
                battle.getBattle().getFrame().dispose();
                battle.getBattle().getMusic().stop();
            }else{
                pet = trainer1.getPetList().get(battle.getBattle().getNextPet());
                assignPointForLevel(pet);
                setAttacktoChoose(pet);
                JOptionPane.showMessageDialog(null, "IL TUO PET è STATO SCONFITTO!");
                JOptionPane.showMessageDialog(null, "MANDI IN CAMPO UN'ALTRO PET!");
                battle.setLifeForFrame(pet,"My");
                battle.getBattle().getOpzioni()[3].setText("START FIGHT");
                battle.getBattle().getOpzioni()[0].setEnabled(false);
                battle.getBattle().getOpzioni()[1].setEnabled(false);
                battle.getBattle().getOpzioni()[2].setEnabled(false);
                battle.getBattle().getOpzioni()[3].setEnabled(true);
            }
        }else if(pet_.isDead()) {
            battle.getBattle().setNextPetEnemy(1);
            battle.getBattle().getLifeEnemy().setText("K.O.");
            battle.getBattle().getEnemyPet().setIcon(new ImageIcon(Constant.ko));
            if(trainer2.getPetList().get(battle.getBattle().getNextPetEnemy()) == null){
                JOptionPane.showMessageDialog(null, "HAI VINTO LO SCONTRO!");
                Levels actuallyLevel = trainer1.getLevels();
                trainer1.setVictory(1);
                if(actuallyLevel != trainer1.getLevels()){
                    battle.getBattle().getOpzioni()[0].setEnabled(true);
                    battle.getBattle().getOpzioni()[1].setEnabled(true);
                    battle.getBattle().getOpzioni()[2].setEnabled(true);
                    battle.addNewAttack(pet,battle.newAttackByType(pet));
                }
                battle.getBattle().getFrame().dispose();
                battle.getBattle().getMusic().stop();
            }else{
                pet_ = trainer2.getPetList().get(battle.getBattle().getNextPetEnemy());
                assignPointForLevel(pet_);
                JOptionPane.showMessageDialog(null, "IL PET NEMICO è STATO SCONFITTO!");
                JOptionPane.showMessageDialog(null, "MANDA IN CAMPO UN ALTRO PET!");
                battle.setLifeForFrame(pet_,"Enemy");
                battle.getBattle().getOpzioni()[3].setText("START FIGHT");
                battle.getBattle().getOpzioni()[0].setEnabled(false);
                battle.getBattle().getOpzioni()[1].setEnabled(false);
                battle.getBattle().getOpzioni()[2].setEnabled(false);
                battle.getBattle().getOpzioni()[3].setEnabled(true);
            }
        }
    }
    private void setAttacktoChoose(Pet pet){
        for(int i=0; i<4; i++) {
            if(i==3){
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

    public void setBattle(BattleWindow battle) {
        this.battle.setBattle(battle);
    }

    public BattleJFrame getRepositoryBattle() {
        return battle;
    }

    public void setRepositoryBattle(BattleJFrame repositoryBattle) {
        this.battle = repositoryBattle;
    }

    public Random getRandom() {
        return random;
    }

    public void setRandom(Random random) {
        this.random = random;
    }

    public Person getTrainer1() {
        return trainer1;
    }

    public void setTrainer1(Person trainer1) {
        this.trainer1 = trainer1;
    }

    public Person getTrainer2() {
        return trainer2;
    }

    public void setTrainer2(Person trainer2) {
        this.trainer2 = trainer2;
    }

}
