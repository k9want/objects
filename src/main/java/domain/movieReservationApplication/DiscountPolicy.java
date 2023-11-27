package domain.movieReservationApplication;

import domain.movieReservationApplication.Money;
import domain.movieReservationApplication.Screening;

public interface DiscountPolicy {
    Money calculateDiscountAmount(Screening screening);
}
