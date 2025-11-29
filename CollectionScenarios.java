//1. Maintain order of attendance list
//Collection: ArrayList
//Reason: It maintains insertion order and allows duplicates.

//2. Remove duplicates from exam submissions
//Collection: HashSet
//Reason: It automatically removes duplicates and is very fast.

//3. College timetable → sorted by time
//Collection: TreeMap
//Reason: It keeps all keys in sorted order (time slots).

//4. Student roll number & name lookup
//Collection: HashMap<Integer, String>
//Reason: It allows fast lookup using roll number as the key.

//5. Manage print queue jobs
//Collection: Queue (implemented by LinkedList)
//Reason: Print jobs follow FIFO (First In First Out), which a queue supports.

//6. Keep browser back–forward history
//Collection: Stack
//Reason: Stack follows LIFO (Last In First Out), same as browser history.

//7. Store leaderboard scores sorted
//Collection: TreeSet
//Reason: It stores unique values in automatically sorted order.

//8. Store products in ecommerce
//Collection: ArrayList
//Reason: It maintains order, supports indexing, and allows duplicates.

//9. Cache with insertion order
//Collection: LinkedHashMap
//Reason: It maintains insertion order and is commonly used for cache implementations.

//10. Manage tasks by priority
//Collection: PriorityQueue
//Reason: It always keeps the highest/lowest priority element at the top.

