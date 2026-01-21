package project;

import java.util.List;
import java.util.Scanner;

public class CommerceSystem {

    private List<Product> products;
    Storage storage = new Storage();

    List<Category> categories = storage.createCategories();

    public CommerceSystem(List<Product> products) {
        this.products = products;
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

            Category selectedCategory = categories.get(select - 1);
            List<Product> list = selectedCategory.getProducts();

            switch (select) {
                case 1, 2, 3 -> selectedCategory.showProducts();
            }

            while (true) {
                System.out.print("품목을 선택하세요: ");
                int answer = Integer.parseInt(sc.nextLine());

                if (answer == 0) {
                    System.out.println("커머스 플랫폼을 종료합니다.");
                    break;
                } else if (answer == 1) {
                    System.out.println("선택한 상품: " + list.get(0).toDisplayString());
                } else if (answer == 2) {
                    System.out.println("선택한 상품: " + list.get(1).toDisplayString());
                }else if (answer == 3) {
                    System.out.println("선택한 상품: " + list.get(2).toDisplayString());
                }
            }

        }
    }
}