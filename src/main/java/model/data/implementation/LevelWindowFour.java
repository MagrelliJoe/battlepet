package model.data.implementation;

import model.data.abstracted.LevelWindow;
import model.data.entities.*;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;
import java.util.Random;

public class LevelWindowFour extends LevelWindow {
    private Person mineTrainer;
    private String sex;
    private JLabel trainer0,trainer1,trainer2,trainer3,trainer4,prof;
    private static  Person trn0 = new Person(Constant.allenatore8Lotta,"Saro", Levels.START);
    private static Person trn1 = new Person(Constant.allenatore10Lotta,"Leon",Levels.START);
    private static Person trn2 = new Person(Constant.allenatore11Lotta,"Lara",Levels.MEDIUM);
    private static Person trn3 = new Person(Constant.allenatore12Lotta,"Claire",Levels.MEDIUM);
    private static Person trn4 = new Person(Constant.allenatoreRenatoLotta,"Renato",Levels.MEDIUM);

    public LevelWindowFour(String filePathImage, String fileMusicPath, String fileMusicPathMessage, int width, int eight,String sex,Person mineTrainer) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        super(filePathImage, fileMusicPath, fileMusicPathMessage, width, eight);
        this.sex = sex;
        this.mineTrainer = mineTrainer;
        setPosition_x(25);
        setPosition_y(250);
        frame.setTitle("MEOWMEOW CITY");
        frame.addKeyListener(this);
        getMyTrainer().setLocation(getPosition_x(),getPosition_y());

        if(this.sex.equalsIgnoreCase("F")) {
            getTeamFrame().getButtons()[6].setIcon(new ImageIcon(Constant.allenatoreMyAlycia));
            myTrainer.setIcon(new ImageIcon(Constant.pgFemaleUp2));
        }else{
            myTrainer.setIcon(new ImageIcon(Constant.pgMaleUp2));
        }

        addPetAtTeam(trn0,new Pet(ConstantPet.leo));
        addPetAtTeam(trn1,new Pet(ConstantPet.mewcat));
        addPetAtTeam(trn1,new Pet(ConstantPet.gomitolo));
        addPetAtTeam(trn1,new Pet(ConstantPet.leo));
        addPetAtTeam(trn2,new Pet(ConstantPet.leo));
        addPetAtTeamWithoutLevel(trn2,new Pet(ConstantPet.black),Levels.START);
        addPetAtTeamWithoutLevel(trn2,new Pet(ConstantPet.gomitolo),Levels.START);
        addPetAtTeam(trn3,new Pet(ConstantPet.mewcat));
        addPetAtTeam(trn3,new Pet(ConstantPet.black));
        addPetAtTeam(trn4,new Pet(ConstantPet.black));
        addPetAtTeam(trn4,new Pet(ConstantPet.gomitolo));
        addPetAtTeam(trn4,new Pet(ConstantPet.king));

        trainer0 = new JLabel(new ImageIcon(Constant.allenatore8));
        trainer0.setSize(40,57);
        trainer0.setLocation(470,225);

        trainer1 = new JLabel(new ImageIcon(Constant.allenatore10));
        trainer1.setSize(40,57);
        trainer1.setLocation(815,230);

        trainer2 = new JLabel(new ImageIcon(Constant.allenatore11));
        trainer2.setSize(40,57);
        trainer2.setLocation(720,405);

        trainer3 = new JLabel(new ImageIcon(Constant.allenatore12));
        trainer3.setSize(40,57);
        trainer3.setLocation(80,410);

        trainer4 = new JLabel(new ImageIcon(Constant.allenatoreRenato));
        trainer4.setSize(40,57);
        trainer4.setLocation(610,510);

        prof = new JLabel(new ImageIcon(Constant.prof));
        prof.setSize(40,57);
        prof.setLocation(340,200);

