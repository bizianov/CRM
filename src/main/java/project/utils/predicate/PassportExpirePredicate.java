package project.utils.predicate;

import project.model.passport.Passport;
import project.utils.date.DateUtils;

import java.util.Date;
import java.util.function.Predicate;

/**
 * Created by slava23 on 11/29/2016.
 */
public class PassportExpirePredicate implements Predicate<Passport> {

    @Override
    public boolean test(Passport passport) {
        Date expireDate = passport.getExpireDate();
        Date today = new Date();
        return (DateUtils.addMonths(today, 12).after(expireDate));
    }
}
