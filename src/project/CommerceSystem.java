package project;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class CommerceSystem {
    // TODO: 입출력만 받는 클래스로 만들기
    private Scanner sc = new Scanner(System.in);
    private List<Category> categories;

    // 각 Category가 내부적으로 Product 리스트를 관리하므로
    // CommerceSystem은 Category 목록만 생성자 주입으로 전달받아 사용한다
    public CommerceSystem() {
        this.categories = Category.createCategories();
    }

    // 커머스 플랫폼의 상품을 관리하고 사용자 입력을 처리하는 클래스
    public void start() {
        System.out.println("[ 실시간 커머스 플랫폼 메인 ]");
        for (int i = 0; i < categories.size(); i++) {
            System.out.println((i + 1) + "." + categories.get(i).getCategoryName());
        }
        System.out.println("0.종료     | 프로그램 종료");

        while (true) {
            System.out.print("메뉴를 선택하세요: ");
            int select = Integer.parseInt(sc.nextLine());

            // seletedCategory: 사용자가 입력한 카테고리를 담아두는 변수
            Category selectedCategory = null;
            switch (select) {
                // TODO: (1~3 외) 다른 값 입력시 categories가 비어있을 시 어떻게 되는가..?
                case 1, 2, 3 -> selectedCategory = categories.get(select - 1);
                // 1, 2, 3 중 하나라면 그에 해당하는 Category 객체를 selectedCategory에 담아둬라.
                case 0 -> {
                    System.out.println("커머스 플랫폼을 종료합니다.");
                    return;
                }
                default -> System.out.println("잘못된 입력입니다.");
            }
            // 해당 Category 객체에게 메뉴를 출력해달라고 요청한다.
            selectedCategory.showCategoryMenu();

            while (true) {
                int answer;
                try {
                    System.out.print("상품을 선택하세요: ");
                    answer = Integer.parseInt(sc.nextLine());
                    if (answer == 0) {
                        return;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("숫자만 입력해주세요.");
                }
            }
//        System.out.println("[ 실시간 커머스 플랫폼 메인 ]");
//        for (int i = 0; i < categories.size(); i++) {
//            System.out.println((i + 1) + "." + categories.get(i).getCategoryName());
//        }
////        System.out.println("1. 전자제품");
////        System.out.println("2. 의류");
////        System.out.println("3. 식품");
//        System.out.println("0.종료     | 프로그램 종료");
//
//        while (true) {
//            System.out.print("메뉴를 선택하세요: ");
//            int select = Integer.parseInt(sc.nextLine());
//
//            switch (select) {
//                // TODO: categories가 비어있을 시 get(0)은 어떻게 되는가..?
//                case 1 -> categories.get(0).showMenu();
//                case 2, 3 -> System.out.println("준비 중인 목록입니다");
//                case 0 -> {
//                    System.out.println("커머스 플랫폼을 종료합니다.");
//                    return;
//                }
//                default -> System.out.println("잘못된 입력입니다.");
//            }
//        }
        }
    }
}