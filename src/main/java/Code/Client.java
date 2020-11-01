package Code;

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
 * @version 1.1
 */
public class Client {

    private final static Logger logger = Logger.getLogger( Logger.GLOBAL_LOGGER_NAME );
    //private String mensaje;
    private String HOST;

    private int port;


    /**
     * This constructor is used by the guest.
     * Request the port and host ip
     * of the other player.
     */
    public Client() {

        while(true) {
            try {
                this.port = Integer.parseInt(JOptionPane.showInputDialog("Enter the port")); //try needed for strings entries
                this.HOST = JOptionPane.showInputDialog("Enter the HOST");
                break;
            }
            catch (NumberFormatException e){
                logger.log(Level.SEVERE, "The port value is invalid");
                JOptionPane.showMessageDialog(null, "The port entered is invalid, please try again");
            }
        }
    }


    /**
     * This constructor is used by the Host.
     * It uses the host and port direction
     * received in the first message of
     * the guest.
     *
     * @param host
     * @param port
     */
    public Client(String host, String port){
        this.HOST = host;
        this.port = Integer.parseInt(port);
    }



    /**
     * This method is used to send a message to the
     * other player.
     */
    public boolean sendMessage(String mensaje) {

        DataOutputStream out;

        try {
            this.logger.info("Sending message...");
            Socket socket = new Socket(HOST, port);

            out = new DataOutputStream(socket.getOutputStream());
            out.writeUTF(mensaje);
            socket.close();

            this.logger.log(Level.INFO, "Message sent");
            return false;

        } catch (IOException ex) {
            this.logger.log(Level.SEVERE, "Failed to send message. The address is probably invalid");
            return true;
        }
    }


    /**
     * It returns the value of Host variable
     *
     * @return HOST
     */
    public String getHOST() {
        return HOST;
    }


    /**
     * It Returns the value of port variable
     * @return
     */
    public int getPort() {
        return port;
    }
}