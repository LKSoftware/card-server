package cards;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.FileReader;
import java.util.ArrayList;

public class CardSupplier {

    private static final CardSupplier INSTANCE = new CardSupplier();

    private Gson gson = new Gson();

    public static CardSupplier getInstance() {
        return INSTANCE;
    }

    private CardSupplier() {
    }

    public ArrayList<Card> generateDeck()
    {
        JsonParser parser = new JsonParser();
        ArrayList<Card> list = new ArrayList<>();
        try
        {
            JsonObject json = (JsonObject)parser.parse(new FileReader(
                    CardSupplier.class.getClassLoader().getResource("cards/CardList.json").getPath()));

            for(int i = 0; i < json.keySet().size(); i++)
            {
                Card card = new Card();
                JsonObject obj = json.getAsJsonObject(String.valueOf(i));
                card.setValue(CardValue.valueOf(obj.get("value").getAsString()));
                card.setSuite(CardSuit.valueOf(obj.get("suit").getAsString()));
                card.setCode(obj.get("code").getAsString());
                list.add(card);
            }
            return list;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }
}
