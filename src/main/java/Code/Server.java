package Code;

import java.net.UnknownHostException;
import java.util.logging.Logger;
import java.util.logging.Level;
import java.io.DataInputStream;
import java.net.ServerSocket;
import java.net.InetAddress;
import java.io.IOException;
import java.net.Socket;


/**
 *This class make possible receive information after each turn,
 * with the finishTurn method.
 *
 * @version 1.1
 */
public class Server {

    private final static Logger logger = Logger.getLogger( Logger.GLOBAL_LOGGER_NAME );
    private ServerSocket servidor = null;
    private Socket socket = null;
    private DataInputStream in;
    private int port;
    private String ip;


    /**
     * This constructor search for a available port to use.
     * The ports searched range from 600 to 10000
     */
    public Server() {

        this.port = 6000;

        while (this.port < 10000) {

            try {
                this.servidor = new ServerSocket(port);
                this.logger.log(Level.INFO, "Server initialized in port " + this.getPort());
                break;


            } catch (IOException ex) {
                this.logger.log(Level.SEVERE, "Failed initializing server, occupied port");
                this.port++;
            }
        }
    }


    /**
     * After each turn this method is called to wait until
     * receive an information message when the other play
     * finish his turn.
     *
     * @return a jason with the information of the opponent's play.
     */
    public String finishTurn() {

        while (true) {

            try {

                this.logger.log(Level.INFO, "Waiting for a message");
                this.socket = this.servidor.accept();
                this.logger.log(Level.INFO,"Incoming message detected");

                in = new DataInputStream(this.socket.getInputStream());
                String mensaje = in.readUTF();
                socket.close();

                return mensaje;
            }

            catch (IOException e) {

                this.logger.log(Level.SEVERE, "Error receiving message");;
            }
        }
    }


    /**
     * This method gets the player host ip
     * @return the host ip
     */
    public String getHost(){

        try{
            this.ip = InetAddress.getLocalHost().getHostAddress();
        }

        catch (UnknownHostException e) {
            this.logger.log(Level.INFO,"Error getting Host");
        }
        return this.ip;
    }


    /**
     * @return the server´s port
     */
    public int getPort() {
        return port;
    }
}
