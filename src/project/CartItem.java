package project;


// 추가 된 여러 타입의 상품들
public class CartItem {

    // CartItem는Pr oduct객체를 참조한다
    Product product;
//    int price;
    int quantity;

    // 객체가 생성될 때 (상품, 수량)의 형태를 갖춰라
    // 생성될 때, Product 객체와 수량 값을 전달받아서 그대로 저장하겠다.
    public CartItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }
}
