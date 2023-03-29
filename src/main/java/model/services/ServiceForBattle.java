package model.services;
import model.data.implementation.BattleJFrame;
import model.entities.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class ServiceForBattle implements ActionListener {
    private BattleJFrame repositoryBattle;

    private BattleWindows battle;
    private Random random;
    private Person trainer1,trainer2;

    public ServiceForBattle(BattleJFrame repositoryBattle, Person trainer1, Person trainer2) {
        this.random = new Random();
        this.repositoryBattle = repositoryBattle;
        this.trainer1 = trainer1;
        this.trainer2 = trainer2;
        this.battle = repositoryBattle.getBattle();
        battle.createBattleWindows();
        setAttacktoChoose(trainer1.getPetList().get(0));
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        boolean done = true;
        int numOfMyPet = 0;
        int numOfPetEnemy = 0;
        Levels actuallyLevel = trainer1.getLevels();
        Pet pet = trainer1.getPetList().get(numOfMyPet);
        Pet pet_ = trainer2.getPetList().get(numOfPetEnemy);
        repositoryBattle.setAttackDefenseByLevels(pet);
        repositoryBattle.setAttackDefenseByLevels(pet_);
        if("option3".equals(e.getActionCommand())){
            if(repositoryBattle.getBattle().getOpzioni()[3].getText().
                    equalsIgnoreCase("START FIGHT")){
                repositoryBattle.setLifeForFrame(pet,"My");
                repositoryBattle.getBattle().getOpzioni()[0].setEnabled(true);
                repositoryBattle.getBattle().getOpzioni()[1].setEnabled(true);
                repositoryBattle.getBattle().getOpzioni()[2].setEnabled(true);
                repositoryBattle.setLifeForFrame(pet_,"Enemy");
                battle.getOpzioni()[3].setEnabled(false);
            }else{
                repositoryBattle.turnEnemy(pet_,pet);
                repositoryBattle.setLifeForFrame(pet,"My");
                battle.getOpzioni()[3].setEnabled(false);
                repositoryBattle.getBattle().getOpzioni()[0].setEnabled(true);
                repositoryBattle.getBattle().getOpzioni()[1].setEnabled(true);
                repositoryBattle.getBattle().getOpzioni()[2].setEnabled(true);
            }
        }
        if("option0".equals(e.getActionCommand())){
            Pet petMostSpeed = repositoryBattle.whoAttackFirst(pet,pet_);
            if(petMostSpeed.equals(pet)){
                repositoryBattle.isDamageOrShelter(repositoryBattle.seeDamage(pet,0),
                        repositoryBattle.seeDamage(pet,0),pet,pet_);
                repositoryBattle.viewCommentAttack(pet,repositoryBattle.seeDamage(pet,0)
                        ,repositoryBattle.seeDamage(pet,0));
                repositoryBattle.setLifeForFrame(pet_,"Enemy");
                repositoryBattle.getBattle().getOpzioni()[0].setEnabled(false);
                repositoryBattle.getBattle().getOpzioni()[1].setEnabled(false);
                repositoryBattle.getBattle().getOpzioni()[2].setEnabled(false);
                repositoryBattle.getBattle().getOpzioni()[3].setEnabled(true);
                repositoryBattle.getBattle().getOpzioni()[3].setText("CONTINUA");
            }else{
                repositoryBattle.turnEnemy(pet_,pet);
                repositoryBattle.setLifeForFrame(pet,"My");
            }
        }
    }
    private void setAttacktoChoose(Pet pet){
        for(int i=0; i<4; i++) {
            if(i==3){
                battle.getOpzioni()[i].addActionListener(this);
                battle.getOpzioni()[i].setActionCommand("option"+i);
            }else{
                battle.getOpzioni()[i].addActionListener(this);
                battle.getOpzioni()[i].setActionCommand("option"+i);
                battle.getOpzioni()[i].setText(pet.getAttackSet().get(i).getName());
            }
        }
    }

    public BattleWindows getBattle() {
        return battle;
    }

    public void setBattle(BattleWindows battle) {
        this.battle = battle;
    }

    public BattleJFrame getRepositoryBattle() {
        return repositoryBattle;
    }

    public void setRepositoryBattle(BattleJFrame repositoryBattle) {
        this.repositoryBattle = repositoryBattle;
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
