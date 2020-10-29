import gui.GraphicController;
import Code.CardGetter;
import Code.Server;
import Code.Client;
import Code.Card;

import java.util.Observable;
import java.io.IOException;
import java.util.logging.*;
import java.util.Observer;
import javax.swing.*;



/**This is the principal class, handles the communication between graphic code and logic code
 *
 *@version 1.0
 */
public class Main implements Observer {


    private final static Logger logger = Logger.getLogger( Logger.GLOBAL_LOGGER_NAME );
    private GraphicController graphics;
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
        this.card = CardGetter.getCard("1"); //method to get the card object from an ID(when selected in hand)
        String mensaje = CardGetter.getCardString(this.card); //method to convert card to string to sent to the other player
        this.card = CardGetter.getCardfromMessage(mensaje); //method to convert a received message to a card Object
        System.out.println(this.card.cardName);

        this.graphics = new GraphicController();
        this.graphics.addObserver(this);
        this.server = new Server();
        loggerConfig();
    }


    /**
     * This method is called when players get connected
     * and starts the turn-based game system.
     *
     * Make the program focus on receive a message so,
     * the user will not be able to interact with the
     * program until the program receive a message.
     */
    public void playGame(){

        while (true){

            System.out.println(this.server.finishTurn());
            System.out.println("recibio un mensaje, este es su turno");
            this.client = new Client();
            Thread thread = new Thread(client);
            thread.start();
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

            JOptionPane.showMessageDialog(null, "Your port is " + this.server.getPuerto());
            JOptionPane.showMessageDialog(null, "Your host ip is " + this.server.getHost());
            playGame();
        }
        else if(arg.equals("guest")){
            this.client = new Client();
            Thread thread = new Thread(this.client);
            thread.start();

            playGame();

        }
        else if(arg.equals("0")){
            //System.out.println("Card 1");

        }
        else if(arg.equals("1")){
            //System.out.println("Card 2");
        }
        else if(arg.equals("2")){
            //System.out.println("Card 3");
        }
        else if(arg.equals("3")){
            //System.out.println("Card 4");
        }
        else if(arg.equals("4")){
           // System.out.println("Card 5");
        }
        else if(arg.equals("5")){
           // System.out.println("Card 6");
        }
        else if(arg.equals("6")){
           // System.out.println("Card 7");
        }
        else if(arg.equals("7")){
            //System.out.println("Card 8");
        }
        else if(arg.equals("8")){
            //System.out.println("Card 9");
        }
        else if(arg.equals("9")){
            //System.out.println("Card 10");
        }

        else{

            /*this.client = new Client();
            Thread thread = new Thread(this.client);
            thread.start();

            playGame();*/
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