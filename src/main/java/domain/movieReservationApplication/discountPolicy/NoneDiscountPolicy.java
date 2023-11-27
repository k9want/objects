package domain.movieReservationApplication.discountPolicy;

import domain.movieReservationApplication.Money;
import domain.movieReservationApplication.Screening;

public class NoneDiscountPolicy extends DefaultDiscountPolicy {
    @Override
    protected Money getDiscountAmount(Screening screening) {
        return Money.ZERO;
    }
}
