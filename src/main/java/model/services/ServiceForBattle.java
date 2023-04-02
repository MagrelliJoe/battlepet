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
import static model.entities.Constant.*;

public class ServiceForBattle implements ActionListener {
    private BattleJFrame battle;
    private Random random;
    private Person trainer1,trainer2;

    public ServiceForBattle(BattleJFrame battle, Person trainer1, Person trainer2)
            throws LineUnavailableException, IOException, UnsupportedAudioFileException{

        this.random = new Random();
        this.battle = battle;
        this.trainer1 = trainer1;
        this.trainer2 = trainer2;
        battle.getBattle().createBattleWindows(sfondo,allenatoreMy,allenatore1Lotta,null,null,musicalotta1,messaggio);
        setAttacktoChoose(trainer1.getPetList().get(0));
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        Levels actuallyLevel = trainer1.getLevels();
        Pet pet = trainer1.getPetList().get(battle.getBattle().getNextPet());
        Pet pet_ = trainer2.getPetList().get(battle.getBattle().getNextPetEnemy());
        battle.setAttackDefenseByLevels(pet);
        battle.setAttackDefenseByLevels(pet_);
        if("option3".equals(e.getActionCommand())){
            if(battle.getBattle().getOpzioni()[3].getText().
                    equalsIgnoreCase("START FIGHT")){
                battle.setLifeForFrame(pet,"My");
                battle.getBattle().getOpzioni()[0].setEnabled(true);
                battle.getBattle().getOpzioni()[1].setEnabled(true);
                battle.getBattle().getOpzioni()[2].setEnabled(true);
                battle.setLifeForFrame(pet_,"Enemy");
                battle.getBattle().getOpzioni()[3].setEnabled(false);
            }else{
                battle.turnEnemy(pet_,pet);
                battle.setLifeForFrame(pet,"My");
                battle.getBattle().getOpzioni()[3].setEnabled(false);
                battle.getBattle().getOpzioni()[0].setEnabled(true);
                battle.getBattle().getOpzioni()[1].setEnabled(true);
                battle.getBattle().getOpzioni()[2].setEnabled(true);
            }
        }
        if("option0".equals(e.getActionCommand())){
           AttackForBattle(pet,pet_,0);
           if(pet.isDead() || pet_.isDead()){
               nextPet(pet,pet_);
           }
        }
        if("option1".equals(e.getActionCommand())){
            AttackForBattle(pet,pet_,1);
            if(pet.isDead() || pet_.isDead()){
                nextPet(pet,pet_);
            }
        }
        if("option2".equals(e.getActionCommand())){
            AttackForBattle(pet,pet_,2);
            if(pet.isDead() || pet_.isDead()){
                nextPet(pet,pet_);
            }
        }
    }

    private void nextPet(Pet pet,Pet pet_){
        if(pet.isDead()){
            if(trainer1.getPetList().get(battle.getBattle().getNextPet()+1) == null){
                JOptionPane.showMessageDialog(null, "HAI PERSO LO SCONTRO!");
                battle.getBattle().getFrame().dispose();
            }else{
                battle.getBattle().setNextPet(+1);
                System.out.println(battle.getBattle().getNextPet());
                pet = trainer1.getPetList().get(battle.getBattle().getNextPet());
                setAttacktoChoose(pet);
                JOptionPane.showMessageDialog(null, "IL TUO PET è STATO SCONFITTO!");
                JOptionPane.showMessageDialog(null, "MANDI IN CAMPO UN'ALTRO PET!");
                battle.setLifeForFrame(pet,"My");
                battle.setAttackDefenseByLevels(pet);
                battle.getBattle().getOpzioni()[3].setText("START FIGHT");
                battle.getBattle().getOpzioni()[0].setEnabled(false);
                battle.getBattle().getOpzioni()[1].setEnabled(false);
                battle.getBattle().getOpzioni()[2].setEnabled(false);
                battle.getBattle().getOpzioni()[3].setEnabled(true);
            }
        }else if(pet_.isDead()) {
            if(trainer2.getPetList().get(battle.getBattle().getNextPet()+1) == null){
                JOptionPane.showMessageDialog(null, "HAI VINTO LO SCONTRO!");
                battle.getBattle().getFrame().dispose();
            }else{
                battle.getBattle().setNextPetEnemy(+1);
                pet_ = trainer2.getPetList().get(battle.getBattle().getNextPet());
                JOptionPane.showMessageDialog(null, "IL PET NEMICO è STATO SCONFITTO!");
                JOptionPane.showMessageDialog(null, "MANDA IN CAMPO UN'ALTRO PET!");
                battle.setLifeForFrame(pet,"Enemy");
                battle.setAttackDefenseByLevels(pet_);
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

    public BattleWindows getBattle() {
        return battle.getBattle();
    }

    public void setBattle(BattleWindows battle) {
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

    private void AttackForBattle(Pet pet,Pet pet_,int n){
        Pet petMostSpeed = battle.whoAttackFirst(pet,pet_);
        if(petMostSpeed.equals(pet)) {
            battle.viewCommentAttack(pet, battle.isDamageOrShelter(battle.seeDamage(pet,n),
                     battle.seeShelter(pet, n),pet,pet_),battle.seeShelter(pet,n));
            battle.setLifeForFrame(pet_, "Enemy");
            battle.getBattle().getOpzioni()[0].setEnabled(false);
            battle.getBattle().getOpzioni()[1].setEnabled(false);
            battle.getBattle().getOpzioni()[2].setEnabled(false);
            battle.getBattle().getOpzioni()[3].setEnabled(true);
            battle.getBattle().getOpzioni()[3].setText("CONTINUA");
        }else{
               battle.turnEnemy(pet_,pet);
               battle.setLifeForFrame(pet,"My");
            }

    }
}
