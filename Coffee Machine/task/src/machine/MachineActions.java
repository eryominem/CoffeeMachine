package machine;
import machine.TypesOfCoffee.*;
import java.util.Scanner;

public abstract class MachineActions {

    public static void actionBuy(CoffeeMachine machine) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ");
        String coffeeType = scanner.nextLine();

        switch (coffeeType) {
            case "1":
                machine.makeCoffee(Espresso.WATER, Espresso.MILK, Espresso.BEANS, Espresso.COST);
                break;
            case "2":
                machine.makeCoffee(Latte.WATER, Latte.MILK, Latte.BEANS, Latte.COST);
                break;
            case "3":
                machine.makeCoffee(Cappuccino.WATER, Cappuccino.MILK, Cappuccino.BEANS, Cappuccino.COST);
                break;
            case "back":
                break;
        }
    }

    public static void actionFill(CoffeeMachine machine) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write how many ml of water you want to add:");
        machine.setWaterIn(machine.getWaterIn() + scanner.nextInt());

        System.out.println("Write how many ml of milk you want to add:");
        machine.setMilkIn(machine.getMilkIn() + scanner.nextInt());

        System.out.println("Write how many grams of coffee beans you want to add:");
        machine.setBeansIn(machine.getBeansIn() + scanner.nextInt());

        System.out.println("Write how many disposable cups of coffee you want to add:");
        machine.setCupsIn(machine.getCupsIn() + scanner.nextInt());

        System.out.println();
    }

    public static void actionTake(CoffeeMachine machine) {
        System.out.println("I gave you $" + machine.getCashIn());
        machine.setCashIn(0);
    }

    public static void actionRemaining(CoffeeMachine machine) {
        System.out.print("The coffee machine has:\n" + machine.getWaterIn() + " ml of water\n" +
                machine.getMilkIn() + " ml of milk\n" + machine.getBeansIn() + " g of coffee beans\n" +
                machine.getCupsIn() + " disposable cups\n" + "$" + machine.getCashIn() + " of money\n\n");
    }
}
