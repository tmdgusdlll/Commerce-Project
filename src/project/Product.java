package project;

public class Product {
    private String name;
    private int price;
    private String explain;
    private int quantity;

    public Product(String name, int price, String explain, int quantity) {
        this.name = name;
        this.price = price;
        this.explain = explain;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getExplain() {
        return explain;
    }

    public void setExplain(String explain) {
        this.explain = explain;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", explain='" + explain + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
