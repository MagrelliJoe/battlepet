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
        battle.getBattle().getMyTrainer().setIcon(new ImageIcon(trainer1.getFilePathImage()));
    }
    @Override
    public void actionPerformed(ActionEvent e) {

        if("option3".equals(e.getActionCommand())){
            if(battle.getBattle().getOpzioni()[3].getText().
                    equalsIgnoreCase("START FIGHT")){
                pet = trainer1.getPetList().get(battle.getBattle().getNextPet());
                setimagefight(Constant.allenatoreMyLotta1);
                pet_ = trainer2.getPetList().get(battle.getBattle().getNextPetEnemy());
                battle.setLifeForFrame(pet,"My");
                battle.getBattle().getOpzioni()[0].setEnabled(true);
                battle.getBattle().getOpzioni()[1].setEnabled(true);
                battle.getBattle().getOpzioni()[2].setEnabled(true);
                battle.setLifeForFrame(pet_,"Enemy");
                battle.getBattle().getOpzioni()[3].setEnabled(false);

            }else if(battle.getBattle().getOpzioni()[3].getText().
                    equalsIgnoreCase("NO")){
                JOptionPane.showMessageDialog(null, "IL TUO PET HA MANTENUTO I SUOI ATTACCHI!");
                setimagefight(Constant.allenatoreMyLotta1);
                pet.getAttackSet().remove(3);
                battle.getBattle().getFrame().dispose();
                battle.getBattle().getMusic().stop();

            }else if(battle.getBattle().getOpzioni()[3].getText().
                    equalsIgnoreCase("YOUR TURN")){

                try {
                    setimagefight(Constant.allenatoreMyLotta2);
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
                    setimagefight(Constant.allenatoreMyLotta1);
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
                battle.getBattle().getMusic().stop();

            }else{

                try {
                    if(!battle.numOfAvailabilityIsFinish(pet.getAttackSet().get(0))) {
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

            if(battle.getBattle().getOpzioni()[3].getText().
                    equalsIgnoreCase("NO")){

                pet.getAttackSet().remove(1);
                JOptionPane.showMessageDialog(null, "IL TUO PET HA IMPARATO IL NUOVO ATTACCO");
                battle.getBattle().getFrame().dispose();
                battle.getBattle().getMusic().stop();

            }else{

                try {
                    if(!battle.numOfAvailabilityIsFinish(pet.getAttackSet().get(1))) {
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

            if(battle.getBattle().getOpzioni()[3].getText().
                    equalsIgnoreCase("NO")){

                pet.getAttackSet().remove(2);
                JOptionPane.showMessageDialog(null, "IL TUO PET HA IMPARATO IL NUOVO ATTACCO");
                battle.getBattle().getFrame().dispose();
                battle.getBattle().getMusic().stop();

            }else{

                try {
                    if(!battle.numOfAvailabilityIsFinish(pet.getAttackSet().get(2))) {
                    attackForBattle(pet, pet_, 2);
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
                setimagefight(Constant.allenatoreMyLotta2);
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
            setimagefight(Constant.allenatoreMyLotta1);
            battle.setLifeForFrame(pet,"My");
            battle.getBattle().getOpzioni()[0].setEnabled(false);
            battle.getBattle().getOpzioni()[1].setEnabled(false);
            battle.getBattle().getOpzioni()[2].setEnabled(false);
            battle.getBattle().getOpzioni()[3].setEnabled(true);
            battle.getBattle().getOpzioni()[3].setText("YOUR TURN");

        }

    }

    private void setimagefight(String filePath){
        trainer1.setFilePathImage(filePath);
        battle.getBattle().getMyTrainer().setIcon(new ImageIcon(trainer1.getFilePathImage()));
    }

    private void nextPet(Pet pet,Pet pet_){
        if(pet.isDead()){
            battle.getBattle().getLife().setText("K.O.");
            battle.getBattle().getMyPet().setIcon(new ImageIcon(Constant.ko));
            battle.getBattle().setNextPet(1);
            setimagefight(Constant.allenatoreMyLotta1);

            if(trainer1.getPetList().get(battle.getBattle().getNextPet()) == null){
                JOptionPane.showMessageDialog(null, "HAI PERSO LO SCONTRO!");
                removePointForLevel(trainer1);
                battle.getBattle().getFrame().dispose();
                battle.getBattle().getMusic().stop();

            }else{
                pet = trainer1.getPetList().get(battle.getBattle().getNextPet());
                setAttacktoChoose(pet);
                JOptionPane.showMessageDialog(null, "IL TUO PET è STATO SCONFITTO!");
                JOptionPane.showMessageDialog(null, "MANDI IN CAMPO UN'ALTRO PET!");
                battle.getBattle().getMyPet().setIcon(new ImageIcon(trainer1.getPetList()
                        .get(battle.getBattle().getNextPet()).getFilePathImage()));
                battle.getBattle().getMyTrainer().setIcon(new ImageIcon(trainer1.getFilePathImage()));
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
                    pet.setLevels(trainer1.getLevels());
                    battle.addNewAttack(pet,battle.newAttackByType(pet));
                }else{
                    battle.getBattle().getFrame().dispose();
                    battle.getBattle().getMusic().stop();
                }
            }else{
                pet_ = trainer2.getPetList().get(battle.getBattle().getNextPetEnemy());
                JOptionPane.showMessageDialog(null, "IL PET NEMICO è STATO SCONFITTO!");
                JOptionPane.showMessageDialog(null, "MANDA IN CAMPO UN ALTRO PET!");
                battle.getBattle().getEnemyPet().setIcon(new ImageIcon(trainer2.getPetList()
                        .get(battle.getBattle().getNextPetEnemy()).getFilePathImage()));
                battle.getBattle().getEnemyTrainer().setIcon(new ImageIcon(trainer2.getFilePathImage()));
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


}
