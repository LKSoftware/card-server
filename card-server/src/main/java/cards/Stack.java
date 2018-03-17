package cards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Random;

/**
 * Defines a stack of cards containing all cards.
 * Used as a model in JSON.
 *
 * @author leonk
 */
public class Stack {

    private String deckId  = null;

    private boolean shuffeld = false;

    private String backgroundImage = "";

    private String pathToImages = "";

    private ArrayList<Card> cards = new ArrayList<>();

    private HashMap<String, ArrayList<Card>> hands = new HashMap<>();

    public String getCardImage(Card card)
    {
        return pathToImages + card.code + ".png";
    }

    public String getDeckId() {
        return deckId;
    }

    public void setDeckId(String deckId) {
        this.deckId = deckId;
    }

    public boolean isShuffeld() {
        return shuffeld;
    }

    public void setShuffeld(boolean shuffeld) {
        this.shuffeld = shuffeld;
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public void setCards(ArrayList<Card> cards) {
        this.cards = cards;
    }

    public int getRemaining()
    {
        return cards.size();
    }

    public void shuffleCards() {
        Collections.shuffle(cards);
        shuffeld = true;
    }

    public ArrayList<Card> drawToHand(int times, String hand){
        if(times >= getRemaining())
        {
            ArrayList<Card> drawn = drawCards(times);
            hands.put(hand, drawn);
            return drawn;
        }
        return null;
    }

    private ArrayList<Card> drawCards(int times)
    {
        Random rand = new Random(915195l);
        ArrayList<Card> drawn = new ArrayList<>();
        for (int i = 0; i < times; i++)
        {
            int item = rand.nextInt(cards.size());
            drawn.add(cards.get(item));
            cards.remove(item);
        }
        return drawn;
    }

}
