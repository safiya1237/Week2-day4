import java.util.Scanner;
import java.util.TreeMap;

public class TimeTableProgram {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of classes: ");
        int n = sc.nextInt(); sc.nextLine();

        TreeMap<Integer, String> timetable = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            System.out.print("Enter time: ");
            int time = sc.nextInt(); sc.nextLine();

            System.out.print("Enter subject: ");
            String subject = sc.nextLine().trim();

            while (timetable.containsKey(time)) time++; // adjust
            timetable.put(time, subject);
        }

        System.out.println("Timetable (sorted):");
        for (int t : timetable.keySet()) {
            System.out.println(t + " -> " + timetable.get(t));
        }
    }
}