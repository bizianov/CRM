package project.service;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.model.passport.Passport;
import project.model.passport.PassportDao;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

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

    public List<Passport> getPassportsDueToExpire(){
        Iterable<Passport> all = passportDao.findAll();
        List<Passport> passportsDueToExpire = Lists.newArrayList(all)
                .stream()
                .filter(Passport::isDueToExpire)
                .collect(Collectors.toList());
        return passportsDueToExpire;
    }

    public Passport createPassport(String serialNumber, String issuer, Date issueDate, Date expireDate){
        Passport passport = Passport.of(serialNumber, issuer, issueDate, expireDate);
        passportDao.save(passport);
        return passport;
    }

    public Passport savePassport(Passport passport){
        return passportDao.save(passport);
    }

    public Passport deletePassport(int id){
        Passport passportById = getPassportById(id);
        if (passportById != null){
            passportDao.delete(passportById);
        }
        return passportById;
    }

    public PassportDao getPassportDao() {
        return passportDao;
    }

    public void setPassportDao(PassportDao passportDao) {
        this.passportDao = passportDao;
    }
}
