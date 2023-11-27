package domain.movieReservationApplication.discountCondition;

import domain.movieReservationApplication.DiscountCondition;
import domain.movieReservationApplication.Screening;

public class SequenceCondition implements DiscountCondition {
    private int sequence;

    public SequenceCondition(int sequence) {
        this.sequence = sequence;
    }

    @Override
    public boolean isSatisfiedBy(Screening screening) {
        return sequence == screening.getSequence();
    }
}
