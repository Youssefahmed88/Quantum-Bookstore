import java.util.HashMap;
import java.util.Map;

public class BookTypeRegistry {
    private static final Map<String, BookTypeHandler> handlers = new HashMap<>();

    public static void register(String type, String deliveryMethod, String messageTemplate) {
        handlers.put(type.toLowerCase(), (book, quantity, email, address) -> {
            String message = messageTemplate
                    .replace("{title}", book.getTitle())
                    .replace("{quantity}", String.valueOf(quantity))
                    .replace("{email}", email)
                    .replace("{address}", address);
            System.out.println("Quantum book store: " + message);
        });
    }

    public static BookTypeHandler get(String type) {
        BookTypeHandler handler = handlers.get(type.toLowerCase());
        if (handler == null) {
            throw new IllegalArgumentException("Unknown book type: " + type);
        }
        return handler;
    }
}