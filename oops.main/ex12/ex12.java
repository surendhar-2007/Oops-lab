
import java.util.*;

class FoodItem {
    private String name;
    private int price;

    public FoodItem(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
}

public class CanteenManagementSystem {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<FoodItem> foodList = new ArrayList<>();

        foodList.add(new FoodItem("Idli", 30));
        foodList.add(new FoodItem("Dosa", 40));
        foodList.add(new FoodItem("Poori", 35));
        foodList.add(new FoodItem("Meals", 100));
        foodList.add(new FoodItem("Tea", 15));

        int[] quantity = new int[foodList.size()];

        System.out.println("===== CANTEEN MANAGEMENT SYSTEM =====");
        System.out.println("\nAvailable Food Items:");

        for (int i = 0; i < foodList.size(); i++) {
            System.out.println((i + 1) + ". "
                    + foodList.get(i).getName()
                    + " - Rs." + foodList.get(i).getPrice());
        }

        while (true) {
            System.out.print("\nEnter food choice (0 to finish): ");
            int choice = sc.nextInt();

            if (choice == 0) {
                break;
            }

            if (choice < 1 || choice > foodList.size()) {
                System.out.println("Invalid choice!");
                continue;
            }

            System.out.print("Enter quantity: ");
            int qty = sc.nextInt();

            if (qty <= 0) {
                System.out.println("Enter a valid quantity!");
                continue;
            }

            quantity[choice - 1] += qty;
            System.out.println("Item added successfully!");
        }

        int total = 0;

        System.out.println("\n========== BILL ==========");
        System.out.printf("%-15s %-10s %-10s%n",
                "Food Item", "Quantity", "Amount");

        for (int i = 0; i < foodList.size(); i++) {
            if (quantity[i] > 0) {
                int amount = foodList.get(i).getPrice()
                        * quantity[i];

                System.out.printf("%-15s %-10d Rs.%d%n",
                        foodList.get(i).getName(),
                        quantity[i], amount);

                total += amount;
            }
        }

        System.out.println("--------------------------");
        System.out.println("Total Amount: Rs." + total);
        System.out.println("==========================");
        System.out.println("Thank you! Visit Again!");

        sc.close();
    }
}