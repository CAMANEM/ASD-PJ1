package gui;

import java.awt.event.WindowEvent;
import javax.swing.*;
import java.awt.*;

/**
 * This class is the frame of the game and have the
 * methods to change between menu canvas and game
 * canvas
 *
 * @version 1.2
 */
class MyFrame extends JFrame {


    private CanvasMenu menu_canvas = new CanvasMenu();
    private CanvasGame ingame_canvas = new CanvasGame();


    /**
     * Create the frame and sets his configuration.
     */
    public MyFrame(){
        Toolkit myWindow = Toolkit.getDefaultToolkit();
        Dimension windowSize = myWindow.getScreenSize(); //Obtiene el tamaño de cualquietr pantalla
        int windowHeight = windowSize.height;
        int windowWidth = windowSize.width;

        setTitle("Tecnologico de Costa Rica");
        setBounds(windowWidth/3, windowHeight/6, 1600, 800);
        setResizable(false);

        Image myIcon = myWindow.getImage("src/cr/ac/tec/adspj1/graphics/img/CR.png");
        setIconImage(myIcon);
    }

    /**
     * It gets part of the information that is going to be
     * in the record of activity
     * @param data string data from GraphicController
     */
    public void history(String data){

        ingame_canvas.history(data);
    }


    /**
     * Set the canvasMenu on the frame and call a canvasMenu method
     * to the add the buttons monitored by the GraphicController.
     * This method is only used whe the program starts.
     *
     * @param btn_anfitrion
     * @param btn_invitado
     */
    public void goMenu(JButton btn_anfitrion, JButton btn_invitado){

        this.add(menu_canvas);
        this.menu_canvas.putButtons(btn_anfitrion, btn_invitado);
    }


    /**
     * Removes the canvasMenu from the frame and
     * sets the gameCanvas on the frame
     */
    public void goGame(JButton[] handgame, JButton skipTurn){
        this.remove(menu_canvas);
        this.add(ingame_canvas);
        this.ingame_canvas.putButtons(handgame, skipTurn);
        this.repaint();
        this.revalidate();
    }


    /**
     * Update the life and mana points of the player in the GUI.
     *
     * @param life
     * @param mana
     */
    public void updateStats(String life, String mana){
        this.ingame_canvas.updateStats(life, mana);
    }

    /**
     * Updates the card image of the last card summoned by the
     * player.
     *
     * @param ID of the card summoned
     */
    public void updateSummonedCard(String ID){
        this.ingame_canvas.updateSummonedCard(ID);

    }

    /**
     * Closes the program when the game is over
     */
    public void closePorgram(){
        this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
    }
}