package model.data.implementation;

import model.data.abstracted.LevelWindow;
import model.data.entities.Constant;
import model.data.entities.Person;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.IOException;

public class WindowTitle extends LevelWindow implements ActionListener {
    private JButton start,istruzioni;

    public WindowTitle(String filePathImage, String fileMusicPath, String fileMusicPathMessage,int width, int eight) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        super(filePathImage, fileMusicPath, fileMusicPathMessage,width, eight);

        super.myTrainer.setVisible(false);
        frame.setTitle("BATTLE PET");
        start = new JButton("START");
        start.setBorder(BorderFactory.createMatteBorder(3,3,3,3, Color.red));
        start.setBackground(Color.black);
        start.setForeground(Color.blue);
        start.setFont(new Font("Serif", Font.BOLD, 22));
        start.setSize(100, 30);
        start.setLocation(100,110);
        start.addActionListener(this);
        start.setActionCommand("start");

        istruzioni = new JButton("ISTRUZIONI");
        istruzioni.setBorder(BorderFactory.createMatteBorder(3,3,3,3, Color.red));
        istruzioni.setBackground(Color.black);
        istruzioni.setForeground(Color.blue);
        istruzioni.setFont(new Font("Serif", Font.BOLD, 20));
        istruzioni.setSize(150, 30);
        istruzioni.setLocation(250,110);
        istruzioni.addActionListener(this);
        istruzioni.setActionCommand("istruzioni");

        frame.add(start);
        frame.add(istruzioni);
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

        if("start".equals(e.getActionCommand())){
            JOptionPane.showMessageDialog(null, "WELCOME TO THE WORLD OF BATTLE PET!");
            frame.dispose();
            music.stop();
            try {
                LevelWindow levelWindow = new WindowPrologue("images/sfondoInitGame.jpg", Constant.musicaInit,Constant.messaggio,500,300);
            } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
                throw new RuntimeException(ex);
            }
        }
        else if("istruzioni".equals(e.getActionCommand())){
            frame.dispose();
            music.stop();
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
