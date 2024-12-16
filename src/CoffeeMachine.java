import java.util.Scanner;

// Coffee class to represent each type of coffee
class Coffee {
    private final int water;
    private final int milk;
    private final int beans;
    private final int cost;

    public Coffee(int water, int milk, int beans, int cost) {
        this.water = water;
        this.milk = milk;
        this.beans = beans;
        this.cost = cost;
    }

    public int getWater() {
        return water;
    }

    public int getMilk() {
        return milk;
    }

    public int getBeans() {
        return beans;
    }

    public int getCost() {
        return cost;
    }
}

// CoffeeMachine class to manage the machine's state and actions
class CoffeeMachine {
    private int water;
    private int milk;
    private int beans;
    private int cups;
    private int money;
    private int needCleaning;

    public CoffeeMachine(int water, int milk, int beans, int cups, int money) {
        this.water = water;
        this.milk = milk;
        this.beans = beans;
        this.cups = cups;
        this.money = money;
        this.needCleaning = 0;
    }

    // Displays the current state of the coffee machine
    public void displayState() {
        System.out.println("\nThe coffee machine has:");
        System.out.println(water + " ml of water");
        System.out.println(milk + " ml of milk");
        System.out.println(beans + " g of coffee beans");
        System.out.println(cups + " disposable cups");
        System.out.println("$" + money + " of money\n");
    }

    // Handles the "buy" action
    public void buyCoffee(Scanner scanner) {
        if (needCleaning >= 10) {
            System.out.println("I need cleaning!");
            return;
        }

        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
        String choice = scanner.next();

        Coffee coffee;
        switch (choice) {
            case "1":
                coffee = new Coffee(250, 0, 16, 4); // Espresso
                break;
            case "2":
                coffee = new Coffee(350, 75, 20, 7); // Latte
                break;
            case "3":
                coffee = new Coffee(200, 100, 12, 6); // Cappuccino
                break;
            case "back":
                return; // Return to the main menu
            default:
                System.out.println("Invalid choice.");
                return;
        }

        makeCoffee(coffee);
    }

    // Makes coffee if resources are sufficient
    private void makeCoffee(Coffee coffee) {
        if (water < coffee.getWater()) {
            System.out.println("Sorry, not enough water!");
        } else if (milk < coffee.getMilk()) {
            System.out.println("Sorry, not enough milk!");
        } else if (beans < coffee.getBeans()) {
            System.out.println("Sorry, not enough coffee beans!");
        } else if (cups < 1) {
            System.out.println("Sorry, not enough disposable cups!");
        } else {
            System.out.println("I have enough resources, making you a coffee!");
            water -= coffee.getWater();
            milk -= coffee.getMilk();
            beans -= coffee.getBeans();
            cups -= 1;
            money += coffee.getCost();
            needCleaning++;
        }
    }

    // Handles the "fill" action
    public void fillMachine(Scanner scanner) {
        System.out.println("Write how many ml of water you want to add:");
        water += scanner.nextInt();
        System.out.println("Write how many ml of milk you want to add:");
        milk += scanner.nextInt();
        System.out.println("Write how many grams of coffee beans you want to add:");
        beans += scanner.nextInt();
        System.out.println("Write how many disposable cups you want to add:");
        cups += scanner.nextInt();
    }

    // Handles the "take" action
    public void takeMoney() {
        System.out.println("I gave you $" + money);
        money = 0;
    }

    // Handles the "clean" action
    public void cleanMachine() {
        needCleaning = 0;
        System.out.println("I have been cleaned!");
    }

    // Processes user actions
    public void processAction(String action, Scanner scanner) {
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
            case "clean":
                cleanMachine();
                break;
            case "remaining":
                displayState();
                break;
            case "exit":
                System.exit(0);
                break;
            default:
                System.out.println("Invalid action");
        }
    }
}

// Main class to run the coffee machine
 class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CoffeeMachine coffeeMachine = new CoffeeMachine(400, 540, 120, 9, 550);

        while (true) {
            System.out.println("Write action (buy, fill, take, clean, remaining, exit):");
            String action = scanner.next();
            coffeeMachine.processAction(action, scanner);
        }
    }
}
