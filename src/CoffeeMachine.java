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

        switch (choice) {
            case "1" -> {
                water -= 250;
                beans -= 16;
                cups -= 1;
                money += 4;
            }
            case "2" -> {
                water -= 350;
                milk -= 75;
                beans -= 20;
                cups -= 1;
                money += 7;
            }
            case "3" -> {
                water -= 200;
                milk -= 100;
                beans -= 12;
                cups -= 1;
                money += 6;
            }


        }

        System.out.println("The coffee machine has:");
        System.out.println(water + " ml of water");
        System.out.println(milk + " ml of milk");
        System.out.println(beans + " g of coffee beans");
        System.out.println(cups + " disposable cups");
        System.out.println("$"+money + " of money\n");

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
        displayState();
    }

    private static void takeMoney() {
        System.out.println("I gave you $" + money);
        money = 0;
        displayState();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


            displayState();
            while (true)
            {
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
                        return;
                    default:
                        System.out.println("Invalid action");

                }

            }



    }
}
