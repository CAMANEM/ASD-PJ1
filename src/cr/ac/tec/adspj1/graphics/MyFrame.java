package cr.ac.tec.adspj1.graphics;

import javax.swing.*;
import java.awt.*;

/**
 * This class is the frame of the game and have the
 * methods to change between menu canvas and game
 * canvas
 *
 * @version 1.0
 */
class MyFrame extends JFrame {


    public CanvasMenu myCanvas = new CanvasMenu();
    public CanvasGame ingame_canvas = new CanvasGame();


    /**
     * Create the frame and sets his configuration.
     */
    public MyFrame(){
        Toolkit myWindow = Toolkit.getDefaultToolkit();
        Dimension windowSize = myWindow.getScreenSize(); //Obtiene el tamaño de cualquietr pantalla
        int windowHeight = windowSize.height;
        int windowWidth = windowSize.width;

        setTitle("Tecnologico de Costa Rica");
        setBounds(windowWidth/3, windowHeight/6, 700, 800);
        setResizable(false);

        Image myIcon = myWindow.getImage("src/cr/ac/tec/adspj1/graphics/img/CR.png");
        setIconImage(myIcon);
    }


    /**
     * Set the canvasMenu on the frame and call a canvasMenu method
     * to the add the buttons monitored by the GraphicController.
     *
     * @param btn_anfitrion
     * @param btn_invitado
     */
    public void goMenu(JButton btn_anfitrion, JButton btn_invitado){

        this.add(myCanvas);
        this.myCanvas.putButtons(btn_anfitrion, btn_invitado);
    }


    /**
     * Removes the canvasMenu from the frame and
     * sets the gameCanvas on the frame
     */
    public void goGame(){
        this.remove(myCanvas);
        this.add(ingame_canvas);
        this.repaint();
        this.revalidate();
    }

}