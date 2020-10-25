package cr.ac.tec.adspj1.code;

import javax.swing.*;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Client implements Runnable {

    private final static Logger logger = Logger.getLogger( Logger.GLOBAL_LOGGER_NAME );
    private String mensaje;
    private int puerto;
    private String HOST;



    /**
     * Constructor de la clase
     * @param puerto
     * @param mensaje
     */
    public Client(String HOST,int puerto, String mensaje) {
        this.puerto = Integer.parseInt(JOptionPane.showInputDialog("introduzca el puerto"));
        this.mensaje = JOptionPane.showInputDialog("introduzca su mensaje");
        this.HOST = JOptionPane.showInputDialog("introduzca el HOST");
    }

    /**
     * Hilo con el que se envía el mensaje
     */
    @Override
    public void run() {
        //Host del servidor
        //HOST = "192.168.1.108";//127.0.0.1
        //Puerto del servidor
        DataOutputStream out;

        try {
            //Creo el socket para conectarme con el Client
            Socket socket = new Socket(HOST, puerto);

            out = new DataOutputStream(socket.getOutputStream());

            //Envio un mensaje al Client
            out.writeUTF(mensaje);

            socket.close();

            logger.log(Level.INFO, "Mensaje enviado");

        } catch (IOException ex) {
            logger.log(Level.SEVERE, "Fallo al enviar mensaje. Probablemente el destinatario no es válido");
        }

    }
}
