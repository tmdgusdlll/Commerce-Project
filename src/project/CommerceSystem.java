package project;

import java.util.List;
import java.util.Scanner;

public class CommerceSystem {

//    private List<Product> products;

    // Storage 객체 생성
    Storage storage = new Storage();

    // Storage에게 카데고리 목록을 만들어 달라고 요청 -> 그 결과(List<Category>)를 categories라는 이름의 변수에 담는다.
    List<Category> categories = storage.createCategories();

    public CommerceSystem() {
//        this.products = products;
    }
    void start() {

        System.out.println("[ 실시간 커머스 플랫폼 메인 ]");
        for (int i = 0; i < categories.size(); i++) {
            System.out.println((i + 1) + "." + categories.get(i).getCategoryName());
        }
        System.out.println("0.종료     | 프로그램 종료");

        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("카테고리를 선택하세요: ");
            int select = Integer.parseInt(sc.nextLine());

            if (select == 0) {
                System.out.println("커머스 플랫폼을 종료합니다.");
                return;
            }
            if (select < 1 || select > categories.size()) {
                System.out.println("잘못된 입력입니다. 다시 선택해주세요.");
                continue;
            }

            // 카테고리 목록 중 선택한 숫자 - 1의 인덱스의 카테고리를 가져와라. 그걸 selectedCategory 변수에 넣어라.
            Category selectedCategory = categories.get(select - 1);


            // selectedCategory 변수에 있는 해당 카테고리를 showCategory 라는 메서드를 통해 보여주는 기능을 실행해라.
            selectedCategory.showCategory();

            // selectedCategory 변수에 있는 해당 카테고리가 가진 상품 리스트를 가져와라. 그걸 list에 넣어라.
            List<Product> list = selectedCategory.getProducts();

            while (true) {
                System.out.print("품목을 선택하세요: ");
                int answer = Integer.parseInt(sc.nextLine());

                if (answer == 0) {
                    // TODO: 뒤로가기 구현하기
                    break;
                }
                if (answer < 1 || answer > list.size()) {
                    System.out.println("잘못된 입력입니다. 다시 선택해주세요.");
                    continue;
                }
                // 카테고리가 가진 상품 리스트 중 선택한 숫자 - 1인 인덱스에 해당하는 상품을 toDisplayString해서 가져와라.
                System.out.println("선택한 상품: " + list.get(answer - 1).toDisplayString());
            }
            }
        }
    }
