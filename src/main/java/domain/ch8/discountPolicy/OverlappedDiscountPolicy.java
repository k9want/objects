package domain.ch8.discountPolicy;

import domain.ch8.DiscountPolicy;
import domain.ch8.Money;
import domain.ch8.Screening;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OverlappedDiscountPolicy extends DiscountPolicy {
    private List<DiscountPolicy> discountPolicies = new ArrayList<>();

    public OverlappedDiscountPolicy(DiscountPolicy... discountPolicies) {
        this.discountPolicies = Arrays.asList(discountPolicies);
    }

    @Override
    protected Money getDiscountAmount(Screening screening) {
        Money result = Money.ZERO;
        for (DiscountPolicy discountPolicy : discountPolicies) {
            result = result.plus(discountPolicy.calculateDiscountAmount(screening));
        }
        return result;
    }
}
