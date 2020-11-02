package Code;


/**
 * Description
 *
 * @version 1.2
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

    private static void regulateLife(){
        if (life > 1000){
            life = 1000;
        }
    }

    private static void regulateMana(){
        mana += 250;
        if (mana > 1000){
            mana = 1000;
        }
    }

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

    public static int getLife(){
        return life;
    }

    public static int getMana() {
        return mana;
    }


    private static void playSpell(Card card){

        String cardName = card.cardName;
        if (cardName.equals("Freeze")){

            ;
        }

        else if (cardName.equals("Health")){

            System.out.println("holi");
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
    }


    /**
     * Perform the action determined for each spell
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

        return false;

    }

    public static boolean getMaxPower(){

        return maxPower;
    }

    public static int getCounterMP(){

        return counterMP;
    }

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