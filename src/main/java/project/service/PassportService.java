package project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.model.passport.Passport;
import project.model.passport.PassportDao;

import java.util.Date;

/**
 * Created by slava23 on 11/29/2016.
 */

@Service
public class PassportService {

    @Autowired
    private PassportDao passportDao;

    public Passport getPassportById(int id){
        return passportDao.findOne(id);
    }

    public Passport createPassport(String serialNumber, String issuer, Date issueDate, Date expireDate){
        Passport passport = new Passport(serialNumber, issuer, issueDate, expireDate);
        passportDao.save(passport);
        return passport;
    }

    public PassportDao getPassportDao() {
        return passportDao;
    }

    public void setPassportDao(PassportDao passportDao) {
        this.passportDao = passportDao;
    }
}
