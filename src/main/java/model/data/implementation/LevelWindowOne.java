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

public class LevelWindowOne extends LevelWindow{
    private String sex;
    private JLabel trainer1,trainer2,trainer3;
    private Person mineTrainer;
    private static  Person trn0 = new Person(Constant.allenatore0Lotta,"Vali", Levels.BASE);
    private static Person trn1 = new Person(Constant.allenatore1Lotta,"Giuseppe",Levels.BASE);
    private static Person trn2 = new Person(Constant.allenatore2Lotta,"Giacomo",Levels.BASE);

    public LevelWindowOne(String filePathImage, String fileMusicPath, String fileMusicPathMessage,int width,int eight,String sex,Person mineTrainer)
            throws UnsupportedAudioFileException, IOException, LineUnavailableException {

        super(filePathImage, fileMusicPath, fileMusicPathMessage ,width,eight);
        this.mineTrainer = mineTrainer;
        this.sex = sex;
        setPosition_x(920);
        setPosition_y(105);
        frame.setTitle("ON THE 1ST ROAD");
        frame.addKeyListener(this);
        getMyTrainer().setLocation(getPosition_x(),getPosition_y());

        if(this.sex.equalsIgnoreCase("F")) {
            getTeamFrame().getButtons()[6].setIcon(new ImageIcon(Constant.allenatoreMyAlycia));
            myTrainer.setIcon(new ImageIcon(Constant.pgFemaleUp2));
        }else{
            myTrainer.setIcon(new ImageIcon(Constant.pgMaleUp2));
        }

        addPetAtTeam(trn0,new Pet(ConstantPet.axel));
        addPetAtTeam(trn1,new Pet(ConstantPet.axel));
        addPetAtTeam(trn1,new Pet(ConstantPet.vito));
        addPetAtTeam(trn2,new Pet(ConstantPet.pepita));
        addPetAtTeam(trn2,new Pet(ConstantPet.vito));

        trainer1 = new JLabel(new ImageIcon(Constant.allenatore0));
        trainer1.setSize(40,57);
        trainer1.setLocation(800,105);

        trainer2 = new JLabel(new ImageIcon(Constant.allenatore2));
        trainer2.setSize(40,57);
        trainer2.setLocation(270,115);

        trainer3 = new JLabel(new ImageIcon(Constant.allenatore1));
        trainer3.setSize(40,57);
        trainer3.setLocation(185,0);

        frame.add(trainer1);
        frame.add(trainer2);
        frame.add(trainer3);
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
            SetFightPosition(845,105,trn0,"Anche io ho appena preso il mio primissimo Pet!Lottiamo!!!","Basta lottare!Sei troppo forte per i miei gusti!");
            SetFightPosition(315,115,trn1,"Michael mi ha battuto per tre volte,perchè non riesco a batterlo?!?","Non batterò mai nemmeno te!Meglio fare un pò di teoria sulle lotte.");
            SetFightPosition(185,30,trn2,"Qui sono il più forte.Ora è il tuo turno poi andrò verso WoofyCity per sfidare il Leader della città!!!","Wow!Non pensavo tu fossi cosi forte!Complimenti!");
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

        if(endGame.isVisible() && position_x==120 && position_y==100){
            frame.dispose();
            music.stop();
            try {
               new LevelWindowsTwo(Constant.sfondoWoofyCity,Constant.musicaWoofyCity,Constant.messaggio,1000,700,getSex(),mineTrainer);
            } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
                throw new RuntimeException(ex);
            }
        }
    }
    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
           //DO NOTHING
        }
    }

    @Override
    public void SetFightPosition(int posX, int posY,Person trainer,String comment1,String comment2)
            throws UnsupportedAudioFileException, LineUnavailableException, IOException, InterruptedException {

           if(trainer.getName().equalsIgnoreCase("giacomo") && trainer.getNumberOfLosses() == 1){
               getEndGame().setVisible(true);
               getEndGame().setLocation(120,120);
           }

           if (getMyTrainer().getX()==posX && getMyTrainer().getY()==posY && trainer.getNumberOfLosses() < 2) {
               super.musicMessage.start();
               JOptionPane.showMessageDialog(null, trainer.getName() + ":" + "\n" + comment1);
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
    public String getSex() {
        return sex;
    }

}