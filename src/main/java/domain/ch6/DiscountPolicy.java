package domain.ch6;

public interface DiscountPolicy {
    Money calculateDiscountAmount(Screening screening);
}
