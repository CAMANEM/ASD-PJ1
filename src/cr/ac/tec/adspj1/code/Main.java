package cr.ac.tec.adspj1.code;

import javax.swing.*;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;
import java.util.logging.*;

public class Main implements Observer {


    private final static Logger logger = Logger.getLogger( Logger.GLOBAL_LOGGER_NAME );
    Servidor servidor;


    public static void main(String[] args) {

        new Main();
    }


    public Main(){
        loggerConfig();
        createFrame();
        iniciarServidor();
        System.out.println(servidor.getPuerto());
    }


    public void createFrame(){
        MyFrame frame = new MyFrame();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void iniciarServidor(){

        this.servidor = new Servidor();
        this.servidor.addObserver(this);
        Thread hilo_servidor = new Thread(this.servidor);
        hilo_servidor.start();
    }


    /**
     * Observer que se activa cuando el servidor recibe un mensaje.
     * Este método muestra el mensaje recibido en la ventana de chat
     * @param o
     * @param arg
     */
    @Override
    public void update(Observable o, Object arg) {
        try {
            System.out.println((String) arg);
        }
        catch (RuntimeException e){
            logger.log(Level.SEVERE, "Error al recibir mensaje");
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




