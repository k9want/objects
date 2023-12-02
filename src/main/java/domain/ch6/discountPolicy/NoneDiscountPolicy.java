package domain.ch6.discountPolicy;

import domain.ch6.Money;
import domain.ch6.Screening;

public class NoneDiscountPolicy extends DefaultDiscountPolicy {
    @Override
    protected Money getDiscountAmount(Screening screening) {
        return Money.ZERO;
    }
}
