package come.emese.mathe.promotion;

import java.time.LocalDate;
import java.util.*;

public class Promotion {
    private Calendar startDate;
    private Calendar endDate;
    private String weekdays;
    private String startHour;
    private String endHour;

    public Promotion(Calendar startDate, Calendar endDate, String weekdays, String startHour, String endHour){
       this.startDate = startDate;
       this.endDate = endDate;
       this.weekdays = weekdays;
       this.startHour = startHour;
       this.endHour = endHour;
    }

    public boolean isActive(){
        Calendar now = Calendar.getInstance();
        return isActiveHelper(now);
    }

    boolean isStartHour(Calendar calendar) {
        return true;
    }

    boolean isEndHour(Calendar calendar) {
        return true;
    }

    boolean isStartCalendar(Calendar calendar) {
        return startDate == null || startDate.before(calendar);
//        return true;
    }

    boolean isEndCalendar(Calendar calendar) {
        return endDate == null || endDate.after(calendar);
//        return true;
    }

    boolean isWeekOfDay(Calendar calendar) {
        if (weekdays == null) {
            return true;
        }
        String dayOfWeek = LocalDate.now().getDayOfWeek().getValue() + "";

        List<String> dayOfWeeks = Arrays.asList(weekdays.split(","));
        Optional<String> partOfWeek = dayOfWeeks.stream()
                .filter(element -> element.equals(dayOfWeek))
                .findFirst();

        return partOfWeek.isPresent();
//        return true;
    }

    boolean isActiveHelper(Calendar c){
        return isStartCalendar(c) && isEndCalendar(c) && isWeekOfDay(c) && isStartHour(c) && isEndHour(c);
    }
}
