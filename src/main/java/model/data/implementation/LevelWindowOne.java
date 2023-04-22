package model.data.implementation;
import model.data.abstracted.LevelWindow;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class LevelWindowOne extends LevelWindow {
    public LevelWindowOne(String filePathImage, String fileMusicPath, String fileMusicPathMessage) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        super(filePathImage, fileMusicPath, fileMusicPathMessage);
    }

}
