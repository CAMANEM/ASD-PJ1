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


    /**
     * Draws the background image
     *
     * @param g
     */
    public void paintComponent(Graphics g){
        super.paintComponent(g);

        Image imagen;
        try{
            imagen = ImageIO.read(new File("src/main/java/gui/img/general/ArmyGreen.jpg"));
            g.drawImage(imagen,0,0, 1600,800, null);
            Font font = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream(new File("src/main/java/gui/img/general/Russeldexter.ttf"))).deriveFont(Font.PLAIN, 50);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(font);

            g.setFont(font);
        }
        catch (Exception e){
            logger.log(Level.SEVERE, "Can´t open the image file");
        }

        g.setColor(Color.WHITE);
        g.drawString("Monster TEC", 600    , 125);
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

        anfitrion.setBounds(650,200, 230, 50);
        invitado.setBounds(610, 300, 310, 50);
        anfitrion.setFont(new Font("Arial", Font.PLAIN, 30));
        invitado.setFont(new Font("Arial", Font.PLAIN, 30));
        this.add(anfitrion);
        this.add(invitado);
    }
}