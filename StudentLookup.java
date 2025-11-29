import java.util.HashMap;
import java.util.Scanner;

public class StudentLookup {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int n = sc.nextInt(); sc.nextLine();

        HashMap<Integer, String> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            System.out.print("Enter roll: ");
            int roll = sc.nextInt(); sc.nextLine();

            System.out.print("Enter name: ");
            map.put(roll, sc.nextLine().trim());
        }

        System.out.print("Search roll number: ");
        int s = sc.nextInt();

        System.out.println("Result: " + map.getOrDefault(s, "[not found]"));
    }
}