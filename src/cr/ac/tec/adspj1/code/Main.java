package cr.ac.tec.adspj1.code;

import javax.swing.*;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;
import java.util.logging.*;

//Este es el main actualizado
public class Main implements Observer {


    private final static Logger logger = Logger.getLogger( Logger.GLOBAL_LOGGER_NAME );
    GraphicController graphics = new GraphicController();
    Servidor servidor;



    public static void main(String[] args) {

        new Main();
    }


    public Main(){
        loggerConfig();
        iniciarServidor();
        graphics.addObserver(this);
        //System.out.println(servidor.getPuerto());
    }

    public void playGame(){

        while (true){

            System.out.println(this.servidor.finishTurn());
            System.out.println("123");
        }
    }


    public void iniciarServidor(){

        this.servidor = new Servidor();

    }


    /**
     * Observer que se activa cuando el servidor recibe un mensaje.
     * Este método muestra el mensaje recibido en la ventana de chat
     * @param o
     * @param arg
     */

    @Override
    public void update(Observable o, Object arg) {

        if(arg.equals("1")){
            JOptionPane.showMessageDialog(null, this.servidor.getPuerto());
            playGame();
        }
        else{
            new Client("host",192, "mensaje");
            playGame();
        }
    }

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




