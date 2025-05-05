import java.util.*;

public class main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        Set<Integer> lottis = new HashSet<>();
        for(int i = 1; i<7; i++) {
            System.out.println("Geben sie Ihre " + i + "te Lottozahl ab: ");
            lottis.add(scanner.nextInt());
        }

        Lotto lotto = new Lotto();

        System.out.println("Sie haben: " + lotto.check(lottis) + " gleiche!");

        lotto.ziehung();

        System.out.println("Sie haben: " + lotto.check(lottis) + " gleiche!");


    }
}
