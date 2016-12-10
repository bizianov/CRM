package project.service;

import com.google.common.collect.Lists;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.model.accounting.Accounting;
import project.model.accounting.AccountingDao;
import project.model.tour.Tour;
import project.model.tourist.Tourist;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by slava23 on 12/11/2016.
 */

@Service
@Data
public class AccountingService {

    @Autowired
    private AccountingDao accountingDao;

    public Accounting saveAccounting(Accounting accounting) {
        return accountingDao.save(accounting);
    }

    public Accounting findAccountingById(int id) {
        return accountingDao.findOne(id);
    }

    public Accounting findAccountingByTour(Tour tour) {
        return Lists.newArrayList(accountingDao.findAll())
                .stream()
                .filter(accounting -> accounting.getTour().equals(tour))
                .findFirst()
                .get();
    }

    public List<Accounting> findAccountingByDate(int year, int month) {
        return Lists.newArrayList(accountingDao.findAll())
                .stream()
                .filter(accounting -> accounting.getTour().getEndDate().getYear() == year
                        && accounting.getTour().getEndDate().getMonthValue() == month)
                .collect(Collectors.toList());
    }

    public List<Accounting> findAccountingByTouristLastName(String lastName){
        return Lists.newArrayList(accountingDao.findAll())
                .stream()
                .filter(accounting -> !accounting.getTour().getTouristList()
                        .stream()
                        .map(tourist -> tourist.getLastName())
                        .filter(s -> s.equals(lastName))
                        .collect(Collectors.toList())
                        .isEmpty())
                .collect(Collectors.toList());
    }
}
