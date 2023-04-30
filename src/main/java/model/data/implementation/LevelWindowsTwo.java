package model.data.implementation;

import model.data.abstracted.LevelWindow;
import model.data.entities.Person;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.awt.event.KeyEvent;
import java.io.IOException;

public class LevelWindowsTwo extends LevelWindow {


    public LevelWindowsTwo(String filePathImage, String fileMusicPath, String fileMusicPathMessage, int numOfNeon, int width, int eight) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        super(filePathImage, fileMusicPath, fileMusicPathMessage, numOfNeon, width, eight);
    }

    @Override
    public void SetFightPosition(int posX, int posY, Person trainer,String comment) throws UnsupportedAudioFileException, LineUnavailableException, IOException {

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
