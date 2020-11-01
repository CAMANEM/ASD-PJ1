package gui;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * This class shows and controls the in-game screen
 */
public class CanvasGame extends JPanel {

    private JLabel life = new JLabel("1000");
    private JLabel mana = new JLabel("200");
    private JLabel summonedCard = new JLabel();


    /**
     * Draws the background image
     * @param g
     */
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Image imagen;
        try{
            imagen = ImageIO.read(new File("src/main/java/gui/img/general/WoodenTable.jpg"));
            g.drawImage(imagen,0,0, 1300,800, null);

        }
        catch (IOException e){
            System.out.println("No se logró acceder a la imagen en la ruta especificada");
        }
    }


    /**
     * Add the labels with the life and mana to the canvas
     */
    public CanvasGame() {

        this.setLayout(null);

        life.setBounds(50, 300, 100, 50);
        mana.setBounds(50, 350, 100, 50);
        summonedCard.setBounds(600, 50, 270, 350);
        life.setFont(new Font("Arial", Font.PLAIN, 30));
        mana.setFont(new Font("Arial", Font.PLAIN, 30));
        //updateSummonedCard("12");
        this.add(summonedCard);
        this.add(life);
        this.add(mana);
    }


    public void updateStats(String life, String mana){
        this.life.setText(life);
        this.mana.setText(mana);
    }

    /**
     * Add the buttons with the card images to the canvas
     *
     * @param handgame list of buttons representing the player hand of cards
     * @param skipTurn button to skip your turn
     */
    public void putButtons(JButton[] handgame, JButton skipTurn) {

        //ListCL listita =  new ListCL();


        for (int i = 0; i < 10; i++) {

            this.add(handgame[i]);

            //listita.insert(handgame[i]);

        }
        this.add(handgame[10]);
        this.add(skipTurn);
        /*if (!listita.verification()){
            listita.showList();

        }else{
            System.out.println("hdfdjfh");
        }*/
    }

    public void updateSummonedCard(String ID){
        ImageIcon cardImage = new ImageIcon("src/main/java/gui/img/cards/"+ ID +".png");
        this.summonedCard.setIcon(new ImageIcon(cardImage.getImage().getScaledInstance(
                summonedCard.getWidth(), summonedCard.getHeight(), Image.SCALE_SMOOTH)));
    }
}
