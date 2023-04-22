package model.entities;
import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class BattleWindow {
    private static final int width = 700;
    private static final int eight = 421;
    private ImageIcon icon, iconMyTrainer, iconEnemyTrainer, iconMyPet, iconEnemyPet;
    private JLabel sfondo = new JLabel(icon);
    protected JTextArea tx = new JTextArea();
    private JButton myTrainer, enemyTrainer, myPet, enemyPet;
    private JButton namePet,life,level,namePetEnemy,lifeEnemy,levelEnemy;
    private JCheckBoxMenuItem[] opzioni = new JCheckBoxMenuItem[4];
    private ButtonGroup bg = new ButtonGroup();
    protected JFrame frame;
    private int nextPet, nextPetEnemy = 0;
    private String filePathImage, fileMusicPath, fileMusicPathMessage;
    private File audioMusic, audioMusicMessage;
    private AudioInputStream audioInputStreamMusic, audioInputStreamMusicMessage;
    private Clip music, musicMessage = null;
    private GifFrame gifFrame;

    public BattleWindow(String filePathImage, String fileMusicPath, String fileMusicPathMessage)
            throws LineUnavailableException, IOException, UnsupportedAudioFileException {

        this.gifFrame = new GifFrame();
        this.filePathImage = filePathImage;
        this.fileMusicPath = fileMusicPath;
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

        frame = new JFrame("its time to fight!");
        Dimension dimension = new Dimension(width, eight);
        this.getSfondo().setIcon(new ImageIcon(filePathImage));
        frame.setVisible(true);
        frame.setResizable(false);
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
        tx.setBorder(BorderFactory.createMatteBorder(5,5,5,5,Color.DARK_GRAY));
        tx.setForeground(Color.BLACK);
        tx.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));

        life = new JButton();
        life.setBorder(BorderFactory.createMatteBorder(5,5,5,5,Color.DARK_GRAY));
        life.setSize(100, 30);

        lifeEnemy= new JButton();
        lifeEnemy.setBorder(BorderFactory.createMatteBorder(5,5,5,5,Color.DARK_GRAY));
        lifeEnemy.setSize(100, 30);

        namePet = new JButton();
        namePet.setBorder(BorderFactory.createMatteBorder(5,5,5,5,Color.DARK_GRAY));
        namePet.setSize(100, 30);

        namePetEnemy = new JButton();
        namePetEnemy.setBorder(BorderFactory.createMatteBorder(5,5,5,5,Color.DARK_GRAY));
        namePetEnemy.setSize(100, 30);

        level = new JButton();
        level.setBorder(BorderFactory.createMatteBorder(5,5,5,5,Color.DARK_GRAY));
        level.setSize(100, 30);

        levelEnemy = new JButton();
        levelEnemy.setBorder(BorderFactory.createMatteBorder(5,5,5,5,Color.DARK_GRAY));
        levelEnemy.setSize(100, 30);

        myPet = new JButton(iconMyPet);
        myPet.setBorder(BorderFactory.createMatteBorder(5,5,5,5,Color.DARK_GRAY));
        myPet.setSize(60, 60);

        enemyPet = new JButton(iconEnemyPet);
        enemyPet.setBorder(BorderFactory.createMatteBorder(5,5,5,5,Color.DARK_GRAY));
        enemyPet.setSize(60, 60);

        myTrainer = new JButton(iconMyTrainer);
        myTrainer.setBorder(BorderFactory.createMatteBorder(5,5,5,5,Color.DARK_GRAY));
        myTrainer.setSize(70, 90);

        enemyTrainer = new JButton(iconEnemyTrainer);
        enemyTrainer.setBorder(BorderFactory.createMatteBorder(5,5,5,5,Color.DARK_GRAY));
        enemyTrainer.setSize(70, 90);

        myPet.setLocation(50, 15);
        enemyPet.setLocation(560, 15);
        namePet.setLocation(50,80);
        life.setLocation(70,112);
        level.setLocation(90,144);
        namePetEnemy.setLocation(520,80);
        lifeEnemy.setLocation(500,112);
        levelEnemy.setLocation(480,144);
        myTrainer.setLocation(5, 290);
        enemyTrainer.setLocation(611, 290);

        for (int i = 0; i < opzioni.length; i++) {
            opzioni[i] = new JCheckBoxMenuItem();
            bg.add(opzioni[i]);
            frame.add(opzioni[i]);
            opzioni[i].setSize(155, 30);
            opzioni[i].setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
            opzioni[i].setContentAreaFilled(false);
            opzioni[i].setFocusPainted(false);
            opzioni[i].setBorder(BorderFactory.createMatteBorder(5,5,5,5,Color.DARK_GRAY));
            opzioni[i].setEnabled(false);
            opzioni[i].setFont(new Font("Serif", Font.ITALIC, 15));
            opzioni[i].setBackground(Color.gray);
            opzioni[i].setForeground(Color.BLACK);
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
        frame.add(myPet);
        frame.add(enemyPet);
        frame.add(namePet);
        frame.add(level);
        frame.add(levelEnemy);
        frame.add(namePetEnemy);
        frame.add(life);
        frame.add(lifeEnemy);
        frame.add(myTrainer);
        frame.add(enemyTrainer);
        frame.add(sfondo);
    }

    public GifFrame getGifFrame() {
        return gifFrame;
    }

    public void setGifFrame(GifFrame gifFrame) {
        this.gifFrame = gifFrame;
    }

    public JButton getLife() {
        return life;
    }

    public void setLife(JButton life) {
        this.life = life;
    }

    public JButton getLevel() {
        return level;
    }

    public void setLevel(JButton level) {
        this.level = level;
    }

    public JButton getLifeEnemy() {
        return lifeEnemy;
    }

    public void setLifeEnemy(JButton lifeEnemy) {
        this.lifeEnemy = lifeEnemy;
    }

    public JButton getLevelEnemy() {
        return levelEnemy;
    }

    public void setLevelEnemy(JButton levelEnemy) {
        this.levelEnemy = levelEnemy;
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

    public int getNextPet() {
        return nextPet;
    }

    public void setNextPet(int nextPet) {
        this.nextPet += nextPet;
    }

    public int getNextPetEnemy() {
        return nextPetEnemy;
    }

    public void setNextPetEnemy(int nextPetEnemy) {
        this.nextPetEnemy += nextPetEnemy;
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

    public JButton getNamePet() {
        return namePet;
    }

    public void setNamePet(JButton namePet) {
        this.namePet = namePet;
    }

    public JButton getNamePetEnemy() {
        return namePetEnemy;
    }

    public void setNamePetEnemy(JButton namePetEnemy) {
        this.namePetEnemy = namePetEnemy;
    }
}