package model.data.implementation;
import model.data.abstracted.LevelWindow;
import model.data.entities.*;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;
import java.util.Random;

public class LevelWindowsTwo extends LevelWindow {

   private Person mineTrainer;
   private String sex;
   private JLabel trainer0,trainer1,trainer2,trainer3,trainer4,prof;
    private static  Person trn0 = new Person(Constant.allenatore1Lotta,"Giuseppe", Levels.BASE);
    private static Person trn1 = new Person(Constant.allenatore4Lotta,"Alessandro",Levels.BASE);
    private static Person trn2 = new Person(Constant.allenatore5Lotta,"Anna",Levels.START);
    private static Person trn3 = new Person(Constant.allenatore6Lotta,"Gina",Levels.START);
    private static Person trn4 = new Person(Constant.allenatore7Lotta,"Gaetano",Levels.START);


    public LevelWindowsTwo(String filePathImage, String fileMusicPath, String fileMusicPathMessage,int width, int eight,String sex,Person mineTrainer) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        super(filePathImage, fileMusicPath, fileMusicPathMessage,width, eight);

        this.sex = sex;
        this.mineTrainer = mineTrainer;
        setPosition_x(25);
        setPosition_y(250);
        frame.setTitle("WOOFY CITY");
        frame.addKeyListener(this);
        getMyTrainer().setLocation(getPosition_x(),getPosition_y());

        if(this.sex.equalsIgnoreCase("F")) {
            getTeamFrame().getButtons()[6].setIcon(new ImageIcon(Constant.allenatoreMyAlycia));
            myTrainer.setIcon(new ImageIcon(Constant.pgFemaleUp2));
        }else{
            myTrainer.setIcon(new ImageIcon(Constant.pgMaleUp2));
        }

        addPetAtTeam(trn0,new Pet(ConstantPet.axel));
        addPetAtTeam(trn0,new Pet(ConstantPet.tex));
        addPetAtTeam(trn1,new Pet(ConstantPet.iron));
        addPetAtTeam(trn2,new Pet(ConstantPet.vito));
        addPetAtTeamWithoutLevel(trn2,new Pet(ConstantPet.mia),Levels.BASE);
        addPetAtTeam(trn3,new Pet(ConstantPet.pepita));
        addPetAtTeam(trn3,new Pet(ConstantPet.vito));
        addPetAtTeamWithoutLevel(trn4,new Pet(ConstantPet.tex),Levels.BASE);
        addPetAtTeam(trn4,new Pet(ConstantPet.mia));
        addPetAtTeam(trn4,new Pet(ConstantPet.woody));

        trainer0 = new JLabel(new ImageIcon(Constant.allenatore1));
        trainer0.setSize(40,57);
        trainer0.setLocation(750,270);

        trainer1 = new JLabel(new ImageIcon(Constant.allenatore4));
        trainer1.setSize(40,57);
        trainer1.setLocation(565,35);

        trainer2 = new JLabel(new ImageIcon(Constant.allenatore5));
        trainer2.setSize(40,57);
        trainer2.setLocation(530,190);

        trainer3 = new JLabel(new ImageIcon(Constant.allenatore6));
        trainer3.setSize(40,57);
        trainer3.setLocation(875,515);

        trainer4 = new JLabel(new ImageIcon(Constant.allenatore7));
        trainer4.setSize(40,57);
        trainer4.setLocation(430,490);

        prof = new JLabel(new ImageIcon(Constant.prof));
        prof.setSize(40,57);
        prof.setLocation(400,175);

