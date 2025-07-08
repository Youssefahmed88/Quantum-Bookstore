import java.util.*;

public class Inventory {
    private Map<String, StockItem> inventoryMap = new HashMap<>();

    public void addBook(Book book, int quantity) {
        inventoryMap.put(book.getISBN(), new StockItem(book, quantity));
    }

    public void removeOutdatedBooks(int currentYear, int maxAge) {
        List<String> outdatedBooks = new ArrayList<>();

        for (Map.Entry<String, StockItem> entry : inventoryMap.entrySet()) {

            int publishYear = entry.getValue().getBook().getPublishYear();
            int age = currentYear - publishYear;

            if (age > maxAge) {
                outdatedBooks.add(entry.getKey());
            }
        }

        for (String isbn : outdatedBooks) {
            inventoryMap.remove(isbn);
            System.out.println("Quantum book store: Removed outdated book with ISBN: " + isbn);
        }
    }

    public Book findByTitle(String title){
        for (StockItem item : inventoryMap.values()) {
            if (item.getBook().getTitle().equalsIgnoreCase(title)) {
                return item.getBook();
            }
        }
        return null;
    }

    public StockItem findBookWithQuantity(String title) {
        for (StockItem item : inventoryMap.values()) {
            if (item.getBook().getTitle().equalsIgnoreCase(title)) {
                return item;
            }
        }
        return null;
    }

    public double buyBook(String isbn, int quantity, String email, String address) {
        StockItem entry = inventoryMap.get(isbn);
        if (entry == null) {
            throw new IllegalArgumentException("Quantum book store: Book not found.");
        }
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be positive.");
        }
        entry.reduceQuantity(quantity);
        Book book = entry.getBook();
        double total = book.getPrice() * quantity;
        book.deliver(quantity, email, address); // استدعاء الـ handler
        System.out.println("Quantum book store: Sold " + book.getTitle() + " Quantity: " + quantity);
        return total;
    }
}