        frame.add(prof);
        frame.add(trainer0);
        frame.add(trainer1);
        frame.add(trainer2);
        frame.add(trainer3);
        frame.add(trainer4);
        frame.add(sfondo);
    }

    @Override
    public void SetFightPosition(int posX, int posY, Person trainer, String comment, String comment2) throws UnsupportedAudioFileException, LineUnavailableException, IOException, InterruptedException {

        if (getMyTrainer().getX() == posX && getMyTrainer().getY() == posY) {

            if (!trainer.getName().equalsIgnoreCase("renato") && getMyTrainer().getX()
                    == posX && getMyTrainer().getY() == posY && trainer.getNumberOfLosses() < 2) {

                super.musicMessage.start();
                JOptionPane.showMessageDialog(null, trainer.getName() + ":" + "\n" + comment);
                battle = new ServiceForBattle(mineTrainer, trainer, new BattleWindow(Constant.sfondoLotta1, Constant.musicalotta));
                updateTeamShow(mineTrainer);

            }else if(trainer.getName().equalsIgnoreCase("renato") && getMyTrainer().getX()
                    == posX && getMyTrainer().getY() == posY && trainer.getNumberOfLosses() < 1) {

                super.musicMessage.start();
                JOptionPane.showMessageDialog(null, trainer.getName() + ":" + "\n" + comment);
                battle = new ServiceForBattle(mineTrainer, trainer, new BattleWindow(Constant.sfondoLotta1, Constant.musicalotta1));
                updateTeamShow(mineTrainer);

            }

            battle.getBattle().getFrame().addWindowListener(new WindowListener() {
                @Override
                public void windowOpened(WindowEvent e) {
                    music.stop();
                }

                @Override
                public void windowClosing(WindowEvent e) {

                }

                @Override
                public void windowClosed(WindowEvent e) {
                    music.loop(3);
                    if (trainer.getName().equalsIgnoreCase("renato") && trainer.getNumberOfLosses() == 1) {
                        getEndGame().setVisible(true);
                        getEndGame().setLocation(695, 580);
                        getLeader().getTextAreas()[1].setFont(new Font("Serif", Font.BOLD, 20));
                        getLeader().getTextAreas()[1].setText("SCONFITTO");
                    }
                }

                @Override
                public void windowIconified(WindowEvent e) {
                    //DO NOTHING
                }

                @Override
                public void windowDeiconified(WindowEvent e) {
                    //DO NOTHING
                }

                @Override
                public void windowActivated(WindowEvent e) {
                    //DO NOTHING
                }

                @Override
                public void windowDeactivated(WindowEvent e) {
                    //DO NOTHING
                }
            });

        } else if (getMyTrainer().getX() == posX && getMyTrainer().getY() == posY && trainer.getNumberOfLosses() >= 2) {

            JOptionPane.showMessageDialog(null, trainer.getName() + ":" + "\n" + comment2);
        }

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

        try {
            SetTalkinWithProf(340, 235);
            SetFightPosition(725, 440, trn2, "Mio papà ama i Pet di tipo Cat,come me!", "Mia mamma invece quelli di tipo Rabbit!");
            SetFightPosition(815, 265, trn1, "Ho raggiunto sedici vittorie è la prof.ssa Alice mi ha regalato un Pet di tipo Cat!", "Puoi fartelo donare anche tu!Basta raggiungere un tot di vittorie!");
            SetFightPosition(475, 270, trn0, "Finalmente sono qua!Devo assolutamente battere Renato con il mio nuovo Pet!", "Perchè con te perdo sempre?!?");
            SetFightPosition(80, 450, trn3, "I Pet di tipo Cat sono cosi' carini,non trovi?", "Anche quelli di tipo Rabbit sono cosi' dolci!!!");
            SetFightPosition(610, 540, trn4, "Eccomi,sono il Leader di MeowMeow City!Utilizzo solo Pet di tipo Cat perchè hanno una difesa d'acciaio!Riuscirai a scalfirli?", "Bravissimo,hai trovato il modo!" + "\n" +
                    "Hai già parlato con la prof.ssa Alice?Avrà una sorpresa per te!La trovi nei pressi del vortice di cambio zona!");
            updateTeamShow(mineTrainer);
        } catch (UnsupportedAudioFileException | LineUnavailableException | IOException | InterruptedException ex) {
            throw new RuntimeException(ex);
        }

        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            position_x -= 5;
            switch (getSex()) {
                case "M":
                    if (position_x % 2 == 0) {
                        super.myTrainer.setIcon(new ImageIcon(Constant.pgMaleSx2));
                    } else {
                        super.myTrainer.setIcon(new ImageIcon(Constant.pgMaleSx1));
                    }
                    break;
                case "F":
                    if (position_x % 2 == 0) {
                        super.myTrainer.setIcon(new ImageIcon(Constant.pgFemaleSx1));
                    } else {
                        super.myTrainer.setIcon(new ImageIcon(Constant.pgFemaleSx2));
                    }
                    break;
            }
            super.myTrainer.setLocation(position_x, position_y);
        }
            if (e.getKeyCode() == KeyEvent.VK_UP) {
                position_y -= 5;
                System.out.println(getPosition_x());
                System.out.println(getPosition_y());
                switch (getSex()) {
                    case "M":
                        if (position_y % 2 == 0) {
                            super.myTrainer.setIcon(new ImageIcon(Constant.pgMaleUp1));
                        } else {
                            super.myTrainer.setIcon(new ImageIcon(Constant.pgMaleUp2));
                        }
                        break;
                    case "F":
                        if (position_y % 2 == 0) {
                            super.myTrainer.setIcon(new ImageIcon(Constant.pgFemaleUp1));
                        } else {
                            super.myTrainer.setIcon(new ImageIcon(Constant.pgFemaleUp2));
                        }
                        break;
                }
                super.myTrainer.setLocation(position_x, position_y);
            }

            if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                position_y += 5;
                System.out.println(getPosition_x());
                System.out.println(getPosition_y());
                switch (getSex()) {
                    case "M":
                        if (position_y % 2 == 0) {
                            super.myTrainer.setIcon(new ImageIcon(Constant.pgMaleDown2));
                        } else {
                            super.myTrainer.setIcon(new ImageIcon(Constant.pgMaleDown1));
                        }
                        break;
                    case "F":
                        if (position_y % 2 == 0) {
                            super.myTrainer.setIcon(new ImageIcon(Constant.pgFemaleDown1));
                        } else {
                            super.myTrainer.setIcon(new ImageIcon(Constant.pgFemaleDown2));
                        }
                        break;
                }
                super.myTrainer.setLocation(position_x, position_y);
            }

            if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                position_x += 5;
                System.out.println(getPosition_x());
                System.out.println(getPosition_y());
                switch (getSex()) {
                    case "M":
                        if (position_x % 2 == 0) {
                            super.myTrainer.setIcon(new ImageIcon(Constant.pgMaleDx1));
                        } else {
                            super.myTrainer.setIcon(new ImageIcon(Constant.pgMaleDx2));
                        }
                        break;
                    case "F":
                        if (position_x % 2 == 0) {
                            super.myTrainer.setIcon(new ImageIcon(Constant.pgFemaleDx1));
                        } else {
                            super.myTrainer.setIcon(new ImageIcon(Constant.pgFemaleDx2));
                        }
                        break;
                }
                super.myTrainer.setLocation(position_x, position_y);
            }

            if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                super.getTeamFrame().getFrame().setVisible(true);
            }

            if (e.getKeyCode() == KeyEvent.VK_L) {
                super.getLeader().getFrame().setVisible(true);
            }

            if (endGame.isVisible() && position_x == 695 && position_y == 580) {
                frame.dispose();
                music.stop();
                try {
                    new LevelWindowThree(Constant.sfondoRoute2, Constant.musicaRoute2, Constant.messaggio, 1000, 333, getSex(), mineTrainer);
                } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
                    throw new RuntimeException(ex);
                }
            }

        }

        @Override
        public void keyReleased (KeyEvent e){

        }

        private void SetTalkinWithProf ( int posX, int posY){

            if (getPosition_x() == posX && getPosition_y() == posY && mineTrainer.getVictory() >= 16
                    && mineTrainer.getPetList().size() <= 2) {
                JOptionPane.showMessageDialog(null,
                        "Complimenti!Hai raggiunto tante vittorie.Tuttavia la strada si farà sempre più ardua man mano che" + "\n" +
                                "avanzerai!Ecco perchè sono qui!Ogni volta che raggiungerai un tot numero di vittorie vieni da me " + "\n" +
                                "ti consegnerò personalmente un Pet che verrà aggiunto al tuo Team!Ecco tieni!.Trattalo con cura " + "\n" +
                                "vedrai che ti sarà di grande aiuto!See you soon!");
                Random random = new Random();
                int nRandom = random.nextInt(3);
                if (getSex().equalsIgnoreCase("M")) {
                    switch (nRandom) {
                        case 0:
                            mineTrainer.addPet(2, new Pet(ConstantPet.king));
                            break;
                        case 1:
                            mineTrainer.addPet(2, new Pet(ConstantPet.gomitolo));
                            break;
                        case 2:
                            mineTrainer.addPet(2, new Pet(ConstantPet.mewcat));
                            break;
                    }
                }
                switch (nRandom) {
                    case 0:
                        mineTrainer.addPet(2, new Pet(ConstantPet.king));
                        break;
                    case 1:
                        mineTrainer.addPet(2, new Pet(ConstantPet.leo));
                        break;
                    case 2:
                        mineTrainer.addPet(2, new Pet(ConstantPet.black));
                        break;
                }
                JOptionPane.showMessageDialog(null, mineTrainer.getPetList().get(2).getName() + " E' STATO AGGIUNTO AL TUO TEAM!");
            } else if (getPosition_x() == posX && getPosition_y() == posY && mineTrainer.getVictory() < 16) {

                JOptionPane.showMessageDialog(null,
                        "Torna da me quando avrai raggiunto SEDICI vittorie!");

            } else if (getPosition_x() == posX && getPosition_y() == posY && mineTrainer.getVictory() >= 16
                    && mineTrainer.getPetList().size() > 2) {
                JOptionPane.showMessageDialog(null,
                        "Divertiti con il tuo nuovo Pet!Ci vediamo in giro nelle prossime città!");
            }

        }
        public String getSex () {
            return sex;
        }

}
