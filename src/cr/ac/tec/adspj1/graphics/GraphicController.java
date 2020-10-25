package cr.ac.tec.adspj1.code;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GraphicController extends Observable implements ActionListener {

    private final static Logger logger = Logger.getLogger( Logger.GLOBAL_LOGGER_NAME );
    JButton btn_invitado = new JButton("Entrar como invitado");
    JButton btn_anfitrion = new JButton("Ser anfitrión");
    MyFrame frame;

    public GraphicController(){

        createFrame();
    }


    public void createFrame(){

        this.frame = new MyFrame();
        this.frame.setLocationRelativeTo(null);
        this.frame.setVisible(true);
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.goMenu(btn_anfitrion, btn_invitado);
        btn_anfitrion.addActionListener(this);
        btn_invitado.addActionListener(this);
    }



    @Override
    public void actionPerformed(ActionEvent e) {

        Object selection = e.getSource();

        if(selection == btn_anfitrion){
            try{
                InetAddress ip = InetAddress.getLocalHost();
                System.out.println(ip.getHostAddress());
                this.frame.goGame();

                this.setChanged();
                this.notifyObservers("1");
                this.clearChanged();


                //observers cuando iniicar servidor
            }
            catch (UnknownHostException ex){
                this.logger.log(Level.SEVERE, "Cannot get HOST IP");
            }
        }
        else{
            this.frame.goGame();
            this.setChanged();
            this.notifyObservers("0");
            this.clearChanged();
        }
    }
}
