package Code;


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


    public static void reset(){

        life = 1000;
        mana = 200;
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

            ;
        }
        else if (cardType.equals("Spell")){

            playSpell(card);
        }
        else if(cardType.equals("skip turn")){

            ;
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

            life -= card.damage;
            return false;
        }

        else if (cardType.equals("Spell")){
            return opponentSpell(card);
        }

        else if(cardType.equals("skip turn")){

            return false;
        }

        else {
            return false;
        }

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
            regulateLife();
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

            return true;
        }

        else if (card_name.equals("Health")){

            ;
        }

        else if (card_name.equals("Max Power")){

            return false;
        }

        else if (card_name.equals("Increased Damage")){

            life -= life * 0.50;
        }

        else if (card_name.equals("Mana Leak")){

            mana = 0;
        }

        return false;

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

}