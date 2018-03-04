import jdk.nashorn.internal.objects.NativeJSON;
import spark.*;
import spark.utils.IOUtils;

import java.io.InputStream;

public class Main {
    public static void main(String... args)
    {
        Spark.port(7788);
        Spark.get("/spark", (req,res) -> {
            res.type("application/json");
            return IOUtils.toString(Main.class.getClassLoader().getResourceAsStream("cards/CardList.json"));
        });

    }
}
