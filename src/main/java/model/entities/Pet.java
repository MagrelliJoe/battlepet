package model.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

public class Pet {
    private String name;
    private Type type;
    private List<Attack> attackSet= new ArrayList<>();
    private int life,power,defense,speed;
    private Levels levels;
    private Person person;


    public Pet(String name, Type type, int life, int power, int defense, int speed, Levels levels) {
        this.name = name;
        this.type = type;
        this.life = life;
        this.power = power;
        this.defense = defense;
        this.speed = speed;
        this.levels = levels;

        if(type == Type.BIRD){
            this.attackSet.add(Attack.ALATA);
            this.attackSet.add(Attack.BECCATA);
            this.attackSet.add(Attack.PERFORBECCO);
            this.attackSet.add(Attack.VOLO);
        }else if(type == Type.CAT){
            this.attackSet.add(Attack.SFURIATE);
            this.attackSet.add(Attack.GRAFFIO);
            this.attackSet.add(Attack.ZAMPATA);
            this.attackSet.add(Attack.COLPOCODA);
        }else{
            this.attackSet.add(Attack.GELODENTI);
            this.attackSet.add(Attack.ROGODENTI);
            this.attackSet.add(Attack.MORSO);
            this.attackSet.add(Attack.IPERMORSO);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public List<Attack> getAttackSet() {
        return attackSet;
    }

    public void setAttackSet(List<Attack> attackSet) {
        this.attackSet = attackSet;
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public int getPower() {
        switch(this.getLevels()){
            case BASE : this.power+=10;
            break;
            case START: this.power+=5;
            break;
            case MEDIUM: this.power+=15;
            break;
            case GREAT: this.power += 20;
            break;
            case ADVANCE: this.power += 25;
            break;
            case PERFECT: this.power += 30;
        }
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getDefense() {
        switch(this.getLevels()){
            case BASE : this.defense += 10;
                break;
            case START: this.defense += 5;
                break;
            case MEDIUM: this.defense += 15;
                break;
            case GREAT: this.defense += 20;
                break;
            case ADVANCE: this.defense += 25;
                break;
            case PERFECT: this.defense += 30;
        }
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getSpeed() {
        switch(this.getLevels()){
            case BASE : this.speed += 10;
                break;
            case START: this.speed += 5;
                break;
            case MEDIUM: this.speed += 15;
                break;
            case GREAT: this.speed += 20;
                break;
            case ADVANCE: this.speed += 25;
                break;
            case PERFECT: this.speed += 30;
        }
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public Levels getLevels() {
        this.setLevels(person.getLevels());
        return levels;
    }

    public void setLevels(Levels levels) {
        this.levels = levels;
    }
}
