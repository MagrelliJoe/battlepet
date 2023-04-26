package model.data.implementation;
import model.data.abstracted.LevelWindow;
import model.data.entities.*;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;

public class LevelWindowOne extends LevelWindow  implements KeyListener {
    private JLabel trainer1,trainer2,trainer3;
    private Person myTrainer;
    private static  Person trn0 = new Person(Constant.allenatore0Lotta,"Floriana", Levels.BASE);
    private static Person trn1 = new Person(Constant.allenatore1Lotta,"Joseph",Levels.BASE);
    private static Person trn2 = new Person(Constant.allenatore2Lotta,"Michael",Levels.BASE);

    public LevelWindowOne(String filePathImage, String fileMusicPath, String fileMusicPathMessage,int numOfNeon,Person myTrainer)
            throws UnsupportedAudioFileException, IOException, LineUnavailableException {

        super(filePathImage, fileMusicPath, fileMusicPathMessage , numOfNeon);
        this.myTrainer = myTrainer;
        setPosition_x(920);
        setPosition_y(105);
        frame.setTitle("INIT");
        frame.addKeyListener(this);
        getMyTrainer().setLocation(getPosition_x(),getPosition_y());

        addPetatTeam(trn0,new Pet(ConstantPetTrainer.axel));
        addPetatTeam(trn1,new Pet(ConstantPetTrainer.axel));
        addPetatTeam(trn1,new Pet(ConstantPetTrainer.vito));
        addPetatTeam(trn2,new Pet(ConstantPetTrainer.pepita));
        addPetatTeam(trn2,new Pet(ConstantPetTrainer.vito));

        trainer1 = new JLabel(new ImageIcon(Constant.allenatore0));
        trainer1.setSize(40,50);
        trainer1.setLocation(800,105);

        trainer2 = new JLabel(new ImageIcon(Constant.allenatore2));
        trainer2.setSize(40,50);
        trainer2.setLocation(270,105);

        trainer3 = new JLabel(new ImageIcon(Constant.allenatore1));
        trainer3.setSize(40,50);
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

        } catch (UnsupportedAudioFileException | LineUnavailableException | IOException | InterruptedException ex) {
            throw new RuntimeException(ex);
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            if(position_x%2 == 0){
                super.myTrainer.setIcon(new ImageIcon("images/MyTrainer/pg_right_2.jpg"));
                position_x-=5;
                super.myTrainer.setLocation(position_x,position_y);
            }else{
                super.myTrainer.setIcon(new ImageIcon("images/MyTrainer/pg_right_1.jpg"));
                position_x-=5;
                super.myTrainer.setLocation(position_x,position_y);
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            if(position_y%2 == 0){
                super.myTrainer.setIcon(new ImageIcon("images/MyTrainer/pg_up_left.jpg"));
                position_y-=5;
                super.myTrainer.setLocation(position_x,position_y);

            }else{
                super.myTrainer.setIcon(new ImageIcon("images/MyTrainer/pg_up_right.jpg"));
                position_y-=5;
                super.myTrainer.setLocation(position_x,position_y);
            }
        }

        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            if(position_y%2 == 0){
                super.myTrainer.setIcon(new ImageIcon("images/MyTrainer/pg_down_left.jpg"));
                position_y+=5;
                super.myTrainer.setLocation(position_x,position_y);
            }else{
                super.myTrainer.setIcon(new ImageIcon("images/MyTrainer/pg_down_right.jpg"));
                position_y+=5;
                super.myTrainer.setLocation(position_x,position_y);
            }
        }

        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            if(position_x%2 == 0){
                super.myTrainer.setIcon(new ImageIcon("images/MyTrainer/pg_left_2.jpg"));
                position_x+=5;
                super.myTrainer.setLocation(position_x,position_y);
            }else{
                super.myTrainer.setIcon(new ImageIcon("images/MyTrainer/pg_left_1.png"));
                position_x+=5;
                super.myTrainer.setLocation(position_x,position_y);
            }
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
               battle = new ServiceForBattle(myTrainer, trainer, new BattleWindow(Constant.sfondoLotta1, Constant.musicalotta1));
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
}