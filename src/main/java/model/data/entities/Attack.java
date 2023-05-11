package model.data.entities;

public class Attack {
    private int powerUp;
    private String name;
    private int damage;
    private String description;
    private int numOfAvailability;
    private int shelter;
    private Levels levels;

    public Attack(Attack attack) {
        this.powerUp = attack.getPowerUp();
        this.name = attack.getName();
        this.damage = attack.getDamage();
        this.description = attack.getDescription();
        this.numOfAvailability = attack.getNumOfAvailability();
        this.shelter = attack.getShelter();
        this.levels = attack.getLevels();
    }

    public Attack(String name, int damage, int shelter, String description, int numOfAvailability, Levels levels, int powerUp) {
        this.name = name;
        this.damage = damage;
        this.description = description;
        this.shelter = shelter;
        this.numOfAvailability = numOfAvailability;
        this.levels = levels;
        this.powerUp = powerUp;

    }

    public Levels getLevels() {
        return levels;
    }

    public void setLevels(Levels levels) {
        this.levels = levels;
    }

    public int getNumOfAvailability() {
        return numOfAvailability;
    }

    public void setNumOfAvailability(int numOfAvailability) {
        this.numOfAvailability -= numOfAvailability;
    }

    public void setNumOfAvailabilityRestore(int numOfAvailability){
        this.numOfAvailability = numOfAvailability;
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

    public int getPowerUp() {
        return powerUp;
    }

    public void setPowerUp(int powerUp) {
        this.powerUp = powerUp;
    }

    @Override
    public String toString() {
        return name;
    }

    //attacchi di tipo BIRD
    public static Attack beccata = new Attack("Beccata",20,0,"Attacco diretto",25,Levels.BASE,0);
    public static Attack alaProtettrice = new Attack("AlaProtettrice",0,5,"Il pet si protegge",25,Levels.BASE,0);
    public static Attack volo = new Attack("Volo",30,0,"Attacco diretto",20,Levels.BASE,0);
    public static Attack alata = new Attack("Alata",40,5,"Attacco diretto",18,Levels.START,0);
    public static Attack raffica = new Attack("Raffica",55,0,"Attacco diretto",15,Levels.MEDIUM,0);
    public static Attack alataProtettrice = new Attack("AlataProtettrice",55,10,"Attacco diretto con difesa",10,Levels.ADVANCE,0);
    public static Attack perforbecco = new Attack("Perforbecco",75,0,"Attacco diretto",10,Levels.GREAT,0);
    public static Attack doppiaAlata = new Attack("DoppiaAlata",95,10,"Attacco diretto",5,Levels.PERFECT,0);
    //attacchi di tipo DOG
    public static Attack morso = new Attack("Morso",25,0,"Attacco diretto",25,Levels.BASE,0);
    public static Attack colpoCoda = new Attack("ColpoCoda",0,2,"Il pet si protegge",25,Levels.BASE,0);
    public static Attack gelodenti = new Attack("GeloDenti",35,2,"Attacco diretto",20,Levels.BASE,0);
    public static Attack supermorso = new Attack("SuperMorso",45,0,"Attacco diretto",18,Levels.START,0);
    public static Attack elettrodenti = new Attack("ElettroDenti",60,0,"Attacco diretto",15,Levels.MEDIUM,0);
    public static Attack colpoCodaVigoroso = new Attack("Colpo Coda Vigoroso",60,5,"Attacco diretto con difesa",10,Levels.ADVANCE,0);
    public static Attack ipermorso = new Attack("IperMorso",85,0,"Attacco diretto",10,Levels.GREAT,0);
    public static Attack elettroGeloDenti = new Attack("ElettroGeloDenti",105,5,"Attacco diretto",5,Levels.PERFECT,0);
    //attacchi di tipo CAT
    public static Attack graffio = new Attack("Graffio",20,0,"Attacco diretto",25,Levels.BASE,0);
    public static Attack Arruffarsi = new Attack("Arruffarsi",0,5,"Il pet si protegge",15,Levels.BASE,0);
    public static Attack sfuriate = new Attack("Sfuriate",30,0,"Attacco diretto",25,Levels.BASE,0);
    public static Attack zampata = new Attack("Zampata",40,5,"Attacco diretto",20,Levels.START,0);
    public static Attack lacerazione = new Attack("Lacerazione",55,0,"Attacco diretto",15,Levels.MEDIUM,0);
    public static Attack arruffarsiGraffiando = new Attack("ArruffarsiGraffiando",50,10,"Attacco diretto con difesa",10,Levels.ADVANCE,0);
    public static Attack pallaDiPelo = new Attack("Palla di Pelo",75,0,"Attacco diretto",10,Levels.GREAT,0);
    public static Attack rogodenti = new Attack("Rogodenti",95,10,"Attacco diretto",5,Levels.PERFECT,0);
    //attacchi di tipo RABBIT
    public static Attack rosicchiamento = new Attack("Rosicchiamento",20,0,"Attacco diretto",25,Levels.BASE,0);
    public static Attack posizioneDiDifesa  = new Attack("Posizione di Difesa",0,5,"Il pet si protegge",15,Levels.BASE,0);
    public static Attack fossa = new Attack("Fossa",30,0,"Attacco diretto",25,Levels.BASE,0);
    public static Attack doppioGraffio = new Attack("Doppio Graffio",40,5,"Attacco diretto",20,Levels.START,0);
    public static Attack sgranocchio = new Attack("Sgranocchio",55,0,"Attacco diretto",15,Levels.MEDIUM,0);
    public static Attack corsaSpietata = new Attack("Corsa Spietata",55,10,"Attacco diretto con difesa",10,Levels.ADVANCE,0);
    public static Attack triploGraffio = new Attack("Triplo Graffio",75,0,"Attacco diretto",10,Levels.GREAT,0);
    public static Attack iperSgranocchio = new Attack("IperSgranocchio",95,10,"Attacco diretto",5,Levels.PERFECT,0);
    //attacchi di tipo TURTLE
    public static Attack sgusciata = new Attack("Sgusciata",20,0,"Attacco diretto",25,Levels.BASE,0);
    public static Attack reparo = new Attack("Reparo",0,5,"Il pet si protegge",15,Levels.BASE,0);
    public static Attack colpoDiGuscio = new Attack("Colpo di Guscio",30,0,"Attacco diretto",25,Levels.BASE,0);
    public static Attack rotolamento = new Attack("Rotolamento",40,5,"Attacco diretto",20,Levels.START,0);
    public static Attack doppioRotolamento = new Attack("Doppio Rotolamento",55,0,"Attacco diretto",15,Levels.MEDIUM,0);
    public static Attack sgusciataReparo = new Attack("SgusciataReparo",55,10,"Attacco diretto con difesa",10,Levels.ADVANCE,0);
    public static Attack doppioColpoDiGuscio = new Attack("Doppio Colpo di Guscio",75,0,"Attacco diretto",10,Levels.GREAT,0);
    public static Attack triploRotolamento = new Attack("Triplo Rotolamento",95,10,"Attacco diretto",5,Levels.PERFECT,0);
    //attacchi generici per tutti i tipi
    public static Attack gridoDiLotta = new Attack("Grido di Lotta",0,0,"Il Pet aumenta la sua potenza!",5,Levels.BASE,5);
    public static Attack noMerci = new Attack("Nessuna Pietà",90,0,"Il Pet aumenta la sua potenza in modo esponenziale!Inoltre infligge un danno grave!",3,Levels.GREAT,10);
    public static Attack noMerciDog = new Attack("Nessuna Pietà",100,0,"Il Pet aumenta la sua potenza in modo esponenziale!Inoltre infligge un danno grave!",3,Levels.GREAT,13);
    public static Attack gridoDiLottaDog = new Attack("Grido di Lotta",0,0,"Il Pet aumenta la sua potenza!",5,Levels.BASE,8);

}