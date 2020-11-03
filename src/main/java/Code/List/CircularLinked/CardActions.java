package Code.List.CircularLinked;


/**
 * This class give us in what place the next card will
 * will be added, making easier the activation process
 */
public class CardActions {
    private boolean flagList[];
    private int poss;

    /**
     * This is the constructor if this class
     * @param flagList
     */

    public CardActions(boolean flagList[]){
        this.flagList = flagList;

    }

    /**
     * It give us a list of boolean values where in some
     * they are the ones that determine what position or which
     * button needs to be turned on
     * @return b
     */
    public boolean[] getFlagList() {

        return flagList;
    }


    /**
     * It gives us what are the possible positions
     * where a new card will be added
     * @param flagList
     */
    public void setFlagList(boolean[] flagList) {
        this.flagList = flagList;
    }

    /**
     * This method is the one that determines which
     * position needs to be turned on.
     * @return
     */
    public int SiteAnalysis(){

        for(int i = 0; i < 10; i++){

            if (flagList[i] != true){
                poss = i;
                flagList[i] = true;
                break;

            }else{

            }
        }
        return poss;
    }
}
