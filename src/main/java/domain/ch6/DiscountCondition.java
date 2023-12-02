package domain.ch6;

public interface DiscountCondition {
    boolean isSatisfiedBy(Screening screening);
}
