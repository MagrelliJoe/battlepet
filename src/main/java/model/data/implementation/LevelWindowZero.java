package model.data.implementation;
import model.data.abstracted.LevelWindow;
import model.data.entities.Constant;
import model.data.entities.Person;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.Set;

public class LevelWindowZero extends LevelWindow {
    private  String sex;
    private JLabel parent;
    private Person mineTrainer;
    private JLabel pet;

    public LevelWindowZero(String filePathImage, String fileMusicPath, String fileMusicPathMessage, int numOfNeon, int width, int eight,String sex,Person mineTrainer) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        super(filePathImage, fileMusicPath, fileMusicPathMessage, numOfNeon, width, eight);
        this.sex = sex;
        this.mineTrainer = mineTrainer;
        if(this.sex.equalsIgnoreCase("F")) {
            myTrainer.setIcon(new ImageIcon("images/MyTrainer/pg_f_up_left.jpg"));
        }else{
            myTrainer.setIcon(new ImageIcon("images/MyTrainer/pg_up_left.jpg"));
        }

        setPosition_x(330);
        setPosition_y(50);
        frame.addKeyListener(this);
        getMyTrainer().setLocation(getPosition_x(),getPosition_y());

        parent = new JLabel(new ImageIcon("images/dad.jpg"));
        parent.setSize(45,62);
        parent.setLocation(400,300);

        pet = new JLabel(new ImageIcon("images/petInit.png"));
        pet.setSize(100,50);
        pet.setLocation(80,160);
        pet.setVisible(false);

        neons[0].setLocation(355,310);
        frame.add(neons[0]);
        neons[1].setLocation(40,215);
        neons[1].setVisible(false);
        frame.add(neons[1]);

        frame.add(pet);
        frame.add(parent);
        frame.add(sfondo);

        if(getSex().equalsIgnoreCase("M")){
            JOptionPane.showMessageDialog(null,mineTrainer.getName() + ":" + "\n" +
                    "Basta giocare con l'XBOX!Vado dal papà che mi sta aspettando per regalarmi" + "\n" +
                    "il mio primissimo Pet!Non vedo l'ora!!!");
        }else{
            JOptionPane.showMessageDialog(null,mineTrainer.getName() + ":" + "\n" +
                    "Basta giocare con la SWITCH!Vado dal papà che mi sta aspettando per regalarmi" + "\n" +
                    "il mio primissimo Pet!Non vedo l'ora!!!");
        }

    }

    @Override
    public void SetFightPosition(int posX, int posY, Person trainer, String comment) throws UnsupportedAudioFileException, LineUnavailableException, IOException, InterruptedException {
           int pos_neg[] = {320,325,330,335,340,345,350,355};
           for(int i=0;i<pos_neg.length;i++){
               if(getPosition_x() == pos_neg[i] && getPosition_y() == 345){
                   setPosition_y(300);
                   getMyTrainer().setLocation(getPosition_x(),getPosition_y());
                   JOptionPane.showMessageDialog(null,mineTrainer.getName() + ":" + "\n" +
                           "Non posso andarmene subito!Devo parlare con Papà!!!");
               }
           }
           if(getPosition_x() == posX && getPosition_y() == posY){
               JOptionPane.showMessageDialog(null,
                       comment);
           }

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
            SetFightPosition(0,0,null,null);
        } catch (UnsupportedAudioFileException | LineUnavailableException | IOException | InterruptedException ex) {
            throw new RuntimeException(ex);
        }

        if (getPosition_x() == 370 && getPosition_y() == 305 && neons[1].isVisible()==false) {
            JOptionPane.showMessageDialog(null, "Joe:" + "\n" +
                    mineTrainer.getName() + "!!!" + "Finalmente hai smesso di giocare a WARNING INFECTION THE GAME!" + "\n" +
                    "Quel gioco ti sta piacendo molto vero?!? Parlando di cose più importanti,è venuto il momento" + "\n" +
                    "per te di ricevere il primo Pet!Sul tavolo ci sono tre Pet,scegli il tuo preferito!");
            neons[0].setVisible(false);
            neons[1].setVisible(true);
            parent.setLocation(140, 205);
            pet.setVisible(true);
        }
        if(getPosition_x() == 55 && getPosition_y() == 210 && neons[1].isVisible()){
            JOptionPane.showMessageDialog(null, mineTrainer.getName() + ":" + "\n" +
                    "Ecco i Pet di papa!!!");
        }
        updateTeamShow(mineTrainer);

        if(e.getKeyCode() == KeyEvent.VK_LEFT) {
            position_x -= 5;
            System.out.println("x:"+position_x);
            System.out.println("y:"+position_y);
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
            System.out.println("x:"+position_x);
            System.out.println("y:"+position_y);
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
            System.out.println("x:"+position_x);
            System.out.println("y:"+position_y);
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
            System.out.println("x:"+position_x);
            System.out.println("y:"+position_y);
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
    }
    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            //DO NOTHING
        }
    }
    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
