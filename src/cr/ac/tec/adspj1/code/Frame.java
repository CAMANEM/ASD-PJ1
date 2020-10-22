package cr.ac.tec.adspj1.code;

import javax.swing.*;
import java.awt.*;

public class Frame {
    public static void main(String[] args) {
        myFrame frame1 = new myFrame();
        frame1.setVisible(true);
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}

class myFrame extends JFrame{
    public myFrame(){
        Toolkit myWindow = Toolkit.getDefaultToolkit();
        Dimension windowSize = myWindow.getScreenSize(); //Obtiene el tamaño de cualquietr pantalla
        int windowHeight = windowSize.height;
        int windowWidth = windowSize.width;

        setTitle("Tecnologico de Costa Rica");
        setBounds((windowWidth-500)/2, (windowHeight-500)/2, 500, 500);
        setResizable(false);

        Image myIcon = myWindow.getImage("src/cr/ac/tec/adspj1/img/CR.png");
        setIconImage(myIcon);
    }

}
