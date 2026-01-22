package project;


import java.util.ArrayList;
import java.util.List;

// 싱픔을 장바구니에 추가시 CartItem 클래스에 담긴 상품들을 리스트로 관리하고
// 주문가능 여부(재고)를 확인하는 클래스
// 총 금액 계산까지..?
public class Cart {
    List<CartItem> cartItems = new ArrayList<>();



    // addproduct, totalPrice, 조회
    public boolean addProduct(Product product, int quantity) {
        if (!product.checkStock(quantity)) {
            return false;
        }
        cartItems.add(new CartItem(product,quantity));
        return true;
    }




}
