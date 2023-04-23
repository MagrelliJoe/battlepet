package model.data.abstracted;

import model.entities.Constant;
import model.entities.Person;
import model.entities.Pet;
import model.entities.TeamFrame;
import org.hibernate.dialect.MyISAMStorageEngine;

import javax.imageio.ImageIO;
import javax.sound.sampled.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static javax.swing.text.StyleConstants.setBackground;

public abstract class LevelWindow extends JFrame implements KeyListener {
    private static final int width = 950;
    private static final int eight = 650;
    private Icon icon,myTrainerMove;
    private JLabel sfondo = new JLabel(icon);
    private File audioMusic, audioMusicMessage;
    private JButton myTrainer,myTeam;
    private AudioInputStream audioInputStreamMusic, audioInputStreamMusicMessage;
    private Clip music, musicMessage = null;
    private String filePathImage, fileMusicPath, fileMusicPathMessage;
    protected int position_x=300;
    protected int position_y=200;
    private TeamFrame teamFrame;

    public LevelWindow(String filePathImage, String fileMusicPath, String fileMusicPathMessage) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        teamFrame = new TeamFrame(Constant.sfondoBronze);
        this.filePathImage = filePathImage;
        this.fileMusicPath = fileMusicPath;
        this.fileMusicPathMessage = fileMusicPathMessage;
        this.audioMusic = new File(this.fileMusicPath);
        this.audioInputStreamMusic = AudioSystem.getAudioInputStream(this.audioMusic);
        this.music = AudioSystem.getClip();
        this.music.open(this.audioInputStreamMusic);
        this.music.loop(1);

        this.fileMusicPathMessage = fileMusicPathMessage;
        this.audioMusicMessage = new File(this.fileMusicPathMessage);
        this.audioInputStreamMusicMessage = AudioSystem.getAudioInputStream(this.audioMusicMessage);
        this.musicMessage = AudioSystem.getClip();
        this.musicMessage.open(this.audioInputStreamMusicMessage);

        Dimension dimension = new Dimension(width, eight);
        this.getSfondo().setIcon(new ImageIcon(filePathImage));
        setVisible(true);
        setResizable(false);
        setSize(width, eight);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        sfondo.setSize(dimension);
        addKeyListener(this);

        myTrainerMove = new ImageIcon("images/MyTrainer/pg_left_1.png");

        myTrainer = new JButton(myTrainerMove);
        myTrainer.setBackground(new Color(0,0,0,0));
        myTrainer.setBorder(new EmptyBorder(0,0,0,0));
        myTrainer.setLocation(position_x,position_y);
        myTrainer.setSize(40,57);

        myTeam = new JButton("TEAM");
        myTeam.setBorder(BorderFactory.createMatteBorder(5,5,5,5,Color.DARK_GRAY));
        myTeam.setBackground(Color.blue);
        myTeam.setBorder(new EmptyBorder(0,0,0,0));
        myTeam.setForeground(Color.BLACK);
        myTeam.setLocation(800,570);
        myTeam.setSize(100, 30);

