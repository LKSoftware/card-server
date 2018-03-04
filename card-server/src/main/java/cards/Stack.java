package cards;

import java.util.ArrayList;

/**
 * Defines a stack of cards containing all cards.
 * Used as a model in JSON.
 *
 * @author leonk
 */
public class Stack {

    String deckId  = null;

    boolean shuffeld = false;

    ArrayList<Card> cards = new ArrayList<>();

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

}
