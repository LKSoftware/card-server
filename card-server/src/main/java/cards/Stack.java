package cards;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Defines a stack of cards containing all cards.
 * Used as a model in JSON.
 *
 * @author leonk
 */
public class Stack {

    private String deckId  = null;

    private boolean shuffeld = false;

    private ArrayList<Card> cards = new ArrayList<>();

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
    public void shuffleCards()
    {
        Collections.shuffle(cards);
        shuffeld = true;
    }

}
