package domain.scheduler;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Main {
    public static void main(String[] args) {
        Event event = new Event("회의", LocalDateTime.of(2019, 5, 9, 10, 30),
                Duration.ofMinutes(30));
        RecurringSchedule schedule = new RecurringSchedule("회의", DayOfWeek.WEDNESDAY, LocalTime.of(10, 30),
                Duration.ofMinutes(30));

        System.out.println("reschedule 전: " + event.isSatisfied(schedule));
        if (!event.isSatisfied(schedule)) {
            event.reschedule(schedule);
            System.out.println("reschedule 후: " + event.isSatisfied(schedule));
        }
    }
}
