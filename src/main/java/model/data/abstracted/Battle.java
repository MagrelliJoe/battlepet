package model.data.abstracted;
import model.entities.Attack;
import model.entities.Person;
import model.entities.Pet;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.util.List;

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
