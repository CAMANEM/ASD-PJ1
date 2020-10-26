package gui;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.logging.Logger;
import java.util.Observable;
import javax.swing.*;


/**
 * This class makes easier the control of the graphic
 * interface.
 * The Main use only this class directly to make any
 * change in the graphic interface.
 *
 * @version 1.0
 */
public class GraphicController extends Observable implements ActionListener {

    private final static Logger logger = Logger.getLogger( Logger.GLOBAL_LOGGER_NAME );
    JButton btn_invitado = new JButton("Enter as guest");
    JButton btn_anfitrion = new JButton("Enter as host");
    JButton button1;
    JButton button2;
    JButton button3;
    JButton button4;
    JButton button5;
    JButton button6;
    JButton button7;
    JButton button8;
    JButton button9;
    JButton button10;
    JButton [] handgame = {this.button1, this.button2, this.button3, this.button4, this.button5,
            this.button6, this.button7, this.button8, this.button9, this.button10};
    MyFrame frame;


    /**
     * This constructor calls the method to create a frame.
     */
    public GraphicController(){

        createFrame();
        createGameButtons();
    }

    public void createGameButtons() {

        int posx =20;

        for (int i = 0; i < 10; i++) {

            ImageIcon buttonImage = new ImageIcon("src/main/java/gui/img/cards/H_DamageIncresed.png");
            handgame[i] = new JButton();
            handgame[i].setBounds(posx, 480, 180, 250);
            handgame[i].setIcon(new ImageIcon(buttonImage.getImage().getScaledInstance(handgame[i].getWidth(), handgame[i].getHeight(), Image.SCALE_SMOOTH)));
            handgame[i].addActionListener(this);
            posx += 120;
        }
    }

    /**
     * Creates a frame that initializes with the canvas of the
     * menu and add listeners to the menu buttons.
     */
    public void createFrame(){

        this.frame = new MyFrame();
        this.frame.setLocationRelativeTo(null);
        this.frame.setVisible(true);
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.goMenu(btn_anfitrion, btn_invitado);
        btn_anfitrion.addActionListener(this);
        btn_invitado.addActionListener(this);
    }


    /**
     * This ActionListener is activated when a menu button is pressed,
     * then chance to the game Canvas and notify the button pressed
     * to the observer of the Main.
     *
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {

        Object selection = e.getSource();

        if(selection == btn_anfitrion){

            this.frame.goGame(handgame);

            this.setChanged();
            this.notifyObservers("1");
            this.clearChanged();
        }

        else{

            this.frame.goGame(handgame);

            this.setChanged();
            this.notifyObservers("0");
            this.clearChanged();
        }
    }
}
