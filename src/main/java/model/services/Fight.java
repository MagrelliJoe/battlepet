package model.services;
import model.data.abstracted.Repository;
import model.data.implementation.RepositotyP;
import model.entities.Pet;
public class Fight {
    Repository repo = new RepositotyP();
    public void Fight(Pet pet, Pet pet_){
        while(!repo.isDead(pet_)) {
            repo.viewLifeRemain(pet);
            repo.viewLifeRemain(pet_);
            System.out.println(pet.getLife());
            System.out.println(pet_.getLife());
            Pet petMostSpeed = repo.whoAttackFirst(pet,pet_);
            if(petMostSpeed.equals(pet)) {
                repo.turnMy(pet,pet_);
                repo.turnEnemy(pet_, pet);
            }else{
                repo.turnEnemy(pet_, pet);
                repo.turnMy(pet,pet_);
            }

        }

    }
}