import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.TreeMap;
import java.util.HashMap;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Deque;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class CollectionScenarios {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // --- ATTENDANCE ---
        System.out.println("\n--- ATTENDANCE ---");
        System.out.print("Enter number of students: ");
        int nAttendance = sc.nextInt();
        sc.nextLine();
        ArrayList<String> attendance = new ArrayList<>();
        for (int i = 0; i < nAttendance; i++) {
            System.out.print("Enter name: ");
            attendance.add(sc.nextLine().trim());
        }

        // --- EXAM SUBMISSIONS ---
        System.out.println("\n--- EXAM SUBMISSIONS ---");
        System.out.print("Enter number of submissions: ");
        int nSub = sc.nextInt();
        sc.nextLine();
        HashSet<String> submissions = new HashSet<>();
        ArrayList<String> subInputOrder = new ArrayList<>();
        for (int i = 0; i < nSub; i++) {
            System.out.print("Enter filename: ");
            String f = sc.nextLine().trim();
            subInputOrder.add(f);
            submissions.add(f);
        }

        // --- TIMETABLE ---
        System.out.println("\n--- TIMETABLE ---");
        System.out.print("Enter number of classes: ");
        int nSlots = sc.nextInt();
        sc.nextLine();
        // Using TreeMap<Integer, String> to sort by hour
        TreeMap<Integer, String> timetable = new TreeMap<>();
        for (int i = 0; i < nSlots; i++) {
            System.out.print("Enter time (24hr): ");
            int time = sc.nextInt();
            sc.nextLine();
            System.out.print("Enter subject: ");
            String subj = sc.nextLine().trim();
            // if duplicate hour, increment until free (keeps both)
            while (timetable.containsKey(time)) time++;
            timetable.put(time, subj);
        }

        // --- STUDENT LOOKUP ---
        System.out.println("\n--- STUDENT LOOKUP ---");
        System.out.print("Enter number of students: ");
        int nStudents = sc.nextInt();
        sc.nextLine();
        HashMap<Integer, String> studentMap = new HashMap<>();
        for (int i = 0; i < nStudents; i++) {
            System.out.print("Enter roll: ");
            int roll = sc.nextInt();
            sc.nextLine();
            System.out.print("Enter name: ");
            String name = sc.nextLine().trim();
            studentMap.put(roll, name);
        }
        System.out.print("Search roll number: ");
        int searchRoll = sc.nextInt();
        sc.nextLine();

        // --- PRINT QUEUE ---
        System.out.println("\n--- PRINT QUEUE ---");
        System.out.print("Enter number of print jobs: ");
        int nPrint = sc.nextInt();
        sc.nextLine();
        Queue<String> printQueue = new LinkedList<>();
        for (int i = 0; i < nPrint; i++) {
            System.out.print("Enter job: ");
            printQueue.add(sc.nextLine().trim());
        }

        // --- BROWSER HISTORY ---
        System.out.println("\n--- BROWSER HISTORY ---");
        System.out.print("Enter number of visited sites: ");
        int nSites = sc.nextInt();
        sc.nextLine();
        Deque<String> backStack = new ArrayDeque<>();
        Deque<String> forwardStack = new ArrayDeque<>();
        String current = null;
        for (int i = 0; i < nSites; i++) {
            System.out.print("Enter site: ");
            String site = sc.nextLine().trim();
            if (current != null) backStack.push(current);
            current = site;
            forwardStack.clear();
        }

        // --- LEADERBOARD ---
        System.out.println("\n--- LEADERBOARD ---");
        System.out.print("Enter number of scores: ");
        int nScores = sc.nextInt();
        sc.nextLine();
        List<Integer> scores = new ArrayList<>();
        for (int i = 0; i < nScores; i++) {
            System.out.print("Enter score: ");
            scores.add(sc.nextInt());
            sc.nextLine();
        }

        // --- PRODUCT CATALOG ---
        System.out.println("\n--- PRODUCT CATALOG ---");
        System.out.print("Enter number of products: ");
        int nProducts = sc.nextInt();
        sc.nextLine();
        List<String> products = new ArrayList<>();
        for (int i = 0; i < nProducts; i++) {
            System.out.print("Enter product name: ");
            products.add(sc.nextLine().trim());
        }

        // --- PRIORITY TASKS ---
        System.out.println("\n--- PRIORITY TASKS ---");
        System.out.print("Enter number of tasks: ");
        int nTasks = sc.nextInt();
        sc.nextLine();
        PriorityQueue<Integer> tasks = new PriorityQueue<>();
        for (int i = 0; i < nTasks; i++) {
            System.out.print("Enter priority: ");
            tasks.add(sc.nextInt());
            sc.nextLine();
        }

        // --- PRODUCE OUTPUT (exact style as requested) ---
        System.out.println("\n=== OUTPUT ===\n");

        // Attendance
        System.out.println("Attendance (original): " + attendance);
        // Unique attendance in insertion order:
        LinkedList<String> uniqueAttendance = new LinkedList<>();
        HashSet<String> seen = new HashSet<>();
        for (String s : attendance) {
            if (!seen.contains(s)) {
                uniqueAttendance.add(s);
                seen.add(s);
            }
        }
        System.out.println("Attendance (unique): " + uniqueAttendance + "\n");

        // Submissions: print unique set but to match sample ordering (HashSet iteration is arbitrary).
        // We'll show unique values but sorted by first appearance in input to give deterministic output.
        LinkedList<String> uniqueSubsOrdered = new LinkedList<>();
        HashSet<String> seenSubs = new HashSet<>();
        for (String s : subInputOrder) {
            if (!seenSubs.contains(s)) {
                uniqueSubsOrdered.add(s);
                seenSubs.add(s);
            }
        }
        System.out.println("Unique exam submissions: " + uniqueSubsOrdered + "\n");

        // Timetable sorted
        System.out.println("Timetable (sorted):");
        for (Integer t : timetable.keySet()) {
            System.out.println(t + " -> " + timetable.get(t));
        }
        System.out.println();

        // Student lookup
        String lookupResult = studentMap.get(searchRoll);
        System.out.println("Search result: " + (lookupResult == null ? "[not found]" : lookupResult) + "\n");

        // Print queue
        System.out.println("Printing jobs in order:");
        while (!printQueue.isEmpty()) {
            System.out.println(printQueue.poll());
        }
        System.out.println();

        // Browser history: current, back (one step), forward (one step)
        System.out.println("Current site: " + (current == null ? "[none]" : current));
        // simulate one back
        if (!backStack.isEmpty()) {
            String backSite = backStack.pop();
            forwardStack.push(current);
            current = backSite;
            System.out.println("Back: " + (current == null ? "[none]" : current));
        } else {
            System.out.println("Back: [none]");
        }
        // simulate one forward
        if (!forwardStack.isEmpty()) {
            String f = forwardStack.pop();
            System.out.println("Forward: " + f);
            current = f;
        } else {
            System.out.println("Forward: [none]");
        }
        System.out.println();

        // Leaderboard: sort descending and print top 3 (with duplicates)
        Collections.sort(scores, Collections.reverseOrder());
        System.out.println("Leaderboard (Top 3):");
        for (int i = 0; i < Math.min(3, scores.size()); i++) {
            System.out.println(scores.get(i));
        }
        System.out.println();

        // Products: sample output showed [Bag, Shoes] given inputs Shoes, Bag -> sorted alphabetically
        Collections.sort(products);
        System.out.println("All products: " + products + "\n");

        // Tasks by priority: poll from priority queue (smallest number = highest priority)
        System.out.println("Tasks by priority (small \u2192 big):");
        while (!tasks.isEmpty()) {
            System.out.println(tasks.poll());
        }

        sc.close();
    }
}