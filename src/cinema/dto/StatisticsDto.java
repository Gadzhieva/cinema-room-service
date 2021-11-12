package cinema.dto;

import cinema.entity.Ticket;
import cinema.repository.Theater;
import com.fasterxml.jackson.annotation.JsonProperty;

public class StatisticsDto {

    @JsonProperty("current_income")
    private int currentIncome;

    @JsonProperty("number_of_available_seats")
    private int availableSeatsNumber;

    @JsonProperty("number_of_purchased_tickets")
    private int purchasedTicketsNumber;

    public StatisticsDto(Theater theater) {
        currentIncome = 0;
        availableSeatsNumber = theater.getTotalColumns() * theater.getTotalRows();
        purchasedTicketsNumber = 0;
        for (Ticket ticket: theater.getTickets()) {
            currentIncome += ticket.getTicket().getPrice();
            purchasedTicketsNumber++;
        }
        availableSeatsNumber -= purchasedTicketsNumber;
    }
}
