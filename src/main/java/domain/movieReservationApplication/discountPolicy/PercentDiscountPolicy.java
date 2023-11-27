package domain.movieReservationApplication.discountPolicy;

import domain.movieReservationApplication.DiscountCondition;
import domain.movieReservationApplication.Money;
import domain.movieReservationApplication.Screening;

public class PercentDiscountPolicy extends DefaultDiscountPolicy {
    private double percent;

    public PercentDiscountPolicy(double percent, DiscountCondition... conditions) {
        super(conditions);
        this.percent = percent;
    }

    @Override
    protected Money getDiscountAmount(Screening screening) {
        return screening.getMovieFee().times(percent);
    }
}
