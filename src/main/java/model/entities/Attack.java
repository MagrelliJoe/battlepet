package model.entities;

public class Attack {
    private String name;
    private int damage;
    private String description;
    private int numOfAvailability;
    private int shelter;

    public Attack(String name, int damage,int shelter, String description,int numOfAvailability) {
        this.name = name;
        this.damage = damage;
        this.description = description;
        this.shelter = shelter;
        this.numOfAvailability = numOfAvailability;
    }

    public int getNumOfAvailability() {
        return numOfAvailability;
    }

    public void setNumOfAvailability(int numOfAvailability) {
        this.numOfAvailability -= numOfAvailability;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getShelter() {
        return shelter;
    }

    public void setShelter(int shelter) {
        this.shelter = shelter;
    }

    public static Attack beccata = new Attack("Beccata",10,0,"Attacco diretto",4);
    static Attack volo = new Attack("Volo",15,0,"Attacco diretto",4);
    static Attack alata = new Attack("Alata",20,0,"Attacco diretto",3);
    static Attack morso = new Attack("Morso",10,0,"Attacco diretto",10);
    static Attack ipermorso = new Attack("IperMorso",20,0,"Attacco diretto",3);
    static Attack gelodenti = new Attack("GeloDenti",15,0,"Attacco diretto",5);
    static Attack graffio = new Attack("Graffio",10,0,"Attacco diretto",10);
    static Attack sfuriate = new Attack("Sfuriate",20,0,"Attacco diretto",3);
    static Attack zampata = new Attack("Zampata",15,0,"Attacco diretto",5);
    static Attack alaProtettrice = new Attack("Ala Protettrice",0,5,"Il pet si protegge con la sua ala",4);
    static Attack colpoCoda = new Attack("ColpoCoda",0,5,"Il pet si protegge con la sua coda",5);
    static Attack Arruffarsi = new Attack("Arruffarsi",0,5,"Il pet si protegge arruffando il pelo",5);
}