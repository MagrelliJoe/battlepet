package model.data.implementation;
import model.data.abstracted.LevelWindow;
import model.data.entities.Constant;
import model.data.entities.Person;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.IOException;

public class WindowPrologue extends LevelWindow implements ActionListener {
    private JTextArea textArea;
    private JButton  button,buttonGif;

    public WindowPrologue(String filePathImage, String fileMusicPath, String fileMusicPathMessage,int width, int eight) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        super(filePathImage, fileMusicPath, fileMusicPathMessage, width, eight);

        super.myTrainer.setVisible(false);
        frame.setTitle("LET'S GET START YOUR ADVENTURE!");
        buttonGif = new JButton(new ImageIcon("images/gifInit.gif"));
        buttonGif.setSize(200,100);
        buttonGif.setBorder(BorderFactory.createMatteBorder(2,2,2,2,Color.DARK_GRAY));
        buttonGif.setBackground(new Color(0,0,0,0));
        buttonGif.setOpaque(false);
        buttonGif.setForeground(Color.white);
        buttonGif.setLocation(20,150);

        button = new JButton("..continue..");
        button.setOpaque(false);
        button.setBorder(BorderFactory.createMatteBorder(0,0,0,0,Color.DARK_GRAY));
        button.setBackground(new Color(0,0,0,0));
        button.setForeground(Color.white);
        button.setFont(new Font("Serif", Font.BOLD, 20));
        button.setSize(100, 30);
        button.addActionListener(this);
        button.setActionCommand("continua");
        button.setLocation(280,190);

        textArea = new JTextArea("Benvenuto/a nel mondo di Battle Pet! Tra poco inizierà" +"\n" +
                "la tua avventura ad Isla Nueva!Quest'isola è popolata da animali"+"\n" +
                "fantastici e particolari che gli uomini e le donne coccolano ed" +"\n" +
                "allenano per partecipare a dei tornei in cui questi animali," + "\n" +
                "che vengono rinominati 'PET',lottano fra di loro per decidere" +"\n"+
                "chi sia il più forte! ");
        textArea.setFont(new Font("Serif", Font.BOLD, 13));
        textArea.setBorder(BorderFactory.createMatteBorder(0,0,0,0,Color.DARK_GRAY));
        textArea.setBackground(new Color(0,0,0,0));
        textArea.setForeground(Color.white);
        textArea.setSize(380,130);
        textArea.setEditable(false);
        textArea.setLocation(60,10);

        frame.add(textArea);
        frame.add(buttonGif);
        frame.add(button);
        frame.add(sfondo);
    }

    @Override
    public void SetFightPosition(int posX, int posY, Person trainer, String comment,String comment2,int numOfVictory,int numMin) throws UnsupportedAudioFileException, LineUnavailableException, IOException, InterruptedException {
      //DO NOTHING
    }
    @Override
    public void actionPerformed(ActionEvent e) {

        if("continua".equals(e.getActionCommand())){
            textArea.setVisible(false);
           textArea.setText("Tutti i ragazzi,una volta finiti gli studi,scelgono" +"\n" +
                    "il primo Pet che viene donato loro dai propri genitori!"+"\n" +
                    "Una volta fatta la scelta,intraprendono il proprio viaggio" +"\n" +
                    "alla scoperta di Isla Nueva,sfidando gli altri allenatori e " + "\n" +
                    "cercando di conquistare fama e gloria!Il passo finale è " +"\n"+
                    "sconfiggere i leader delle città ed essere incoronato/a come "+"\n"+
                    "miglior allenatore/allenatrice di tutta l'intera isola!");
            textArea.setVisible(true);
            button.setActionCommand("continua.");

        }
        if("continua.".equals(e.getActionCommand())){
            frame.dispose();
            music.stop();
            try {
                LevelWindow levelWindow = new WindowChooseTrainer("images/sfondoInitGame.jpg", Constant.musicaInit,Constant.messaggio,500,300);
            } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
                throw new RuntimeException(ex);
            }
        }

    }
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
