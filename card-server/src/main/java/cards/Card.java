package cards;

/**
 * A simple card object containing all infos for the playing card.
 * Used as a model in JSON.
 *
 * @author leonk
 */
class Card {

    String image = "image";
    CardValue value = null;
    CardSuite suite = null;
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

    public CardSuite getSuite() {
        return suite;
    }

    public void setSuite(CardSuite suite) {
        this.suite = suite;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
