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

public class LevelWindowThree extends LevelWindow {
    private String sex;
    private JLabel trainer1,trainer2,trainer3;
    private Person mineTrainer;
    private static  Person trn0 = new Person(Constant.allenatore6Lotta,"Gina", Levels.START);
    private static Person trn1 = new Person(Constant.allenatore8Lotta,"Saro",Levels.START);
    private static Person trn2 = new Person(Constant.allenatore9Lotta,"Rino",Levels.START);
    public LevelWindowThree(String filePathImage, String fileMusicPath, String fileMusicPathMessage, int width, int eight,String sex, Person mineTrainer) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        super(filePathImage, fileMusicPath, fileMusicPathMessage, width, eight);
        this.mineTrainer = mineTrainer;
        this.sex = sex;
        setPosition_x(135);
        setPosition_y(20);
        frame.setTitle("ON THE 2ND ROAD");
        frame.addKeyListener(this);
        getMyTrainer().setLocation(getPosition_x(),getPosition_y());

        if(this.sex.equalsIgnoreCase("F")) {
            getTeamFrame().getButtons()[6].setIcon(new ImageIcon("images/AlyciaChoose.jpg"));
            myTrainer.setIcon(new ImageIcon("images/MyTrainer/pg_f_up_left.jpg"));
        }else{
            myTrainer.setIcon(new ImageIcon("images/MyTrainer/pg_up_left.jpg"));
        }

        addPetAtTeam(trn0,new Pet(ConstantPet.pepita));
        addPetAtTeam(trn0,new Pet(ConstantPet.vito));
        addPetAtTeam(trn0,new Pet(ConstantPet.black));
        addPetAtTeam(trn1,new Pet(ConstantPet.mewcat));
        addPetAtTeam(trn1,new Pet(ConstantPet.leo));
        addPetAtTeam(trn2,new Pet(ConstantPet.mia));
        addPetAtTeam(trn2,new Pet(ConstantPet.gomitolo));

        trainer3 = new JLabel(new ImageIcon(Constant.allenatore9));
        trainer3.setSize(40,57);
        trainer3.setLocation(655,15);

        trainer1 = new JLabel(new ImageIcon(Constant.allenatore6));
        trainer1.setSize(40,57);
        trainer1.setLocation(415,5);

        trainer2 = new JLabel(new ImageIcon(Constant.allenatore8));
        trainer2.setSize(40,57);
        trainer2.setLocation(925,25);

        frame.add(trainer1);
        frame.add(trainer2);
        frame.add(trainer3);
        frame.add(sfondo);
    }

    @Override
    public void SetFightPosition(int posX, int posY, Person trainer, String comment, String comment2) throws UnsupportedAudioFileException, LineUnavailableException, IOException, InterruptedException {

        if(trainer.getName().equalsIgnoreCase("rino") && trainer.getNumberOfLosses() == 1){
            getEndGame().setVisible(true);
            getEndGame().setLocation(790,-10);
        }

        if (getMyTrainer().getX()==posX && getMyTrainer().getY()==posY && trainer.getNumberOfLosses() < 2) {
            super.musicMessage.start();
            JOptionPane.showMessageDialog(null, trainer.getName() + ":" + "\n" + comment);
            battle = new ServiceForBattle(mineTrainer, trainer, new BattleWindow(Constant.sfondoLotta1, Constant.musicalotta2));
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
                    music.loop(3);
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
        }else if(getMyTrainer().getX()==posX && getMyTrainer().getY()==posY && trainer.getNumberOfLosses() >= 2){
            JOptionPane.showMessageDialog(null, trainer.getName() + ":" + "\n" + comment2);
        }

    }

    @Override
    public void SetTalkingPosition(int posX, int posY, String comment) {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

        try {
            SetFightPosition(415,45,trn0,"Anche tu qui?Ho aggiunto un Pet al mio Team!Lottiamo!","Forse prima di sfidarti di nuovo dovrei aggiungerne ancora...");
            SetFightPosition(660,50,trn1,"Voglio battere Renato,il Leader della città qui vicino!","Sei forte!Pensi di riuscire a batterlo???");
            SetFightPosition(930,60,trn2,"Anche tu hai sconfitto Gaetano di WoofyCity?Bene!Allora sarà una bella lotta,dai!!!","Ora vai,puoi battere anche il Leader di MeowMeowCity!!!");
            updateTeamShow(mineTrainer);
        } catch (UnsupportedAudioFileException | LineUnavailableException | IOException | InterruptedException ex) {
            throw new RuntimeException(ex);
        }
        if(e.getKeyCode() == KeyEvent.VK_LEFT) {
            position_x -= 5;
            System.out.println(getPosition_x());
            System.out.println(getPosition_y());
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
            System.out.println(getPosition_x());
            System.out.println(getPosition_y());
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
            System.out.println(getPosition_x());
            System.out.println(getPosition_y());
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
            System.out.println(getPosition_x());
            System.out.println(getPosition_y());
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

        if (e.getKeyCode() == KeyEvent.VK_L) {
            super.getLeader().getFrame().setVisible(true);
        }

        if(endGame.isVisible() && position_x==790 && position_y==-10){
            frame.dispose();
            music.stop();
            try {
                new LevelWindowFour(Constant.sfondoMeowCity, Constant.musicaMeowCity, Constant.messaggio,1000, 700,getSex(), mineTrainer);
            } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
                throw new RuntimeException(ex);
            }

        }

    }
    @Override
    public void keyReleased(KeyEvent e) {

    }
    public String getSex() {
        return sex;
    }

}
