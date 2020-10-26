package cr.ac.tec.adspj1.graphics;


import javax.swing.*;
import java.awt.*;

public class HandGame extends CanvasGame {
    public HandGame(String file, int xPos, int yPos){

        ImageIcon image = new ImageIcon("src/cr/ac/tec/adspj1/graphics/img/" + file + ".png");
        JLabel label1 = new JLabel(new ImageIcon());
        label1.setBounds(xPos, yPos, 100, 100);
        label1.setIcon(new ImageIcon(image.getImage().getScaledInstance(label1.getWidth(), label1.getHeight(), Image.SCALE_SMOOTH)));
        this.setLayout(null);
        this.add(label1);
    }

}
