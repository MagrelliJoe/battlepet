package model.data.implementation;
import model.data.abstracted.LevelWindow;
import model.data.entities.Constant;
import model.data.entities.Levels;
import model.data.entities.Person;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.IOException;


public class WindowChooseTrainer extends LevelWindow implements ActionListener {
    private JButton girl,boy,chooseGirl,chooseBoy;
    private JTextArea girlDescription,boyDescription;
    private Person mineTrainer;

    public WindowChooseTrainer(String filePathImage, String fileMusicPath, String fileMusicPathMessage,int width, int eight) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        super(filePathImage, fileMusicPath, fileMusicPathMessage,width, eight);

        super.myTrainer.setVisible(false);
        frame.setTitle("CHOOSE YOUR CHARACTER!");
        girl = new JButton(new ImageIcon("images/AlyciaChoose.jpg"));
        girl.setSize(70,80);
        girl.setLocation(150,30);
        girl.setOpaque(false);

        boy = new JButton(new ImageIcon("images/DavidChoose.jpg"));
        boy.setSize(70,80);
        boy.setLocation(280,30);
        boy.setOpaque(false);

        girlDescription = new JTextArea("Name:Alycia"+"\n" +
                "Age:17"+ "\n" +
                "Favorite Pet:" + "\n" +
                "Dog");
        girlDescription.setSize(100,100);
        girlDescription.setLocation(150,130);
        girlDescription.setFont(new Font("Serif", Font.BOLD, 13));
        girlDescription.setBorder(BorderFactory.createMatteBorder(0,0,0,0,Color.DARK_GRAY));
        girlDescription.setBackground(new Color(0,0,0,0));
        girlDescription.setForeground(Color.white);
        girlDescription.setEditable(false);
        girlDescription.setOpaque(false);

        boyDescription = new JTextArea("Name:David"+ "\n" +
                "Age:18" + "\n" +
                "Favorite Pet:" + "\n" +
                "Rabbit");
        boyDescription.setSize(100,100);
        boyDescription.setLocation(280,130);
        boyDescription.setFont(new Font("Serif", Font.BOLD, 13));
        boyDescription.setBorder(BorderFactory.createMatteBorder(0,0,0,0,Color.DARK_GRAY));
        boyDescription.setBackground(new Color(0,0,0,0));
        boyDescription.setForeground(Color.white);
        boyDescription.setEditable(false);
        boyDescription.setOpaque(false);

        chooseBoy = new JButton("CHOOSE DAVID");
        chooseBoy.setSize(100,50);
        chooseBoy.setOpaque(false);
        chooseBoy.setBorder(BorderFactory.createMatteBorder(0,0,0,0,Color.DARK_GRAY));
        chooseBoy.setBackground(new Color(0,0,0,0));
        chooseBoy.setForeground(Color.white);
        chooseBoy.setFont(new Font("Serif", Font.BOLD, 12));
        chooseBoy.setLocation(270,210);
        chooseBoy.addActionListener(this);
        chooseBoy.setActionCommand("boy");

        chooseGirl = new JButton("CHOOSE ALYCIA");
        chooseGirl.setSize(100,50);
        chooseGirl.setOpaque(false);
        chooseGirl.setBorder(BorderFactory.createMatteBorder(0,0,0,0,Color.DARK_GRAY));
        chooseGirl.setBackground(new Color(0,0,0,0));
        chooseGirl.setForeground(Color.white);
        chooseGirl.setFont(new Font("Serif", Font.BOLD, 12));
        chooseGirl.setLocation(150,210);
        chooseGirl.addActionListener(this);
        chooseGirl.setActionCommand("girl");

        frame.add(girl);
        frame.add(boy);
        frame.add(girlDescription);
        frame.add(boyDescription);
        frame.add(chooseBoy);
        frame.add(chooseGirl);
        frame.add(sfondo);

    }

    @Override
    public void SetFightPosition(int posX, int posY, Person trainer, String comment,String comment2) throws UnsupportedAudioFileException, LineUnavailableException, IOException, InterruptedException {
       //DO NOTHING
    }

    @Override
    public void SetTalkingPosition(int posX, int posY, String comment) {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if("girl".equals(e.getActionCommand()) || "boy".equals(e.getActionCommand())){
            frame.dispose();
            music.stop();
            if("girl".equals(e.getActionCommand())){
                try {
                    this.mineTrainer =new Person("images/AlyciaChoose.jpg", "Alycia", Levels.BASE);
                    new LevelWindowZero("images/Sfondi/home.jpg", "images/audio/homeMusic.wav",Constant.messaggio,580,440,"F",mineTrainer);
                } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
                    throw new RuntimeException(ex);
                }
            }else{
                try {
                    this.mineTrainer =new Person("images/DavidChoose.jpg", "David", Levels.BASE);
                    new LevelWindowZero("images/Sfondi/home.jpg", "images/audio/homeMusic.wav",Constant.messaggio,580,440,"M",mineTrainer);
                } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
                    throw new RuntimeException(ex);
                }
            }

        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        //DO NOTHING
    }

    @Override
    public void keyPressed(KeyEvent e) {
        //DO NOTHING
    }

    @Override
    public void keyReleased(KeyEvent e) {
        //DO NOTHING
    }
}
