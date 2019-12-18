
import java.util.LinkedList;
import java.util.Scanner;

public class B_drinker_game {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedList<Integer> player1 = new LinkedList<>();
        LinkedList<Integer> player2 = new LinkedList<>();

        for (int i = 0; i < 5; i++) {
            player1.addLast(scanner.nextInt());
        }
        for (int i = 0; i < 5; i++) {
            player2.addLast(scanner.nextInt());
        }

        long step = 0;
        while (step < 1000000 && !player1.isEmpty() && !player2.isEmpty()) {
            if ((player1.getFirst() > player2.getFirst() ||
                    (player1.getFirst() == 0 && player2.getFirst() == 9)) && !(player2.getFirst() == 0 && player1.getFirst() == 9)) {
                player1.addLast(player1.removeFirst());
                player1.addLast(player2.removeFirst());
            } else {
                player2.addLast(player1.removeFirst());
                player2.addLast(player2.removeFirst());
            }
            step++;
        }

        if (player2.isEmpty()) {
            System.out.println("first " + step);
        } else if (player1.isEmpty()) {
            System.out.println("second " + step);
        } else {
            System.out.println("botva");
        }
    }
}
