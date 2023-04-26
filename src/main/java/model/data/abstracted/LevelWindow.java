package model.data.abstracted;
import model.data.entities.*;
import javax.sound.sampled.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;

public abstract class LevelWindow {
    protected static final int width = 1000;
    protected static final int eight = 333;
    protected Icon icon,myTrainerMove;
    protected JLabel sfondo = new JLabel(icon);
    private File audioMusic, audioMusicMessage;
    protected JButton myTrainer;
    private AudioInputStream audioInputStreamMusic, audioInputStreamMusicMessage;
    protected Clip music, musicMessage = null;
    private String filePathImage, fileMusicPath, fileMusicPathMessage;
    protected int position_x=0;
    protected int position_y=0;
    protected JFrame frame;
    protected TeamFrame teamFrame;
    protected ServiceForBattle battle;
    protected JLabel[] neons;

    public LevelWindow(String filePathImage, String fileMusicPath, String fileMusicPathMessage,int numOfNeon)
            throws UnsupportedAudioFileException, IOException, LineUnavailableException {

        teamFrame = new TeamFrame();
        this.filePathImage = filePathImage;
        this.neons = new JLabel[numOfNeon];

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

        for(int i=0;i<numOfNeon;i++){
            neons[i] = new JLabel(new ImageIcon("images/cerchio.jpg"));
            neons[i].setSize(80,80);
        }

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

        myTrainer = new JButton(myTrainerMove);
        myTrainer.setBackground(new Color(0,0,0,0));
        myTrainer.setBorder(new EmptyBorder(0,0,0,0));
        myTrainer.setLocation(position_x,position_y);
        myTrainer.setSize(40,57);

        frame.add(myTrainer);
        frame.add(sfondo);
    }

    public abstract void SetFightPosition(int posX, int posY, Person trainer,String comment) throws UnsupportedAudioFileException, LineUnavailableException, IOException, InterruptedException;

    protected void addPetatTeam(Person trainer,Pet pet){
        if(trainer.getPetList().size()>1) {
            trainer.addPet(trainer.getPetList().size() + 1, pet);
        }else if(trainer.getPetList().size()==1){
            trainer.addPet(1, pet);
        }else{
            trainer.addPet(0, pet);
        }
    }
    public void updateTeamShow(Person trainer){
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

    public JLabel[] getNeons() {
        return neons;
    }

    public void setNeons(JLabel[] neons) {
        this.neons = neons;
    }

    public JFrame getFrame() {
        return frame;
    }

    public void setFrame(JFrame frame) {
        this.frame = frame;
    }

    public ServiceForBattle getBattle() {
        return battle;
    }

    public void setBattle(ServiceForBattle battle) {
        this.battle = battle;
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

