package project;


import java.util.ArrayList;
import java.util.List;

// 싱픔을 장바구니에 추가시 CartItem 클래스에 담긴 상품들을 리스트로 관리하고
// 주문가능 여부(재고)를 확인하는 클래스
// 총 금액 계산까지..?
public class Cart {
    List<CartItem> cartItems = new ArrayList<>();



    // TODO: addproduct(완료), 조회(완료), totalPrice
    public boolean addProduct(Product product, int quantity) {
        if (!product.checkStock(quantity)) {
            return false;
        }
        cartItems.add(new CartItem(product,quantity));
        return true;
    }

    // 장바구니 비어있는 지?
    public boolean checkEmpty() {
        return cartItems.isEmpty();
    }

    // 장바구니 조회..?
    public List<CartItem> getCartItems() {
        return cartItems;
    }

    public int getTotalPrice() {
        int total = 0;
        for (CartItem item : cartItems) {
            int price = item.getProduct().getPrice();
            int qty = item.getQuantity();
            total += price * qty;
        }
        return total;
    }

    public void clear() {
        cartItems.clear();
    }
}
