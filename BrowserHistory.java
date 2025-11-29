import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class BrowserHistory {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Deque<String> back = new ArrayDeque<>();
        Deque<String> forward = new ArrayDeque<>();
        String current = null;

        System.out.print("Enter number of sites: ");
        int n = sc.nextInt(); sc.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.print("Enter site: ");
            String site = sc.nextLine().trim();

            if (current != null) back.push(current);

            current = site;
            forward.clear();
        }

        System.out.println("Current: " + current);

        if (!back.isEmpty()) {
            forward.push(current);
            current = back.pop();
            System.out.println("Back: " + current);
        } else System.out.println("Back: [none]");

        if (!forward.isEmpty()) {
            current = forward.pop();
            System.out.println("Forward: " + current);
        } else System.out.println("Forward: [none]");
    }
}