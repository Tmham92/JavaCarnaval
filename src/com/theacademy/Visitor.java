package com.theacademy;

import com.theacademy.attractionmodels.*;
import java.util.Scanner;


public class Visitor {
    Cashier cashier = new Cashier();
    Scanner scanner = new Scanner(System.in);
    BumperCarts bumperCarts = new BumperCarts();
    Spin spin = new Spin();
    MirrorPalace mirrorPalace = new MirrorPalace();
    HauntedHouse hauntedHouse = new HauntedHouse();
    Hawaii hawaii = new Hawaii();
    ClimbingLadder climbingLadder = new ClimbingLadder();


    public void enterAttraction() {

        System.out.println("Enter your attraction");

        int attractionNumber = Integer.parseInt(scanner.next());
        switch (attractionNumber) {
            case 1:
                buyTicket(bumperCarts.getPrize(), attractionNumber);
                bumperCarts.run();

                break;
            case 2:
                buyTicket(spin.getPrize(), attractionNumber);
                spin.run();
                break;
            case 3:
                buyTicket(mirrorPalace.getPrize(), attractionNumber);
                mirrorPalace.run();
                break;
            case 4:
                buyTicket(hauntedHouse.getPrize(), attractionNumber);
                hauntedHouse.run();
                break;
            case 5:
                buyTicket(hawaii.getPrize(), attractionNumber);
                hawaii.run();
                break;
            case 6:
                buyTicket(climbingLadder.getPrize(), attractionNumber);
                climbingLadder.run();
                break;
            default:
                System.out.println("give valid input (1 to 6)");
                enterAttraction();
        }
        enterAgain();
    }

    public void buyTicket(double ticketPrize, int attractionNumber) {
        TaxInspector inspector = new TaxInspector();

        cashier.moneyPerAttraction.set(attractionNumber - 1, cashier.moneyPerAttraction.get(attractionNumber - 1) + ticketPrize);
        cashier.ticketsPerAttraction.set(attractionNumber - 1, cashier.ticketsPerAttraction.get(attractionNumber - 1) + 1);

        cashier.updateTotalEarnings();
        cashier.updateTotalTicketsSold();

        if (inspector.isComing()) {
            System.out.println("Taxes to pay: ");
            System.out.println(climbingLadder.getEarnings() + " times " + climbingLadder.getGamblingTaxes());
            System.out.println("which is a total of " + climbingLadder.getEarnings() * climbingLadder.getGamblingTaxes());
            cashier.payTaxes(climbingLadder.getEarnings(), climbingLadder.getGamblingTaxes());
            cashier.updateTotalEarnings();
        }

        System.out.println("Earnings");
        System.out.println(cashier.moneyPerAttraction);
        System.out.println("");
        System.out.println("Tickets");
        System.out.println(cashier.ticketsPerAttraction);
        System.out.println("");
    }

    public void enterAgain() {
        System.out.println("Exit = 'n'; Anything is again");
        System.out.println("Earnings = 'o'; Tickets = 'k'");
        char userInput = scanner.next().charAt(0);

        if (userInput == 'n') {
            System.out.println("Goodbye");
            System.exit(0);

        } else if (userInput == 'o') {
            System.out.println("Total Earnings: " + cashier.getMoneyEarned());
            enterAgain();

        } else if (userInput == 'k') {
            System.out.println("Total Tickets Sold: " + cashier.getTicketsSold());
            enterAgain();
        } else {
            enterAttraction();
        }
    }
}


