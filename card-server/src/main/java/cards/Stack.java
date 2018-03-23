package cards;

import java.util.*;

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

    private List<Card> cards = new ArrayList<>();

    private Map<String, List<Card>> hands = new HashMap<>();

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

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
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

    public List<Card> drawToHand(String hand, int times){
        if(times <= getRemaining())
        {
            List<Card> drawn = drawCards(times);
            hands.put(hand, drawn);
            return drawn;
        }
        return Collections.emptyList();
    }

    private List<Card> drawCards(int times)
    {
        Random rand = new Random(915195l);
        List<Card> drawn = new ArrayList<>();
        for (int i = 0; i < times; i++)
        {
            int item = rand.nextInt(cards.size());
            drawn.add(cards.get(item));
            cards.remove(item);
        }
        return drawn;
    }

}
