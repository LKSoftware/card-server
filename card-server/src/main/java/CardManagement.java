import cards.Card;
import cards.CardSupplier;
import cards.Stack;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

/**
 * CardManagement holds all the methods for playing a deck of cards adding, removing, generating and distributing cards.
 */
public class CardManagement {

    private static final Logger LOG = LoggerFactory.getLogger(CardManagement.class);
    private static final CardManagement INSTANCE = new CardManagement();

    public static HashMap<String, Stack> stacks = new HashMap<>();

    private CardManagement()
    {
        //SINGLETON
    }
    public static CardManagement getInstance()
    {
        return INSTANCE;
    }

    public String createGame()
    {
        Stack stack = new Stack();
        String result = UUID.randomUUID().toString();
        stack.setDeckId(result);
        stack.setCards(CardSupplier.getInstance().generateDeck());
        if(stack.getCards().isEmpty())
        {
            throw new RuntimeException("Couldn't generate Deck");
        }
        LOG.info("Created a new deck with id: " + result);
        stacks.put(result,stack);
        LOG.info("Added a Deck to the stacks with id: " + result);
        return result;
    }
    public Stack getStack(String id)
    {
        return stacks.get(id);
    }
}
