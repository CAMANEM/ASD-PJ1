package gui;

import Code.List.ListCL;

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
        int[] names = {1, 2, 3, 4, 1, 2};

        for (int i = 0; i < names.length; i++) {
            ImageIcon image = new ImageIcon("src/main/java/gui/img/general/Taste" + names[i] + ".jpg");
            JLabel label1 = new JLabel(new ImageIcon());
            label1.setBounds(20 * i * 5, 640, 75, 75);
            label1.setIcon(new ImageIcon(image.getImage().getScaledInstance(label1.getWidth(), label1.getHeight(), Image.SCALE_SMOOTH)));
            this.setLayout(null);
            this.add(label1);

        }
    }
    public void putButtons(JButton[] handgame) {
        int numero = 0;
        ListCL listita =  new ListCL();


        for (int i = 0; i < 10; i++) {

            this.add(handgame[i]);
            //this.remove(handgame[i]);


            listita.insert(handgame[i]);
            ++numero;

        }
        if (!listita.verification()){
            listita.showList();
        }else{
            System.out.println("hdfdjfh");
        }
    }
}


