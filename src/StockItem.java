public class StockItem {
    private Book book;
    private int quantity;

    public StockItem(Book book, int quantity) {
        this.book = book;
        this.quantity = quantity;
    }

    public Book getBook() {
        return book;
    }

    public int getQuantity() {
        return quantity;
    }

    public void reduceQuantity(int amount) {
        if (amount > quantity) {
            throw new IllegalArgumentException("Quantum book store: Not enough stock.");
        }
        quantity -= amount;
    }

    public void increaseQuantity(int amount) {
        quantity += amount;
    }
}
