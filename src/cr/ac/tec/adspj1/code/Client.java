package cr.ac.tec.adspj1.code;

import java.io.DataOutputStream;
import java.util.logging.Logger;
import java.util.logging.Level;
import java.io.IOException;
import java.net.Socket;
import javax.swing.*;


/**
 * This class is used to send a message to
 * the opponent with the information of
 * the play made.
 *
 * @version 1.0
 */
public class Client implements Runnable {

    private final static Logger logger = Logger.getLogger( Logger.GLOBAL_LOGGER_NAME );
    private String mensaje;
    private String HOST;
    private int puerto;



    /**
     * The constructor of this class request the port
     * and host ip of the other player.
     */
    public Client() {

        this.puerto = Integer.parseInt(JOptionPane.showInputDialog("introduzca el puerto")); //try needed for strings entries
        this.mensaje = JOptionPane.showInputDialog("introduzca su mensaje");
        this.HOST = JOptionPane.showInputDialog("introduzca el HOST");
    }


    /**
     * This thread is used to send a message to the
     * other player.
     */
    @Override
    public void run() {

        DataOutputStream out;

        try {
            this.logger.info("Sending message...");
            Socket socket = new Socket(HOST, puerto);

            out = new DataOutputStream(socket.getOutputStream());
            out.writeUTF(mensaje);
            socket.close();

            this.logger.log(Level.INFO, "Message sent");

        } catch (IOException ex) {
            this.logger.log(Level.SEVERE, "Failed to send message. The address is probably invalid");
        }
    }
}
