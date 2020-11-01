package Code;

public class Player {

    private static int life;
    private static int mana;


    public static void reset(){

        life = 1000;
        mana = 200;
    }

    public static void playMyTurn(Card card){

        String cardType = card.type;

        if(cardType.equals("Minion")) {

            mana -= card.manaCost;
        }
        else if (cardType.equals("Spells")){

            System.out.println("spell");
        }
        else if(cardType.equals("skip turn")){

            ;
        }
        regulateMana();
    }

    private static void regulateMana(){
        mana += 250;
        if (mana > 1000){
            mana = 1000;
        }
    }

    public static void opponentPlay(Card card){

        String cardType = card.type;

        if (cardType.equals("Minion")){

            life -= card.damage;
        }
        else if(cardType.equals("skip turn")){

            ;
        }
    }

    public static int getLife(){
        return life;
    }

    public static int getMana() {
        return mana;
    }

}