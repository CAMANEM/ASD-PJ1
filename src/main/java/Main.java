import Code.*;
import gui.GraphicController;

import java.util.Observable;
import java.io.IOException;
import java.util.logging.*;
import java.util.Observer;
import javax.swing.*;



/**This is the principal class, handles the communication between graphic code and logic code
 *
 *@version 1.2
 */
public class Main implements Observer {


    private final static Logger logger = Logger.getLogger( Logger.GLOBAL_LOGGER_NAME );
    private GraphicController graphics;
    private boolean frozenTurn = false;
    private Server server;
    private Client client;
    private Card card;


    /**
     * This method creates a Main object, starting the program
     *
     * @param args
     */
    public static void main(String[] args) {

        new Main();
    }


    /**
     * This constructor calls the basic methods required to open the menu window
     */
    public Main() {
        //this.card = CardGetter.getCard("6"); //method to get the card object from an ID(when selected in hand)
        //String mensaje = CardGetter.getCardString(this.card); //method to convert card to string to sent to the other player
        //this.card = CardGetter.getCardfromMessage(mensaje); //method to convert a received message to a card Object
        //System.out.println(this.card.healing);

        this.graphics = new GraphicController();
        this.graphics.addObserver(this);
        this.server = new Server();
        loggerConfig();
    }


    /**
     * This method is called when players get connected
     * and starts the turn-based game system and after
     * each play.
     *
     * Make the program focus on receive a message so,
     * the user will not be able to interact with the
     * program until the program receive a message.
     *
     * Also check that no player has lost.
     */
    public void playGame(){

        this.card = CardGetter.getCardfromMessage(this.server.finishTurn());

        //Game Won
        if (this.card.type.equals("opponent defeated")){
            JOptionPane.showMessageDialog(null, "Congratulations! You Win!!");
            this.graphics.closeProgram();
        }
        else {
            //it executes the opponent's move
            this.frozenTurn = Player.opponentPlay(this.card);
            this.graphics.updateStats(Integer.toString(Player.getLife()), Integer.toString(Player.getMana()));

            //Game Lost
            if (Player.getLife() <= 0) {
                this.card = CardGetter.getCard("41");
                this.client.sendMessage(CardGetter.getCardString(this.card));
                JOptionPane.showMessageDialog(null, "You lose");
                this.graphics.closeProgram();
            }

            //frozen turn
            else if (this.frozenTurn || this.card.frozenTurn){

                logger.log(Level.WARNING, "You lost your turn");
                this.frozenTurn = false;
                this.card = CardGetter.getCard("40");
                this.client.sendMessage(CardGetter.getCardString(this.card));
                playGame();

            }
        }
    }


    /**
     * This observer is notified when the the player
     *  select to play as a host or guest.
     *
     *  If selected host: The user should share the
     *  IP and port showed. Then wait for the
     *  opponent connection.
     *
     *  If selected guest: The user have to enter the
     *  host IP and port to init start the game.
     *
     * @param o the button from which the notification comes.
     * @param arg other identifier sent by the observable to know what to do.
     */
    @Override
    public void update(Observable o, Object arg) {

        if(arg.equals("host")){

            JOptionPane.showMessageDialog(null, "Your port is " + this.server.getPort());
            JOptionPane.showMessageDialog(null, "Your host ip is " + this.server.getHost());
            Player.reset();
            String[] guestIP = ((String) this.server.finishTurn()).split(":"); //host - port
            this.client = new Client(guestIP[0], guestIP[1]);
            logger.log(Level.INFO, "Is your turn, the host does the first play");
            //playGame();
        }

        else if(arg.equals("guest")){
            //Connect the host and guest
            boolean players_not_Conected = true;
            while(players_not_Conected) {
                this.client = new Client();
                if (this.server.getHost().equals(this.client.getHOST()) &&
                        this.server.getPort() == this.client.getPort()){
                    logger.log(Level.WARNING, "The host and port entered are yours");
                }
                else {
                    players_not_Conected = this.client.sendMessage(this.server.getHost() + ":" + this.server.getPort() + ":");
                }
            }
            logger.log(Level.INFO, "Players connected");
            Player.reset();
            playGame();
        }

        else{
            this.card = (Card) arg;
            Player.playMyTurn(this.card);
            Player.regulateMaxPower();
            this.client.sendMessage(CardGetter.getCardString(this.card));
            playGame();
        }

    }


    /**
     * This method configures the format for the logging fileHandler and consoleHandler.
     */
    public void loggerConfig(){

        LogManager.getLogManager().reset();
        logger.setLevel(Level.ALL);

        //Console config
        ConsoleHandler consoleHandler = new ConsoleHandler();
        consoleHandler.setLevel(Level.ALL);
        logger.addHandler(consoleHandler);

        //File config
        try {
            FileHandler fileHandler = new FileHandler("src/main/java/logging/Logging_File.log", false);
            fileHandler.setFormatter(new SimpleFormatter()); // simplify log format
            fileHandler.setLevel(Level.ALL);
            logger.addHandler(fileHandler);
        }
        catch (IOException e){
            logger.log(Level.SEVERE, "Error creating fileHandler and Logging_File.log", e);
        }
    }
}