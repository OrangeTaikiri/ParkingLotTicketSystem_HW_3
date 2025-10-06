package org.lecture;

/**
 * Represents a ticket with a unique number that can transition through various states.
 *
 * The ticket goes through the following states:
 * ISSUED, PAID, VALIDATED, CLOSED, and CANCELLED. It transitions between these states
 * based on specific actions such as paying, validating, closing, or canceling the ticket.
 */
public class Ticket {

    String ticketNumber;

    TicketStatusEnumeration status;

    /**
     * Constructs a new Ticket with a given ticket number.
     *
     * The ticket number is automatically converted to uppercase, and the initial
     * status of the ticket is set to ISSUED. A message is printed to indicate the
     * creation and status of the ticket using the printStateTransaction method.
     *
     * @param ticketNumber the identifier of the ticket to be created
     */
    public Ticket(String ticketNumber) {
        this.ticketNumber = ticketNumber.toUpperCase();
        status = TicketStatusEnumeration.ISSUED;
        printStateTransaction("issued", true);
    }


    /**
     * Pays the ticket if it is currently in the ISSUED state.
     *
     * If the ticket's status is ISSUED, the status is updated to PAID, and a success message
     * is printed using the printStateTransaction method.
     * If the ticket is not in the ISSUED state, the payment will not be processed, and
     * an error message will be printed.
     */
    public void payTicket() {
        if (status == TicketStatusEnumeration.ISSUED) {
            this.status = TicketStatusEnumeration.PAID;
            printStateTransaction("paid", true);
        } else {
            printStateTransaction("paid", false);
        }
    }

    /**
     * Validates the ticket if it is currently in the PAID state.
     *
     * If the ticket is in the PAID state, its status will be updated to VALIDATED
     * and a success message will be printed using the printStateTransaction method.
     * If the ticket is in any other state, validation will not be allowed and
     * an error message will be printed.
     */
    public void validateTicket() {
        if (status == TicketStatusEnumeration.PAID) {
            this.status = TicketStatusEnumeration.VALIDATED;
            printStateTransaction("validated", true);
        } else {
            printStateTransaction("validated", false);
        }
    }

    /**
     * Closes the ticket if it is currently in the VALIDATED state.
     *
     * If the ticket is in the VALIDATED state, its status will be updated to CLOSED
     * and a success message will be printed using the printStateTransaction method.
     * If the ticket is in any other state, the closure will not be allowed and
     * an error message will be printed.
     */
    public void closeTicket() {
        if (status == TicketStatusEnumeration.VALIDATED) {
            this.status = TicketStatusEnumeration.CLOSED;
            printStateTransaction("closed", true);
        } else {
            printStateTransaction("closed", false);
        }

    }

    /**
     * Cancels the ticket if it is currently in the ISSUED state.
     *
     * If the ticket is in the ISSUED state, its status will be updated to CANCELLED
     * and a success message will be printed using the printStateTransaction method.
     * If the ticket is in any other state, the cancellation will not be allowed
     * and an error message will be printed.
     */
    public void cancelTicket() {
        if (status == TicketStatusEnumeration.ISSUED) {
            this.status = TicketStatusEnumeration.CANCELLED;
            printStateTransaction("cancelled", true);
        } else {
            printStateTransaction("cancelled", false);
        }
    }

    /**
     * Prints the current status of the ticket along with its ticket number.
     * The status includes information such as whether the ticket is issued,
     * paid, validated, closed, or canceled.
     */
    public void printStatus() {
        System.out.println("Ticket " + ticketNumber + " is currently " + status + ".");
    }

    /**
     * Prints the result of a state transition operation for a ticket.
     *
     * @param stateString the name of the state to which the ticket is transitioning
     * @param success     a boolean indicating whether the transition was successful
     */
    private void printStateTransaction(String stateString, boolean success) {
        System.out.printf(success ? "Ticket %s has been %s %n" : "Ticket %s cannot be %s at this stage %n", this.ticketNumber,  stateString);
    }


}
