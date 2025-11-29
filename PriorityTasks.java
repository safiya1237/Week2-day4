import java.util.PriorityQueue;
import java.util.Scanner;

public class PriorityTasks {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of tasks: ");
        int n = sc.nextInt(); sc.nextLine();

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            System.out.print("Enter priority: ");
            pq.add(sc.nextInt());
            sc.nextLine();
        }

        System.out.println("Tasks by priority:");
        while (!pq.isEmpty()) {
            System.out.println(pq.poll());
        }
    }
}