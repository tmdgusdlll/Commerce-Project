package project;


import java.util.ArrayList;
import java.util.List;

// 싱픔을 장바구니에 추가시 CartItem 클래스에 담긴 상품들을 리스트로 관리하고
// 주문가능 여부(재고)를 확인하는 클래스
// 총 금액 계산까지..?
public class Cart {

    // CartItem 클래스의 객체 생성하는데 List로 관리 할 거다. 변수명은 cartItems (참조 가능)
    List<CartItem> cartItems = new ArrayList<>();



    // TODO: addproduct(완료), 조회(완료), totalPrice(완료)
    // 상품을 장바구니에 추가할 건데,
    public boolean addProduct(Product product, int quantity) {
        // 입력받은 수량(quantity)를 checkStock 메서드를 통해 체크했을 때, true 가 아니라면(입력수량>재고) false 반환
        if (!product.checkStock(quantity)) {
            return false;
        }
        // true라면 이름, 수량 형태로 카트아이템(리스트)에 추가해라.
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

    // 장바구니에 담긴 상품들 총 가격 계산
    public int getTotalPrice() {
        int total = 0;
        // cartItems(리스트)를 순회하면서 item을 담을 거다.
        for (CartItem item : cartItems) {
            // item이 참조하고 있는 Product 객체의 상품의 가격을 price 변수에 담겠다
            int price = item.getProduct().getPrice();
            // item이 참조하고 있는 Product 객체의 수량을 qty 변수에 담겠다.
            int qty = item.getQuantity();
            total += price * qty;
        }
        return total;
    }

    // 장바구니 초기화
    public void clear() {
        cartItems.clear();
    }
}
