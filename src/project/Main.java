package project;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // new 키워드로만 객체 생성
        Product product1 = new Product("Galaxy S25 ", 1200000, "최신 안드로이드 스마트폰", 50);
        Product product2 = new Product("iphone 16  ", 1350000, "Apple의 최신 스마트폰", 30);
        Product product3 = new Product("MacBook Pro", 2400000, "M3 칩셋이 탑재된 노트북", 20);
        Product product4 = new Product("AirPods Pro", 350000, "노이즈 캔슬링 무선 이어폰", 70);

        // List 선언으로 객체 생성
        List<Product> products = new ArrayList<>();
        products.add(product1);
        products.add(product2);
        products.add(product3);
        products.add(product4);

        // 반복문 활용해 객체 탐색 & 접근
        System.out.println("[ 실시간 커머스 플랫폼 - 전자제품 ]");
        for (int i = 0; i < products.size(); i++) {
            Product p = products.get(i);
            System.out.println((i + 1) + ". " + p.getName() + "   | " + p.getPrice() + "원 | " + p.getExplain());
        }
        System.out.println("0. 종료           | 프로그램 종료" );

    }
}
