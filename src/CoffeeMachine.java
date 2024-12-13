import java.util.Random;
import java.util.Scanner;

public class CoffeeMachine {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

//        int cups = input.nextInt();
//        int water = cups * 200;
//        int milk = cups * 50;
//        int coffeeBeans = cups * 15;

        System.out.println("Write how many ml of water the coffee machine has: ");
        int water = input.nextInt();
        System.out.println("Write how many ml of milk the coffee machine has: ");
        int milk = input.nextInt();
        System.out.println("Write how many grams of coffee beans the coffee machine has: ");
        int grams = input.nextInt();
        System.out.println("Write how many cups of coffee you will need: ");
        int cups = input.nextInt();

        int amountOfWater = water / 200;
        int amountOfMilk = milk / 50;
        int amountOfGrams = grams / 15;
        int totalCups = Math.min(amountOfWater, Math.min(amountOfMilk, amountOfGrams));


         if(totalCups >= cups) {
             System.out.println("Yes, I can make that amount of coffee");

             if(totalCups > cups) {
                 System.out.println(" (and even " + (totalCups - cups) + " more than that)");
             }
         } else {
             System.out.println("No, I can only make " + totalCups + " cup(s) of coffee");
         }







    }
}
