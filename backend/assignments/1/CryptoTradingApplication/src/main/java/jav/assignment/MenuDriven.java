package jav.assignment;

import java.util.Scanner;
import jav.assignment.Functions.MenuFunctions;
import jav.assignment.globalObjects.GlobalData;

public class MenuDriven extends Thread {

    static Scanner sc = new Scanner(System.in);
    public static int menu;

    public static void getChoice() {
        boolean flag = true;
        while (flag) {
            Logging.logInfo("Enter your choice 1 || 2 || 3 || 4 || 5 || 6\n");
            System.out.println("1 -> Given the name or code of a coin, retrieve all its details.\n2 -> Display top 50 coins in the market based on price.\n3 -> For a given trader, show his portfolio.\n4 -> For a given trader, display the total profit or loss they have made trading in the crypto market.\n5 -> Show top 5 and bottom 5 traders based on their profit/loss.\n6 -> EXIT");
            menu = sc.nextInt();
            switch (menu) {
                case 1:
                    MenuFunctions.getDetailsByNameOrCodeOfCoin();
                    break;
                case 2:
                    MenuFunctions.get50CoinsOnPrice();
                    break;
                case 3:
                    MenuFunctions.getPortfolioByName();
                    break;
                case 4:
                    sc.nextLine();
                    String traderName = sc.nextLine();
                    MenuFunctions.ProfitAndLossOfEachTrader(traderName);
                    break;
                case 5:
                    System.out.println("Enter value of n");
                    int n = sc.nextInt();
                    MenuFunctions.TopNBottomNTraders(n);
                    break;
                case 6:
                    flag = false;
                    break;
                default:
                    System.out.println("Enter a valid choice");
                    break;
            }
        }
    }

    @Override
    public void run() {
        getChoice();
    }
}