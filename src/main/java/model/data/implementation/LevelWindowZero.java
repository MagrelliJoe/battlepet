package model.data.implementation;
import model.data.abstracted.LevelWindow;
import model.data.entities.Constant;
import model.data.entities.Person;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;

public class LevelWindowZero extends LevelWindow {
    private  String sex;
    private JLabel parent;
    private Person mineTrainer;
    private JLabel pet;

    public LevelWindowZero(String filePathImage, String fileMusicPath, String fileMusicPathMessage,int width, int eight,String sex,Person mineTrainer) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        super(filePathImage, fileMusicPath, fileMusicPathMessage,width, eight);
        this.sex = sex;
        this.mineTrainer = mineTrainer;
        if(this.sex.equalsIgnoreCase("F")) {
            getTeamFrame().getButtons()[6].setIcon(new ImageIcon("images/AlyciaChoose.jpg"));
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

        frame.setTitle("HOME SWEET HOME");
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
    public void SetFightPosition(int posX, int posY, Person trainer, String comment1,String comment2) throws UnsupportedAudioFileException, LineUnavailableException, IOException, InterruptedException {
           int pos_neg[] = {320,325,330,335,340,345,350,355};
           for(int i=0;i<pos_neg.length;i++){
               if(getPosition_x() == pos_neg[i] && getPosition_y() == 345 && mineTrainer.getPetList().size()==0){
                   setPosition_y(300);
                   getMyTrainer().setLocation(getPosition_x(),getPosition_y());
                   JOptionPane.showMessageDialog(null,mineTrainer.getName() + ":" + "\n" +
                           "Non posso andarmene subito!Devo parlare con Papà!!!");
               }
           }
           if(getPosition_x() == posX && getPosition_y() == posY){
               JOptionPane.showMessageDialog(null,
                       comment1);
           }

    }

    @Override
    public void SetTalkingPosition(int posX, int posY, String comment) {

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
            SetFightPosition(0,0,null,null,null);
        } catch (UnsupportedAudioFileException | LineUnavailableException | IOException | InterruptedException ex) {
            throw new RuntimeException(ex);
        }

        if (getPosition_x() == 370 && getPosition_y() == 305) {
            JOptionPane.showMessageDialog(null, "Joe:" + "\n" +
                    mineTrainer.getName() + "!!!" + "Finalmente hai smesso di giocare a WARNING INFECTION THE GAME!" + "\n" +
                    "Quel gioco ti sta piacendo molto vero?!? Parlando di cose più importanti,è venuto il momento" + "\n" +
                    "per te di ricevere il primo Pet!Siediti comodamente di fronte a me al tavolo e scegli il tuo preferito!");
            parent.setLocation(140, 205);
            pet.setVisible(true);
        }
        if(getPosition_x() == 55 && getPosition_y() == 210){
            JOptionPane.showMessageDialog(null, mineTrainer.getName() + ":" + "\n" +
                    "Ecco i Pet di papa!!!");
            try {
                LevelWindow levelWindow = new WindowChoosePet(Constant.sfondoLotta1,Constant.fineLivello,Constant.musica1,500,300,getSex(),mineTrainer);
                levelWindow.getFrame().addWindowListener(new WindowListener() {
                    @Override
                    public void windowOpened(WindowEvent e) {
                        music.stop();
                    }
                    @Override
                    public void windowClosing(WindowEvent e) {
                        //DO NOTHING
                    }
                    @Override
                    public void windowClosed(WindowEvent e) {
                        music.start();
                        JOptionPane.showMessageDialog(null, "Joe:" + ":" + "\n" +
                                "Bene!vedo che ha deciso di optare per " + " " + mineTrainer.getPetList().get(0).getName().toUpperCase() + "\n" +
                                "Ottima scelta!Vedrai che diventerete ottimi amici!Ora non ti trattengo oltre,se hai dubbi e" + "\n" +
                                "non hai ancora visto le istruzioni,ti consiglio di SALVARE e di dargli un'occhiata prima di" + "\n" +
                                "riprendere il cammino!Sono sicuro che ti divertirai un mondo nel tuo viaggio!!!Ora vai!!!!!");
                        pet.setVisible(false);
                        frame.dispose();
                        music.stop();
                        try {
                            LevelWindow levelWindow1 = new LevelWindowOne(Constant.sfondoInit, Constant.musica1, Constant.messaggio, 1000, 333,getSex(), mineTrainer);
                        } catch (UnsupportedAudioFileException | LineUnavailableException | IOException ex) {
                            throw new RuntimeException(ex);
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
            } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
                throw new RuntimeException(ex);
            }
        }
        updateTeamShow(mineTrainer);

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
}
