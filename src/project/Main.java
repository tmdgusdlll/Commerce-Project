package project;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // new 키워드로만 객체 생성
        Product elecproduct1 = new Product("Galaxy S24", 1200000, "최신 안드로이드 스마트폰", 50);
        Product elecproduct2 = new Product("iphone 15", 1350000, "Apple의 최신 스마트폰", 30);
        Product elecproduct3 = new Product("MacBook Pro", 2400000, "M3 칩셋이 탑재된 노트북", 20);
        Product elecproduct4 = new Product("AirPods Pro", 350000, "노이즈 캔슬링 무선 이어폰", 70);

        // List 선언으로 객체 생성
        List<Product> elecList = new ArrayList<>();
        elecList.add(elecproduct1);
        elecList.add(elecproduct2);
        elecList.add(elecproduct3);
        elecList.add(elecproduct4);

        // 나머지 두 리스트 생성
        List<Product> clothList = new ArrayList<>();
        clothList.add(new Product("오프화이트 후드티", 129000, "오프화이트 시그니처 로고 후드티", 40));
        clothList.add(new Product("무신사 스탠다드 데님 팬츠", 69900, "슬림 스트레이트 핏 데님 팬츠", 120));
        clothList.add(new Product("노스페이스 눕시 패딩", 359000, "보온성 뛰어난 겨울용 다운 패딩", 25));
        clothList.add(new Product("아디다스 트랙 자켓", 99000, "데일리 착용 가능한 트랙 자켓", 70));

        List<Product> foodList = new ArrayList<>();
        foodList.add(new Product("한우 등심 1++ (300g)", 59800, "국내산 1++ 등급 한우 등심", 35));
        foodList.add(new Product("제주 삼다수 2L x 6", 6900, "제주 화산암반수 생수", 200));
        foodList.add(new Product("신라면 멀티팩 (5입)", 4200, "농심 대표 매운 라면", 500));
        foodList.add(new Product("동원 참치 라이트스탠다드", 2300, "담백한 맛의 캔 참치", 180));

//        System.out.println("[ 실시간 커머스 플랫폼 - 전자제품 ]");
//        for (int i = 0; i < elecList.size(); i++) {
//            Product p = elecList.get(i);
//            System.out.printf("%d. %-12s | %,10d원 | %s%n", i + 1,
//                    p.getName(),
//                    p.getPrice(),
//                    p.getDescription()
//            );
//        }
//        System.out.println("0. 뒤로가기");

        CommerceSystem cs = new CommerceSystem(elecList);
        cs.start();

    }
}
