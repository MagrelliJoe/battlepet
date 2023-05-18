package model.data.entities;
import javax.swing.*;
import java.awt.*;

public class TeamFrame {
    private static final int width = 300;
    private static final int eight = 400;
    private JFrame frame;
    private ImageIcon[] icons = new ImageIcon[7];
    private JButton[] buttons = new JButton[7];
    private JLabel[] labels = new JLabel[6];
    private JLabel sfondo;
    private Icon iconSfondo;

    public TeamFrame() {
        Dimension dimension = new Dimension(width, eight);
        this.frame = new JFrame("TRAINER PET'S TEAM");
        iconSfondo = new ImageIcon(Constant.sfondoMyTeam);
        sfondo = new JLabel(iconSfondo);
        sfondo.setSize(dimension);
        frame.setSize(dimension);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setResizable(false);
        frame.setVisible(false);

        for (int i = 0; i < buttons.length-1; i++) {

                buttons[i] = new JButton(icons[i]);
                buttons[i].setSize(40, 40);
                buttons[i].setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, Color.DARK_GRAY));
                labels[i] = new JLabel();
                labels[i].setSize(180, 35);
                labels[i].setFont(new Font("Serif", Font.ITALIC, 15));
                labels[i].setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, Color.DARK_GRAY));
                frame.add(buttons[i]);
                frame.add(labels[i]);
                buttons[i].setLocation(10, 50 * i);
                labels[i].setLocation(10 + 50, 50 * i);
            }

            icons[6] = new ImageIcon(Constant.allenatoreMyDavid);
            buttons[6] = new JButton(icons[6]);
            buttons[6].setSize(70, 70);
            buttons[6].setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, Color.DARK_GRAY));
            buttons[6].setLocation(100,290);
            frame.add(buttons[6]);
            frame.add(sfondo);
        }

    public JFrame getFrame() {
        return frame;
    }

    public void setFrame(JFrame frame) {
        this.frame = frame;
    }

    public JButton[] getButtons() {
        return buttons;
    }

    public JLabel[] getLabels() {
        return labels;
    }

    public JLabel getSfondo() {
        return sfondo;
    }

    public void setSfondo(JLabel sfondo) {
        this.sfondo = sfondo;
    }

}

