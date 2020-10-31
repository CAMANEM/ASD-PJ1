package gui;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * This class shows and controls the in-game screen
 */
public class CanvasGame extends JPanel {


    /**
     * Draws the background image
     * @param g
     */
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Image imagen;
        try{
            imagen = ImageIO.read(new File("src/main/java/gui/img/general/WoodenTable.jpg"));
            g.drawImage(imagen,0,0, 1300,800, null);

        }
        catch (IOException e){
            System.out.println("No se logró acceder a la imagen en la ruta especificada");
        }
    }


    /**
     * Add the labels with the cards to the canvas
     */
    public CanvasGame() {
        this.setLayout(null);

    }
    public void putButtons(JButton[] handgame) {

        //ListCL listita =  new ListCL();


        for (int i = 0; i < 10; i++) {

            this.add(handgame[i]);

            //listita.insert(handgame[i]);

        }
        this.add(handgame[10]);
        /*if (!listita.verification()){
            listita.showList();

        }else{
            System.out.println("hdfdjfh");
        }*/
    }

}
