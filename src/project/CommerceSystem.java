package project;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class CommerceSystem {

    // 커머스 플랫폼의 상품을 관리하고 사용자 입력을 처리하는 클래스
    private List<Product> products;

    public CommerceSystem(List<Product> products) {
        this.products = products;
    }

    public void start() {
        System.out.println("[ 실시간 커머스 플랫폼 - 전자제품 ]");
        for (int i = 0; i < products.size(); i++) {
            Product p = products.get(i);
            System.out.println((i + 1) + ". " + p.getName() + "   | " + p.getPrice() + "원 | " + p.getExplain());
        }
        System.out.println("0. 종료           | 프로그램 종료" );

        while (true) {
            Scanner sc = new Scanner(System.in);
            int answer;

            try {
                System.out.print("상품을 선택하세요: ");
                answer = Integer.parseInt(sc.nextLine());
                if (answer == 0) {
                    System.out.println("커머스 플랫폼을 종료합니다.");
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("숫자만 입력해주세요.");
            }
        }
    }
}
