import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class ExamSubmissions {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of submissions: ");
        int n = sc.nextInt(); sc.nextLine();

        ArrayList<String> order = new ArrayList<>();
        HashSet<String> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            System.out.print("Enter filename: ");
            String f = sc.nextLine().trim();
            order.add(f);
            set.add(f);
        }

        // Unique with same input order
        ArrayList<String> unique = new ArrayList<>();
        HashSet<String> seen = new HashSet<>();

        for (String s : order) {
            if (!seen.contains(s)) {
                unique.add(s);
                seen.add(s);
            }
        }

        System.out.println("Unique submissions: " + unique);
    }
}