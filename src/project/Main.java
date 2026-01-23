package project;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // 오 날짜 출력 해주는 거 찾아봤는데 신기;;
        LocalDate now = LocalDate.now();
        System.out.println(now);

        CommerceSystem cs = new CommerceSystem();
        cs.start();

    }
}
