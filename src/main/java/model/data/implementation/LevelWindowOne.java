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

    public LevelWindowOne(String filePathImage, String fileMusicPath, String fileMusicPathMessage,int numOfNeon,int width,int eight,String sex,Person mineTrainer)
            throws UnsupportedAudioFileException, IOException, LineUnavailableException {

        super(filePathImage, fileMusicPath, fileMusicPathMessage , numOfNeon,width,eight);
        this.mineTrainer = mineTrainer;
        this.sex = sex;
        setPosition_x(920);
        setPosition_y(105);
        frame.setTitle("ON THE ROAD 1");
        frame.addKeyListener(this);
        getMyTrainer().setLocation(getPosition_x(),getPosition_y());

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
        trainer2.setLocation(270,105);

        trainer3 = new JLabel(new ImageIcon(Constant.allenatore1));
        trainer3.setSize(40,57);
        trainer3.setLocation(185,0);

        frame.add(trainer1);
        frame.add(trainer2);
        frame.add(trainer3);

        for(int i = 0;i < numOfNeon; i++){
            frame.add(neons[i]);
            if(i==0){
                neons[i].setLocation(830,100);
            }else if(i==1){
                neons[i].setLocation(300,100);
            }else{
                neons[i].setLocation(168,38);
            }
        }
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
            SetFightPosition(845,90,trn0,"Anche io ho appena preso il mio primissimo Pet!Lottiamo!!!");
            SetFightPosition(315,95,trn1,"Michael mi ha battuto per tre volte,perchè non riesco a batterlo?!?");
            SetFightPosition(185,30,trn2,"Qui sono il leader indiscusso.Ora è il tuo turno poi andrò verso WoofyCity per sfidare il T.L. della città!!!");
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
    }
    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
           //DO NOTHING
        }
    }

    @Override
    public void SetFightPosition(int posX, int posY,Person trainer,String comment)
            throws UnsupportedAudioFileException, LineUnavailableException, IOException, InterruptedException {

           if (getMyTrainer().getX()==posX && getMyTrainer().getY()==posY) {
               super.musicMessage.loop(0);
               JOptionPane.showMessageDialog(null, trainer.getName() + ":" + "\n" + comment);
               battle = new ServiceForBattle(mineTrainer, trainer, new BattleWindow(Constant.sfondoLotta1, Constant.musicalotta1));
               updateTeamShow(trainer);
               battle.getBattle().getFrame().addWindowListener(new WindowListener() {
                   @Override
                   public void windowOpened(WindowEvent e) {
                       music.stop();
                   }
                   @Override
                   public void windowClosing(WindowEvent e) {
                       music.start();
                   }
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