package org.lecture;

import java.util.Scanner;

public class Main {

    static void main() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Please enter a ticket number: ");
        String number = scanner.nextLine();

        Ticket ticket = new Ticket(number);

        ticket.payTicket();
        ticket.validateTicket();
        ticket.closeTicket();
        ticket.printStatus();

        // Attempt invalid transition
        ticket.cancelTicket();

        scanner.close();



    }
}
