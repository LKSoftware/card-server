import cards.Stack;

import java.util.ArrayList;
import java.util.UUID;

/**
 * CardManagement holds all the methods for playing a deck of cards adding, removing, generating and distributing cards.
 */
public class CardManagement {

    private static final CardManagement INSTANCE = new CardManagement();

    public static ArrayList<Stack> stacks = new ArrayList<>();

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
        stacks.add(new Stack());
        return result;
    }
}
