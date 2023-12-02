package domain.ch8;

import domain.ch8.discountCondition.PeriodCondition;
import domain.ch8.discountCondition.SequenceCondition;
import domain.ch8.discountPolicy.AmountDiscountPolicy;
import domain.ch8.discountPolicy.OverlappedDiscountPolicy;
import domain.ch8.discountPolicy.PercentDiscountPolicy;
import java.math.BigDecimal;
import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class ReservationAgency {
    public static void main(String[] args) {
        DiscountPolicy discountPolicy = new AmountDiscountPolicy(Money.wons(1_000),
                new SequenceCondition(1));
        Movie movie = new Movie("The Great Movie", Duration.ofMinutes(120), new Money(new BigDecimal(15000)),
                discountPolicy);

        Screening screening = new Screening(movie, 1, LocalDateTime.of(2023, 11, 27, 14, 30));
        Customer customer = new Customer("A", "1");

        Reservation reserve = screening.reserve(customer, 1);
        System.out.println(reserve.getFee());

        Movie avatar = new Movie("Avatar", Duration.ofMinutes(100), new Money(new BigDecimal(18000)),
                new OverlappedDiscountPolicy(
                        new AmountDiscountPolicy(Money.wons(1_500),
                                new SequenceCondition(1),
                                new PeriodCondition(
                                        DayOfWeek.WEDNESDAY,
                                        LocalTime.of(10, 0),
                                        LocalTime.of(14, 0))),
                        new PercentDiscountPolicy(10,
                                new SequenceCondition(1),
                                new PeriodCondition(
                                        DayOfWeek.THURSDAY,
                                        LocalTime.of(10, 0),
                                        LocalTime.of(14, 0)))));
    }
}
