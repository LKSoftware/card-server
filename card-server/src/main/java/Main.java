import cards.Card;
import cards.CardSupplier;
import cards.Stack;
import com.google.gson.Gson;
import jdk.nashorn.internal.objects.NativeJSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import spark.*;
import spark.utils.IOUtils;

import java.io.InputStream;
import java.util.List;

public class Main {
    private static final Logger LOG = LoggerFactory.getLogger(Main.class);

    public static final Gson gson = new Gson();
    public static void main(String... args)
    {
        Spark.port(7788);
        Spark.get("/spark", (req,res) -> {
            res.type("application/json");
            return IOUtils.toString(Main.class.getClassLoader().getResourceAsStream("cards/CardList.json"));
        });
        Spark.get("/create", (req,res) -> {
            res.type("application/json");

            return gson.toJson(CardManagement.getInstance().createGame());
        });
        Spark.get("/deck", (req,res) ->{
            res.type("application/json");
            String deckId = req.queryParams("deckId");
            LOG.info("Accuiring Deck for id " + deckId);
            return CardManagement.getInstance().getStackAsJson(deckId);
        });
        Spark.get("/draw", (req,res) ->{
            res.type("application/json");
            String deckId = req.queryParams("deckId");
            String hand = req.queryParams("hand");
            int cards = Integer.valueOf(req.queryParams("cards"));
            LOG.info("Drawing from " + deckId);
            return gson.toJson(CardManagement.getInstance().drawCards(deckId,hand,cards), List.class);
        });


    }
}
