package model.entities;

import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class GifFrame {
    private static final int width = 185;
    private static final int eight = 185;
    private JFrame frame;
    private ImageIcon icon;
    private JLabel sfondo = new JLabel(icon);
    private AudioInputStream audioInputStreamMusic;
    private Clip music;
    private File audioMusic;
    private String filePathImage;

    public GifFrame() {
        Dimension dimension = new Dimension(width, eight);
        this.frame = new JFrame();
        frame.setSize(width, eight);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setVisible(false);
        frame.add(sfondo);
    }

    public void createMusicforFrame(String fileMusicPath) throws UnsupportedAudioFileException, IOException, LineUnavailableException {

        this.audioMusic = new File(fileMusicPath);
        this.audioInputStreamMusic = AudioSystem.getAudioInputStream(this.audioMusic);
        this.music = AudioSystem.getClip();
        this.music.open(this.audioInputStreamMusic);
        this.music.loop(1);
    }

    public JFrame getFrame() {
        return frame;
    }

    public void setFrame(JFrame frame) {
        this.frame = frame;
    }

    public ImageIcon getIcon() {
        return icon;
    }

    public void setIcon(ImageIcon icon) {
        this.icon = icon;
    }

    public JLabel getSfondo() {
        return sfondo;
    }

    public void setSfondo(JLabel sfondo) {
        this.sfondo = sfondo;
    }

    public AudioInputStream getAudioInputStreamMusic() {
        return audioInputStreamMusic;
    }

    public void setAudioInputStreamMusic(AudioInputStream audioInputStreamMusic) {
        this.audioInputStreamMusic = audioInputStreamMusic;
    }

    public Clip getMusic() {
        return music;
    }

    public void setMusic(Clip music) {
        this.music = music;
    }

    public File getAudioMusic() {
        return audioMusic;
    }

    public void setAudioMusic(File audioMusic) {
        this.audioMusic = audioMusic;
    }

    public String getFilePathImage() {
        return filePathImage;
    }

    public void setFilePathImage(String filePathImage) {
        this.filePathImage = filePathImage;
    }

}
