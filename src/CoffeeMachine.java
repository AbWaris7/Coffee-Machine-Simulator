import java.util.Scanner;

public class CoffeeMachine {

    private static int water = 400; // ml
    private static int milk = 540;  // ml
    private static int beans = 120; // grams
    private static int cups = 9;    // disposable cups
    private static int money = 550; // dollars

    private static void displayState() {
        System.out.println("\nThe coffee machine has:");
        System.out.println(water + " ml of water");
        System.out.println(milk + " ml of milk");
        System.out.println(beans + " g of coffee beans");
        System.out.println(cups + " disposable cups");
        System.out.println("$" + money + " of money\n");
    }

    private static void buyCoffee(Scanner scanner) {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
        String choice = scanner.next();

        int neededWater = 0, neededMilk = 0, neededBeans = 0, cost = 0;

        switch (choice) {
            case "1": // Espresso
                neededWater = 250;
                neededMilk = 0;
                neededBeans = 16;
                cost = 4;
                break;
            case "2": // Latte
                neededWater = 350;
                neededMilk = 75;
                neededBeans = 20;
                cost = 7;
                break;
            case "3": // Cappuccino
                neededWater = 200;
                neededMilk = 100;
                neededBeans = 12;
                cost = 6;
                break;
            case "back":
                return; // Return to the main menu
            default:
                System.out.println("Invalid choice.");
                return;
        }

        if (water < neededWater) {
            System.out.println("Sorry, not enough water!");
        } else if (milk < neededMilk) {
            System.out.println("Sorry, not enough milk!");
        } else if (beans < neededBeans) {
            System.out.println("Sorry, not enough coffee beans!");
        } else if (cups < 1) {
            System.out.println("Sorry, not enough disposable cups!");
        } else {
            System.out.println("I have enough resources, making you a coffee!");
            water -= neededWater;
            milk -= neededMilk;
            beans -= neededBeans;
            cups -= 1;
            money += cost;
        }
    }

    private static void fillMachine(Scanner scanner) {
        System.out.println("Write how many ml of water you want to add:");
        water += scanner.nextInt();
        System.out.println("Write how many ml of milk you want to add:");
        milk += scanner.nextInt();
        System.out.println("Write how many grams of coffee beans you want to add:");
        beans += scanner.nextInt();
        System.out.println("Write how many disposable cups you want to add:");
        cups += scanner.nextInt();
    }

    private static void takeMoney() {
        System.out.println("I gave you $" + money);
        money = 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Write action (buy, fill, take, remaining, exit):");
            String action = scanner.next();

            switch (action) {
                case "buy":
                    buyCoffee(scanner);
                    break;
                case "fill":
                    fillMachine(scanner);
                    break;
                case "take":
                    takeMoney();
                    break;
                case "remaining":
                    displayState();
                    break;
                case "exit":
                    return; // Exit the program
                default:
                    System.out.println("Invalid action");
            }
        }
    }
}
