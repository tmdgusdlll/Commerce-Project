package project;

public class Customer {
    private String name;
    private String email;
    private Rank rank;
    private int totalPrice;

    public Customer(String name, String email, Rank rank) {
        this.name = name;
        this.email = email;
        this.rank = rank;
    }

    void myRank() {
        if (totalPrice < 500000) {
            this.rank = Rank.BRONZE;
            System.out.println("등급: " + rank);
        } else if (totalPrice < 1000000) {
            this.rank = Rank.SILVER;
            System.out.println("등급: " + rank);
        } else if (totalPrice < 2000000) {
            this.rank = Rank.GOLD;
            System.out.println("등급: " + rank);
        } else {
            this.rank = Rank.PLATINUM;
            System.out.println("등급: " + rank);
        }
    }
}
