package Code.List.Stack;

import java.util.Random;

public class RandomCards {

    public RandomCards() {

    }

    /**
     * It hive us the firsts four card, that are the
     * ones that appears originally in the game hand
     * @return
     */
    public int[] RandomHand (){
        int hand [] = {0, 0, 0, 0};
        Random random = new Random();
        for (int i = 0; i < 4; i++){
            hand[i] = random.nextInt(7);
        }
        return hand;
    }

    /**
     * It give us all the sixteen cards that are going
     * to be located in the deck of each player.
     * @return
     */
    public int RandomDeck(){
        Random random = new Random();
        return random.nextInt(19);
    }
}
