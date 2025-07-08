public class Main {
    public static void main(String[] args) {
        // Register book types
        System.out.println("Registering book types...");
        BookTypeRegistry.register("PDF", "email", "Sending PDF of {title} to {email}");
        BookTypeRegistry.register("Paper", "ship", "Shipping {quantity} copies of {title} to {address}");
        BookTypeRegistry.register("audiobook", "email", "Sending audio file of {title} to {email}");
        BookTypeRegistry.register("comic", "ship", "Shipping {quantity} copies of {title} to {address}");

        // Create inventory
        System.out.println("\nSetting up inventory...");
        Inventory inventory = new Inventory();
        Book pdfBook = new Book("123", "Java Programming", "John Doe", 2020, 29.99, "PDF");
        Book paperBook = new Book("456", "Python Basics", "Jane Smith", 2018, 39.99, "Paper");
        Book audioBook = new Book("789", "AI Revolution", "Sam Altman", 2023, 19.99, "audiobook");
        Book comic = new Book("111", "Superhero Saga", "Comic Inc.", 2022, 14.99, "comic");
        inventory.addBook(pdfBook, 10);
        inventory.addBook(paperBook, 5);
        inventory.addBook(audioBook, 3);
        inventory.addBook(comic, 4);

        // Create customers
        Customer customer = new Customer("Ali", "ali@example.com", "123 Tahrir Street");
        Customer invalidCustomer = new Customer("Bob", "invalid-email", "");

        //  Case 1-4: Valid purchases
        System.out.println("\nCase 4: Buying Books");
        customer.checkout(inventory, "Java Programming", 2);

        customer.checkout(inventory, "Python Basics", 1);

        customer.checkout(inventory, "AI Revolution", 1);

        customer.checkout(inventory, "Superhero Saga", 2);

        //  Case 5: Book not found
        System.out.println("\nCase 5: Trying to buy a non-existent book");
        customer.checkout(inventory, "Nonexistent Book", 1);

        //  Case 6: Not enough quantity
        System.out.println("\nCase 6: Trying to buy more copies than available");
        customer.checkout(inventory, "Python Basics", 10);

        //  Case 7 & 8: Invalid quantity
        System.out.println("\nCase 7: Trying to buy zero copies");
        try {
            inventory.buyBook("123", 0, "ali@example.com", "123 Tahrir Street");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("\nCase 8: Trying to buy negative quantity");
        try {
            inventory.buyBook("123", -1, "ali@example.com", "123 Tahrir Street");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        //  Case 11: Unknown book type
        System.out.println("\nCase 11: Trying to buy a book with unknown type");
        Book unknownTypeBook = new Book("000", "Unknown Book", "Author", 2023, 15.99, "unknown");
        inventory.addBook(unknownTypeBook, 5);
        customer.checkout(inventory, "Unknown Book", 1);

        //  Case 12: Remove outdated books
        System.out.println("\nCase 12: Removing outdated books (older than 5 years in 2025)");
        inventory.removeOutdatedBooks(2025, 5);
    }
}
