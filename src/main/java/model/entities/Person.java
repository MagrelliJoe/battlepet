package model.entities;
import java.util.HashMap;
import java.util.Map;

public class Person {
    private String name;
    Map<Integer,Pet> petList = new HashMap<>();
    int victory;
    Levels levels;

    public Person(String name,Levels levels) {
        this.name = name;
        this.levels = levels;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<Integer, Pet> getPetList() {
        return petList;
    }

    public void addPet(Integer key ,Pet pet) {
        this.petList.put(key,pet);
    }

    public int getVictory() {
        return victory;
    }

    public void setVictory(int victory) {
        this.victory += victory;
    }

    public Levels getLevels() {
       switch(this.getVictory()){
           case 5 : this.setLevels(Levels.START);
           break;
           case 15 : this.setLevels(Levels.BASE);
           break;
           case 25 : this.setLevels(Levels.MEDIUM);
           break;
           case 35 : this.setLevels(Levels.GREAT);
           break;
           case 50 : this.setLevels(Levels.ADVANCE);
           break;
           case 70 : this.setLevels(Levels.PERFECT);

       }
        return levels;
    }

    public void setLevels(Levels levels) {
        this.levels = levels;
    }

}
