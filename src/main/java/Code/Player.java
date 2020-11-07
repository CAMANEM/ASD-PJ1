package Code;


import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

/**
 * This class represents the life and mana of the player
 * and his methods controls the changes made by other
 * cards.
 *
 * @version 1.3
 */
public class Player {

    private static int life;
    private static int mana;
    private static boolean maxPower = false;
    private static int counterMP;
    private static String secret;


    public static void reset(){
        life = 1000;
        mana = 200;
        secret = "";
    }


    /**
     * This method is called when the player plays
     * his turn and apply the necessary changes
     * on his life and mana.
     *
     * @param card the card summoned for the player.
     */
    public static void playMyTurn(Card card){

        String cardType = card.type;

        if (!maxPower) {
            mana -= card.manaCost;
            regulateMana();
        }

        if(cardType.equals("Minion")) {

            if (secret.equals("Devastation")) {
                playSound("33");
                secret = "";
            }
            else if (secret.equals("Claw Grinding")){
                mana += 100;
                secret = "";
            }

        }
        else if (cardType.equals("Spell")){

            if (secret.equals("Discover Magic")){
                playSound("37");
            }
            playSpell(card);
        }
        else if(cardType.equals("skip turn")){

            if (secret.equals("Magic Circle")){
                playSound("35");
            }
        }

        else if (cardType.equals("Secret")){

            secret = card.cardName;
        }
    }


    /**
     * It ensures the health don´t exceed the 1000 points.
     */
    private static void regulateLife(){
        if (life > 1000){
            life = 1000;
        }
    }


    /**
     * It ensures that the mana don´t exceed the 1000 points.
     */
    private static void regulateMana(){
        mana += 250;
        if (mana > 1000){
            mana = 1000;
        }
    }

    /**
     * This method is called when the opponent player played
     * his turn and apply the necessary changes
     * on life and mana.
     *
     * @param card the cards summoned by opponent.
     * @return true if player turn is skipped.
     */
    public static boolean opponentPlay(Card card){

        String cardType = card.type;

        if (cardType.equals("Minion")){

            card = counterSecret(card);
            life -= card.damage;
            if(secret.equals("Death")){
                playSound("36");
            }
            return false;
        }

        else if (cardType.equals("Spell")){
            if (secret.equals("Golem of Mana")){
                mana += card.manaCost;
                regulateMana();
                secret = "";
            }
            return opponentSpell(card);
        }

        else if(cardType.equals("skip turn")){

            if (secret.equals("Storm")){
                playSound("34");
            }
            return false;
        }

        else if(cardType.equals("Secret")){
            if (secret.equals("Storm")){
                playSound("34");
            }
        }
        return false;
    }


    /**
     * @return the player´s life points.
     */
    public static int getLife(){
        return life;
    }

    /**
     * @return the player´s mana points.
     */
    public static int getMana() {
        return mana;
    }


    /**
     * Is called when the player summons a Spell card
     * and executes the necessary changes on life
     * and mana.
     *
     * @param card the card summoned.
     */
    private static void playSpell(Card card){

        String cardName = card.cardName;
        if (cardName.equals("Freeze")){

            ;
        }

        else if (cardName.equals("Health")){

            life += card.healing;
            enhanceSecret(card);
            regulateLife();
        }

        else if (cardName.equals("Max Power")){

            maxPower = true;
            counterMP = 0;
        }

        else if (cardName.equals("Steal")){

            ;
        }

        else if (cardName.equals("Max Health")){

            life += life * 0.50;
            card.healing = (int) (life * 0.50);
            enhanceSecret(card);
            regulateLife();
        }
        else if (cardName.equals("Increased Damage")){
            if (secret.equals("Devastation")){
                playSound("33");
                secret = "";
            }
        }
    }


    /**
     * Perform the action determined for each spell summoned
     * by the opponent.
     *
     * @param card the card received by the opponent
     * @return true if the card freezes your turn
     * @return false if it does not.
     */
    private static boolean opponentSpell(Card card){

        String card_name = card.cardName;

        if (card_name.equals("Freeze")){

            if (secret.equals("Condense")){
                playSound("32");
            }
            return true;
        }

        else if (card_name.equals("Health")){

            if (secret.equals("Storm")){
                playSound("34");
            }
        }

        else if (card_name.equals("Max Power")){

            if (secret.equals("Storm")){
                playSound("34");
            }
        }

        else if (card_name.equals("Increased Damage")){

            life -= life * 0.50;
            if(secret.equals("Death")){
                playSound("36");
            }
        }

        else if (card_name.equals("Mana Leak")){

            if (secret.equals("Storm")){
                playSound("34");
            }
            mana = 0;
        }

        return false;
    }


    /**
     * Returns the damage of the card, but the
     * damage divided at 50%
     * @param card specific card
     * @return card with the new value
     */
    private static Card counterSecret(Card card){

        if (secret.equals("Claw Break") && card.type.equals("Minion")){
            card.damage = (int) (card.damage * 0.50);
            secret = "";
        }
        return card;
    }

    /**
     * It increases the mana value in relation
     * to the card value
     * @param card
     */
    private static void enhanceSecret(Card card){

        if (secret.equals("Magic Stones of Mana")){

            mana += card.healing;
            secret = "";
        }
    }


    /**
     * Returns a boolean representing if the Max Power
     * is active.
     *
     * @return true if it is active.
     */
    public static boolean getMaxPower(){

        return maxPower;
    }


    /**
     * Returns the number of invocations made using max power.
     * @return
     */
    public static int getCounterMP(){

        return counterMP;
    }

    /**
     * It deactivates the Max Power when
     * the three cards were summoned.
     */
    public static void regulateMaxPower() {

        if (maxPower) {

            if (counterMP == 3){

                maxPower = false;
            }

            else {
                counterMP += 1;
            }
        }
    }

    /**
     * It plays an specific sound according
     * to the action provided
     * @param sound sound name
     */
    public static void playSound(String sound){
        secret = "";
        try {
            File file = new File("src/main/java/gui/sounds/" + sound + ".wav");
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(file));
            clip.start();
        }
        catch (Exception e){

            System.out.println("Agregar un logger" + e);
        }
    }
}