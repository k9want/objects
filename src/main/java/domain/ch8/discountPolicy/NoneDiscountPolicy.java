package domain.ch8.discountPolicy;

import domain.ch8.DiscountPolicy;
import domain.ch8.Money;
import domain.ch8.Screening;

public class NoneDiscountPolicy extends DiscountPolicy {
    @Override
    protected Money getDiscountAmount(Screening screening) {
        return Money.ZERO;
    }
}
