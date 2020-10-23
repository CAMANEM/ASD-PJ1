package cr.ac.tec.adspj1.code;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.InetAddress;
import java.net.UnknownHostException;

class CanvasMenu extends JPanel{


    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawString("Default Data", 125, 125);

    }

    public CanvasMenu(){
        ImageIcon i = new ImageIcon("src/cr/ac/tec/adspj1/img/cardswallpaper.jpg");
        Image image = i.getImage();
        Image modified_image = image.getScaledInstance(700,720, Image.SCALE_SMOOTH);
        i = new ImageIcon(modified_image);
        JLabel imagen = new JLabel("", i, JLabel.CENTER);
        imagen.setBounds(0,0,25,0);
        this.add(imagen);
    }




}