package project;

import java.util.List;
import java.util.Scanner;

public class CommerceSystem {
    // Product클래스와의 연결은 끊어짐. (카테고리나 리스트가 필요하면 Storage 클래스에게 요청하면 됨)

    // Storage 객체 생성
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
            showMainMenu();
            if (!cart.checkEmpty()) {
                showOrderManage();
            }

            System.out.print("번호를 입력하세요: ");
            int select = Integer.parseInt(sc.nextLine());

            if (select == 0) {
                System.out.println("커머스 플랫폼을 종료합니다.");
                return;
            }
            if (select == 4) {
                if (cart.checkEmpty()) {
                    System.out.println("안 돼 돌아가.");
                } else {
                    // TODO: 장바구니 확인 / 주문 처리
                    showCart();
                    int as = Integer.parseInt(sc.nextLine());
                    if (as == 1) {
                        System.out.printf("주문이 완료되었습니다!" + "총 금액: %,d원%n", cart.getTotalPrice());
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

            // 카테고리 목록 중 선택한 숫자 - 1의 인덱스의 카테고리를 가져와라. 그걸 selectedCategory 변수에 넣어라.
            Category selectedCategory = categories.get(select - 1);

            // selectedCategory 변수에 있는 해당 카테고리를 showCategory 라는 메서드를 통해 보여주는 기능을 실행해라.

            // selectedCategory 변수에 있는 해당 카테고리가 가진 상품 리스트를 가져와라. 그걸 list에 넣어라.
            List<Product> list = selectedCategory.getProducts();

            // TODO: 장바구니 상품 추가후 메인으로 가는 게 나은가 아님 카테고리에 머물러있는게 나은가..
            while (true) {
                selectedCategory.showCategory();
                System.out.print("번호를 입력하세요: ");
                int answer = Integer.parseInt(sc.nextLine());

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
                    int respond = Integer.parseInt(sc.nextLine());
                    if (respond == 1) {
                        System.out.println("담을 수량을 입력해 주세요.");
                        System.out.print("수량: ");
                        int respond2 = Integer.parseInt(sc.nextLine());
                        boolean addOk = cart.addProduct(list.get(answer - 1), respond2);
                        if (addOk) {
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

    public void showMainMenu() {
        System.out.println("[ 실시간 커머스 플랫폼 메인 ]");
        for (int i = 0; i < categories.size(); i++) {
            System.out.println((i + 1) + "." + categories.get(i).getCategoryName());
        }
        System.out.println("0.종료     | 프로그램 종료");
    }

    public void showOrderManage() {
        System.out.println();
        System.out.println("[ 장바구니 내역]");
        System.out.printf("%-1d.%-12s | %s%n", 4, "장바구니 확인", "장바구니를 확인 후 주문합니다.");
        System.out.printf("%-1d.%-13s | %s%n", 5, "주문 취소", "진행중인 주문을 취소합니다.");
    }

    // TODO: 장바구니에 담긴 상품 목록 보여주는 메서드
    public void showCart() {
        int total = 0;
        for (CartItem item : cart.getCartItems()) {
            Product p = item.getProduct();
            int price = item.getProduct().getPrice();
            int qty = item.getQuantity();
//            total += price * qty;
            System.out.println("[ 장바구니 내역 ]");
            System.out.printf(
                    "%-12s | %,d원 | %s | 수량: %d개%n",
                    p.getName(),
                    price,
                    p.getDescription(),
                    qty
            );
            System.out.println();
            System.out.println("[ 총 주문 금액 ]");
//            System.out.println(total);
            System.out.printf("%,d원%n", cart.getTotalPrice());
            System.out.println("1. 주문 확정        2. 메인으로 돌아가기");
        }
    }
}
