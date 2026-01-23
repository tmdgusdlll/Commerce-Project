package project;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

/**
 * 전체적인 구조 (참조 흐름)
 * CommerceSystem (Cart 객체를 통해 CartItem도 참조 가능, CartItem을 통해 Product까지 접근은 가능)
 * -> Cart (CartItem 객체의 cartItems을 리스트로 관리)
 * --> CartItem (Product 객체를 필드고 가지고 있으므로 참조 가능)
 * ---> Product
 */

public class CommerceSystem {
    // Product클래스와의 연결은 끊어짐. (카테고리나 리스트가 필요하면 Storage 클래스에게 요청하면 됨)

    // Storage, Cart 객체 생성 (참조 가능)
    Storage storage = new Storage();
    Cart cart = new Cart();

    // Storage에게 카데고리 목록을 만들어 달라고 요청 -> 그 결과(List<Category>)를 categories라는 이름의 변수에 담는다.
    List<Category> categories = storage.createCategories();

    public CommerceSystem() {
//        this.products = products;
    }

    void start() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println();
            showMainMenu();

            // 장바구니를 확인해서 비어있지 않으면 주문 관리창을 보여줘라.
            if (!cart.checkEmpty()) {
                showOrderManage();
            }

            int select;
            while (true) {
                try {
                    System.out.print("번호를 입력하세요: ");
                    select = Integer.parseInt(sc.nextLine());
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("숫자만 입력해주세요.");
                }

            }

            if (select == 0) {
                System.out.println("커머스 플랫폼을 종료합니다.");
                return;
            }
            if (select == 4) {
                if (cart.checkEmpty()) {
                    System.out.println("안 돼 돌아가.");
                } else {
                    showCart();
                    int as = Integer.parseInt(sc.nextLine());
                    if (as == 1) {
                        System.out.printf("주문이 완료되었습니다!" + "총 금액: %,d원%n", cart.getTotalPrice());
                        update();
                        cart.clear();
                    } else if (as == 2) {
                        continue;
                    }
                }
                continue;
            }
            if (select < 1 || select > categories.size()) {
                System.out.println("잘못된 입력입니다. 다시 선택해주세요.");
                continue;
            }

            // 카테고리 목록 중 선택한 숫자 - 1의 인덱스에 해당하는 카테고리를 가져와라. 그걸 selectedCategory 변수에 넣어라.
            Category selectedCategory = categories.get(select - 1);
            // selectedCategory 변수에 있는 해당 카테고리가 가진 상품 리스트를 가져와라. 그걸 list에 넣어라.
            List<Product> list = selectedCategory.getProducts();

