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

public class LevelWindowsFive extends LevelWindow {
    private String sex;
    private JLabel trainer1,trainer2,trainer3;
    private Person mineTrainer;
    private static  Person trn0 = new Person(Constant.allenatore13Lotta,"Tony", Levels.MEDIUM);
    private static Person trn1 = new Person(Constant.allenatore14Lotta,"Steve",Levels.MEDIUM);
    private static Person trn2 = new Person(Constant.allenatore15Lotta,"Tohr",Levels.MEDIUM);
    public LevelWindowsFive(String filePathImage, String fileMusicPath, String fileMusicPathMessage, int width, int eight,String sex,Person mineTrainer) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        super(filePathImage, fileMusicPath, fileMusicPathMessage, width, eight);
        this.mineTrainer = mineTrainer;
        this.sex = sex;
        setPosition_x(920);
        setPosition_y(105);
        frame.setTitle("ON THE 3rd ROAD");
        frame.addKeyListener(this);
        getMyTrainer().setLocation(getPosition_x(),getPosition_y());

        if(this.sex.equalsIgnoreCase("F")) {
            getTeamFrame().getButtons()[6].setIcon(new ImageIcon(Constant.allenatoreMyAlycia));
            myTrainer.setIcon(new ImageIcon(Constant.pgFemaleUp2));
        }else{
            myTrainer.setIcon(new ImageIcon(Constant.pgMaleUp2));
        }

        addPetAtTeam(trn0,new Pet(ConstantPet.jerry));
        addPetAtTeam(trn0,new Pet(ConstantPet.tom));
        addPetAtTeam(trn0,new Pet(ConstantPet.briciola));
        addPetAtTeam(trn1,new Pet(ConstantPet.bianca));
        addPetAtTeam(trn1,new Pet(ConstantPet.bianchina));
        addPetAtTeam(trn2,new Pet(ConstantPet.bianca));
        addPetAtTeam(trn2,new Pet(ConstantPet.cute));

        trainer1 = new JLabel(new ImageIcon(Constant.allenatore13));
        trainer1.setSize(40,57);
        trainer1.setLocation(600,95);

        trainer2 = new JLabel(new ImageIcon(Constant.allenatore14));
        trainer2.setSize(40,57);
        trainer2.setLocation(250,215);

        trainer3 = new JLabel(new ImageIcon(Constant.allenatore15));
        trainer3.setSize(40,57);
        trainer3.setLocation(245,55);

        frame.add(trainer1);
        frame.add(trainer2);
        frame.add(trainer3);
        frame.add(sfondo);
    }

    @Override
    public void SetFightPosition(int posX, int posY, Person trainer, String comment, String comment2) throws UnsupportedAudioFileException, LineUnavailableException, IOException, InterruptedException {
        if(trainer.getName().equalsIgnoreCase("tohr") && trainer.getNumberOfLosses() == 1){
            getEndGame().setVisible(true);
            getEndGame().setLocation(145,90);
        }

        if (getMyTrainer().getX()==posX && getMyTrainer().getY()==posY && trainer.getNumberOfLosses() < 2) {
            super.musicMessage.start();
            JOptionPane.showMessageDialog(null, trainer.getName() + ":" + "\n" + comment);
            battle = new ServiceForBattle(mineTrainer, trainer, new BattleWindow(Constant.sfondoLotta1, Constant.musicalotta2));
            updateTeamShow(mineTrainer);

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
            SetFightPosition(600,130,trn0,"Sei giunto quasi a metà del tuo percorso!Ma ci sono io ora!","Basta lottare!Sei troppo forte per i miei gusti!");
            SetFightPosition(290,215,trn1,"Adoro il Leader di HairyCity!","Purtroppo non sono mai riuscito a batterlo!");
            SetFightPosition(250,95,trn2,"Hai sconfitto due Leader?Bene,allora sarà una lotta avvincente!","Ho la netta impressione che anche il prossimo Leader se la vedrà brutta con te!");
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
            System.out.println(getPosition_x());
            System.out.println(getPosition_y());
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
            System.out.println(getPosition_x());
            System.out.println(getPosition_y());
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
            System.out.println(getPosition_x());
            System.out.println(getPosition_y());
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

        if(endGame.isVisible() && position_x==145 && position_y==90){
            frame.dispose();
            music.stop();
            try {
                new LevelWindowSix(Constant.sfondoHairyCity,Constant.musicaHairyCity,Constant.messaggio,1000,700,getSex(),mineTrainer);
            } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
                throw new RuntimeException(ex);
            }
        }

    }

    private String getSex() {
        return this.sex;
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
