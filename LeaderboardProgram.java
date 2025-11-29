import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class LeaderboardProgram {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of scores: ");
        int n = sc.nextInt(); sc.nextLine();

        ArrayList<Integer> scores = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            scores.add(sc.nextInt());
            sc.nextLine();
        }

        Collections.sort(scores, Collections.reverseOrder());

        System.out.println("Top 3:");
        for (int i = 0; i < Math.min(3, scores.size()); i++) {
            System.out.println(scores.get(i));
        }
    }
}