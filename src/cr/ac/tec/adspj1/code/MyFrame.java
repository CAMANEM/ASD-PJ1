package cr.ac.tec.adspj1.code;


import javax.swing.*;
import java.awt.*;

class MyFrame extends JFrame {


    public CanvasMenu myCanvas = new CanvasMenu();
    public CanvasGame ingame_canvas = new CanvasGame();


    public MyFrame(){
        Toolkit myWindow = Toolkit.getDefaultToolkit();
        Dimension windowSize = myWindow.getScreenSize(); //Obtiene el tamaño de cualquietr pantalla
        int windowHeight = windowSize.height;
        int windowWidth = windowSize.width;

        setTitle("Tecnologico de Costa Rica");
        setBounds(windowWidth/3, windowHeight/6, 700, 800);
        setResizable(false);

        Image myIcon = myWindow.getImage("src/cr/ac/tec/adspj1/img/CR.png");
        setIconImage(myIcon);
    }


    public void goMenu(JButton btn_anfitrion, JButton btn_invitado){

        this.add(myCanvas);
        this.myCanvas.putButtons(btn_anfitrion, btn_invitado);
    }


    public void goGame(){
        this.remove(myCanvas);
        this.add(ingame_canvas);
        this.repaint();
        this.revalidate();
    }

}