        frame.add(prof);
        frame.add(trainer0);
        frame.add(trainer1);
        frame.add(trainer2);
        frame.add(trainer3);
        frame.add(trainer4);
        frame.add(sfondo);

    }
    @Override
    public void keyTyped(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            //DO NOTHING
        }
    }
    @Override
    public void keyPressed(KeyEvent e) {
        try {
            SetTalkinWithProf(400,210);

            SetTalkingPosition(840,110,"Mara:" + "\n" +
                    "Vincendo potrai salire di livello ed i tuoi Pet impareranno cosi' attacchi sempre" + "\n" +
                    " più potenti!Inoltre le loro caratteristiche(vita,potenza,difesa,velocità)miglioreranno!");

            SetTalkingPosition(530,280,"Franco:" + "\n" +
                    "Ehilà!Lo sai che puoi vedere la tua squadra premendo la barra spaziatrice,vero?" + "\n" +
                    "Puoi anche vedere quali Leader hai battuto e quali ti mancano ancora premendo invece il tasto 'L'!");

            SetTalkingPosition(305,465,"Giulia:" + "\n" +
                    "Io non sono un'allenatrice!Ho provato ma non sono affatto brava nelle lotte!" + "\n" +
                    "Però posso darti un consiglio!Sai come salvare i tuoi progressi?" + "\n" +
                    "Semplice!Basta premere il tasto 'S'!!");

            SetFightPosition(580,185,trn2,"Sono qui per battere il Leader,tu?","Se incroci lo sguardo di un altro trainer,parte la lotta!");
            SetFightPosition(565,85,trn1,"Lo sai che puoi sfidare un altro trainer più di una volta?Almeno finchè non si stanca!","Devo far riposare i miei Pet,scusami.");
            SetFightPosition(750,315,trn0,"Ci siamo già incontrati nella First Road!Ora ho allenato i miei Pet,vedrai!","No,vabbè.Lasciami in pace,devo meditare su come diventare forte.");
            SetFightPosition(875,550,trn3,"Sono un talento naturale nelle lotte!Sei ancora in tempo per tornare sui tuoi passi.","Il talento qua è solo il tuo,mi sà!");
            SetFightPosition(430,530,trn4,"Eccomi,sono il Leader di Woofy City!I miei Pet di tipo Dog faranno a pezzi i tupi.Preparati alla sconfitta!!!","Prosegui verso la Second Road,te lo meriti!." + "\n" +
                    "Hai già parlato con la prof.ssa Alice?Avrà una sorpresa per te!La trovi nei pressi del vortice di cambio zona!");
            updateTeamShow(mineTrainer);

        } catch (UnsupportedAudioFileException | LineUnavailableException | IOException | InterruptedException ex) {
            throw new RuntimeException(ex);
        }
        if(e.getKeyCode() == KeyEvent.VK_LEFT) {
            position_x -= 5;
            switch (getSex()) {
                case "M":
                    if (position_x % 2 == 0) {
                        super.myTrainer.setIcon(new ImageIcon(Constant.pgMaleSx2));
                    } else {
                        super.myTrainer.setIcon(new ImageIcon(Constant.pgMaleSx1));
                    }
                    break;
                case "F":
                    if (position_x % 2 == 0) {
                        super.myTrainer.setIcon(new ImageIcon(Constant.pgFemaleSx1));
                    } else {
                        super.myTrainer.setIcon(new ImageIcon(Constant.pgFemaleSx2));
                    }
                    break;
            }
            super.myTrainer.setLocation(position_x, position_y);
        }
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            position_y -= 5;
            switch (getSex()) {
                case "M":
                    if (position_y % 2 == 0) {
                        super.myTrainer.setIcon(new ImageIcon(Constant.pgMaleUp1));
                    } else {
                        super.myTrainer.setIcon(new ImageIcon(Constant.pgMaleUp2));
                    }
                    break;
                case "F":
                    if (position_y % 2 == 0) {
                        super.myTrainer.setIcon(new ImageIcon(Constant.pgFemaleUp1));
                    } else {
                        super.myTrainer.setIcon(new ImageIcon(Constant.pgFemaleUp2));
                    }
                    break;
            }
            super.myTrainer.setLocation(position_x, position_y);
        }

        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            position_y += 5;
            switch (getSex()) {
                case "M":
                    if (position_y % 2 == 0) {
                        super.myTrainer.setIcon(new ImageIcon(Constant.pgMaleDown2));
                    } else {
                        super.myTrainer.setIcon(new ImageIcon(Constant.pgMaleDown1));
                    }
                    break;
                case "F":
                    if (position_y % 2 == 0) {
                        super.myTrainer.setIcon(new ImageIcon(Constant.pgFemaleDown1));
                    } else {
                        super.myTrainer.setIcon(new ImageIcon(Constant.pgFemaleDown2));
                    }
                    break;
            }
            super.myTrainer.setLocation(position_x, position_y);
        }

        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            position_x += 5;
            switch (getSex()) {
                case "M":
                    if (position_x % 2 == 0) {
                        super.myTrainer.setIcon(new ImageIcon(Constant.pgMaleDx1));
                    } else {
                        super.myTrainer.setIcon(new ImageIcon(Constant.pgMaleDx2));
                    }
                    break;
                case "F":
                    if (position_x % 2 == 0) {
                        super.myTrainer.setIcon(new ImageIcon(Constant.pgFemaleDx1));
                    } else {
                        super.myTrainer.setIcon(new ImageIcon(Constant.pgFemaleDx2));
                    }
                    break;
            }
            super.myTrainer.setLocation(position_x, position_y);
        }

        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            super.getTeamFrame().getFrame().setVisible(true);
        }

        if (e.getKeyCode() == KeyEvent.VK_L) {
            super.getLeader().getFrame().setVisible(true);
        }

        if(endGame.isVisible() && position_x==400 && position_y==20){
            frame.dispose();
            music.stop();
            try {
                new LevelWindowThree(Constant.sfondoRoute2, Constant.musicaRoute2, Constant.messaggio,1000, 333,getSex(), mineTrainer);
            } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
    @Override
    public void SetFightPosition(int posX, int posY, Person trainer, String comment1, String comment2) throws UnsupportedAudioFileException, LineUnavailableException, IOException, InterruptedException {

        if (getMyTrainer().getX() == posX && getMyTrainer().getY() == posY) {

            if (!trainer.getName().equalsIgnoreCase("gaetano") && getMyTrainer().getX()
                    == posX && getMyTrainer().getY() == posY && trainer.getNumberOfLosses() < 2) {

                super.musicMessage.start();
                JOptionPane.showMessageDialog(null, trainer.getName() + ":" + "\n" + comment1);
                battle = new ServiceForBattle(mineTrainer, trainer, new BattleWindow(Constant.sfondoLotta1, Constant.musicalotta));
                updateTeamShow(mineTrainer);

            }else if(trainer.getName().equalsIgnoreCase("gaetano") && getMyTrainer().getX()
                    == posX && getMyTrainer().getY() == posY && trainer.getNumberOfLosses() < 1) {

                super.musicMessage.start();
                JOptionPane.showMessageDialog(null, trainer.getName() + ":" + "\n" + comment1);
                battle = new ServiceForBattle(mineTrainer, trainer, new BattleWindow(Constant.sfondoLotta1, Constant.musicalotta1));
                updateTeamShow(mineTrainer);

            }

            battle.getBattle().getFrame().addWindowListener(new WindowListener() {
                @Override
                public void windowOpened(WindowEvent e) {
                    music.stop();
                }

                @Override
                public void windowClosing(WindowEvent e) {

                }

                @Override
                public void windowClosed(WindowEvent e) {
                    music.loop(3);
                    if (trainer.getName().equalsIgnoreCase("gaetano") && trainer.getNumberOfLosses() == 1) {
                        getEndGame().setVisible(true);
                        getEndGame().setLocation(400, 20);
                        getLeader().getTextAreas()[0].setFont(new Font("Serif", Font.BOLD, 20));
                        getLeader().getTextAreas()[0].setText("SCONFITTO");
                    }
                }

                @Override
                public void windowIconified(WindowEvent e) {
                    //DO NOTHING
                }

                @Override
                public void windowDeiconified(WindowEvent e) {
                    //DO NOTHING
                }

                @Override
                public void windowActivated(WindowEvent e) {
                    //DO NOTHING
                }

                @Override
                public void windowDeactivated(WindowEvent e) {
                    //DO NOTHING
                }
            });

        } else if (getMyTrainer().getX() == posX && getMyTrainer().getY() == posY && trainer.getNumberOfLosses() >= 2) {

            JOptionPane.showMessageDialog(null, trainer.getName() + ":" + "\n" + comment2);
        }
    }

    private void SetTalkinWithProf(int posX,int posY){

        if(getPosition_x() == posX && getPosition_y() == posY && mineTrainer.getVictory() >= 8
                && mineTrainer.getPetList().size() == 1){
            JOptionPane.showMessageDialog(null,
            "Complimenti!Hai raggiunto tante vittorie.Tuttavia la strada si farà sempre più ardua man mano che" + "\n" +
            "avanzerai!Ecco perchè sono qui!Ogni volta che raggiungerai un tot numero di vittorie vieni da me " + "\n" +
            "ti consegnerò personalmente un Pet che verrà aggiunto al tuo Team!Ecco tieni!.Trattalo con cura "  + "\n" +
            "vedrai che ti sarà di grande aiuto!See you soon!");
            Random random = new Random();
            int nRandom = random.nextInt(3);
            if(getSex().equalsIgnoreCase("M")){
                switch (nRandom){
                    case 0:
                        mineTrainer.addPet(1,new Pet(ConstantPet.mia));
                        break;
                    case 1:
                        mineTrainer.addPet(1,new Pet(ConstantPet.pepita));
                        break;
                    case 2:
                        mineTrainer.addPet(1,new Pet(ConstantPet.tom));
                        break;
                }
            }
            switch (nRandom){
                case 0:
                    mineTrainer.addPet(1,new Pet(ConstantPet.pulce));
                    break;
                case 1:
                    mineTrainer.addPet(1,new Pet(ConstantPet.bianca));
                    break;
                case 2:
                    mineTrainer.addPet(1,new Pet(ConstantPet.jerry));
                    break;
            }
            JOptionPane.showMessageDialog(null, mineTrainer.getPetList().get(1).getName() + " E' STATO AGGIUNTO AL TUO TEAM!");
        }
        else if(getPosition_x() == posX && getPosition_y() == posY && mineTrainer.getVictory() < 8){

            JOptionPane.showMessageDialog(null,
            "Sono la prof.ssa Alice!Torna da me quando avrai raggiunto OTTO vittorie!");

        }
        else if(getPosition_x() == posX && getPosition_y() == posY && mineTrainer.getVictory() >= 8
                && mineTrainer.getPetList().size() > 1){
            JOptionPane.showMessageDialog(null,
                    "Divertiti con il tuo nuovo Pet!Ci vediamo in giro nelle prossime città!");
        }
    }
    @Override
    public void SetTalkingPosition(int posX, int posY, String comment) {

        if(getPosition_x() == posX && getPosition_y() == posY ){
            JOptionPane.showMessageDialog(null,comment);
        }

    }
    public String getSex() {
        return sex;
    }
}
