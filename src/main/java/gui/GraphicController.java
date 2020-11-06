package gui;

import Code.Card;
import Code.CardGetter;
import Code.List.CircularLinked.CardActions;
import Code.List.CircularLinked.Circular;
import Code.List.Stack.Stack;
import Code.List.Stack.RandomCards;
import Code.Player;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Random;
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
 * @version 1.2
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
    JButton skipTurn;
    JButton [] handgame = {this.button1, this.button2, this.button3, this.button4, this.button5,
            this.button6, this.button7, this.button8, this.button9, this.button10, this.deck};
    MyFrame frame;

    RandomCards randomHand = new RandomCards();
    Stack newNode = new Stack();
    Circular circular = new Circular();

    boolean justCard = true;

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

    /**
     * It gets part of the information that is going to be
     * in the record of activity
     * @param data string data from the main class
     */
    public void setHistory(String data){
        frame.history(data);

    }

    public boolean[] getFlags() {
        return flags;
    }


    /**
     * It creates the game buttons for the cards, deck and skip.
     */
    public void createGameButtons() {

        skipTurn = new JButton("skip turn");
        skipTurn.setBounds(1100, 420, 90, 25);
        skipTurn.addActionListener(this);

        for(int i = 0; i < 16; ++i){
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
                circular.insert(String.valueOf(handImages[i]));

            }else if(i < 10){

                ImageIcon buttonImage = new ImageIcon("src/main/java/gui/img/cards/Stack.jpg");
                handgame[i] = new JButton();
                handgame[i].setBounds(posx, 480, 180, 250);
                handgame[i].setIcon(new ImageIcon(buttonImage.getImage().getScaledInstance(handgame[i].getWidth(), handgame[i].getHeight(), Image.SCALE_SMOOTH)));
                handgame[i].addActionListener(this);
                handgame[i].setEnabled(false);
                circular.insert("");

            }
            else{
                ImageIcon buttonImage = new ImageIcon("src/main/java/gui/img/cards/Stack.jpg");
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
     * @return a random integer betweeen 0 and 9 representing
     * the cards in the game hand.
     */
    public int randomChoice(){
        Random random = new Random();
        return random.nextInt(9);
    }

    /**
     * It select randomly the card stolen by game hand
     * removes it from the player hand
     *
     * @return The cards stolen by the opponent.
     */
    public String cardVerification(){
        boolean pointer = false;
        int aux = 0;
        while(pointer == false){
            int poss = randomChoice();
            if(controller.getFlagList()[poss]){
                aux = poss;

                break;
            }
        }
        handgame[aux].setEnabled(false);
        flags[aux] = false;
        fullHand -= 1;
        return circular.getID(aux);
    }


    /**
     * Add a card to the game hand if it is not full.
     *
     * @param ID of the card should be added from deck
     *           or opponent hand.
     */
    public void cardInsertion(int ID){
        if (fullHand < 10 && newNode.stackSize() > 0) {

            controller.setFlagList(flags);
            position = controller.SiteAnalysis();

            ImageIcon buttonImage = new ImageIcon("src/main/java/gui/img/cards/" + ID + ".png");
            handgame[position].setIcon(new ImageIcon(buttonImage.getImage().
                    getScaledInstance(handgame[position].getWidth(), handgame[position].getHeight(), Image.SCALE_SMOOTH)));

            handgame[position].setEnabled(true);
            controller.getFlagList();
            ++fullHand;

            circular.modify(position, String.valueOf(ID));

        }else{
            logger.log(Level.WARNING, "The hand game is full of the stack is out");
        }

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

            this.frame.goGame(handgame, skipTurn);

            this.setChanged();
            this.notifyObservers("host");
            this.clearChanged();
        }

        else if (selection == btn_invitado){

            this.frame.goGame(handgame, skipTurn);
            this.setChanged();
            this.notifyObservers("guest");
            this.clearChanged();
        }

        else if (selection == skipTurn){
            Card card = CardGetter.getCard("40");
            this.setChanged();
            this.notifyObservers(card);
            this.clearChanged();
            justCard = true;
        }

        else if (selection == handgame[10] && justCard){

            if (fullHand < 10 && newNode.stackSize() > 0) {
                cardInsertion(newNode.delete());
                justCard = false;
            }

        }

        else {

            //Searches for the button pressed

            for(int index = 0; index <= 9; ++index){

                if (selection == handgame[index]){

                    String circularID = circular.getID(index);
                    Card card = CardGetter.getCard(circularID);

                    //Check that the player has enough mana for the summon
                    if (card.manaCost <= Player.getMana() || Player.getMaxPower()) {

                        if (Player.getCounterMP() < 3){
                            card.frozenTurn = Player.getMaxPower();
                        }
                        handgame[index].setEnabled(false);
                        flags[index] = false;
                        fullHand -= 1;
                        this.frame.updateSummonedCard(circularID);
                        this.setChanged();
                        this.notifyObservers(card);
                        this.clearChanged();
                        justCard = true;

                    }

                    else{
                        logger.log(Level.WARNING, "You don´t have enough mana for this summon");
                    }
                    break;
                }
            }


        }
    }


    /**
     * Update the life and mana points of the player in the GUI.
     *
     * @param life
     * @param mana
     */
    public void updateStats(String life, String mana){
        this.frame.updateStats(life, mana);
    }

    /**
     * Closes the program when the game is over
     */
    public void closeProgram(){
        this.frame.closePorgram();
    }
}