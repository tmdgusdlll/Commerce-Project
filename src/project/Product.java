package project;

public class Product {
    private String name;
    private int price;
    private String description;
    private int stock;

    public Product(String name, int price, String description, int stock) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.stock = stock;
    }

    public String getName() {
        return name;
    }

//    public void setName(String name) {
//        this.name = name;
//    }

    public int getPrice() {
        return price;
    }

//    public void setPrice(int price) {
//        this.price = price;
//    }

    public String getDescription() {
        return description;
    }

//    public void setDescription(String description) {
//        this.description = description;
//    }

    public int getStock() {
        return stock;
    }

    // 세터를 사용해 재고를 차감하는 것 보다 새로운 메서드를 이용하는 것이 효율적이다 라고 판단
//    public void setStock(int stock) {
//        this.stock = stock;
//    }

    // 재고 확인 메서드
    public boolean checkStock(int inputStock) {
        return stock >= inputStock;
    }

    // 재고 차감 메서드
    public void decStock(int inputStock) {
        if (checkStock(inputStock)) {
            stock -= inputStock;
        }
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", explain='" + description + '\'' +
                ", quantity=" + stock +
                '}';
    }

    public String toDisplayString() {
        return String.format("%s | %,d원 | %s|",
                name, price, description);
    }

}
