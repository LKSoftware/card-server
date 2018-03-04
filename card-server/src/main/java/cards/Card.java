package cards;

/**
 * A simple card object containing all infos for the playing card.
 * Used as a model in JSON.
 *
 * @author leonk
 */
public class Card {

    String image = "image";
    CardValue value = null;
    CardSuit suit = null;
    String code = "code";

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public CardValue getValue() {
        return value;
    }

    public void setValue(CardValue value) {
        this.value = value;
    }

    public CardSuit getSuite() {
        return suit;
    }

    public void setSuite(CardSuit suite) {
        this.suit = suite;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
