public class Customer {
    private String name;
    private String email;
    private String address;

    Customer(String name, String email, String address) {
        this.name = name;
        this.email = email;
        this.address = address;
    }

    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getAddress() { return address; }

    public void setName(String name) { this.name = name; }
    public void setEmail(String email) { this.email = email; }
    public void setAddress(String address) { this.address = address; }

    public void checkout(Inventory inventory, String title, int quantity) {
        Book book = inventory.findByTitle(title);
        if (book == null) {
            System.out.println("Quantum book store: Book not found with title \"" + title + "\"");
            return;
        }
        try {
            double total = inventory.buyBook(book.getISBN(), quantity, this.email, this.address);
            System.out.println("Quantum book store: " + name + " paid $" + total);
        } catch (IllegalArgumentException e) {
            System.out.println("Quantum book store: Purchase failed - " + e.getMessage());
        }
    }
}
