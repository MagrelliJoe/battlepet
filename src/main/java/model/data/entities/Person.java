package model.data.entities;
import java.util.HashMap;
import java.util.Map;

public class Person {
    private String name;
    private Map<Integer,Pet> petList = new HashMap<>();
    private int victory;
    private Levels levels;
    private String filePathImage;

    public Person(String filePathImage,String name,Levels levels) {
        this.name = name;
        this.levels = levels;
        this.filePathImage = filePathImage;

    }


    public void setPetList(Map<Integer, Pet> petList) {
        this.petList = petList;
    }

    public String getFilePathImage() {
        return filePathImage;
    }

    public void setFilePathImage(String filePathImage) {
        this.filePathImage = filePathImage;
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
        pet.setLevels(this.getLevels());

            switch (pet.getType()) {
                case BIRD:
                    pet.getAttackSet().add(Attack.beccata);
                    pet.getAttackSet().add(Attack.volo);
                    pet.getAttackSet().add(Attack.alaProtettrice);

                    switch (pet.getLevels()) {
                        case START:
                            pet.getAttackSet().remove(0);
                            pet.getAttackSet().add(Attack.alata);
                            break;
                        case MEDIUM:
                            pet.getAttackSet().remove(1);
                            pet.getAttackSet().add(Attack.raffica);
                            break;
                        case ADVANCE:
                            pet.getAttackSet().remove(2);
                            pet.getAttackSet().add(Attack.alataProtettrice);
                            break;
                        case GREAT:
                            pet.getAttackSet().remove(0);
                            pet.getAttackSet().add(Attack.perforbecco);
                            break;
                        case PERFECT:
                            pet.getAttackSet().remove(1);
                            pet.getAttackSet().add(Attack.doppiaAlata);
                            break;
                    }
                    break;
                case CAT:
                    pet.getAttackSet().add(Attack.graffio);
                    pet.getAttackSet().add(Attack.sfuriate);
                    pet.getAttackSet().add(Attack.Arruffarsi);
                    switch (pet.getLevels()) {
                        case START:
                            pet.getAttackSet().remove(0);
                            pet.getAttackSet().add(Attack.zampata);
                            break;
                        case MEDIUM:
                            pet.getAttackSet().remove(1);
                            pet.getAttackSet().add(Attack.lacerazione);
                            break;
                        case ADVANCE:
                            pet.getAttackSet().remove(0);
                            pet.getAttackSet().add(Attack.arruffarsiGraffiando);
                            break;
                        case GREAT:
                            pet.getAttackSet().remove(0);
                            pet.getAttackSet().add(Attack.pallaDiPelo);
                            break;
                        case PERFECT:
                            pet.getAttackSet().remove(1);
                            pet.getAttackSet().add(Attack.rogodenti);
                            break;
                    }
                    break;
                case DOG:
                    pet.getAttackSet().add(Attack.gelodenti);
                    pet.getAttackSet().add(Attack.morso);
                    pet.getAttackSet().add(Attack.colpoCoda);
                    switch (pet.getLevels()) {
                        case START:
                            pet.getAttackSet().remove(0);
                            pet.getAttackSet().add(Attack.supermorso);
                            break;
                        case MEDIUM:
                            pet.getAttackSet().remove(1);
                            pet.getAttackSet().add(Attack.elettrodenti);
                            break;
                        case ADVANCE:
                            pet.getAttackSet().remove(2);
                            pet.getAttackSet().add(Attack.colpoCodaVigoroso);
                            break;
                        case GREAT:
                            pet.getAttackSet().remove(0);
                            pet.getAttackSet().add(Attack.ipermorso);
                            break;
                        case PERFECT:
                            pet.getAttackSet().remove(1);
                            pet.getAttackSet().add(Attack.elettroGeloDenti);
                            break;
                    }
                    break;
                case RABBIT:
                    pet.getAttackSet().add(Attack.rosicchiamento);
                    pet.getAttackSet().add(Attack.posizioneDiDifesa);
                    pet.getAttackSet().add(Attack.fossa);
                    switch (pet.getLevels()) {
                        case START:
                            pet.getAttackSet().remove(0);
                            pet.getAttackSet().add(Attack.doppioGraffio);
                            break;
                        case MEDIUM:
                            pet.getAttackSet().remove(1);
                            pet.getAttackSet().add(Attack.sgranocchio);
                            break;
                        case ADVANCE:
                            pet.getAttackSet().remove(2);
                            pet.getAttackSet().add(Attack.corsaSpietata);
                            break;
                        case GREAT:
                            pet.getAttackSet().remove(0);
                            pet.getAttackSet().add(Attack.triploGraffio);
                            break;
                        case PERFECT:
                            pet.getAttackSet().remove(1);
                            pet.getAttackSet().add(Attack.iperSgranocchio);
                            break;
                    }
                    break;
                case TURTLE:
                    pet.getAttackSet().add(Attack.sgusciata);
                    pet.getAttackSet().add(Attack.reparo);
                    pet.getAttackSet().add(Attack.colpoDiGuscio);
                    switch (pet.getLevels()) {
                        case START:
                            pet.getAttackSet().remove(0);
                            pet.getAttackSet().add(Attack.rotolamento);
                            break;
                        case MEDIUM:
                            pet.getAttackSet().remove(1);
                            pet.getAttackSet().add(Attack.doppioRotolamento);
                            break;
                        case ADVANCE:
                            pet.getAttackSet().remove(2);
                            pet.getAttackSet().add(Attack.sgusciataReparo);
                            break;
                        case GREAT:
                            pet.getAttackSet().remove(0);
                            pet.getAttackSet().add(Attack.doppioColpoDiGuscio);
                            break;
                        case PERFECT:
                            pet.getAttackSet().remove(1);
                            pet.getAttackSet().add(Attack.triploRotolamento);
                            break;
                    }
                    break;
            }
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
