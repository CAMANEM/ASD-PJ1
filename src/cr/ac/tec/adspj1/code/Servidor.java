package cr.ac.tec.adspj1.code;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Servidor {

    private int puerto;
    private final static Logger logger = Logger.getLogger( Logger.GLOBAL_LOGGER_NAME ); // usa el logger configurado en la clase Interfaz
    ServerSocket servidor = null;
    Socket socket = null;
    DataInputStream in;

    /**
     * Constructor
     */
    public Servidor() {

        this.puerto = 6000;

        while (this.puerto < 10000) {

            //Este primer try busca un puerto libre (del 5000 al 10000) para establecer el servidor
            try {
                //Crea el socket del servidor
                this.servidor = new ServerSocket(puerto);
                System.out.println(this.puerto);
                break;
            } catch (IOException ex) {
                this.logger.log(Level.SEVERE, "Fallo al recibir un nuevo mensaje ó inicializar servidor");
                this.puerto++;
            }
        }
    }

    public String finishTurn() {
        //Este segundo try se encarga de estar siempre esperando un mensaje
        while (true) {
            try {

                //Espero a que un cliente se conecte
                System.out.println("waiting");
                this.socket = this.servidor.accept();
                this.logger.info("Mensaje entrante detectado");

                in = new DataInputStream(socket.getInputStream());

                //Leo el mensaje que me envia
                String mensaje = in.readUTF();

                //Cierro el socket
                socket.close();

                return mensaje;
            }
            catch (IOException e) {
                this.logger.log(Level.SEVERE, "Error receiving message");;
            }
        }
    }


    /**
     * Método para obtener el puerto en el que se encuentra el servidor
     * @return
     */
    public int getPuerto() {
        return puerto;
    }
}
