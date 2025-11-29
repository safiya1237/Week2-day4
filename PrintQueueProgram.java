import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class PrintQueueProgram {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of jobs: ");
        int n = sc.nextInt(); sc.nextLine();

        Queue<String> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            System.out.print("Enter job: ");
            queue.add(sc.nextLine().trim());
        }

        System.out.println("Printing jobs:");
        while (!queue.isEmpty()) {
            System.out.println(queue.poll());
        }
    }
}