package project.utils.date;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by slava23 on 11/29/2016.
 */
public class DateUtils {

    public static Date addMonths(Date date, int number){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, number);
        return calendar.getTime();
    }

    public static Date addDays(Date date, int number){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_YEAR, number);
        return calendar.getTime();
    }
}
