package project;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Category {
    Scanner sc = new Scanner(System.in);
    // Product 클래스를 관리하는 클래스
    private String categoryName;
    private List<Product> products;


    // Category는 여러 Product를 관리하는 클래스이며,
    // 그 Product 목록을 외부에서 생성자 주입으로 전달받아 사용한다.
    public Category(String categoryName, List<Product> products) {
        this.categoryName = categoryName;
        this.products = products;
    }

    // 카테고리 이름 반환(게터)
    public String getCategoryName() {
        return categoryName;
    }

    public void showMenu() {
        System.out.println("[ " + categoryName + " 카테고리 ]");
        for (int i = 0; i < products.size(); i++) {
            Product p = products.get(i);
            System.out.println((i + 1) + ". " + p.getName() + "   | " + p.getPrice() + "원 | " + p.getExplain());
        }
        System.out.println("0. 뒤로가기" );

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
    }


}
