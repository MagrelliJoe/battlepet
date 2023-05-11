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
    public WindowChoosePet(String filePathImage, String fileMusicPath, String fileMusicPathMessage,int width, int eight,String sex,Person mineTrainer) throws UnsupportedAudioFileException, IOException, LineUnavailableException {

        super(filePathImage, fileMusicPath, fileMusicPathMessage,width, eight);
        this.sex = sex;
        this.mineTrainer = mineTrainer;
        super.myTrainer.setVisible(false);
        frame.setTitle("CHOOSE YOUR PET!");

        pet1 = new JButton(new ImageIcon());
        pet1.setBorder(BorderFactory.createMatteBorder(20,22,20,22, Color.black));
        pet1.setSize(100, 100);
        pet1.setLocation(50,50);
        pet1.addActionListener(this);
        pet1.setActionCommand("pet1");

        pet2 = new JButton(new ImageIcon());
        pet2.setBorder(BorderFactory.createMatteBorder(20,22,20,22, Color.blue));
        pet2.setSize(100, 100);
        pet2.setLocation(200,50);
        pet2.addActionListener(this);
        pet2.setActionCommand("pet2");

        pet3 = new JButton(new ImageIcon());
        pet3.setBorder(BorderFactory.createMatteBorder(20,22,20,22, Color.red));
        pet3.setSize(100, 100);
        pet3.setLocation(350,50);
        pet3.addActionListener(this);
        pet3.setActionCommand("pet3");

        pet1Name = new JLabel();
        pet1Name.setBorder(BorderFactory.createMatteBorder(4,4,4,4, Color.black));
        pet1Name.setBackground(Color.black);
        pet1Name.setForeground(Color.white);
        pet1Name.setOpaque(true);
        pet1Name.setSize(100, 30);
        pet1Name.setLocation(50,180);
        pet1Name.setFont(new Font("Serif", Font.BOLD, 18));

        pet2Name = new JLabel();
        pet2Name.setBorder(BorderFactory.createMatteBorder(4,4,4,4, Color.blue));
        pet2Name.setBackground(Color.blue);
        pet2Name.setForeground(Color.white);
        pet2Name.setOpaque(true);
        pet2Name.setSize(100, 30);
        pet2Name.setLocation(200,180);
        pet2Name.setFont(new Font("Serif", Font.BOLD, 18));

        pet3Name = new JLabel();
        pet3Name.setBorder(BorderFactory.createMatteBorder(4,4,4,4, Color.red));
        pet3Name.setBackground(Color.red);
        pet3Name.setForeground(Color.white);
        pet3Name.setOpaque(true);
        pet3Name.setSize(100, 30);
        pet3Name.setLocation(350,180);
        pet3Name.setFont(new Font("Serif", Font.BOLD, 18));

        if(getSex().equalsIgnoreCase("F")){
            pet1.setIcon(new ImageIcon(Constant.mia));
            pet2.setIcon(new ImageIcon(Constant.pepita));
            pet3.setIcon(new ImageIcon(Constant.tom));
            pet1Name.setText("MIA");
            pet2Name.setText("PEPITA");
            pet3Name.setText("TOM");
        }else{
            pet1.setIcon(new ImageIcon(Constant.pulce));
            pet2.setIcon(new ImageIcon(Constant.bianca));
            pet3.setIcon(new ImageIcon(Constant.jerry));
            pet1Name.setText("PULCE");
            pet2Name.setText("BIANCA");
            pet3Name.setText("JERRY");
        }
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.add(pet1);
        frame.add(pet2);
        frame.add(pet3);
        frame.add(pet1Name);
        frame.add(pet2Name);
        frame.add(pet3Name);
        frame.add(sfondo);

    }

    @Override
    public void SetFightPosition(int posX, int posY, Person trainer, String comment1,String comment2) throws UnsupportedAudioFileException, LineUnavailableException, IOException, InterruptedException {
        //DO NOTHING
    }

    @Override
    public void SetTalkingPosition(int posX, int posY, String comment) {

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
               }else if ("pet3".equals(e.getActionCommand())) {
                   addPetAtTeam(mineTrainer, new Pet(ConstantPet.tom));
               }
                frame.dispose();
                music.stop();
                break;

            case "M":
                if ("pet1".equals(e.getActionCommand())) {
                    addPetAtTeam(mineTrainer, new Pet(ConstantPet.pulce));
                } else if ("pet2".equals(e.getActionCommand())) {
                    addPetAtTeam(mineTrainer, new Pet(ConstantPet.bianca));
                } else if ("pet3".equals(e.getActionCommand())) {
                    addPetAtTeam(mineTrainer, new Pet(ConstantPet.jerry));
                }
                frame.dispose();
                music.stop();
                break;
        }
    }

    public String getSex() {
        return sex;
    }
}
