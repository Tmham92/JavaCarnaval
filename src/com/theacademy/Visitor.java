package com.theacademy;

import com.theacademy.attractionmodels.*;

import java.util.ArrayList;
import java.util.List;
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
                System.out.println(bumperCarts.toString());
                enterAgain();
                break;
            case 2:
                buyTicket(spin.getPrize(), attractionNumber);
                spin.run();
                System.out.println(spin.toString());
                enterAgain();
                break;
            case 3:
                buyTicket(mirrorPalace.getPrize(), attractionNumber);
                mirrorPalace.run();
                System.out.println(mirrorPalace.toString());
                enterAgain();
                break;
            case 4:
                buyTicket(hauntedHouse.getPrize(), attractionNumber);
                hauntedHouse.run();
                System.out.println(hauntedHouse.toString());
                enterAgain();
                break;
            case 5:
                buyTicket(hawaii.getPrize(), attractionNumber);
                hawaii.run();
                System.out.println(hawaii.toString());
                enterAgain();
                break;
            case 6:
                buyTicket(climbingLadder.getPrize(), attractionNumber);
                climbingLadder.run();
                System.out.println(climbingLadder.toString());
                enterAgain();
                break;
            default:
                System.out.println("give valid input (1 to 6)");
                enterAttraction();
        }
    }

    public void buyTicket(double ticketPrize, int attractionNumber) {
        cashier.moneyPerAttraction.set(attractionNumber - 1, cashier.moneyPerAttraction.get(attractionNumber - 1) + ticketPrize);
        cashier.ticketsPerAttraction.set(attractionNumber - 1, cashier.ticketsPerAttraction.get(attractionNumber - 1) + 1);
        cashier.updateTotalEarnings();
        cashier.updateTotalTicketsSold();

        System.out.println("Earnings");
        System.out.println(cashier.moneyPerAttraction);
        System.out.println("");
        System.out.println("Tickets");
        System.out.println(cashier.ticketsPerAttraction);
        System.out.println("");
    }

    public void enterAgain() {
        System.out.println("Exit = 'n'; Anything is again");
        System.out.println("Earnings = 'o'; Tickets = 't'");
        char userInput = scanner.next().charAt(0);

        if (userInput == 'n') {
            System.out.println("Goodbye");
            System.exit(0);

        } else if (userInput == 'o') {
            System.out.println("Total Earnings: " + cashier.getMoneyEarned());
            enterAgain();

        } else if (userInput == 't') {
            System.out.println("Total Tickets Sold: " + cashier.getTicketsSold());
            enterAgain();
        } else {
            enterAttraction();
        }
    }
}


