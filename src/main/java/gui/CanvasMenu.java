package gui;

import java.util.logging.Logger;
import java.util.logging.Level;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.*;

/**
 *This class contains all that is showed in the menu.
 */
class CanvasMenu extends JPanel{

    private final static Logger logger = Logger.getLogger( Logger.GLOBAL_LOGGER_NAME );
    private JLabel title = new JLabel("Monster TECG");
    private Font font;




    /**
     * Draws the background image
     *
     * @param g
     */
    public void paintComponent(Graphics g){
        super.paintComponent(g);

        g.drawString("Default Data", 125, 125);
        Image imagen;
        try{
            imagen = ImageIO.read(new File("src/main/java/gui/img/general/ArmyGreen.jpg"));
            g.drawImage(imagen,0,0, 1600,800, null);
        }
        catch (IOException e){
            logger.log(Level.SEVERE, "Can´t open the ");
            System.out.println("No se logró acceder a la imagen en la ruta especificada");
        }
    }

    /**
     * The constructor set the layout of the canvas
     */
    public CanvasMenu(){

        this.setLayout(null);


    }

    /**
     * Add external buttons to the canvas
     *
     * @param anfitrion
     * @param invitado
     */
    public void putButtons(JButton anfitrion, JButton invitado){

        /*try {
            font = Font.createFont(Font.TRUETYPE_FONT,new File("src/main/java/gui/img/general/Russeldexter.ttf")).deriveFont(50f);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("src/main/java/gui/img/general/Russeldexter.ttf")));

        } catch (IOException | FontFormatException e) {

        }*/


        //title.setBounds(400, 100, 230, 50);
        //title.setFont(font);

        anfitrion.setBounds(250,200, 230, 50);
        invitado.setBounds(210, 300, 310, 50);
        anfitrion.setFont(new Font("Arial", Font.PLAIN, 30));
        invitado.setFont(new Font("Arial", Font.PLAIN, 30));
        this.add(anfitrion);
        this.add(invitado);
        //this.add(title);
    }
}