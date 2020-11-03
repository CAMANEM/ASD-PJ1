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
    JTextArea area = new JTextArea();


    /**
     * Draws the background image
     * @param g
     */
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Image imagen;
        try{
            imagen = ImageIO.read(new File("src/main/java/gui/img/general/WoodenTable.jpg"));
            g.drawImage(imagen,0,0, 1600,800, null);

        }
        catch (IOException e){
            System.out.println("No se logró acceder a la imagen en la ruta especificada");
        }
    }

    public void history(String data){
        area.append(data + "\n");

    }


    /**
     * Add the labels with the life and mana to the canvas
     */
    public CanvasGame() {
        area.setBounds(1310, 100, 260, 500);
        area.setEditable(false);
        this.add(area);

        this.setLayout(null);

        life.setBounds(50, 300, 100, 50);
        mana.setBounds(50, 350, 100, 50);
        summonedCard.setBounds(600, 50, 270, 350);
        life.setFont(new Font("Arial", Font.PLAIN, 30));
        mana.setFont(new Font("Arial", Font.PLAIN, 30));
        this.add(summonedCard);
        this.add(life);
        this.add(mana);
    }


    /**
     * Update the life and mana points of the player in the GUI.
     *
     * @param life
     * @param mana
     */
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

    /**
     * Updates the card image of the last card summoned by the
     * player.
     *
     * @param ID of the card summoned.
     */
    public void updateSummonedCard(String ID){
        ImageIcon cardImage = new ImageIcon("src/main/java/gui/img/cards/"+ ID +".png");
        this.summonedCard.setIcon(new ImageIcon(cardImage.getImage().getScaledInstance(
                summonedCard.getWidth(), summonedCard.getHeight(), Image.SCALE_SMOOTH)));
    }
}
