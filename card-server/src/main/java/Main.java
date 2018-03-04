import cards.CardSupplier;
import cards.Stack;
import com.google.gson.Gson;
import jdk.nashorn.internal.objects.NativeJSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import spark.*;
import spark.utils.IOUtils;

import java.io.InputStream;

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
        Spark.get("/test", (req,res) -> {
            res.type("application/json");

            return "Created deck with ID: " + CardManagement.getInstance().createGame();
        });
        Spark.get("/deck", (req,res) ->{
            System.out.println("Accuiring Deck for id " + req.queryParams("deckId"));
            Stack st = CardManagement.getInstance().getStack(req.queryParams("deckId"));
            res.type("application/json");
            st.shuffleCards();
            return "Deck size " + st.getRemaining() + gson.toJson(st, Stack.class);
        });

    }
}