            // TODO: 장바구니 상품 추가후 메인으로 가는 게 나은가 아님 카테고리에 머물러있는게 나은가..
            while (true) {
                // selectedCategory 변수에 있는 해당 카테고리를 showCategory 라는 메서드를 통해 보여주는 기능을 실행해라.
                selectedCategory.showCategory();
                int answer;
                while (true) {
                    try {
                        System.out.print("번호를 입력하세요: ");
                        answer = Integer.parseInt(sc.nextLine());
                        System.out.println();
                        break;
                    } catch (NumberFormatException e) {
                        System.out.println("숫자만 입력하세요.");
                    }
                }

                if (answer == 0) {
                    break;
                }
                if (answer < 1 || answer > list.size()) {
                    System.out.println("잘못된 입력입니다. 다시 선택해주세요.");
                    continue;
                }
                // 카테고리가 가진 상품 리스트 중 선택한 숫자 - 1인 인덱스에 해당하는 상품을 toDisplayString해서 가져와라.
                System.out.println("선택한 상품: " + list.get(answer - 1).toDisplayString());
                while (true) {
                    System.out.println("\"" + list.get(answer - 1).toDisplayString() + "\"");
                    System.out.println("위 상품을 장바구니에 추가하시겠습니까?");
                    System.out.println("1. 확인       2. 취소");
                    System.out.print("입력: ");
                    int respond;
                    while (true) {
                        try {
                            respond = Integer.parseInt(sc.nextLine());
                            break;
                        } catch (NumberFormatException e) {
                            System.out.println("잘못된 입력입니다.");
                        }
                    }
                    if (respond == 1) {
                        int respond2;
                        System.out.println("담을 수량을 입력해 주세요.");
                        while (true) {
                            try {
                                System.out.print("수량: ");
                                respond2 = Integer.parseInt(sc.nextLine());
                                break;
                            } catch (NumberFormatException e) {
                                System.out.println("숫자만 입력해주세요.");
                            }
                        }
                        boolean addOk = cart.addProduct(list.get(answer - 1), respond2);
                        if (addOk) {
                            // addOk가 true 라면 카트에 상품을 추가
                            System.out.println(list.get(answer - 1)
                                    .toDisplayString() + "가 " + respond2 + "개 장바구니에 추가되었습니다.");
                        } else {
                            System.out.println("재고가 부족합니다.");
                        }
                        break;
                    } else if (respond == 2) {
                        break;
                    }
                }
            }
        }
    }

    // 가장 첫 메인 보여주는 메서트
    public void showMainMenu() {
        System.out.println("[ 실시간 커머스 플랫폼 메인 ]");
        // 카테고리의 크기만큼 돌면서 출력해라.
        for (int i = 0; i < categories.size(); i++) {
            System.out.println((i + 1) + "." + categories.get(i).getCategoryName());
        }
        System.out.println("0.종료     | 프로그램 종료");
    }

    // 주문 관리 창 보여주는 메서드
    public void showOrderManage() {
        System.out.println();
        System.out.println("[ 주문 관리 ]");
        System.out.printf("%-1d.%-12s | %s%n", 4, "장바구니 확인", "장바구니를 확인 후 주문합니다.");
        System.out.printf("%-1d.%-13s | %s%n", 5, "주문 취소", "진행중인 주문을 취소합니다.");
    }

    // 장바구니에 담긴 상품 목록 보여주는 메서드
    public void showCart() {
        int total = 0;
        System.out.println("[ 장바구니 내역 ]");
        // Cart 객체를 통해 CartItem에 담긴 상품들(cartItems)을 순회하면서 item에 담는다.
        for (CartItem item : cart.getCartItems()) {
            // item이 참조하는 Product 객체를 변수 p에 담을 거다.
            Product p = item.getProduct();
            // item이 참조하는 Product 객체의 상품 가격을 price에 담을 거다.
            int price = item.getProduct().getPrice();
            // item이 참조하는 Product 객체의  상품의 수량을 qty에 담을 거다.
            int qty = item.getQuantity();
            System.out.printf("%-12s | %,d원 | %s | 수량: %d개%n", p.getName(), price, p.getDescription(), qty);
        }
        System.out.println();
        System.out.println("[ 총 주문 금액 ]");
        System.out.printf("%,d원%n", cart.getTotalPrice());
        System.out.println();
            System.out.println("1. 주문 확정        2. 메인으로 돌아가기");
        }


    // 주문 확정시 재고 업데이트, 날짜 출력
    public void update() {
        // 현재 날짜 출력
        LocalDate now = LocalDate.now();
        System.out.println("[" + now + " 변경됨]");

        // Cart 객체를 통해 CartItem에 담긴 상품들(cartItems)을 순회하면서 item에 담는다.
        for (CartItem item : cart.getCartItems()) {

            // CartItem의 item(임시 변수)이 참조하는 Product 객체의 상품을 p 변수에 담겠다.
            Product p = item.getProduct();

            // 수량을 qty 에 담겠다.
            int qty = item.getQuantity();

            // p의 재고량을 beStock에 담겠다.
            int beStock = p.getStock();

            // qty만큼 p의 재고를 차감하겠다.
            p.decStock(qty);

            // 차감하고 남은 p의 재고를 afStock에 담겠다.
            int afStock = p.getStock();

            System.out.printf("%s 재고가 %d개 → %d개로 업데이트되었습니다.%n", p.getName(), beStock, afStock);
        }
    }
}
