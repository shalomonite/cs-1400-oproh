
import java.util.Scanner;

public class SandwichApp {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            Sandwich sandwich = createSandwich();
            Order order = createOrder(sandwich);
            SandwichIO.writeOrderToFile(order);

            System.out.print("Continue to order more sandwich? (y/n): ");
            String choice = scanner.next();
            if (!choice.equalsIgnoreCase("y")) {
                break;
            }
        }
        scanner.close();
    }
    private static Sandwich createSandwich() {
        System.out.println("=== Select Sandwich Bread: ===");
        System.out.println("1 White Bread $1.5");
        System.out.println("2 Wheat Bread $1.6");
        System.out.println("3 French Bread $1.8");
        System.out.println("4 Organic Bread $2.0");

        int breadChoice;
        do {
            System.out.print("Select a bread [1, 4]: ");
            breadChoice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
        } while (breadChoice < 1 || breadChoice > 4);

        String bread;
        double price;
        switch (breadChoice) {
            case 1:
                bread = "White Bread";
                price = 1.5;
                break;
            case 2:
                bread = "Wheat Bread";
                price = 1.6;
                break;
            case 3:
                bread = "French Bread";
                price = 1.8;
                break;
            default:
                bread = "Organic Bread";
                price = 2.0;
                break;
        }

        String[] vegetables = selectVegetables();
        String meat = selectMeat();

        double totalPrice = price + calculateVegetablePrice(vegetables);

        return new Sandwich(bread, vegetables, meat, totalPrice);
    }

    private static String[] selectVegetables() {
        System.out.println("=== Select Sandwich Vegetables: ===");
        System.out.println("1 red onions $0.05");
        System.out.println("2 olives $0.10");
        System.out.println("3 pickles $0.10");
        System.out.println("4 lettuce $0.20");
        System.out.println("5 green peppers $0.25");
        System.out.println("6 tomatoes $0.30");
        System.out.println("7 cheese $0.50");
        System.out.println("8 Quit vegetable selection");

        String[] selectedVegetables = new String[0];
        while (true) {
            System.out.print("Select vegetables: [1, 8]: ");
            String vegetableChoice = scanner.nextLine();
            if (vegetableChoice.equals("8")) {
                break;
            } else if (vegetableChoice.matches("[1-7]")) {
                String[] temp = new String[selectedVegetables.length + 1];
                System.arraycopy(selectedVegetables, 0, temp, 0, selectedVegetables.length);
                temp[selectedVegetables.length] = vegetableChoice;
                selectedVegetables = temp;
            } else {
                System.out.println("Invalid choice. Please select a number between 1 and 8.");
            }
        }
        return selectedVegetables;
    }

    private static String selectMeat() {
        System.out.println("=== Select Sandwich Meat: ===");
        System.out.println("1 Ham $1.0");
        System.out.println("2 Roasted Chicken Breast $1.1");
        System.out.println("3 Turkey Breast $1.2");
        System.out.println("4 Roast Beef $1.5");

        int meatChoice;
        do {
            System.out.print("Select meat [1, 4]: ");
            meatChoice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
        } while (meatChoice < 1 || meatChoice > 4);

        switch (meatChoice) {
            case 1:
                return "Ham";
            case 2:
                return "Roasted Chicken Breast";
            case 3:
                return "Turkey Breast";
            default:
                return "Roast Beef";
        }
    }

    private static double calculateVegetablePrice(String[] vegetables) {
        double totalVegetablePrice = 0.0;
        for (String vegetable : vegetables) {
            switch (vegetable) {
                case "1":
                    totalVegetablePrice += 0.05;
                    break;
                case "2":
                    totalVegetablePrice += 0.10;
                    break;
                case "3":
                    totalVegetablePrice += 0.10;
                    break;
                case "4":
                    totalVegetablePrice += 0.20;
                    break;
                case "5":
                    totalVegetablePrice += 0.25;
                    break;
                case "6":
                    totalVegetablePrice += 0.30;
                    break;
                case "7":
                    totalVegetablePrice += 0.50;
                    break;
            }
        }
        return totalVegetablePrice;
    }

    private static Order createOrder(Sandwich sandwich) {
        System.out.print("Enter customer's name: ");
        String customerName = scanner.nextLine();

        return new Order(customerName, sandwich);
    }
}