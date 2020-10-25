package cr.ac.tec.adspj1.code;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *This class make possible receive information after each turn,
 * with the finishTurn method.
 *
 * @version 1.0
 */
public class Servidor {

    private int puerto;
    private final static Logger logger = Logger.getLogger( Logger.GLOBAL_LOGGER_NAME );
    ServerSocket servidor = null;
    Socket socket = null;
    DataInputStream in;


    /**
     * This constructor search for a available port to use.
     * The ports searched range from 600 to 10000
     */
    public Servidor() {

        this.puerto = 6000;

        while (this.puerto < 10000) {

            try {
                this.servidor = new ServerSocket(puerto);
                this.logger.log(Level.INFO, "Server initialized in port " + this.getPuerto());
                break;


            } catch (IOException ex) {
                this.logger.log(Level.SEVERE, "Failed initializing server, occupied port");
                this.puerto++;
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
                this.logger.info("Incoming message detected");

                in = new DataInputStream(socket.getInputStream());
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
     * @return the server´s port
     */
    public int getPuerto() {
        return puerto;
    }
}
