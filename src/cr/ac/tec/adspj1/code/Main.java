package cr.ac.tec.adspj1.code;

import javax.swing.*;
import java.util.Observable;
import java.util.Observer;

public class Main implements Observer {

    Servidor servidor;

    public static void main(String[] args) {
        MyFrame frame1 = new MyFrame();
        frame1.setVisible(true);
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        new Main();
    }

    public Main(){
        iniciarServidor();
    }

    public void iniciarServidor(){

        servidor = new Servidor();
        servidor.addObserver(this);
        Thread hilo_servidor = new Thread(servidor);
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
            System.out.println("helou error");
            //logger.log(Level.SEVERE, "Error al recibir mensaje");
        }
    }
}




