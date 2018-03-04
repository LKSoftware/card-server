package cards;

public class CardSupplier {
    private static final CardSupplier INSTANCE = new CardSupplier();

    public static CardSupplier getInstance() {
        return INSTANCE;
    }

    private CardSupplier() {
    }
}
