package cr.ac.tec.adspj1.code;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.io.*;

class CanvasMenu extends JPanel{

    private SpringLayout layout = new SpringLayout();

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawString("Default Data", 125, 125);
        Image imagen;
        try{
        imagen = ImageIO.read(new File("src/cr/ac/tec/adspj1/img/cardswallpaper.jpg"));
        g.drawImage(imagen,0,0, 700,800, null);
        }
        catch (IOException e){
            System.out.println("No se logró acceder a la imagen en la ruta especificada");
        }

    }


    public CanvasMenu(){
        this.setLayout(layout);
        System.out.println("esto es inutil");
    }

    public void putButtons(JButton anfitrion, JButton invitado){
        Spring dock = Spring.constant(0,5,30);
        this.add(anfitrion);
        this.add(invitado);
        this.layout.putConstraint(SpringLayout.NORTH, anfitrion, dock, SpringLayout.NORTH, this);
        this.layout.putConstraint(SpringLayout.NORTH, invitado, dock, SpringLayout.SOUTH, anfitrion);
        this.layout.putConstraint(SpringLayout.SOUTH, this, dock, SpringLayout.NORTH, invitado);
    }




}