package model.data.implementation;
import model.data.abstracted.Repository;
import model.entities.Levels;
import model.entities.Person;
import model.entities.Pet;


public class RepositotyP implements Repository {
    @Override
    public void attack(Pet pet_att,Pet pet_def) {
        pet_def.setLife(pet_def.getDefense() - pet_att.getPower());
    }

    @Override
    public void chooseAttack(Pet pet_att, Pet pet_def) {
        if( pet_att.getSpeed() > pet_def.getSpeed()){
            attack(pet_att,pet_def);
        }else{
            attack(pet_def,pet_att);
        }
    }




}
