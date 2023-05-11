package model.data.entities;
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

    public Pet(Pet pet){
        this.name = pet.getName();
        this.type = pet.getType();
        this.attackSet = pet.getAttackSet();
        this.levels = pet.getLevels();
        this.filePathImage = pet.getFilePathImage();
        this.life = pet.getLife();
        this.defense = pet.getDefense();
        this.speed = pet.getSpeed();
        this.power = pet.getPower();
        this.isDead = pet.isDead();
    }

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
    public void restoreNumOfAvb(int[] array){
        for(int i=0; i < getAttackSet().size(); i ++){
            getAttackSet().get(i).setNumOfAvailabilityRestore(array[i]);
        }
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

    public void setDead(boolean dead) {
        isDead = dead;
    }

    public void setPower(int power) {
        this.power += power;
    }

    public void removeDefense(int defense){
        this.defense -= defense;
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

    public Type getType() {
        return type;
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
    public void removePower(int power){
        this.power -= power;
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

    public void setLevels(Levels levels) {
        this.levels = levels;
    }

    @Override
    public String toString() {
        return name;
    }

    public String toStringMy() {
        return "Pet{" +
                "name='" + name + '\'' +
                ", type=" + type +
                ", attackSet=" + attackSet +
                ", life=" + life +
                ", power=" + power +
                ", defense=" + defense +
                ", speed=" + speed +
                ", levels=" + levels +
                ", isDead=" + isDead +
                ", filePathImage='" + filePathImage + '\'' +
                '}';

    }

}
