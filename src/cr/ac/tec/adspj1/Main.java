package cr.ac.tec.adspj1;

import cr.ac.tec.adspj1.graphics.GraphicController;
import cr.ac.tec.adspj1.code.Client;
import cr.ac.tec.adspj1.code.Server;

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
    GraphicController graphics;
    Server server;
    Client client;


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
    public Main(){
        this.graphics = new GraphicController();
        this.graphics.addObserver(this);
        startServer();
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
     * Creates the server class that is used to receive
     * a message after you finish your turn.
     */
    public void startServer(){

        this.server = new Server();
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
     * @param o
     * @param arg
     */
    @Override
    public void update(Observable o, Object arg) {

        if(arg.equals("1")){

            JOptionPane.showMessageDialog(null, "Your port is " + this.server.getPuerto());
            JOptionPane.showMessageDialog(null, "Your host ip is " + this.server.getHost());
            playGame();
        }

        else{

            this.client = new Client();
            Thread thread = new Thread(this.client);
            thread.start();

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
            FileHandler fileHandler = new FileHandler("Logging_File.log", false);
            fileHandler.setFormatter(new SimpleFormatter()); // simplify log format
            fileHandler.setLevel(Level.ALL);
            logger.addHandler(fileHandler);
        }
        catch (IOException e){
            logger.log(Level.SEVERE, "Error creating fileHandler and Logging_File.log", e);
        }
    }
}




