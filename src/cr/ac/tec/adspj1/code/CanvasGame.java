package cr.ac.tec.adspj1.code;

import javax.swing.*;
import java.awt.*;

public class CanvasGame extends JPanel {

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawString("Default Data", 125, 125);

    }

    public CanvasGame(){
        ImageIcon icon = new ImageIcon("src/cr/ac/tec/adspj1/img/WoodenTable.jpg");
        Image image = icon.getImage();
        Image modified_image = image.getScaledInstance(700,800, Image.SCALE_SMOOTH);
        icon = new ImageIcon(modified_image);
        JLabel image_ready = new JLabel("", icon, JLabel.CENTER);
        //imagen.setBounds(0,0,25,100);
        this.add(image_ready);
    }
}