        add(myTrainer);
        add(myTeam);
        add(sfondo);

    }
    @Override
    public void keyTyped(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP) {
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            if(position_x%2 == 0){
                myTrainer.setIcon(new ImageIcon("images/MyTrainer/pg_right_2.jpg"));
                position_x-=5;
                myTrainer.setLocation(position_x,position_y);
            }
            else{
                myTrainer.setIcon(new ImageIcon("images/MyTrainer/pg_right_1.jpg"));
                position_x-=5;
                myTrainer.setLocation(position_x,position_y);

            }
        }
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            if(position_y%2 == 0){
                myTrainer.setIcon(new ImageIcon("images/MyTrainer/pg_up_left.jpg"));
                position_y-=5;
                myTrainer.setLocation(position_x,position_y);
            }
            else{
                myTrainer.setIcon(new ImageIcon("images/MyTrainer/pg_up_right.jpg"));
                position_y-=5;
                myTrainer.setLocation(position_x,position_y);

            }
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            if(position_y%2 == 0){
                myTrainer.setIcon(new ImageIcon("images/MyTrainer/pg_down_left.jpg"));
                position_y+=5;
                myTrainer.setLocation(position_x,position_y);
            }
            else{
                myTrainer.setIcon(new ImageIcon("images/MyTrainer/pg_down_right.jpg"));
                position_y+=5;
                myTrainer.setLocation(position_x,position_y);

            }
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            if(position_x%2 == 0){
                myTrainer.setIcon(new ImageIcon("images/MyTrainer/pg_left_2.jpg"));
                position_x+=5;
                myTrainer.setLocation(position_x,position_y);
            }
            else{
                myTrainer.setIcon(new ImageIcon("images/MyTrainer/pg_left_1.png"));
                position_x+=5;
                myTrainer.setLocation(position_x,position_y);

            }
        }
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {

            teamFrame.getFrame().setVisible(true);
        }
    }
    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {

        }
    }

    public void updateTeamShow(Person trainer){
        int i=0;
        for(Pet pet:trainer.getPetList().values()){
            switch(pet.getType()){
                case DOG :
                    teamFrame.getButtons()[i].setIcon(new ImageIcon(Constant.leo));
                    teamFrame.getLabels()[i].setText(pet.getName() + " " + pet.getLevels());
                    break;
            }
            i++;
        }
    }

    public Icon getMyTrainerMove() {
        return myTrainerMove;
    }


    public void setMyTrainerMove(Icon myTrainerMove) {
        this.myTrainerMove = myTrainerMove;
    }

    public JButton getMyTrainer() {
        return myTrainer;
    }

    public void setMyTrainer(JButton myTrainer) {
        this.myTrainer = myTrainer;
    }

    public JButton getMyTeam() {
        return myTeam;
    }

    public void setMyTeam(JButton myTeam) {
        this.myTeam = myTeam;
    }

    public int getPosition_x() {
        return position_x;
    }

    public void setPosition_x(int position_x) {
        this.position_x = position_x;
    }

    public int getPosition_y() {
        return position_y;
    }

    public void setPosition_y(int position_y) {
        this.position_y = position_y;
    }

    public TeamFrame getTeamFrame() {
        return teamFrame;
    }

    public void setTeamFrame(TeamFrame teamFrame) {
        this.teamFrame = teamFrame;
    }

    public Icon getIcon() {
        return icon;
    }

    public void setIcon(Icon icon) {
        this.icon = icon;
    }

    public JLabel getSfondo() {
        return sfondo;
    }

    public void setSfondo(JLabel sfondo) {
        this.sfondo = sfondo;
    }

    public File getAudioMusic() {
        return audioMusic;
    }

    public void setAudioMusic(File audioMusic) {
        this.audioMusic = audioMusic;
    }

    public File getAudioMusicMessage() {
        return audioMusicMessage;
    }

    public void setAudioMusicMessage(File audioMusicMessage) {
        this.audioMusicMessage = audioMusicMessage;
    }

    public AudioInputStream getAudioInputStreamMusic() {
        return audioInputStreamMusic;
    }

    public void setAudioInputStreamMusic(AudioInputStream audioInputStreamMusic) {
        this.audioInputStreamMusic = audioInputStreamMusic;
    }

    public AudioInputStream getAudioInputStreamMusicMessage() {
        return audioInputStreamMusicMessage;
    }

    public void setAudioInputStreamMusicMessage(AudioInputStream audioInputStreamMusicMessage) {
        this.audioInputStreamMusicMessage = audioInputStreamMusicMessage;
    }

    public Clip getMusic() {
        return music;
    }

    public void setMusic(Clip music) {
        this.music = music;
    }

    public Clip getMusicMessage() {
        return musicMessage;
    }

    public void setMusicMessage(Clip musicMessage) {
        this.musicMessage = musicMessage;
    }

    public String getFilePathImage() {
        return filePathImage;
    }

    public void setFilePathImage(String filePathImage) {
        this.filePathImage = filePathImage;
    }

    public String getFileMusicPath() {
        return fileMusicPath;
    }

    public void setFileMusicPath(String fileMusicPath) {
        this.fileMusicPath = fileMusicPath;
    }

    public String getFileMusicPathMessage() {
        return fileMusicPathMessage;
    }

    public void setFileMusicPathMessage(String fileMusicPathMessage) {
        this.fileMusicPathMessage = fileMusicPathMessage;
    }


}

