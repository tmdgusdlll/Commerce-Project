package project;

import java.util.ArrayList;
import java.util.List;

// 카테고리(+물품 리스트) 관리 하는 클래스
public class Storage {

    /**
     * 결론적으로 Product 클래스 (개별 상품들)은 리스트로 만들어서 (각 categoryName을 붙혀서)Category 클래스가 관리
     * Storage 클래스는 그 Category 클래스를 관리(보관)
     * CommerceSystem 클래스는 Product 클래스 몰라도 됨. Storage 클래스에서 카테고리를 그냥 요청하면 됨.
     * 만든거를 CommerceSystem 클래스에서 불러서 써야하기 때문에 void (X) return!!
     */
    //내부의 카테고리 이름과 상품 리스트들로 카테고리 객체를 만들겠다. -> 그것들을 List<Category>로 반환
    public List<Category> createCategories() {
        Category elec = new Category("전자제품", elecProduct);
        Category cloth = new Category("의류", clothProducts);
        Category food = new Category("식품", foodProducts);
        return List.of(elec, cloth, food);
    }

    // 카테고리 별 물품리스트 (getter)
    public List<Product> getElecProduct() {
        return elecProduct;
    }
    public List<Product> getClothProduct() {
        return clothProducts;
    }
    public List<Product> getFoodProduct() {
        return foodProducts;
    }

    private List<Product> elecProduct = List.of(
            new Product("Galaxy S24", 1200000, "최신 안드로이드 스마트폰", 50),
            new Product("iphone 15", 1350000, "Apple의 최신 스마트폰", 30),
            new Product("MacBook Pro", 2400000, "M3 칩셋이 탑재된 노트북", 20),
            new Product("AirPods Pro", 350000, "노이즈 캔슬링 무선 이어폰", 70)
    );
    private List<Product> clothProducts = List.of(
            new Product("오프화이트 후드티", 129000, "오프화이트 시그니처 로고 후드티", 40),
            new Product("무신사 스탠다드 데님 팬츠", 69900, "슬림 스트레이트 핏 데님 팬츠", 120),
            new Product("노스페이스 눕시 패딩", 359000, "보온성 뛰어난 겨울용 다운 패딩", 25),
            new Product("아디다스 트랙 자켓", 99000, "데일리 착용 가능한 트랙 자켓", 70)
    );
    private List<Product> foodProducts = List.of(
            new Product("한우 등심 1++ (300g)", 59800, "국내산 1++ 등급 한우 등심", 35),
            new Product("제주 삼다수 2L x 6", 6900, "제주 화산암반수 생수", 200),
            new Product("신라면 멀티팩 (5입)", 4200, "농심 대표 매운 라면", 500),
            new Product("동원 참치 라이트스탠다드", 2300, "담백한 맛의 캔 참치", 180)
    );
}



