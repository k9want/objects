package domain.ch8.discountPolicy;

import domain.ch8.DiscountCondition;
import domain.ch8.DiscountPolicy;
import domain.ch8.Money;
import domain.ch8.Screening;

public class PercentDiscountPolicy extends DiscountPolicy {
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
