package cr.ac.tec.adspj1.code;

import javax.swing.*;
import java.awt.*;

public class Player1 {

}

class playe1Frame extends JFrame{
    public playe1Frame(){
        Toolkit player1Window = Toolkit.getDefaultToolkit();
        Dimension windowSize = player1Window.getScreenSize();
        int windowHeight = windowSize.height;
        int windowWidth = windowSize.width;

        setTitle("Player 1");
        setBounds((windowWidth-500)/2, (windowHeight-500)/2, 500, 500);
        setResizable(false);

        Image myIcon = player1Window.getImage("src/cr/ac/tec/adspj1/img/CR.png");
        setIconImage(myIcon);
        player1Canvas canvas = new player1Canvas();
        add(canvas);
    }
}

class player1Canvas extends JPanel{
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawString("Default Data", 150, 150);
    }
}