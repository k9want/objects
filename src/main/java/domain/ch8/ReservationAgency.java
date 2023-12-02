package domain.ch8;

import domain.ch8.discountCondition.SequenceCondition;
import domain.ch8.discountPolicy.AmountDiscountPolicy;
import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDateTime;

public class ReservationAgency {
    public static void main(String[] args) {
        DiscountPolicy discountPolicy = new AmountDiscountPolicy(Money.wons(2_000),
                new SequenceCondition(1));
        Movie movie = new Movie("The Great Movie", Duration.ofMinutes(120), new Money(new BigDecimal(15000)), discountPolicy);
        Screening screening = new Screening(movie, 1, LocalDateTime.of(2023, 11, 27, 14, 30));
        Customer customer = new Customer("A", "1");

        Reservation reserve = screening.reserve(customer, 1);
        System.out.println(reserve.getFee());
    }
}
