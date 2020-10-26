package cr.ac.tec.adspj1.graphics;

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
    MyFrame frame;


    /**
     * This constructor calls the method to create a frame.
     */
    public GraphicController(){

        createFrame();
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

            this.frame.goGame();

            this.setChanged();
            this.notifyObservers("1");
            this.clearChanged();
        }

        else{

            this.frame.goGame();

            this.setChanged();
            this.notifyObservers("0");
            this.clearChanged();
        }
    }
}
