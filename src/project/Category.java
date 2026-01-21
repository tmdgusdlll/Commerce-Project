package project;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Category {
    //    Scanner sc = new Scanner(System.in);
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

    public void showCommerce() {

    }

    public void showCategoryMenu() {
        System.out.println("[ " + categoryName + " 카테고리 ]");
        for (int i = 0; i < products.size(); i++) {
            Product p = products.get(i);
            // 문자열 포맷팅
            System.out.printf("%d. %-12s | %,10d원 | %s%n", i + 1,
                    p.getName(),
                    p.getPrice(),
                    p.getDescription()
            );
//            System.out.println((i + 1) + ". " + p.getName() + "   | " + p.getPrice() + "원 | " + p.getExplain());
        }
        System.out.println("0. 뒤로가기");

//        while (true) {
//            int answer;
//
//            try {
//                System.out.print("상품을 선택하세요: ");
//                answer = Integer.parseInt(sc.nextLine());
//                if (answer == 0) {
//                    return;
//                }
//            } catch (NumberFormatException e) {
//                System.out.println("숫자만 입력해주세요.");
//            }
//        }
    }

    // 카테고리별 물품 리스트(List<Product> products)
    public static List<Category> createCategories() {
        List<Product> elecproduct = List.of(
                new Product("Galaxy S24", 1200000, "최신 안드로이드 스마트폰", 50),
                new Product("iphone 15", 1350000, "Apple의 최신 스마트폰", 30),
                new Product("MacBook Pro", 2400000, "M3 칩셋이 탑재된 노트북", 20),
                new Product("AirPods Pro", 350000, "노이즈 캔슬링 무선 이어폰", 70)
        );
        List<Product> clothProducts = List.of(
                new Product("오프화이트 후드티", 129000, "오프화이트 시그니처 로고 후드티", 40),
                new Product("무신사 스탠다드 데님 팬츠", 69900, "슬림 스트레이트 핏 데님 팬츠", 120),
                new Product("노스페이스 눕시 패딩", 359000, "보온성 뛰어난 겨울용 다운 패딩", 25),
                new Product("아디다스 트랙 자켓", 99000, "데일리 착용 가능한 트랙 자켓", 70)
        );
        List<Product> foodProducts = List.of(
                new Product("한우 등심 1++ (300g)", 59800, "국내산 1++ 등급 한우 등심", 35),
                new Product("제주 삼다수 2L x 6", 6900, "제주 화산암반수 생수", 200),
                new Product("신라면 멀티팩 (5입)", 4200, "농심 대표 매운 라면", 500),
                new Product("동원 참치 라이트스탠다드", 2300, "담백한 맛의 캔 참치", 180)
        );


        // 카테고리 리스트
        Category elec = new Category("전자제품", elecproduct);
        Category cloth = new Category("의류", clothProducts);
        Category food = new Category("식품", foodProducts);

        return List.of(elec, cloth, food);
    }
}
