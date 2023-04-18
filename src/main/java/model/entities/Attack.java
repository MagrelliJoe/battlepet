package model.entities;

public class Attack {
    private String name;
    private int damage;
    private String description;
    private int numOfAvailability;
    private int shelter;
    private Levels levels;

    public Attack(String name, int damage,int shelter, String description,int numOfAvailability,Levels levels) {
        this.name = name;
        this.damage = damage;
        this.description = description;
        this.shelter = shelter;
        this.numOfAvailability = numOfAvailability;
        this.levels = levels;

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

    //attacchi di tipo BIRD
    public static Attack beccata = new Attack("Beccata",10,0,"Attacco diretto",25,Levels.BASE);
    public static Attack alaProtettrice = new Attack("AlaProtettrice",0,10,"Il pet si protegge",25,Levels.BASE);
    public static Attack volo = new Attack("Volo",15,0,"Attacco diretto",20,Levels.BASE);
    public static Attack alata = new Attack("Alata",20,0,"Attacco diretto",18,Levels.START);
    public static Attack raffica = new Attack("Raffica",30,0,"Attacco diretto",15,Levels.MEDIUM);
    public static Attack alataProtettrice = new Attack("AlataProtettrice",35,30,"Attacco diretto con difesa",10,Levels.ADVANCE);
    public static Attack perforbecco = new Attack("Perforbecco",40,0,"Attacco diretto",10,Levels.GREAT);
    public static Attack doppiaAlata = new Attack("DoppiaAlata",80,0,"Attacco diretto",5,Levels.PERFECT);
    //attacchi di tipo DOG
    public static Attack morso = new Attack("Morso",10,0,"Attacco diretto",25,Levels.BASE);
    public static Attack colpoCoda = new Attack("ColpoCoda",0,10,"Il pet si protegge",25,Levels.BASE);
    public static Attack gelodenti = new Attack("GeloDenti",15,0,"Attacco diretto",20,Levels.BASE);
    public static Attack supermorso = new Attack("SuperMorso",20,0,"Attacco diretto",18,Levels.START);
    public static Attack elettrodenti = new Attack("ElettroDenti",25,0,"Attacco diretto",15,Levels.MEDIUM);
    public static Attack colpoCodaVigoroso = new Attack("Colpo Coda Vigoroso",30,30,"Attacco diretto con difesa",10,Levels.ADVANCE);
    public static Attack ipermorso = new Attack("IperMorso",40,0,"Attacco diretto",10,Levels.GREAT);
    public static Attack elettroGeloDenti = new Attack("ElettroGeloDenti",90,0,"Attacco diretto",5,Levels.PERFECT);
    //attacchi di tipo CAT
    public static Attack graffio = new Attack("Graffio",30,0,"Attacco diretto",25,Levels.BASE);
    public static Attack Arruffarsi = new Attack("Arruffarsi",0,5,"Il pet si protegge",15,Levels.BASE);
    public static Attack sfuriate = new Attack("Sfuriate",30,0,"Attacco diretto",25,Levels.BASE);
    public static Attack zampata = new Attack("Zampata",33,0,"Attacco diretto",20,Levels.START);
    public static Attack lacerazione = new Attack("Lacerazione",35,0,"Attacco diretto",15,Levels.MEDIUM);
    public static Attack arruffarsiGraffiando = new Attack("Arruffamento Dannoso",35,20,"Attacco diretto con difesa",10,Levels.ADVANCE);
    public static Attack pallaDiPelo = new Attack("Palla di Pelo",40,0,"Attacco diretto",10,Levels.GREAT);
    public static Attack rogodenti = new Attack("Rogodenti",100,0,"Attacco diretto",5,Levels.PERFECT);
    //attacchi di tipo RABBIT
    public static Attack rosicchiamento = new Attack("Rosicchiamento",15,0,"Attacco diretto",25,Levels.BASE);
    public static Attack posizioneDiDifesa  = new Attack("Posizione di Difesa",0,15,"Il pet si protegge",15,Levels.BASE);
    public static Attack fossa = new Attack("Fossa",25,0,"Attacco diretto",25,Levels.BASE);
    public static Attack doppioGraffio = new Attack("Doppio Graffio",30,0,"Attacco diretto",20,Levels.START);
    public static Attack sgranocchio = new Attack("Sgranocchio",35,0,"Attacco diretto",15,Levels.MEDIUM);
    public static Attack corsaSpietata = new Attack("Corsa Spietata",35,30,"Attacco diretto con difesa",10,Levels.ADVANCE);
    public static Attack triploGraffio = new Attack("Triplo Graffio",40,0,"Attacco diretto",10,Levels.GREAT);
    public static Attack iperSgranocchio = new Attack("IperSgranocchio",90,0,"Attacco diretto",5,Levels.PERFECT);
    //attacchi di tipo TURTLE
    public static Attack sgusciata = new Attack("Sgusciata",40,0,"Attacco diretto",25,Levels.BASE);
    public static Attack reparo = new Attack("Reparo",0,30,"Il pet si protegge",15,Levels.BASE);
    public static Attack colpoDiGuscio = new Attack("Colpo di Guscio",40,0,"Attacco diretto",25,Levels.BASE);
    public static Attack rotolamento = new Attack("Rotolamento",41,0,"Attacco diretto",20,Levels.START);
    public static Attack doppioRotolamento = new Attack("Doppio Rotolamento",42,0,"Attacco diretto",15,Levels.MEDIUM);
    public static Attack sgusciataReparo = new Attack("Sgusciata & Reparo",43,31,"Attacco diretto con difesa",10,Levels.ADVANCE);
    public static Attack doppioColpoDiGuscio = new Attack("Doppio Colpo di Guscio",50,0,"Attacco diretto",10,Levels.GREAT);
    public static Attack triploRotolamento = new Attack("Triplo Rotolamento",80,0,"Attacco diretto",5,Levels.PERFECT);
    //attacchi generici per tutti i tipi
    public static Attack gridoDiLotta = new Attack("Grido di Lotta",0,50,"Il Pet aumenta la sua difesa",10,Levels.ADVANCE);
    public static Attack protego = new Attack("Protego",0,80,"Il pet si protegge in modo esponenziale",5,Levels.PERFECT);

}