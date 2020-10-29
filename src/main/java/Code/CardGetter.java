package Code;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.JsonNode;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.BufferedReader;
import java.io.FileReader;


public class CardGetter {

    private final static Logger logger = Logger.getLogger( Logger.GLOBAL_LOGGER_NAME );
    private static ObjectMapper objectMapper = new ObjectMapper();


    /**
     * Returns a Card object according to the given cardID.
     *
     * @param cardID
     * @return Card
     */
    public static Card getCard(String cardID){
        Card card = null;
        JsonNode cards = readJson();

        try {
            card = objectMapper.treeToValue(cards.get(cardID), Card.class);

        } catch (JsonProcessingException e) {
            logger.log(Level.SEVERE, "Error getting Card");
        }

        return card;
    }

    /**
     * It reads the json file with all the cards information and returns it as a JsonNode
     *
     * @return cards -> a JsonNode containing all the cards info
     */
    private static JsonNode readJson() {
        JsonNode cards = null;
        try {
            String json;
            BufferedReader br = new BufferedReader(new FileReader("src/main/java/Code/cards.json"));

            try {
                StringBuilder sb = new StringBuilder();
                String line = br.readLine();

                while (line != null) {
                    sb.append(line);
                    sb.append(System.lineSeparator());
                    line = br.readLine();
                }
                json = sb.toString();
                cards = objectMapper.readTree(json);
            }
            finally {
                br.close();
            }
        }
        catch (Exception e){
            logger.log(Level.SEVERE, "Error reading json-cards");
        }
        return cards;
    }


    /**
     * It converts a Card Object into a String to send it as a message.
     * @param card
     * @return cardString
     */
    public static String getCardString(Card card){
        String cardString = null;
        try {
            cardString = objectMapper.writeValueAsString(card);
        }
        catch (JsonProcessingException e){
            logger.log(Level.SEVERE, "Error converting card to string");
        }
        return cardString;
    }


    /**
     * It converts a received message into a Card object
     * @param message
     * @return card
     */
    public static Card getCardfromMessage(String message){
        Card card = null;
        try {
            JsonNode messageNode = objectMapper.readTree(message);
            card = objectMapper.treeToValue(messageNode, Card.class);
        }
        catch (JsonProcessingException e){
            logger.log(Level.SEVERE, "Error converting message to Card Object");
        }
        return card;
    }
}
