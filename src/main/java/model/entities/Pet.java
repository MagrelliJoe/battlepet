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
    private String filePathImage;

    public Pet(String filePathImage,String name, Type type, int life, int power, int defense, int speed, Levels levels) {
        this.name = name;
        this.type = type;
        this.life = life;
        this.power = power;
        this.defense = defense;
        this.speed = speed;
        this.levels = levels;
        this.isDead=false;
        this.filePathImage = filePathImage;

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
        if(getLife()<=0){
            return true;
        }
        return isDead;
    }

    public void setAttackSet(List<Attack> attackSet) {
        this.attackSet = attackSet;
    }

    public void setPower(int power) {
        this.power += power;
    }

    public void setDefense(int defense) {
        this.defense += defense;
    }

    public void setSpeed(int speed) {
        this.speed += speed;
    }

    public String getFilePathImage() {
        return filePathImage;
    }

    public void setFilePathImage(String filePathImage) {
        this.filePathImage = filePathImage;
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
    public void setLifeForLevel(int life) {
        this.life += life;
    }

    public int getPower() {
        return power;
    }
    public int getDefense() {
       return defense;
    }

    public int getSpeed() {
        return speed;
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
