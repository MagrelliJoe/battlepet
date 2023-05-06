package model.data.implementation;

import model.data.abstracted.LevelWindow;
import model.data.entities.*;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;

public class LevelWindowsTwo extends LevelWindow {

   private Person mineTrainer;
   private String sex;
   private JLabel trainer0,trainer1,trainer2,trainer3,trainer4;
    private static  Person trn0 = new Person(Constant.allenatore1Lotta,"Joseph", Levels.BASE);
    private static Person trn1 = new Person(Constant.allenatore4Lotta,"Saro",Levels.BASE);
    private static Person trn2 = new Person(Constant.allenatore5Lotta,"Greta",Levels.START);
    private static Person trn3 = new Person(Constant.allenatore6Lotta,"Gina",Levels.START);
    private static Person trn4 = new Person(Constant.allenatore7Lotta,"Giuseppe",Levels.START);


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
            getTeamFrame().getButtons()[6].setIcon(new ImageIcon("images/AlyciaChoose.jpg"));
            myTrainer.setIcon(new ImageIcon("images/MyTrainer/pg_f_up_left.jpg"));
        }else{
            myTrainer.setIcon(new ImageIcon("images/MyTrainer/pg_up_left.jpg"));
        }

        addPetAtTeam(trn0,new Pet(ConstantPet.axel));
        addPetAtTeam(trn0,new Pet(ConstantPet.tex));
        addPetAtTeam(trn1,new Pet(ConstantPet.tex));
        addPetAtTeam(trn2,new Pet(ConstantPet.vito));
        addPetAtTeam(trn2,new Pet(ConstantPet.iron));
        addPetAtTeam(trn2,new Pet(ConstantPet.pepita));
        addPetAtTeam(trn3,new Pet(ConstantPet.pepita));
        addPetAtTeam(trn3,new Pet(ConstantPet.axel));
        addPetAtTeam(trn4,new Pet(ConstantPet.iron));
        addPetAtTeam(trn4,new Pet(ConstantPet.pepita));
        addPetAtTeam(trn4,new Pet(ConstantPet.iron));

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
            SetFightPosition(580,185,trn2,"Sono qui per battere il Leader,tu?","Se incroci lo sguardo di un altro trainer,parte la lotta!",9,5);
            SetFightPosition(565,85,trn1,"Lo sai che puoi sfidare un altro trainer più di una volta?Almeno finchè non si stanca!","Devo far riposare i miei Pet,scusami.",7,4);
            SetFightPosition(750,315,trn0,"Ci siamo già incontrati nella first road!Ora ho allenato i miei Pet,vedrai!","No,vabbè.Lasciami in pace,devo meditare su come diventare forte.",5,3);
            SetFightPosition(875,550,trn3,"Sono un talento naturale nelle lotte!Sei ancora in tempo per tornare suu tuoi passi.","Il talento qua è solo il tuo,mi sà!",11,6);
            SetFightPosition(430,530,trn4,"Eccomi,sono il Leader di Woofy City!I miei Pet di tipo Dog faranno a pezzi i tupi.Preparati alla sconfitta!!!","Prosegui verso la Second Road,te lo meriti!.",12,7);
            updateTeamShow(mineTrainer);
        } catch (UnsupportedAudioFileException | LineUnavailableException | IOException | InterruptedException ex) {
            throw new RuntimeException(ex);
        }
        if(e.getKeyCode() == KeyEvent.VK_LEFT) {
            position_x -= 5;
            switch (getSex()) {
                case "M":
                    if (position_x % 2 == 0) {
                        super.myTrainer.setIcon(new ImageIcon("images/MyTrainer/pg_right_2.jpg"));
                    } else {
                        super.myTrainer.setIcon(new ImageIcon("images/MyTrainer/pg_right_1.jpg"));
                    }
                    break;
                case "F":
                    if (position_x % 2 == 0) {
                        super.myTrainer.setIcon(new ImageIcon("images/MyTrainer/pg_f_right_2.jpg"));
                    } else {
                        super.myTrainer.setIcon(new ImageIcon("images/MyTrainer/pg_f_right_1.jpg"));
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
                        super.myTrainer.setIcon(new ImageIcon("images/MyTrainer/pg_up_left.jpg"));
                    } else {
                        super.myTrainer.setIcon(new ImageIcon("images/MyTrainer/pg_up_right.jpg"));
                    }
                    break;
                case "F":
                    if (position_y % 2 == 0) {
                        super.myTrainer.setIcon(new ImageIcon("images/MyTrainer/pg_f_up_left.jpg"));
                    } else {
                        super.myTrainer.setIcon(new ImageIcon("images/MyTrainer/pg_f_up_right.jpg"));
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
                        super.myTrainer.setIcon(new ImageIcon("images/MyTrainer/pg_down_left.jpg"));
                    } else {
                        super.myTrainer.setIcon(new ImageIcon("images/MyTrainer/pg_down_right.jpg"));
                    }
                    break;
                case "F":
                    if (position_y % 2 == 0) {
                        super.myTrainer.setIcon(new ImageIcon("images/MyTrainer/pg_f_down_left.jpg"));
                    } else {
                        super.myTrainer.setIcon(new ImageIcon("images/MyTrainer/pg_f_down_right.jpg"));
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
                        super.myTrainer.setIcon(new ImageIcon("images/MyTrainer/pg_left_2.jpg"));
                    } else {
                        super.myTrainer.setIcon(new ImageIcon("images/MyTrainer/pg_left_1.png"));
                    }
                    break;
                case "F":
                    if (position_x % 2 == 0) {
                        super.myTrainer.setIcon(new ImageIcon("images/MyTrainer/pg_f_left_2.jpg"));
                    } else {
                        super.myTrainer.setIcon(new ImageIcon("images/MyTrainer/pg_f_left_1.jpg"));
                    }
                    break;
            }
            super.myTrainer.setLocation(position_x, position_y);
        }

        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            super.getTeamFrame().getFrame().setVisible(true);
        }
        if(endGame.isVisible() && position_x==120 && position_y==100){
            frame.dispose();
            music.stop();
            try {
                LevelWindow levelWindow =  new LevelWindowsTwo(Constant.sfondoInit, Constant.musica1, Constant.messaggio,1000, 333,getSex(), mineTrainer);
            } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
    @Override
    public void SetFightPosition(int posX, int posY, Person trainer, String comment1, String comment2, int numMax,int numMIn) throws UnsupportedAudioFileException, LineUnavailableException, IOException, InterruptedException {

        if(mineTrainer.getVictory() >= 10){
            getEndGame().setVisible(true);
            getEndGame().setLocation(400,20);
        }

        if (getMyTrainer().getX()==posX && getMyTrainer().getY()==posY && mineTrainer.getVictory() <= numMax
                && mineTrainer.getVictory() >= numMIn) {
            super.musicMessage.start();
            JOptionPane.showMessageDialog(null, trainer.getName() + ":" + "\n" + comment1);
            battle = new ServiceForBattle(mineTrainer, trainer, new BattleWindow(Constant.sfondoLotta1, Constant.musicalotta1));

            updateTeamShow(trainer);

            battle.getBattle().getFrame().addWindowListener(new WindowListener() {
                @Override
                public void windowOpened(WindowEvent e) {
                    music.stop();
                }
                @Override
                public void windowClosing(WindowEvent e) {}
                @Override
                public void windowClosed(WindowEvent e) {
                    music.start();
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
        }else if(getMyTrainer().getX()==posX && getMyTrainer().getY()==posY && mineTrainer.getVictory() > numMax){
            JOptionPane.showMessageDialog(null, trainer.getName() + ":" + "\n" + comment2);
        }else if(getMyTrainer().getX()==posX && getMyTrainer().getY()==posY && mineTrainer.getVictory() < numMIn){
            JOptionPane.showMessageDialog(null, trainer.getName() + ":" + "\n" + "Non sei alla mia altezza,allenati e ritorna da me!");
        }
    }

    public Person getMineTrainer() {
        return mineTrainer;
    }

    public String getSex() {
        return sex;
    }
}
