public class Book {
    private String ISBN;
    private String title;
    private String author;
    private int publishYear;
    private double price;
    private String type;

    public Book(String ISBN, String title, String author, int publishYear, double price, String type) {
        this.ISBN = ISBN;
        this.title = title;
        this.author = author;
        this.publishYear = publishYear;
        this.price = price;
        this.type = type;
    }

    public void deliver(int quantity, String email, String address) {
        if (email == null || !email.contains("@")) {
            throw new IllegalArgumentException("Invalid email address.");
        }
        if (address == null || address.trim().isEmpty()) {
            throw new IllegalArgumentException("Address cannot be empty.");
        }
        BookTypeRegistry.get(type).handlePurchase(this, quantity, email, address);
    }

    // Getters
    public String getISBN() {return ISBN;}
    public String getTitle() {return title;}
    public String getAuthor() {return author;}
    public int getPublishYear() {return publishYear;}
    public double getPrice() {return price;}
    public String getType() {return type;}

    // Setters
    public void setISBN(String ISBN) {this.ISBN = ISBN;}
    public void setTitle(String title) {this.title = title;}
    public void setAuthor(String author) {this.author = author;}
    public void setPublishYear(int publishYear) {this.publishYear = publishYear;}
    public void setPrice(double price) {this.price = price;}
    public void setType(String type) {this.type = type;}

    @Override
    public String toString() {
        return title + " by " + author + " (" + publishYear + ") - $" + price + type;
    }


}
