package project;

import java.util.List;

public class Category {

    private String categoryName;
    private List<Product> products;

    // 카테고리라는 객체를 만들건데, 이름과 리스트를 가지고 만들어라.
    public Category(String categoryName, List<Product> products) {
        this.categoryName = categoryName;
        this.products = products;
    }

    public String getCategoryName() {
        return categoryName;
    }

}