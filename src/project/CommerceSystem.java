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
            System.out.print("메뉴를 선택하세요: ");
            int select = Integer.parseInt(sc.nextLine());

            System.out.println("[ 실시간 커머스 플랫폼 - 전자제품 ]");
            for (int i = 0; i < products.size(); i++) {
                Product p = products.get(i);
                System.out.printf("%d. %-12s | %,10d원 | %s%n", i + 1,
                        p.getName(),
                        p.getPrice(),
                        p.getDescription()
                );
            }
            System.out.println("0. 뒤로가기");

            while (true) {
                System.out.print("품목을 선택하세요: ");
                int answer = Integer.parseInt(sc.nextLine());
                if (answer == 0) {
                    System.out.println("커머스 플랫폼을 종료합니다.");
                    break;
                }
            }

        }
    }
}