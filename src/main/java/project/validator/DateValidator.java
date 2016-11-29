package project.validator;

import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by slava23 on 11/29/2016.
 */

@Component
public class DateValidator implements Validator<Date, String> {

    private static final String DATE_PATTERN = "yyyy-MM-dd";
    private SimpleDateFormat simpleDateFormat;

    public DateValidator() {
        simpleDateFormat = new SimpleDateFormat(DATE_PATTERN);
    }

    @Override
    public Date validate(String input) throws ParseException {
        Date parsedDate = simpleDateFormat.parse(input);
        return parsedDate;
    }
}
