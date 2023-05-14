package model.data.implementation;
import model.data.abstracted.Battle;
import model.data.entities.Attack;
import model.data.entities.BattleWindow;
import model.data.entities.Levels;
import model.data.entities.Pet;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.io.IOException;
import java.util.Random;
public class BattleJFrame implements Battle {
    private BattleWindow battle;
    private int lifeRemoved, lifeRemovedEnemy, powerUp, powerUpEnemy,defeseUp,defeseUpEnemy;

    public BattleJFrame(BattleWindow battle) {

        this.battle = battle;
    }

    @Override
    public void viewCommentAttack(Pet pet, int damage, int shelter, String attackName) throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        gif(pet, attackName);
        pet.getAttackSet().stream().filter(d -> d.getName().equalsIgnoreCase(attackName))
                .findAny().get().setNumOfAvailability(1);
        if (damage > 1 && shelter > 0) {
            battle.getTx().setText(pet.getName() + " " + "usa" + attackName + "!!!");
            if (damage > 1 && damage < 50) {
                battle.getTx().append(pet.getName() + " " + "infligge un buon danno!" + "\n");
                battle.getTx().append(pet.getName() + " " + "inoltre" + " " + "aumenta" + "\n");
                battle.getTx().append("la sua difesa di " + " " + shelter + " " + "punti difensivi!");
            } else if (damage > 50 && damage < 100) {
                battle.getTx().append(pet.getName() + " " + "infligge un ottimo danno!" + "\n");
                battle.getTx().append(pet.getName() + " " + "inoltre" + " " + "aumenta" + "\n");
                battle.getTx().append("la sua difesa di " + " " + shelter + " " + "punti difensivi!");
            } else {
                battle.getTx().append(pet.getName() + " " + "infligge un danno importante!" + "\n");
                battle.getTx().append(pet.getName() + " " + "inoltre" + " " + "aumenta" + "\n");
                battle.getTx().append("la sua difesa di " + " " + shelter + " " + "punti difensivi!");
            }
        } else if (damage > 0 && shelter == 0) {
            battle.getTx().setText(pet.getName() + " " + "usa" + attackName + "!!!");
            if (damage < 25) {
                battle.getTx().append("\n" + pet.getName() + "Infligge poco danno" + "\n"
                        + "Il pet nemico si protegge bene!");
            } else if (damage < 25) {
                battle.getTx().append("\n" + pet.getName() + "Infligge un buon danno!");
            } else if (damage > 25 && damage < 50) {
                battle.getTx().append("\n" + pet.getName() + "Infligge un discreto danno!");
            } else {
                battle.getTx().append("\n" + pet.getName() + "Infligge un danno importante!" + "\n"
                        + "Il pet nemico subisce in modo grave l'attacco!");
            }
        } else if (damage == 0 && shelter > 0) {
            battle.getTx().setText(pet.getName() + " " + "usa" + attackName + "!!!");
            battle.getTx().append(pet.getName() + " " + "aumenta" + "\n");
            battle.getTx().append("la sua difesa di " + " " + shelter + " " + "punti difensivi!" + "\n"
                    + "e si prepara per l'attacco nemico!!!");
        } else {
            battle.getTx().setText(pet.getName() + " " + "usa" + attackName + "!!!");
            battle.getTx().append(pet.getName() + " " + "aumenta" + "\n");
            battle.getTx().append("la sua potenza" + "\n"
                    + "e si prepara ad attaccare!!!");
        }
    }

    private void gif(Pet pet, String name) throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        battle.getGifFrame().getFrame().setVisible(true);
        switch (pet.getType()) {
            case BIRD:
                switch (name.toLowerCase()) {
                    case "beccata":
                        setGifFrame("images/Gif/beccata.gif", "images/AudioAttack/beccata.wav");
                        break;
                    case "volo":
                        setGifFrame("images/Gif/volo.gif", "images/AudioAttack/beccata.wav");
                        break;
                    case "alaprotettrice":
                        setGifFrame("images/Gif/alaprotettrice.gif", "images/AudioAttack/alaprotettrice.wav");
                        break;
                    case "alata":
                        setGifFrame("images/Gif/alata.gif", "images/AudioAttack/alata.wav");
                        break;
                    case "raffica":
                        setGifFrame("images/Gif/raffica.gif", "images/AudioAttack/raffica.wav");
                        break;
                    case "alataprotettrice":
                        setGifFrame("images/Gif/alataprotettrice.gif", "images/AudioAttack/alaprotettrice.wav");
                        break;
                    case "perforbecco":
                        setGifFrame("images/Gif/perforbecco.gif", "images/AudioAttack/perforbecco.wav");
                        break;
                    case "doppiaalata":
                        setGifFrame("images/Gif/doppiaalata.gif", "images/AudioAttack/doppiaalata.wav");
                        break;
                    case "grido di lotta":
                        setGifFrame("images/Gif/raffica.gif", "images/AudioAttack/perforbecco.wav");
                        break;
                    case "nessunapietà":
                        setGifFrame("images/Gif/alata.gif", "images/AudioAttack/doppiaalata.wav");
                        break;
                }
                break;
            case DOG:
                switch (name.toLowerCase()) {
                    case "morso":
                        setGifFrame("images/Gif/morso.gif", "images/AudioAttack/morso.wav");
                        break;
                    case "colpocoda":
                        setGifFrame("images/Gif/colpocoda.gif", "images/AudioAttack/colpocoda.wav");
                        break;
                    case "morsoaffamato":
                        setGifFrame("images/Gif/gelodenti.gif", "images/AudioAttack/morso.wav");
                        break;
                    case "supermorso":
                        setGifFrame("images/Gif/supermorso.gif", "images/AudioAttack/supermorso.wav");
                        break;
                    case "ipermorso":
                        setGifFrame("images/Gif/ipermorso.gif", "images/AudioAttack/supermorso.wav");
                        break;
                    case "slanciofurente":
                        setGifFrame("images/Gif/elettrodenti.gif", "images/AudioAttack/elettrodenti.wav");
                        break;
                    case "colpo coda vigoroso":
                        setGifFrame("images/Gif/colpocodavigoroso.gif", "images/AudioAttack/colpocoda.wav");
                        break;
                    case "artigliaffilati":
                        setGifFrame("images/Gif/elettrogelodenti.gif", "images/AudioAttack/elettrodenti.wav");
                        break;
                    case "grido di lotta":
                        setGifFrame("images/Gif/gridodilottadog.gif", "images/AudioAttack/colpocoda.wav");
                        break;
                    case "nessunapietà":
                        setGifFrame("images/Gif/nomercidog.gif", "images/AudioAttack/morso.wav");
                        break;
                }
                break;
            case CAT:
                switch (name.toLowerCase()) {
                    case "graffio":
                        setGifFrame("images/Gif/graffio.gif", "images/AudioAttack/graffio.wav");
                        break;
                    case "mantoprotettivo":
                        setGifFrame("images/Gif/arruffarsi.gif", "images/AudioAttack/arruffarsi.wav");
                        break;
                    case "sfuriate":
                        setGifFrame("images/Gif/sfuriate.gif", "images/AudioAttack/graffio.wav");
                        break;
                    case "zampata":
                        setGifFrame("images/Gif/zampata.gif", "images/AudioAttack/arruffarsi.wav");
                        break;
                    case "lacerazione":
                        setGifFrame("images/Gif/lacerazione.gif", "images/AudioAttack/lacerazione.wav");
                        break;
                    case "artiglioguardiano":
                        setGifFrame("images/Gif/arruffarsigraffiando.gif", "images/AudioAttack/lacerazione.wav");
                        break;
                    case "palla di pelo":
                        setGifFrame("images/Gif/palladipelo.gif", "images/AudioAttack/palladipelo.wav");
                        break;
                    case "graffiofelino":
                        setGifFrame("images/Gif/rogodenti.gif", "images/AudioAttack/rogodenti.wav");
                        break;
                    case "grido di lotta":
                        setGifFrame("images/Gif/sfuriate.gif", "images/AudioAttack/lacerazione.wav");
                        break;
                    case "nessunapietà":
                        setGifFrame("images/Gif/zampata.gif", "images/AudioAttack/graffio.wav");
                        break;
                }
                break;
            case RABBIT:
                switch (name.toLowerCase()) {
                    case "rosicchiamento":
                        setGifFrame("images/Gif/rosicchiamento.gif", "images/AudioAttack/morso.wav");
                        break;
                    case "posizione di difesa":
                        setGifFrame("images/Gif/posizionedidifesa.gif", "images/AudioAttack/posizionedidifesa.wav");
                        break;
                    case "fossa":
                        setGifFrame("images/Gif/fossa.gif", "images/AudioAttack/fossa.wav");
                        break;
                    case "doppiograffio":
                        setGifFrame("images/Gif/doppiograffio.gif", "images/AudioAttack/graffio.wav");
                        break;
                    case "sgranocchio":
                        setGifFrame("images/Gif/sgranocchio.gif", "images/AudioAttack/ipersgranocchio.wav");
                        break;
                    case "corsaspietata":
                        setGifFrame("images/Gif/corsaspietata.gif", "images/AudioAttack/posizionedidifesa.wav");
                        break;
                    case "carotaesplosiva":
                        setGifFrame("images/Gif/triplograffio.gif", "images/AudioAttack/graffio.wav");
                        break;
                    case "morsosaltellante":
                        setGifFrame("images/Gif/ipersgranocchio.gif", "images/AudioAttack/ipersgranocchio.wav");
                        break;
                    case "grido di lotta":
                        setGifFrame("images/Gif/corsaspietata.gif", "images/AudioAttack/posizionedidifesa.wav");
                        break;
                    case "nessunapietà":
                        setGifFrame("images/Gif/doppiograffio.gif", "images/AudioAttack/ipersgranocchio.wav");
                        break;
                }
                break;
            case TURTLE:
                switch (name.toLowerCase()) {
                    case "sgusciata":
                        setGifFrame("images/Gif/sgusciata.gif", "images/AudioAttack/sgusciata.wav");
                        break;
                    case "reparo":
                        setGifFrame("images/Gif/reparo.gif", "images/AudioAttack/posizionedidifesa.wav");
                        break;
                    case "colpo di guscio":
                        setGifFrame("images/Gif/colpodiguscio.gif", "images/AudioAttack/corsaspietata.wav");
                        break;
                    case "rotolamento":
                        setGifFrame("images/Gif/rotolamento.gif", "images/AudioAttack/sgusciata.wav");
                        break;
                    case "morsolentissimo":
                        setGifFrame("images/Gif/doppiorotolamento.gif", "images/AudioAttack/palladipelo.wav");
                        break;
                    case "protezionesolida":
                        setGifFrame("images/Gif/sgusciatareparo.gif", "images/AudioAttack/sgusciata.wav");
                        break;
                    case "testataresistente":
                        setGifFrame("images/Gif/doppiocolpodiguscio.gif", "images/AudioAttack/corsaspietata.wav");
                        break;
                    case "carica da fortino":
                        setGifFrame("images/Gif/triplorotolamento.gif", "images/AudioAttack/posizionedidifesa.wav");
                        break;
                    case "grido di lotta":
                        setGifFrame("images/Gif/rotolamento.gif", "images/AudioAttack/palladipelo.wav");
                        break;
                    case "nessunapietà":
                        setGifFrame("images/Gif/doppiocolpodiguscio.gif", "images/AudioAttack/sgusciata.wav");
                        break;
                }
                break;

        }
        new java.util.Timer().schedule(
                new java.util.TimerTask() {
                    public void run() {
                        battle.getGifFrame().getFrame().setVisible(false);
                    }
                },
                3000
        );
    }

    private void setGifFrame(String fileImagePath, String fileMusicPath) throws UnsupportedAudioFileException, IOException, LineUnavailableException {

        battle.getGifFrame().getSfondo().setIcon(new ImageIcon(fileImagePath));
        battle.getGifFrame().createMusicforFrame(fileMusicPath);

    }

    public int isDamageOrShelter(int damage, int shelter, int poweUp, Pet pet, Pet petEnemy, String TrainerControl) {
        if (damage > 0) {
            int finalDamage = (damage + pet.getPower()) - petEnemy.getDefense();

            if (finalDamage > 1) {
                petEnemy.setLife(finalDamage);
                switch (TrainerControl.toLowerCase()) {
                    case "enemy":
                        lifeRemoved += finalDamage;
                        break;
                    case "my":
                        lifeRemovedEnemy += finalDamage;
                        break;
                }
                return finalDamage;
            } else {
                finalDamage = 1;
                petEnemy.setLife(finalDamage);
                switch (TrainerControl.toLowerCase()) {
                    case "enemy":
                        lifeRemoved += finalDamage;
                        break;
                    case "my":
                        lifeRemovedEnemy += finalDamage;
                        break;
                }
                return finalDamage;
            }

        } else if (shelter > 0) {
            pet.setDefense(shelter);
            switch (TrainerControl.toLowerCase()) {
                case "enemy":
                    defeseUpEnemy += shelter;
                    break;
                case "my":
                    defeseUp += shelter;
                    break;
            }
            return 0;
        }else {
            pet.setPower(poweUp);
            switch (TrainerControl.toLowerCase()) {
                case "enemy":
                    powerUpEnemy += poweUp;
                    break;
                case "my":
                    powerUp += poweUp;
                    break;
            }
        }
        return 0;
    }
    @Override
    public Pet whoAttackFirst(Pet pet_att, Pet pet_def) {
        if(pet_att.getSpeed() > pet_def.getSpeed()){
            return pet_att;
        }else{
            return pet_def;
        }
    }
    @Override
    public String viewLifeRemain(Pet pet) {
        String view = pet.getName() + " " +  pet.getLife();
        return view;
    }
    @Override
    public void turnEnemy(Pet pet, Pet pet_) throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        Random random = new Random();
        int n = random.nextInt(4);
        boolean done = true;
        String choose="";
        while(done) {
            switch (n) {
                case 0:
                    choose = pet.getAttackSet().get(0).getName();
                    break;
                case 1:
                    choose = pet.getAttackSet().get(1).getName();
                    break;
                case 2:
                    choose = pet.getAttackSet().get(2).getName();
                    break;
                case 3:
                    choose = pet.getAttackSet().get(3).getName();
                    break;
            }
            String finalChoose = choose;
            if (numOfAvailabilityIsFinish(pet.getAttackSet().stream().filter(e -> e.getName().equalsIgnoreCase(finalChoose)).findAny().get()) == false) {
                viewCommentAttack(pet, isDamageOrShelter(seeDamage(pet,finalChoose), seeShelter(pet, finalChoose),seePowerUp(pet,choose), pet, pet_,"enemy"), seeShelter(pet,finalChoose) , finalChoose);
                done = false;
            }else{
                n = random.nextInt(4);
            }
        }
    }

    @Override
    public boolean isDead(Pet pet) {
        if(pet.getLife() < 0) {
            return true;
        }
        return false;
    }
    @Override
    public boolean numOfAvailabilityIsFinish(Attack attack) {
        if(attack.getNumOfAvailability() == 0){
            return true;
        }
        return false;
    }
    @Override
    public void addNewAttack(Pet pet, Attack attack) {

        battle.getOpzioni()[4].setText("NO");
        battle.getOpzioni()[4].setEnabled(true);
        JOptionPane.showMessageDialog(null, "Il tuo Pet può imparare un nuovo attacco!");
        battle.getTx().setText(attack.getName() + ":" +
                "possibile danno inflitto->" + attack.getDamage() + ",possibile " +
                "aumento difensivo->" + attack.getShelter() + "\n");
        if(attack.getPowerUp()>0){
            battle.getTx().append("possibili aumento di potenza->" + attack.getPowerUp());
        }
        battle.getTx().append(". Clicca su un attacco tra quelli presenti per rimuoverlo e far" + "\n"
                + "spazio a quello nuovo.Clicca NO per mantenere quelli già presenti.");
        pet.getAttackSet().add(attack);
    }

    @Override
    public Attack newAttackByType(Pet pet) {
        Levels levels = pet.getLevels();
        switch(pet.getType()){
            case CAT:
                switch (levels){
                    case START:return Attack.zampata;
                    case MEDIUM:return Attack.lacerazione;
                    case ADVANCE:return Attack.artiglioGuardiano;
                    case GREAT:return Attack.pallaDiPelo;
                    case PERFECT:return Attack.graffioFelino;
                }
                break;
                case BIRD: switch (levels){
                    case START:return Attack.alata;
                    case MEDIUM:return Attack.raffica;
                    case ADVANCE:return Attack.alataProtettrice;
                    case GREAT:return Attack.perforbecco;
                    case PERFECT:return Attack.doppiaAlata;
                }
                break;
                case DOG:
                    switch (levels){
                        case START: return Attack.supermorso;
                        case MEDIUM:return Attack.slancioFurente;
                        case ADVANCE:return Attack.colpoCodaVigoroso;
                        case GREAT: return Attack.ipermorso;
                        case PERFECT:return Attack.artigliAffilati;
                    }
                    break;
                case RABBIT:
                    switch (levels){
                        case START:return Attack.doppioGraffio;
                        case MEDIUM:return Attack.sgranocchio;
                        case ADVANCE:return Attack.corsaSpietata;
                        case GREAT:return Attack.carotaEsplosiva;
                        case PERFECT:return Attack.morsoSaltellante;
                    }
                    break;
                case TURTLE:
                    switch (levels){
                        case START:return Attack.rotolamento;
                        case MEDIUM:return Attack.morsoLentissimo;
                        case ADVANCE:return Attack.protezioneSolida;
                        case GREAT:return Attack.testataResistente;
                        case PERFECT:return Attack.caricaDaFortino;
                    }
                    break;
            }
          return null;
        }

    public void setLifeForFrame(Pet pet,String trainer){
        if(trainer.equalsIgnoreCase("Enemy")){
            battle.getNamePetEnemy().setText(pet.getName().toUpperCase());
            battle.getLifeEnemy().setText("LIFE->" + pet.getLife());
            battle.getLevelEnemy().setText(pet.getLevels().toString());
        }else{
            battle.getNamePet().setText(pet.getName().toUpperCase());
            battle.getLife().setText("LIFE->" + pet.getLife());
            battle.getLevel().setText(pet.getLevels().toString());
        }
    }
    private int seeDamage(Pet pet,String choose){
        int damage = pet.getAttackSet().stream().filter(d -> d.getName().equalsIgnoreCase(choose)).findAny().get().getDamage();
        return damage;
    }
    private int seeShelter(Pet pet,String choose){
        int shelter = pet.getAttackSet().stream().filter(d -> d.getName().equalsIgnoreCase(choose)).findAny().get().getShelter();
        return shelter;
    }

    public int seePowerUp(Pet pet,String choose){
      int powerUp = pet.getAttackSet().stream().filter(d -> d.getName().equalsIgnoreCase(choose)).findAny().get().getPowerUp();
      return powerUp;
    }

    public int seePowerUp(Pet pet,int index){
        int powerUp = pet.getAttackSet().get(index).getPowerUp();
        return powerUp;
    }
    public int seeDamage(Pet pet,int index){
        int damage = pet.getAttackSet().get(index).getDamage();
        return damage;
    }

    public int seeShelter(Pet pet,int index){
        int shelter = pet.getAttackSet().get(index).getShelter();
        return shelter;
    }

    public BattleWindow getBattle() {
        return battle;
    }

    public void setBattle(BattleWindow battle) {
        this.battle = battle;
    }

    public int getLifeRemoved() {
        return lifeRemoved;
    }

    public int getLifeRemovedEnemy() {
        return lifeRemovedEnemy;
    }

    public void setLifeRemoved(int lifeRemoved) {
        this.lifeRemoved = lifeRemoved;
    }

    public void setLifeRemovedEnemy(int lifeRemovedEnemy) {
        this.lifeRemovedEnemy = lifeRemovedEnemy;
    }

    public int getPowerUp() {
        return powerUp;
    }

    public void setPowerUp(int powerUp) {
        this.powerUp = powerUp;
    }

    public int getPowerUpEnemy() {
        return powerUpEnemy;
    }

    public void setPowerUpEnemy(int powerUpEnemy) {
        this.powerUpEnemy = powerUpEnemy;
    }

    public int getDefeseUp() {
        return defeseUp;
    }

    public void setDefeseUp(int defeseUp) {
        this.defeseUp = defeseUp;
    }

    public int getDefeseUpEnemy() {
        return defeseUpEnemy;
    }

    public void setDefeseUpEnemy(int defeseUpEnemy) {
        this.defeseUpEnemy = defeseUpEnemy;
    }

    @Override
    public String toString() {
        return "BattleJFrame{" +
                "lifeRemoved=" + lifeRemoved +
                ", lifeRemovedEnemy=" + lifeRemovedEnemy +
                ", powerUp=" + powerUp +
                ", powerUpEnemy=" + powerUpEnemy +
                '}';
    }
}
