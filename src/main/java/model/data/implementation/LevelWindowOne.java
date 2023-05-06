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
    private static  Person trn0 = new Person(Constant.allenatore0Lotta,"Floriana", Levels.BASE);
    private static Person trn1 = new Person(Constant.allenatore1Lotta,"Joseph",Levels.BASE);
    private static Person trn2 = new Person(Constant.allenatore2Lotta,"Michael",Levels.BASE);

    public LevelWindowOne(String filePathImage, String fileMusicPath, String fileMusicPathMessage,int width,int eight,String sex,Person mineTrainer)
            throws UnsupportedAudioFileException, IOException, LineUnavailableException {

        super(filePathImage, fileMusicPath, fileMusicPathMessage ,width,eight);
        this.mineTrainer = mineTrainer;
        this.sex = sex;
        setPosition_x(920);
        setPosition_y(105);
        frame.setTitle("ON THE FIRST ROAD");
        frame.addKeyListener(this);
        getMyTrainer().setLocation(getPosition_x(),getPosition_y());

        if(this.sex.equalsIgnoreCase("F")) {
            getTeamFrame().getButtons()[6].setIcon(new ImageIcon("images/AlyciaChoose.jpg"));
            myTrainer.setIcon(new ImageIcon("images/MyTrainer/pg_f_up_left.jpg"));
        }else{
            myTrainer.setIcon(new ImageIcon("images/MyTrainer/pg_up_left.jpg"));
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
            SetFightPosition(845,105,trn0,"Anche io ho appena preso il mio primissimo Pet!Lottiamo!!!","Basta lottare!Sei troppo forte per i miei gusti!",1,0);
            SetFightPosition(315,115,trn1,"Michael mi ha battuto per tre volte,perchè non riesco a batterlo?!?","Non batterò mai nemmeno te!Meglio fare un pò di teoria sulle lotte.",3,0);
            SetFightPosition(185,30,trn2,"Qui sono il leader indiscusso.Ora è il tuo turno poi andrò verso WoofyCity per sfidare il TrainerLeader della città!!!","Wow!Non pensavo tu fossi cosi forte!Complimenti!",5,0);
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
                        super.myTrainer.setIcon(new ImageIcon("images/MyTrainer/pg_left_1.jpg"));
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
                LevelWindow levelWindow =  new LevelWindowsTwo(Constant.sfondoBronze,Constant.musica2,Constant.messaggio,1000,700,"M",mineTrainer);
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
    public void SetFightPosition(int posX, int posY,Person trainer,String comment1,String comment2,int numMax,int numMin)
            throws UnsupportedAudioFileException, LineUnavailableException, IOException, InterruptedException {

           if(mineTrainer.getVictory() >= 3){
               getEndGame().setVisible(true);
               getEndGame().setLocation(120,120);
           }

           if (getMyTrainer().getX()==posX && getMyTrainer().getY()==posY && mineTrainer.getVictory() <= numMax) {
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
           }
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public JLabel getTrainer1() {
        return trainer1;
    }

    public void setTrainer1(JLabel trainer1) {
        this.trainer1 = trainer1;
    }

    public JLabel getTrainer2() {
        return trainer2;
    }

    public void setTrainer2(JLabel trainer2) {
        this.trainer2 = trainer2;
    }

    public JLabel getTrainer3() {
        return trainer3;
    }

    public void setTrainer3(JLabel trainer3) {
        this.trainer3 = trainer3;
    }

    public void setMyTrainer(Person myTrainer) {
        this.mineTrainer = mineTrainer;
    }

    public static Person getTrn0() {
        return trn0;
    }

    public static void setTrn0(Person trn0) {
        LevelWindowOne.trn0 = trn0;
    }

    public static Person getTrn1() {
        return trn1;
    }

    public static void setTrn1(Person trn1) {
        LevelWindowOne.trn1 = trn1;
    }

    public static Person getTrn2() {
        return trn2;
    }

    public static void setTrn2(Person trn2) {
        LevelWindowOne.trn2 = trn2;
    }
}