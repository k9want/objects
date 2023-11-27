package domain.movieReservationApplication.discountPolicy;

import domain.movieReservationApplication.DiscountCondition;
import domain.movieReservationApplication.Money;
import domain.movieReservationApplication.Screening;

public class AmountDiscountPolicy extends DefaultDiscountPolicy {
    private Money discountAmount;

    public AmountDiscountPolicy(Money discountAmount, DiscountCondition... conditions) {
        super(conditions);
        this.discountAmount = discountAmount;
    }

    @Override
    protected Money getDiscountAmount(Screening screening) {
        return discountAmount;
    }
}
