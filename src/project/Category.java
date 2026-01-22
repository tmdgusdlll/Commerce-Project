package project;

import java.util.List;

public class Category {
    // Product 클래스의 각 상품들을 List<Product> 타입으로 정리하고, categoryName을 붙혀서 관리하는 클래스

    private String categoryName;
    private List<Product> products;

    // 카테고리라는 객체를 만들건데, 카테고리 이름과 상품 리스트를 가지고 만들어라.
    public Category(String categoryName, List<Product> products) {
        this.categoryName = categoryName;
        this.products = products;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void showCategory() {
        System.out.println("[ " + getCategoryName() + "카테고리 ]");
        for (int i = 0; i < products.size(); i++) {
            Product p = products.get(i);
            System.out.printf("%d. %-12s | %,10d원 | %s%n", i + 1,
                    p.getName(),
                    p.getPrice(),
                    p.getDescription()
            );
        }
        System.out.println("0. 뒤로가기");
    }
}