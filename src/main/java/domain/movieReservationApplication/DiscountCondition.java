package domain.movieReservationApplication;

public interface DiscountCondition {
    boolean isSatisfiedBy(Screening screening);
}
