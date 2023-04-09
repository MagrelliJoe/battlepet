package model.entities;
import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class BattleWindows {
    private static final int width = 700;
    private static final int eight = 421;
    private ImageIcon icon, iconMyTrainer, iconEnemyTrainer, iconMyPet, iconEnemyPet,iconGifLotta;
    private JLabel sfondo = new JLabel(icon);
    protected JTextArea tx = new JTextArea();
    private JButton myTrainer, enemyTrainer, myPet, enemyPet,gifLotta;
    private JCheckBoxMenuItem[] opzioni = new JCheckBoxMenuItem[4];
    private ButtonGroup bg = new ButtonGroup();
    protected JFrame frame;
    protected JTextArea showLife, showLifeEnemy;
    private int nextPet, nextPetEnemy = 0;
    private String filePathImage, fileMusicPath, fileMusicPathMessage;
    private File audioMusic, audioMusicMessage;
    private AudioInputStream audioInputStreamMusic, audioInputStreamMusicMessage;
    private Clip music, musicMessage = null;


    public BattleWindows(String filePathImage, String fileMusicPath, String fileMusicPathMessage)
            throws LineUnavailableException, IOException, UnsupportedAudioFileException {

        this.filePathImage = filePathImage;

        this.fileMusicPath = fileMusicPath;
        this.audioMusic = new File(this.fileMusicPath);
        this.audioInputStreamMusic = AudioSystem.getAudioInputStream(this.audioMusic);
        this.music = AudioSystem.getClip();
        this.music.open(this.audioInputStreamMusic);
        //b this.music.loop(1);

        this.fileMusicPathMessage = fileMusicPathMessage;
        this.audioMusicMessage = new File(this.fileMusicPathMessage);
        this.audioInputStreamMusicMessage = AudioSystem.getAudioInputStream(this.audioMusicMessage);
        this.musicMessage = AudioSystem.getClip();
        this.musicMessage.open(this.audioInputStreamMusicMessage);

        frame = new JFrame("its time to fight!");
        Dimension dimension = new Dimension(width, eight);
        this.getSfondo().setIcon(new ImageIcon(filePathImage));
        frame.setVisible(true);
        frame.setSize(width, eight);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        sfondo.setSize(dimension);

        tx.setLocation(92, 300);
        tx.setSize(500, 110);
        tx.setBackground(Color.cyan);
        tx.setEditable(false);
        tx.setFont(new Font("Serif", Font.BOLD, 15));
        tx.setOpaque(false);
        tx.setForeground(Color.BLACK);
        tx.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));

        showLife = new JTextArea();
        showLife.setSize(120, 60);
        showLife.setBackground(Color.cyan);
        showLife.setEditable(false);
        showLife.setFont(new Font("Serif", Font.ITALIC, 17));
        showLife.setOpaque(false);
        showLife.setForeground(Color.BLACK);
        showLife.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));

        showLifeEnemy = new JTextArea();
        showLifeEnemy.setSize(80, 60);
        showLifeEnemy.setOpaque(false);
        showLifeEnemy.setEditable(false);
        showLifeEnemy.setFont(new Font("Serif", Font.ITALIC, 17));
        showLifeEnemy.setBackground(Color.cyan);
        showLifeEnemy.setForeground(Color.BLACK);
        showLifeEnemy.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));

        myPet = new JButton(iconMyPet);
        myPet.setSize(45, 45);

        gifLotta = new JButton(iconGifLotta);
        gifLotta.setSize(200,100);

        enemyPet = new JButton(iconEnemyPet);
        enemyPet.setSize(45, 45);

        myTrainer = new JButton(iconMyTrainer);
        myTrainer.setSize(60, 70);

        enemyTrainer = new JButton(iconEnemyTrainer);
        enemyTrainer.setSize(60, 70);

        showLife.setLocation(60, 10);
        showLifeEnemy.setLocation(570, 10);
        myPet.setLocation(1, 15);
        enemyPet.setLocation(637, 15);
        gifLotta.setLocation(250,100);
        myTrainer.setLocation(5, 312);
        enemyTrainer.setLocation(620, 312);

        for (int i = 0; i < opzioni.length; i++) {
            opzioni[i] = new JCheckBoxMenuItem();
            bg.add(opzioni[i]);
            frame.add(opzioni[i]);
            opzioni[i].setSize(155, 30);
            opzioni[i].setEnabled(false);
            opzioni[i].setFont(new Font("Serif", Font.ITALIC, 15));
            opzioni[i].setBackground(Color.gray);
            opzioni[i].setForeground(Color.BLACK);

            //opzioni[i].setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
            if (i < 2) {
                opzioni[i].setLocation(30 + (i * 170), 220);
            } else {
                opzioni[i].setLocation(-190 + (i * 170), 250);
            }
            if (i == 3) {
                opzioni[i].setEnabled(true);
                opzioni[i].setText("START FIGHT");
            }
        }
        frame.add(tx);
        frame.add(showLife);
        frame.add(showLifeEnemy);
        frame.add(myPet);
        frame.add(enemyPet);
        frame.add(gifLotta);
        frame.add(myTrainer);
        frame.add(enemyTrainer);
        frame.add(sfondo);
    }

    public ImageIcon getIcon() {
        return icon;
    }

    public void setIcon(ImageIcon icon) {
        this.icon = icon;
    }

    public ImageIcon getIconMyTrainer() {
        return iconMyTrainer;
    }

    public void setIconMyTrainer(ImageIcon iconMyTrainer) {
        this.iconMyTrainer = iconMyTrainer;
    }

    public ImageIcon getIconEnemyTrainer() {
        return iconEnemyTrainer;
    }

    public void setIconEnemyTrainer(ImageIcon iconEnemyTrainer) {
        this.iconEnemyTrainer = iconEnemyTrainer;
    }

    public ImageIcon getIconMyPet() {
        return iconMyPet;
    }

    public void setIconMyPet(ImageIcon iconMyPet) {
        this.iconMyPet = iconMyPet;
    }

    public ImageIcon getIconEnemyPet() {
        return iconEnemyPet;
    }

    public void setIconEnemyPet(ImageIcon iconEnemyPet) {
        this.iconEnemyPet = iconEnemyPet;
    }

    public JLabel getSfondo() {
        return sfondo;
    }

    public void setSfondo(JLabel sfondo) {
        this.sfondo = sfondo;
    }

    public JTextArea getTx() {
        return tx;
    }

    public void setTx(JTextArea tx) {
        this.tx = tx;
    }

    public JButton getMyTrainer() {
        return myTrainer;
    }

    public void setMyTrainer(JButton myTrainer) {
        this.myTrainer = myTrainer;
    }

    public JButton getEnemyTrainer() {
        return enemyTrainer;
    }

    public void setEnemyTrainer(JButton enemyTrainer) {
        this.enemyTrainer = enemyTrainer;
    }

    public JButton getMyPet() {
        return myPet;
    }

    public void setMyPet(JButton myPet) {
        this.myPet = myPet;
    }

    public JButton getEnemyPet() {
        return enemyPet;
    }

    public void setEnemyPet(JButton enemyPet) {
        this.enemyPet = enemyPet;
    }

    public JCheckBoxMenuItem[] getOpzioni() {
        return opzioni;
    }

    public void setOpzioni(JCheckBoxMenuItem[] opzioni) {
        this.opzioni = opzioni;
    }

    public ButtonGroup getBg() {
        return bg;
    }

    public void setBg(ButtonGroup bg) {
        this.bg = bg;
    }

    public JFrame getFrame() {
        return frame;
    }

    public void setFrame(JFrame frame) {
        this.frame = frame;
    }

    public JTextArea getShowLife() {
        return showLife;
    }

    public void setShowLife(JTextArea showLife) {
        this.showLife = showLife;
    }

    public JTextArea getShowLifeEnemy() {
        return showLifeEnemy;
    }

    public void setShowLifeEnemy(JTextArea showLifeEnemy) {
        this.showLifeEnemy = showLifeEnemy;
    }

    public int getNextPet() {
        return nextPet;
    }

    public void setNextPet(int nextPet) {
        this.nextPet = nextPet;
    }

    public int getNextPetEnemy() {
        return nextPetEnemy;
    }

    public void setNextPetEnemy(int nextPetEnemy) {
        this.nextPetEnemy = nextPetEnemy;
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
}