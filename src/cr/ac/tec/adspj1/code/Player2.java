package cr.ac.tec.adspj1.code;

import javax.swing.*;
import java.awt.*;

public class Player2 {

}

class playe2Frame extends JFrame {
    public playe2Frame(){
        Toolkit player1Window = Toolkit.getDefaultToolkit();
        Dimension windowSize = player1Window.getScreenSize();
        int windowHeight = windowSize.height;
        int windowWidth = windowSize.width;

        setTitle("Player 2");
        setBounds((windowWidth-500)/2, (windowHeight-500)/2, 500, 500);
        setResizable(false);

        Image myIcon = player1Window.getImage("src/cr/ac/tec/adspj1/img/CR.png");
        setIconImage(myIcon);
        player2Canvas canvas = new player2Canvas();
        add(canvas);
    }
}

class player2Canvas extends JPanel{
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawString("Default Data", 150, 150);
    }
}