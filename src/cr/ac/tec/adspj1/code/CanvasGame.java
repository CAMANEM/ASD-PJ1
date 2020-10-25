package cr.ac.tec.adspj1.code;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class CanvasGame extends JPanel {

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Image imagen;
        try{
            imagen = ImageIO.read(new File("src/cr/ac/tec/adspj1/img/WoodenTable.jpg"));
            g.drawImage(imagen,0,0, 700,800, null);
        }
        catch (IOException e){
            System.out.println("No se logró acceder a la imagen en la ruta especificada");
        }
    }

    public CanvasGame(){

        System.out.println("constructor");
    }
}
