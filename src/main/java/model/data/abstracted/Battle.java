package model.data.abstracted;
import model.data.entities.Attack;
import model.data.entities.Pet;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public interface Battle {
    void viewCommentAttack(Pet pet,int damage, int shelter,String attackName) throws UnsupportedAudioFileException, LineUnavailableException, IOException;
    Pet whoAttackFirst(Pet pet_att, Pet pet_def);
    String viewLifeRemain(Pet pet);
    void turnEnemy(Pet pet,Pet pet_) throws UnsupportedAudioFileException, LineUnavailableException, IOException;
    boolean isDead(Pet pet);
    boolean numOfAvailabilityIsFinish(Attack attack);
    void addNewAttack(Pet pet,Attack attack);
    Attack newAttackByType(Pet pet);

}
