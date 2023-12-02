package domain.ch6.discountPolicy;

import domain.ch6.DiscountCondition;
import domain.ch6.DiscountPolicy;
import domain.ch6.Money;
import domain.ch6.Screening;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class DefaultDiscountPolicy implements DiscountPolicy {
    private List<DiscountCondition> conditions = new ArrayList<>();

    public DefaultDiscountPolicy(DiscountCondition... conditions) {
        this.conditions = Arrays.asList(conditions);
    }

    @Override
    public Money calculateDiscountAmount(Screening screening) {
        for (DiscountCondition condition : conditions) {
            if (condition.isSatisfiedBy(screening)) {
                return getDiscountAmount(screening);
            }
        }
        return null;
    }

    protected abstract Money getDiscountAmount(Screening screening);
}
