package org.lecture;

public class Ticket {

    String ticketNumber;

    TicketStatusEnumeration status;

    public Ticket(String ticketNumber) {
        this.ticketNumber = ticketNumber.toUpperCase();
        status = TicketStatusEnumeration.ISSUED;
        printStateTransaction("issued", true);
    }


    public void payTicket() {
        if (status == TicketStatusEnumeration.ISSUED) {
            this.status = TicketStatusEnumeration.PAID;
            printStateTransaction("paid", true);
        } else {
            printStateTransaction("paid", false);
        }
    }

    public void validateTicket() {
        if (status == TicketStatusEnumeration.PAID) {
            this.status = TicketStatusEnumeration.VALIDATED;
            printStateTransaction("validated", true);
        } else {
            printStateTransaction("validated", false);
        }
    }

    public void closeTicket() {
        if (status == TicketStatusEnumeration.VALIDATED) {
            this.status = TicketStatusEnumeration.CLOSED;
            printStateTransaction("closed", true);
        } else {
            printStateTransaction("closed", false);
        }

    }

    public void cancelTicket() {
        if (status == TicketStatusEnumeration.ISSUED) {
            this.status = TicketStatusEnumeration.CANCELLED;
            printStateTransaction("cancelled", true);
        } else {
            printStateTransaction("cancelled", false);
        }
    }

    public void printStatus() {
        System.out.println("Ticket " + ticketNumber + " is currently " + status + ".");
    }

    private void printStateTransaction(String stateString, boolean success) {
        if(success){
            System.out.printf("Ticket %s has been %s %n", this.ticketNumber,  stateString);
        } else  {
            System.out.printf("Ticket %s cannot be %s at this stage %n", this.ticketNumber,  stateString);
        }
    }


}
