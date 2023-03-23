package model.entities;
import javax.swing.*;
import java.awt.*;
public class BattleWindows {
    private static final int width = 700;
    private static final int eight = 440;
    private  ImageIcon icon = new ImageIcon("C:\\Users\\magre_a244ufq\\Desktop\\MyJava\\\\src\\game\\immagini/sfondo_lotta_livello_1.png");
    private JLabel sfondo= new JLabel(icon);
    private JTextArea tx = new JTextArea();
    private JButton showLife,showLifeEnemy,myTrainer,enemyTrainer,myPet,enemyPet;
    private JCheckBoxMenuItem[] opzioni= new JCheckBoxMenuItem[3];
    private ButtonGroup bg = new ButtonGroup();
    private JFrame frame;


    public BattleWindows(){
        frame = new JFrame("its time to fight!");
        Dimension dimension = new Dimension(width,eight);
        frame.setVisible(true);
        frame.setSize(width,eight);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        sfondo.setSize(dimension);

        frame.setBackground(Color.BLUE);

        tx.setLocation(92,280);
        tx.setSize(500,110);
        tx.setBackground(Color.black);
        tx.setForeground(Color.yellow);
        tx.setEditable(false);

        showLife = new JButton();
        showLife.setSize(120,30);
        showLife.setBackground(Color.black);
        showLife.setForeground(Color.yellow);

        showLifeEnemy = new JButton();
        showLifeEnemy.setSize(120,30);
        showLifeEnemy.setBackground(Color.black);
        showLifeEnemy.setForeground(Color.yellow);

        myPet = new JButton();
        myPet.setSize(50,50);

        enemyPet = new JButton();
        enemyPet.setSize(50,50);

        myTrainer = new JButton();
        myTrainer.setSize(80,100);

        enemyTrainer= new JButton();
        enemyTrainer.setSize(80,100);

        showLife.setLocation(60,10);
        showLifeEnemy.setLocation(510,10);
        myPet.setLocation(10,10);
        enemyPet.setLocation(630,10);
        myTrainer.setLocation(5, 290);
        enemyTrainer.setLocation(600, 290);

        for(int i=0; i< opzioni.length; i++) {
            opzioni[i]= new JCheckBoxMenuItem();
            bg.add(opzioni[i]);
            frame.add(opzioni[i]);
            opzioni[i].setLocation(120+(i*120), 180+i);
            opzioni[i].setSize(120, 30);
            opzioni[i].setBackground(Color.black);
            opzioni[i].setForeground(Color.yellow);
        }

        frame.add(tx);
        frame.add(showLife);
        frame.add(showLifeEnemy);
        frame.add(myPet);
        frame.add(enemyPet);
        frame.add(myTrainer);
        frame.add(enemyTrainer);
        frame.add(sfondo);

    }

    public JFrame getFrame() {
        return frame;
    }

    public void setFrame(JFrame frame) {
        this.frame = frame;
    }

    public JCheckBoxMenuItem[] getOpzioni() {
        return opzioni;
    }

    public void setOpzioni(JCheckBoxMenuItem[] opzioni) {
        this.opzioni = opzioni;
    }

    public ButtonGroup getBg() {
        return bg;
    }

    public void setBg(ButtonGroup bg) {
        this.bg = bg;
    }

    public ImageIcon getIcon() {
        return icon;
    }

    public void setIcon(ImageIcon icon) {
        this.icon = icon;
    }

    public JLabel getSfondo() {
        return sfondo;
    }

    public void setSfondo(JLabel sfondo) {
        this.sfondo = sfondo;
    }

    public JTextArea getTx() {
        return tx;
    }

    public void setTx(JTextArea tx) {
        this.tx = tx;
    }

    public JButton getShowLife() {
        return showLife;
    }

    public void setShowLife(JButton showLife) {
        this.showLife = showLife;
    }

    public JButton getShowLifeEnemy() {
        return showLifeEnemy;
    }

    public void setShowLifeEnemy(JButton showLifeEnemy) {
        this.showLifeEnemy = showLifeEnemy;
    }

    public JButton getMyTrainer() {
        return myTrainer;
    }

    public void setMyTrainer(JButton myTrainer) {
        this.myTrainer = myTrainer;
    }

    public JButton getEnemyTrainer() {
        return enemyTrainer;
    }

    public void setEnemyTrainer(JButton enemyTrainer) {
        this.enemyTrainer = enemyTrainer;
    }

    public JButton getMyPet() {
        return myPet;
    }

    public void setMyPet(JButton myPet) {
        this.myPet = myPet;
    }

    public JButton getEnemyPet() {
        return enemyPet;
    }

    public void setEnemyPet(JButton enemyPet) {
        enemyPet = enemyPet;
    }

}
