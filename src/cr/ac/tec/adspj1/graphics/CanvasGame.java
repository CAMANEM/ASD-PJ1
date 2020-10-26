package cr.ac.tec.adspj1.graphics;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * This class shows and controls the in-game screen
 */
public class CanvasGame extends JPanel {
    JButton button1;
    JButton button2;
    JButton button3;
    JButton button4;
    JButton button5;
    JButton button6;
    JButton button7;
    JButton button8;
    JButton button9;
    JButton button10;


    /**
     * Draws the background image
     * @param g
     */
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Image imagen;
        try{
            imagen = ImageIO.read(new File("src/cr/ac/tec/adspj1/graphics/img/WoodenTable.jpg"));
            g.drawImage(imagen,0,0, 700,800, null);

        }
        catch (IOException e){
            System.out.println("No se logró acceder a la imagen en la ruta especificada");
        }
    }


    /**
     * Add the labels with the cards to the canvas
     */
    public CanvasGame(){
        int [] names = {1, 2, 3, 4, 1, 2};

        for(int i = 0; i < names.length; i++){
            ImageIcon image = new ImageIcon("src/cr/ac/tec/adspj1/graphics/img/Taste"+names[i]+".jpg");
            JLabel label1 = new JLabel(new ImageIcon());
            label1.setBounds(20 * i*5, 640, 75, 75);
            label1.setIcon(new ImageIcon(image.getImage().getScaledInstance(label1.getWidth(), label1.getHeight(), Image.SCALE_SMOOTH)));
            this.setLayout(null);
            this.add(label1);;
        }

        button1 = new JButton();
        button1.setBounds(50, 200, 250, 300);
        ImageIcon buttonImage = new ImageIcon("src/cr/ac/tec/adspj1/graphics/img/Cards/H_DamageIncresed.png");
        button1.setIcon(new ImageIcon(buttonImage.getImage().getScaledInstance(button1.getWidth(), button1.getHeight(), Image.SCALE_SMOOTH)));
        this.add(button1);

        button2 = new JButton();
        button2.setBounds(400, 200, 250, 300);
        ImageIcon buttonImage2 = new ImageIcon("src/cr/ac/tec/adspj1/graphics/img/Cards/H_Steal.png");
        button2.setIcon(new ImageIcon(buttonImage2.getImage().getScaledInstance(button2.getWidth(), button2.getHeight(), Image.SCALE_SMOOTH)));
        this.add(button2);

    }
}
