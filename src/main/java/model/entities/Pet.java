package model.entities;
import java.util.ArrayList;
import java.util.List;

public class Pet {
    private String name;
    private Type type;
    private List<Attack> attackSet= new ArrayList<>();
    private int life,power,defense,speed;
    private Levels levels;
    private boolean isDead;

    public Pet(String name, Type type, int life, int power, int defense, int speed, Levels levels) {
        this.name = name;
        this.type = type;
        this.life = life;
        this.power = power;
        this.defense = defense;
        this.speed = speed;
        this.levels = levels;
        this.isDead=false;

        switch(this.getType()){
            case BIRD:
               attackSet.add(Attack.beccata);
               attackSet.add(Attack.volo);
               attackSet.add(Attack.alaProtettrice);
               break;
            case CAT:
               attackSet.add(Attack.graffio);
               attackSet.add(Attack.sfuriate);
               attackSet.add(Attack.Arruffarsi);
               break;
            case DOG:
               attackSet.add(Attack.gelodenti);
               attackSet.add(Attack.morso);
               attackSet.add(Attack.colpoCoda);
               break;
            case RABBIT:
                attackSet.add(Attack.rosicchiamento);
                attackSet.add(Attack.posizioneDiDifesa);
                attackSet.add(Attack.fossa);
                break;
            case TURTLE:
                attackSet.add(Attack.sgusciata);
                attackSet.add(Attack.reparo);
                attackSet.add(Attack.colpoDiGuscio);
                break;
        }
    }

    public void setAttack(Attack attack){
        attackSet.add(attack);
    }

    public void removeAttack(Attack attack){
        attackSet.remove(attack);
    }

    public String getName() {
        return name;
    }

    public boolean isDead() {
        if(getLife()<0){
            return true;
        }
        return isDead;
    }

    public void setDead(boolean dead) {
        isDead = dead;
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

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life -= life;
    }

    public int getPower() {
        return power;
    }

    public void setPower() {
        switch(this.getLevels()){
            case BASE : this.power += 10;
                break;
            case START: this.power = this.power + 5;
                break;
            case MEDIUM: this.power = this.power + 15;
                break;
            case GREAT: this.power = this.power + 20;
                break;
            case ADVANCE: this.power = this.power + 25;
                break;
            case PERFECT: this.power = this.power + 30;
        }
    }

    public int getDefense() {
       return defense;
    }
    public int maxDefense(int shelter){
        this.defense += shelter;
        return this.defense;
    }
    public void setDefense() {
        switch(this.getLevels()){
            case BASE : this.defense = this.getDefense() + 10;
                break;
            case START: this.defense = this.getDefense() + 5;
                break;
            case MEDIUM: this.defense = this.getDefense() + 15;
                break;
            case GREAT: this.defense = this.getDefense() + 20;
                break;
            case ADVANCE: this.defense = this.getDefense() + 25;
                break;
            case PERFECT: this.defense = this.getDefense() + 30;
        }
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed() {
        switch(this.getLevels()){
            case BASE : this.speed = this.speed + 10;
                break;
            case START: this.speed = this.speed + 5;
                break;
            case MEDIUM: this.speed = this.speed + 15;
                break;
            case GREAT: this.speed = this.speed + 20;
                break;
            case ADVANCE: this.speed = this.speed + 25;
                break;
            case PERFECT: this.speed = this.speed + 30;
                break;
        }
    }

    public Levels getLevels() {
        return levels;
    }

    public String viewLevels(){
        return "Level:" + " " + this.getLevels().toString();
    }

    public void setLevels(Levels levels) {
        this.levels = levels;
    }

    @Override
    public String toString() {
        return name;
    }


}
