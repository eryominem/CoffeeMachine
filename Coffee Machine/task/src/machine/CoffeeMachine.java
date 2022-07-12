package machine;
import javax.crypto.Mac;
import java.util.Scanner;

public class CoffeeMachine {
    static Scanner sc = new Scanner(System.in);

    private int waterIn;
    private int milkIn;
    private int beansIn;
    private int cupsIn;
    private int cashIn;

    public CoffeeMachine() {
        this.waterIn = 400;
        this.milkIn = 540;
        this.beansIn = 120;
        this.cupsIn = 9;
        this.cashIn = 550;
    }

    public static void menu(CoffeeMachine machine) {
        //CoffeeMachine machine = new CoffeeMachine();
        boolean flag = true;
        do {
            System.out.print("Write action (buy, fill, take, remaining, exit): ");
            String action = sc.next();

            switch (action) {
                case "buy":
                    MachineActions.actionBuy(machine);
                    break;

                case "fill":
                    MachineActions.actionFill(machine);
                    break;

                case "take":
                    MachineActions.actionTake(machine);
                    break;

                case "remaining":
                    MachineActions.actionRemaining(machine);
                    break;

                case "exit":
                    flag = false;
                    break;

                default:
                    flag = false;
                    break;
            }

        } while (flag);


    }

    public void makeCoffee(int needWater, int needMilk, int needBeans, int needCash) {
        boolean flag = true;

        if (getWaterIn() < needWater) {
            flag = false;
            System.out.println("Sorry, not enough water!");
            return;
        }
        if (getMilkIn() < needMilk) {
            flag = false;
            System.out.println("Sorry, not enough milk!");
            return;
        }
        if (getBeansIn() < needBeans) {
            flag = false;
            System.out.println("Sorry, not enough coffee beans!");
        }

        if (getCupsIn() < 1) {
            flag = false;
            System.out.println("Sorry, not enough cups!");
            return;
        }

        if (flag) {
            setWaterIn(getWaterIn() - needWater);
            setMilkIn(getMilkIn() - needMilk);
            setBeansIn(getBeansIn() - needBeans);
            setCupsIn(getCupsIn() - 1);
            setCashIn(getCashIn() + needCash);

            System.out.println("I have enough resources, making you a coffee!");
        }
    }


    public int getWaterIn() {
        return waterIn;
    }

    public void setWaterIn(int waterIn) {
        this.waterIn = waterIn;
    }

    public int getMilkIn() {
        return milkIn;
    }

    public void setMilkIn(int milkIn) {
        this.milkIn = milkIn;
    }

    public int getBeansIn() {
        return beansIn;
    }

    public void setBeansIn(int beansIn) {
        this.beansIn = beansIn;
    }

    public int getCupsIn() {
        return cupsIn;
    }

    public void setCupsIn(int cupsIn) {
        this.cupsIn = cupsIn;
    }

    public int getCashIn() {
        return cashIn;
    }

    public void setCashIn(int cashIn) {
        this.cashIn = cashIn;
    }
}
