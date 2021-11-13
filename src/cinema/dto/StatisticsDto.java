package cinema.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class StatisticsDto {

    @JsonProperty("current_income")
    private int currentIncome;

    @JsonProperty("number_of_available_seats")
    private int availableSeatsNumber;

    @JsonProperty("number_of_purchased_tickets")
    private int purchasedTicketsNumber;

    public StatisticsDto(int currentIncome, int availableSeatsNumber, int purchasedTicketsNumber) {
        this.currentIncome = currentIncome;
        this.availableSeatsNumber = availableSeatsNumber;
        this.purchasedTicketsNumber = purchasedTicketsNumber;
    }
}
