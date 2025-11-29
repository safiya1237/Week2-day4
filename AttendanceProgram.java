import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class AttendanceProgram {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        sc.nextLine();

        ArrayList<String> attendance = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            System.out.print("Enter name: ");
            attendance.add(sc.nextLine().trim());
        }

        System.out.println("Attendance (original): " + attendance);

        // Unique
        ArrayList<String> unique = new ArrayList<>();
        HashSet<String> seen = new HashSet<>();

        for (String s : attendance) {
            if (!seen.contains(s)) {
                unique.add(s);
                seen.add(s);
            }
        }

        System.out.println("Attendance (unique): " + unique);
    }
}