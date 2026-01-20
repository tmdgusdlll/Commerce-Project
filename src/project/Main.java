package project;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // new 키워드로만 객체 생성
        Product elecproduct1 = new Product("Galaxy S25 ", 1_200_000, "최신 안드로이드 스마트폰", 50);
        Product elecproduct2 = new Product("iphone 16  ", 1_350_000, "Apple의 최신 스마트폰", 30);
        Product elecproduct3 = new Product("MacBook Pro", 2_400_000, "M3 칩셋이 탑재된 노트북", 20);
        Product elecproduct4 = new Product("AirPods Pro", 350_000, "노이즈 캔슬링 무선 이어폰", 70);

        // List 선언으로 객체 생성
        List<Product> elecProducts = new ArrayList<>();
        elecProducts.add(elecproduct1);
        elecProducts.add(elecproduct2);
        elecProducts.add(elecproduct3);
        elecProducts.add(elecproduct4);

        // 카테고리 생성
        Category elecCategory = new Category("전자제품",new ArrayList<>(elecProducts));
        Category clothCategory = new Category("의류", new ArrayList<>());
        Category foodCategory = new Category("식품", new ArrayList<>());
        List<Category> categories = List.of(
                elecCategory, clothCategory, foodCategory
        );
        CommerceSystem cs = new CommerceSystem(new ArrayList<>(categories));
        cs.start();


        // 반복문 활용해 객체 탐색 & 접근
//        System.out.println("[ 실시간 커머스 플랫폼 - 전자제품 ]");
//        for (int i = 0; i < products.size(); i++) {
//            Product p = products.get(i);
//            System.out.println((i + 1) + ". " + p.getName() + "   | " + p.getPrice() + "원 | " + p.getExplain());
//        }
//        System.out.println("0. 종료           | 프로그램 종료" );

//        while (true) {
//            Scanner sc = new Scanner(System.in);
//            int answer;
//
//            try {
//                System.out.print("상품을 선택하세요: ");
//                answer = Integer.parseInt(sc.nextLine());
//                if (answer == 0) {
//                    System.out.println("커머스 플랫폼을 종료합니다.");
//                    break;
//                }
//            } catch (NumberFormatException e) {
//                System.out.println("숫자만 입력해주세요.");
//            }
//        }
//        CommerceSystem cs = new CommerceSystem(products);
//        cs.start();
    }
}
