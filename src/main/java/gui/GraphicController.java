package gui;

import Code.List.Circular.CardActions;
import Code.List.Stack.Stack;
import Code.List.Stack.RandomCards;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.logging.Level;
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

    boolean flags[] = {true, true , true, true, false, false, false, false, false, false};


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
    JButton deck;
    JButton [] handgame = {this.button1, this.button2, this.button3, this.button4, this.button5,
            this.button6, this.button7, this.button8, this.button9, this.button10, this.deck};
    MyFrame frame;

    RandomCards randomHand = new RandomCards();
    Stack newNode = new Stack();

    private int position;
    private int fullHand = 4;

    CardActions controller = new CardActions(flags);

    /**
     * This constructor calls the method to create a frame.
     */
    public GraphicController(){

        createFrame();
        createGameButtons();
        controller.setFlagList(flags);


    }

    public boolean[] getFlags() {
        return flags;
    }

    public void createGameButtons() {

        for(int i = 0; i < 7; ++i){
            newNode.insertNode(randomHand.RandomDeck());
        }

        int handImages [] = randomHand.RandomHand();

        int posx =20;

        for (int i = 0; i < 11; i++) {
            if (i < 4 ){
                ImageIcon buttonImage = new ImageIcon("src/main/java/gui/img/cards/"+ handImages[i] +".png");
                handgame[i] = new JButton();
                handgame[i].setBounds(posx, 480, 180, 250);
                handgame[i].setIcon(new ImageIcon(buttonImage.getImage().getScaledInstance(handgame[i].getWidth(), handgame[i].getHeight(), Image.SCALE_SMOOTH)));
                handgame[i].addActionListener(this);
                handgame[i].setEnabled(true);

            }else if(i < 10){

                ImageIcon buttonImage = new ImageIcon("src/main/java/gui/img/cards/"+ 50 +".png");
                handgame[i] = new JButton();
                handgame[i].setBounds(posx, 480, 180, 250);
                handgame[i].setIcon(new ImageIcon(buttonImage.getImage().getScaledInstance(handgame[i].getWidth(), handgame[i].getHeight(), Image.SCALE_SMOOTH)));
                handgame[i].addActionListener(this);
                handgame[i].setEnabled(false);

            }
            else{
                ImageIcon buttonImage = new ImageIcon("src/main/java/gui/img/cards/"+(i + 1) +".png");
                handgame[i] = new JButton();
                handgame[i].setBounds(1050, 130, 180, 250);
                handgame[i].setIcon(new ImageIcon(buttonImage.getImage().getScaledInstance(handgame[i].getWidth(), handgame[i].getHeight(), Image.SCALE_SMOOTH)));
                handgame[i].addActionListener(this);
                handgame[i].setEnabled(true);

            }

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
            this.notifyObservers("host");
            this.clearChanged();
        }

        else if (selection == btn_invitado){

            this.frame.goGame(handgame);
            this.setChanged();
            this.notifyObservers("guest");
            this.clearChanged();
        }

        else if (selection == handgame[0]){

            this.setChanged();
            this.notifyObservers("0");
            this.clearChanged();
            handgame[0].setEnabled(false);
            flags[0] = false;
            controller.setFlagList(flags);
            fullHand -= 1;

        }
        else if (selection == handgame[1]){

            this.setChanged();
            this.notifyObservers("1");
            this.clearChanged();
            handgame[1].setEnabled(false);
            flags[1] = false;
            controller.setFlagList(flags);
            fullHand -= 1;

        }
        else if (selection == handgame[2]){

            this.setChanged();
            this.notifyObservers("2");
            this.clearChanged();
            handgame[2].setEnabled(false);
            flags[2] = false;
            fullHand -= 1;

        }
        else if (selection == handgame[3]){

            this.setChanged();
            this.notifyObservers("3");
            this.clearChanged();
            handgame[3].setEnabled(false);
            flags[3] = false;
            fullHand -= 1;

        }
        else if (selection == handgame[4]){

            this.setChanged();
            this.notifyObservers("4");
            this.clearChanged();
            handgame[4].setEnabled(false);
            flags[4] = false;
            fullHand -= 1;

        }
        else if (selection == handgame[5]){

            this.setChanged();
            this.notifyObservers("5");
            this.clearChanged();
            handgame[5].setEnabled(false);
            flags[5] = false;
            fullHand -= 1;

        }
        else if (selection == handgame[6]){

            this.setChanged();
            this.notifyObservers("6");
            this.clearChanged();
            handgame[6].setEnabled(false);
            flags[6] = false;
            fullHand -= 1;

        }
        else if (selection == handgame[7]){

            this.setChanged();
            this.notifyObservers("7");
            this.clearChanged();
            handgame[7].setEnabled(false);
            flags[7] = false;
            fullHand -= 1;

        }
        else if (selection == handgame[8]){

            this.setChanged();
            this.notifyObservers("8");
            this.clearChanged();
            handgame[8].setEnabled(false);
            flags[8] = false;
            fullHand -= 1;

        }
        else if (selection == handgame[9]){

            this.setChanged();
            this.notifyObservers("9");
            this.clearChanged();
            handgame[9].setEnabled(false);
            flags[9] = false;
            fullHand -= 1;

        }
        else if (selection == handgame[10]){


            if (fullHand < 10 && newNode.stackSize() > 0){
                this.setChanged();
                this.notifyObservers("deck");
                this.clearChanged();
                //handgame[0].setEnabled(false);
                controller.setFlagList(flags);
                position = controller.SiteAnalysis();

                ImageIcon buttonImage = new ImageIcon("src/main/java/gui/img/cards/"+ newNode.delete() +".png");
                handgame[position].setIcon(new ImageIcon(buttonImage.getImage().
                        getScaledInstance(handgame[position].getWidth(), handgame[position].getHeight(), Image.SCALE_SMOOTH)));

                handgame[position].setEnabled(true);
                controller.getFlagList();
                ++fullHand;


            }else{
                logger.log(Level.WARNING, "The hand game is full of the stack is out");
            }

        }
    }
}
