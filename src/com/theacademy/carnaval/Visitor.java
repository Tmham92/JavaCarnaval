package com.theacademy.carnaval;

import com.theacademy.carnaval.attractionmodels.*;

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
                if (spin.getSpinningLimit() <= 0) {
                    System.out.println("Attraction needs maintenance.");
                } else {
                    buyTicket(spin.getPrize(), attractionNumber);
                    spin.run();
                }
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
                if (hawaii.getSpinningLimit() <= 0) {
                    System.out.println("Attraction needs maintenance.");
                } else {
                    buyTicket(hawaii.getPrize(), attractionNumber);
                    hawaii.run();
                }
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


        if (inspector.isComing() && climbingLadder.getEarnings() != 0) {
            System.out.println("Taxes to pay: ");
            System.out.println((climbingLadder.getEarnings() + climbingLadder.getPrize()) + " times " + climbingLadder.getGamblingTaxes());
            System.out.println("which is a total of " + climbingLadder.getEarnings() + climbingLadder.getPrize() * climbingLadder.getGamblingTaxes());
            cashier.payTaxes(climbingLadder.getEarnings() + climbingLadder.getPrize(), climbingLadder.getGamblingTaxes());
        }
        cashier.updateTotalTicketsSold();
        cashier.updateTotalEarnings();

        System.out.println(cashier.moneyPerAttraction);

    }

    public void enterAgain() {
        System.out.println("Exit = 'n'; Anything is again");
        System.out.println("Earnings = 'o'; Tickets = 'k'");
        if (spin.getSpinningLimit() <= 0 || hawaii.getSpinningLimit() <= 0) {
            System.out.println("Maintenance needed; enter 'm'");
        }
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
        } else if (userInput == 'm') {
            if (spin.getSpinningLimit() <= 0) {
                spin.maintainAttraction();
            }
            else {
                hawaii.maintainAttraction();
            }
            enterAttraction();
        } else {
            enterAttraction();
        }
    }
}


