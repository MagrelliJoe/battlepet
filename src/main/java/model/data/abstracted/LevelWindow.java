package model.data.abstracted;
import model.data.entities.*;
import javax.sound.sampled.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;

public abstract class LevelWindow implements KeyListener {
    protected int width;
    protected int eight;
    protected Icon icon,myTrainerMove;
    protected JLabel sfondo = new JLabel(icon);
    private File audioMusic, audioMusicMessage;
    protected JLabel myTrainer,endGame;
    private AudioInputStream audioInputStreamMusic, audioInputStreamMusicMessage;
    protected Clip music, musicMessage = null;
    private String filePathImage, fileMusicPath, fileMusicPathMessage;
    protected int position_x=0;
    protected int position_y=0;
    protected JFrame frame;
    protected TeamFrame teamFrame;
    protected WindowLeader leader;
    protected ServiceForBattle battle;

    public LevelWindow(String filePathImage, String fileMusicPath, String fileMusicPathMessage,int width,int eight)
            throws UnsupportedAudioFileException, IOException, LineUnavailableException {

        teamFrame = new TeamFrame();
        leader = new WindowLeader();
        this.filePathImage = filePathImage;
        this.width = width;
        this.eight = eight;

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

        this.fileMusicPathMessage = fileMusicPathMessage;
        this.audioMusicMessage = new File(this.fileMusicPathMessage);
        this.audioInputStreamMusicMessage = AudioSystem.getAudioInputStream(this.audioMusicMessage);
        this.musicMessage = AudioSystem.getClip();
        this.musicMessage.open(this.audioInputStreamMusicMessage);

        Dimension dimension = new Dimension(width, eight);
        this.frame = new JFrame();
        this.getSfondo().setIcon(new ImageIcon(filePathImage));
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setSize(width, eight);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        sfondo.setSize(dimension);

        myTrainerMove = new ImageIcon("images/MyTrainer/pg_right_1.jpg");

        myTrainer = new JLabel(myTrainerMove);
        myTrainer.setBackground(new Color(0,0,0,0));
        myTrainer.setBorder(new EmptyBorder(0,0,0,0));
        myTrainer.setLocation(position_x,position_y);
        myTrainer.setSize(40,57);

        endGame = new JLabel(new ImageIcon("images/here.png"));
        endGame.setBackground(new Color(0,0,0,0));
        endGame.setBorder(new EmptyBorder(0,0,0,0));
        endGame.setSize(40,57);
        endGame.setVisible(false);

        frame.add(myTrainer);
        frame.add(endGame);
        frame.add(sfondo);
    }

    public abstract void SetFightPosition(int posX, int posY, Person trainer,String comment,String comment2) throws UnsupportedAudioFileException, LineUnavailableException, IOException, InterruptedException;
    public abstract void SetTalkingPosition(int posX, int posY,String comment);

    protected void addPetAtTeam(Person trainer, Pet pet){
        int numOfPetActually = trainer.getPetList().size();
        trainer.addPet(numOfPetActually,pet);
    }
    public void updateTeamShow(Person trainer){
        teamFrame.getFrame().setTitle("Victory's Trainer->"+trainer.getVictory());
        int i=0;
        for(Pet pet:trainer.getPetList().values()){
            teamFrame.getLabels()[i].setText(pet.getName() + " " +
                    "Level->" + pet.getLevels());
            switch(pet.getType()){
                case DOG :
                    teamFrame.getButtons()[i].setIcon(new ImageIcon("images/Gif/canegif.gif"));
                    break;
                case CAT:
                    teamFrame.getButtons()[i].setIcon(new ImageIcon("images/Gif/gattogif.gif"));
                    break;
                case RABBIT:
                    teamFrame.getButtons()[i].setIcon(new ImageIcon("images/Gif/conigliogif.gif"));
                    break;
                case BIRD:
                    teamFrame.getButtons()[i].setIcon(new ImageIcon("images/Gif/uccellogif.gif"));
                    break;
                case TURTLE:
                    teamFrame.getButtons()[i].setIcon(new ImageIcon("images/Gif/tartarugagif.gif"));
                    break;
            }
            i++;
        }
    }
    public void updateLeaderShow(){

    }

    public WindowLeader getLeader() {
        return leader;
    }

    public JFrame getFrame() {
        return frame;
    }

    public void setFrame(JFrame frame) {
        this.frame = frame;
    }

    public JLabel getMyTrainer() {
        return myTrainer;
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

    public JLabel getSfondo() {
        return sfondo;
    }

    public void setSfondo(JLabel sfondo) {
        this.sfondo = sfondo;
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

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getEight() {
        return eight;
    }

    public void setEight(int eight) {
        this.eight = eight;
    }

    public JLabel getEndGame() {
        return endGame;
    }

}

