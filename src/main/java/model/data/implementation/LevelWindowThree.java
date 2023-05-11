package model.data.implementation;
import model.data.abstracted.LevelWindow;
import model.data.entities.Person;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.awt.event.KeyEvent;
import java.io.IOException;

public class LevelWindowThree extends LevelWindow {
    public LevelWindowThree(String filePathImage, String fileMusicPath, String fileMusicPathMessage, int width, int eight) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        super(filePathImage, fileMusicPath, fileMusicPathMessage, width, eight);
    }

    @Override
    public void SetFightPosition(int posX, int posY, Person trainer, String comment, String comment2) throws UnsupportedAudioFileException, LineUnavailableException, IOException, InterruptedException {

    }

    @Override
    public void SetTalkingPosition(int posX, int posY, String comment) {

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
