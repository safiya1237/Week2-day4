import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ProductCatalog {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of products: ");
        int n = sc.nextInt(); sc.nextLine();

        ArrayList<String> products = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            System.out.print("Enter product: ");
            products.add(sc.nextLine().trim());
        }

        Collections.sort(products);

        System.out.println("Products sorted: " + products);
    }
}