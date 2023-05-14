package model.data.entities;
import javax.swing.*;
import java.awt.*;

public class WindowLeader {
    private static final int width = 300;
    private static final int eight = 450;
    private JFrame frame;
    private JLabel sfondo;
    private Icon iconSfondo;
    private JButton[] buttons = new JButton[6];
    private ImageIcon[] icons = new ImageIcon[6];
    private JTextArea[] textAreas = new JTextArea[8];

    public WindowLeader() {
        Dimension dimension = new Dimension(width, eight);
        this.frame = new JFrame("LEADER");
        iconSfondo = new ImageIcon("images/sfondoMyTeam.jpg");
        sfondo = new JLabel(iconSfondo);
        sfondo.setSize(dimension);
        frame.setSize(dimension);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setResizable(false);
        frame.setVisible(false);

        for (int i = 0; i < buttons.length-1; i++) {

            buttons[i] = new JButton();
            buttons[i].setSize(60, 70);
            buttons[i].setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, Color.red));
            textAreas[i] = new JTextArea();
            textAreas[i].setSize(180, 70);
            textAreas[i].setEditable(false);
            textAreas[i].setFont(new Font("Serif", Font.BOLD, 11));
            textAreas[i].setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, Color.blue));
            frame.add(buttons[i]);
            frame.add(textAreas[i]);
            buttons[i].setLocation(10, 75 * i + 20);
            textAreas[i].setLocation(10 + 70, 75 * i + 20);

            switch(i){
                case 0:
                    getTextAreas()[i].setText("Name -> Gaetano" + "\n" +
                            "Leader dei Pet di tipo DOG." + "\n" +
                            "Location -> Woofy City." + "\n" +
                            "Favorite Pet -> Woody.");
                    getButtons()[i].setIcon(new ImageIcon(Constant.allenatore7Lotta));
                    break;
                case 1:
                    getTextAreas()[i].setText("Name -> Renato" + "\n" +
                            "Leader dei Pet di tipo CAT." + "\n" +
                            "Location-> MeowMeow City." + "\n" +
                            "Favorite Pet-> MewCat.");
                    getButtons()[i].setIcon(new ImageIcon("images/Trainer/renatoC.jpg"));
                    break;
                case 2:
                    getTextAreas()[i].setText("Name -> Joe" + "\n" +
                            "Leader dei Pet di tipo RABBIT." + "\n" +
                            "Location-> Hairy City." + "\n" +
                            "Favorite Pet-> Pulce.");
                    getButtons()[i].setIcon(new ImageIcon("images/Trainer/joeC.jpg"));
                    break;
                case 3:
                    getTextAreas()[i].setText("Name -> Ginevra" + "\n" +
                            "Leader dei Pet di tipo BIRD." + "\n" +
                            "Location-> Fly City." + "\n" +
                            "Favorite Pet-> PettyRed.");
                    getButtons()[i].setIcon(new ImageIcon("images/Trainer/ginevraC.jpg"));
                    break;
                case 4:
                    getTextAreas()[i].setText("Name -> Sonia" + "\n" +
                            "Leader dei Pet di tipo TURTLE." + "\n" +
                            "Location-> Green City." + "\n" +
                            "Favorite Pet-> Rughetta.");
                    getButtons()[i].setIcon(new ImageIcon("images/Trainer/soniaC.jpg"));
                    break;
            }
        }

        frame.add(sfondo);
    }

    public JFrame getFrame() {
        return frame;
    }

    public void setFrame(JFrame frame) {
        this.frame = frame;
    }

    public JLabel getSfondo() {
        return sfondo;
    }

    public void setSfondo(JLabel sfondo) {
        this.sfondo = sfondo;
    }

    public Icon getIconSfondo() {
        return iconSfondo;
    }

    public void setIconSfondo(Icon iconSfondo) {
        this.iconSfondo = iconSfondo;
    }

    public JButton[] getButtons() {
        return buttons;
    }

    public void setButtons(JButton[] buttons) {
        this.buttons = buttons;
    }

    public ImageIcon[] getIcons() {
        return icons;
    }

    public void setIcons(ImageIcon[] icons) {
        this.icons = icons;
    }

    public JTextArea[] getTextAreas() {
        return textAreas;
    }

    public void setTextAreas(JTextArea[] textAreas) {
        this.textAreas = textAreas;
    }
}
