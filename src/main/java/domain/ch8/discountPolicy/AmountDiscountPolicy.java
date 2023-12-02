package domain.ch8.discountPolicy;

import domain.ch8.DiscountCondition;
import domain.ch8.DiscountPolicy;
import domain.ch8.Money;
import domain.ch8.Screening;

public class AmountDiscountPolicy extends DiscountPolicy {
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
