package cr.ac.tec.adspj1.code;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

        canvas myCanvas = new canvas();
        add(myCanvas);
    }
}

class canvas extends JPanel implements ActionListener {

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawString("Default Data", 125, 125);
    }

    JButton button1 = new JButton("Player 1");
    JButton button2 = new JButton("Player 2");

    public canvas(){
        add(button1);
        add(button2);
        button1.addActionListener(this);
        button2.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object selection = e.getSource();

        if(selection == button1){
            playe1Frame frame = new playe1Frame();
            frame.setVisible(true);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            setBackground(Color.DARK_GRAY);
            System.out.println("Player 1 was pressed ");
        }else{
            playe2Frame frame = new playe2Frame();
            frame.setVisible(true);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            setBackground(Color.green);
            System.out.println("Player 2 was pressed");
        }


    }
}
