package model.data.implementation;

import model.data.abstracted.LevelWindow;
import model.data.entities.Constant;
import model.data.entities.ConstantPet;
import model.data.entities.Person;
import model.data.entities.Pet;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.IOException;

public class WindowChoosePet extends LevelWindow implements ActionListener {
    private JButton pet1,pet2,pet3;
    private JLabel pet1Name,pet2Name,pet3Name;
    private String sex;
    private Person mineTrainer;
    public WindowChoosePet(String filePathImage, String fileMusicPath, String fileMusicPathMessage, int numOfNeon, int width, int eight,String sex,Person mineTrainer) throws UnsupportedAudioFileException, IOException, LineUnavailableException {

        super(filePathImage, fileMusicPath, fileMusicPathMessage, numOfNeon, width, eight);
        this.sex = sex;
        this.mineTrainer = mineTrainer;
        super.myTrainer.setVisible(false);

        pet1 = new JButton(new ImageIcon());
        pet1.setBorder(BorderFactory.createMatteBorder(8,8,8,8, Color.black));
        pet1.setSize(100, 100);
        pet1.setLocation(50,50);
        pet1.addActionListener(this);
        pet1.setActionCommand("pet1");

        pet2 = new JButton(new ImageIcon());
        pet2.setBorder(BorderFactory.createMatteBorder(8,8,8,8, Color.blue));
        pet2.setSize(100, 100);
        pet2.setLocation(200,50);
        pet2.addActionListener(this);
        pet2.setActionCommand("pet2");

        pet3 = new JButton(new ImageIcon());
        pet3.setBorder(BorderFactory.createMatteBorder(8,8,8,8, Color.red));
        pet3.setSize(100, 100);
        pet3.setLocation(350,50);
        pet3.addActionListener(this);
        pet3.setActionCommand("pet3");

        pet1Name = new JLabel();
        pet1Name.setBorder(BorderFactory.createMatteBorder(8,8,8,8, Color.black));
        pet1Name.setSize(100, 30);
        pet1Name.setLocation(50,180);

        pet2Name = new JLabel();
        pet2Name.setBorder(BorderFactory.createMatteBorder(8,8,8,8, Color.blue));
        pet2Name.setSize(100, 30);
        pet2Name.setLocation(200,180);

        pet3Name = new JLabel();
        pet3Name.setBorder(BorderFactory.createMatteBorder(8,8,8,8, Color.red));
        pet3Name.setSize(100, 30);
        pet3Name.setLocation(350,180);

        if(getSex().equalsIgnoreCase("F")){
            pet1.setIcon(new ImageIcon(Constant.mia));
            pet2.setIcon(new ImageIcon(Constant.pepita));
            pet3.setIcon(new ImageIcon(Constant.vito));
            pet1Name.setText("MIA");
            pet2Name.setText("PEPITA");
            pet3Name.setText("TOM");
        }else{
            pet1.setIcon(new ImageIcon(Constant.pulce));
            pet2.setIcon(new ImageIcon(Constant.bianca));
            pet3.setIcon(new ImageIcon(Constant.gomitolo));
            pet1Name.setText("PULCE");
            pet2Name.setText("BIANCA");
            pet3Name.setText("JERRY");
        }

        frame.add(pet1);
        frame.add(pet2);
        frame.add(pet3);
        frame.add(pet1Name);
        frame.add(pet2Name);
        frame.add(pet3Name);
        frame.add(sfondo);

    }

    @Override
    public void SetFightPosition(int posX, int posY, Person trainer, String comment) throws UnsupportedAudioFileException, LineUnavailableException, IOException, InterruptedException {
        //DO NOTHING
    }

    @Override
    public void keyTyped(KeyEvent e) {
       //DO NOTHING
    }

    @Override
    public void keyPressed(KeyEvent e) {
        //DO NOTHING
    }

    @Override
    public void keyReleased(KeyEvent e) {
        //DO NOTHING
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch(getSex()) {
            case "F":
               if ("pet1".equals(e.getActionCommand())) {
                   addPetAtTeam(mineTrainer, new Pet(ConstantPet.mia));
               }else if ("pet2".equals(e.getActionCommand())) {
                   addPetAtTeam(mineTrainer, new Pet(ConstantPet.pepita));
               }else if ("pet2".equals(e.getActionCommand())) {
                   addPetAtTeam(mineTrainer, new Pet(ConstantPet.vito));
               }
            break;
            case "M":
                if ("pet1".equals(e.getActionCommand())) {
                    addPetAtTeam(mineTrainer, new Pet(ConstantPet.pulce));
                } else if ("pet2".equals(e.getActionCommand())) {
                    addPetAtTeam(mineTrainer, new Pet(ConstantPet.bianca));
                } else if ("pet2".equals(e.getActionCommand())) {
                    addPetAtTeam(mineTrainer, new Pet(ConstantPet.iron));
                }
            break;
        }
    }

    public JButton getPet1() {
        return pet1;
    }

    public void setPet1(JButton pet1) {
        this.pet1 = pet1;
    }

    public JButton getPet2() {
        return pet2;
    }

    public void setPet2(JButton pet2) {
        this.pet2 = pet2;
    }

    public JButton getPet3() {
        return pet3;
    }

    public void setPet3(JButton pet3) {
        this.pet3 = pet3;
    }

    public JLabel getPet1Name() {
        return pet1Name;
    }

    public void setPet1Name(JLabel pet1Name) {
        this.pet1Name = pet1Name;
    }

    public JLabel getPet2Name() {
        return pet2Name;
    }

    public void setPet2Name(JLabel pet2Name) {
        this.pet2Name = pet2Name;
    }

    public JLabel getPet3Name() {
        return pet3Name;
    }

    public void setPet3Name(JLabel pet3Name) {
        this.pet3Name = pet3Name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
