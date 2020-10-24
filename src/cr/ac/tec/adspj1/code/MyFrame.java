package cr.ac.tec.adspj1.code;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.net.InetAddress;
import java.net.UnknownHostException;

class MyFrame extends JFrame implements ActionListener {

    public CanvasMenu myCanvas = new CanvasMenu();
    JButton btn_anfitrion = new JButton("Ser anfitrión");
    JButton btn_invitado = new JButton("Entrar como invitado");

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
        goMenu();
    }

    public void goMenu(){
        this.add(myCanvas);
        this.myCanvas.putButtons(btn_anfitrion, btn_invitado);
        btn_anfitrion.addActionListener(this);
        btn_invitado.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object selection = e.getSource();

        if(selection == btn_anfitrion){
            try{
                InetAddress ip = InetAddress.getLocalHost();
                System.out.println(ip.getHostAddress());
            }
            catch (UnknownHostException ex){
                System.out.println("puta, un error");
            }
            setBackground(Color.DARK_GRAY);
            System.out.println("Player 1 was pressed ");
        }else{
            this.remove(myCanvas);
            this.add(ingame_canvas);
            this.repaint();
            this.revalidate();
            System.out.println("Player 2 was pressed");
        }
    }

}