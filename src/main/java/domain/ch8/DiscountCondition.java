package domain.ch8;

public interface DiscountCondition {
    boolean isSatisfiedBy(Screening screening);
}
