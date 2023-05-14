package model.data.entities;
import java.util.HashMap;
import java.util.Map;

public class Person {
    private String name;
    private Map<Integer,Pet> petList = new HashMap<>();
    private int victory;
    private Levels levels;
    private String filePathImage;
    private int numberOfLosses = 0;

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

    private void addAttacktoPet(Attack attack){
        new Attack(attack);
    }

    public void addPet(Integer key ,Pet pet) {
        pet.setLevels(this.getLevels());
        if(pet.getAttackSet().size()==0) {
            switch (pet.getType()) {
                case BIRD:
                    pet.getAttackSet().add(Attack.beccata);
                    pet.getAttackSet().add(Attack.volo);
                    pet.getAttackSet().add(Attack.alaProtettrice);
                    pet.getAttackSet().add(new Attack(Attack.gridoDiLotta));

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
                            pet.getAttackSet().remove(3);
                            pet.getAttackSet().add(new Attack(Attack.noMerci));
                            break;
                        case PERFECT:
                            pet.getAttackSet().remove(0);
                            pet.getAttackSet().add(Attack.doppiaAlata);
                            break;
                    }
                    break;
                case CAT:
                    pet.getAttackSet().add(Attack.graffio);
                    pet.getAttackSet().add(Attack.sfuriate);
                    pet.getAttackSet().add(Attack.mantoProtettivo);
                    pet.getAttackSet().add(new Attack(Attack.gridoDiLotta));
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
                            pet.getAttackSet().remove(2);
                            pet.getAttackSet().add(Attack.artiglioGuardiano);
                            break;
                        case GREAT:
                            pet.getAttackSet().remove(3);
                            pet.getAttackSet().add(new Attack(Attack.noMerci));
                            break;
                        case PERFECT:
                            pet.getAttackSet().remove(0);
                            pet.getAttackSet().add(Attack.graffioFelino);
                            break;
                    }
                    break;
                case DOG:
                    pet.getAttackSet().add(new Attack(Attack.morsoAffamato));
                    pet.getAttackSet().add(new Attack(Attack.morso));
                    pet.getAttackSet().add(new Attack(Attack.colpoCoda));
                    pet.getAttackSet().add(new Attack(Attack.gridoDiLottaDog));

                    switch (pet.getLevels()) {
                        case START:
                            pet.getAttackSet().remove(0);
                            pet.getAttackSet().add(Attack.supermorso);
                            break;
                        case MEDIUM:
                            pet.getAttackSet().remove(1);
                            pet.getAttackSet().add(Attack.slancioFurente);
                            break;
                        case ADVANCE:
                            pet.getAttackSet().remove(2);
                            pet.getAttackSet().add(Attack.colpoCodaVigoroso);
                            break;
                        case GREAT:
                            pet.getAttackSet().remove(3);
                            pet.getAttackSet().add(new Attack(Attack.noMerciDog));
                            break;
                        case PERFECT:
                            pet.getAttackSet().remove(0);
                            pet.getAttackSet().add(Attack.artigliAffilati);
                            break;
                    }
                    break;
                case RABBIT:
                    pet.getAttackSet().add(Attack.rosicchiamento);
                    pet.getAttackSet().add(Attack.posizioneDiDifesa);
                    pet.getAttackSet().add(Attack.fossa);
                    pet.getAttackSet().add(new Attack(Attack.gridoDiLotta));
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
                            pet.getAttackSet().remove(3);
                            pet.getAttackSet().add(new Attack(Attack.carotaEsplosiva));
                            break;
                        case PERFECT:
                            pet.getAttackSet().remove(0);
                            pet.getAttackSet().add(Attack.morsoSaltellante);
                            break;
                    }
                    break;
                case TURTLE:
                    pet.getAttackSet().add(Attack.sgusciata);
                    pet.getAttackSet().add(Attack.reparo);
                    pet.getAttackSet().add(Attack.colpoDiGuscio);
                    pet.getAttackSet().add(new Attack(Attack.gridoDiLotta));
                    switch (pet.getLevels()) {
                        case START:
                            pet.getAttackSet().remove(0);
                            pet.getAttackSet().add(Attack.rotolamento);
                            break;
                        case MEDIUM:
                            pet.getAttackSet().remove(1);
                            pet.getAttackSet().add(Attack.morsoLentissimo);
                            break;
                        case ADVANCE:
                            pet.getAttackSet().remove(2);
                            pet.getAttackSet().add(Attack.protezioneSolida);
                            break;
                        case GREAT:
                            pet.getAttackSet().remove(3);
                            pet.getAttackSet().add(new Attack(Attack.testataResistente));
                            break;
                        case PERFECT:
                            pet.getAttackSet().remove(0);
                            pet.getAttackSet().add(Attack.caricaDaFortino);
                            break;
                    }
                    break;
            }
        }
        this.petList.put(key, pet);
    }

    public int getVictory() {
        return victory;
    }

    public void setVictory(int victory) {

        this.victory += victory;
    }

    public int getNumberOfLosses() {
        return numberOfLosses;
    }

    public void setNumberOfLosses(int numberOfLosses) {
        this.numberOfLosses += numberOfLosses;
    }

    public Levels getLevels() {
        return levels;
    }

    public void setLevels() {
        switch(this.getVictory()){
            case 0 : this.levels = (Levels.BASE);
                break;
            case 5 :
            case 6 :
            case 7 :
            case 8 :
            case 9 :
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
                this.levels =(Levels.START);
                break;
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
                this.levels = (Levels.MEDIUM);
                break;
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            case 45:
            case 46:
            case 47:
            case 48:
            case 49:
            case 50:
            case 51:
            case 52:
            case 53:
            case 54:
            case 55:
            case 56:
            case 57:
            case 58:
            case 59:
                this.levels = (Levels.GREAT);
                break;
            case 60:
            case 61:
            case 62:
            case 63:
            case 64:
            case 65:
            case 66:
            case 67:
            case 68:
            case 69:
            case 70:
            case 71:
            case 72:
            case 73:
            case 74:
            case 75:
            case 76:
            case 77:
            case 78:
            case 79:
                this.levels = (Levels.ADVANCE);
                break;
            case 80:
            case 81:
            case 82:
            case 83:
            case 84:
            case 85:
            case 86:
            case 87:
            case 88:
            case 89:
            case 90 :
                this.levels = (Levels.PERFECT);
                break;
        }
    }

}
