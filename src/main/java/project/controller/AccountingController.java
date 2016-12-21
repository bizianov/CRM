package project.controller;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import project.model.accounting.Accounting;
import project.model.tour.Tour;
import project.service.AccountingService;
import project.service.TourService;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * Created by slava23 on 12/11/2016.
 */

@Controller
@Data
@NoArgsConstructor
@RequiredArgsConstructor(staticName = "of", onConstructor = @__(@Autowired))
@Secured("ROLE_ADMIN")
public class AccountingController {

    @NonNull
    private AccountingService accountingService;
    @NonNull
    private TourService tourService;

    @RequestMapping("/createAccounting")
    public String createAccounting(@RequestParam(name = "tourId") int tourId,
                                   @RequestParam(name = "tpaNumber") String tpaNumber,
                                   @RequestParam(name = "tpgNumber") String tpgNumber,
                                   @RequestParam(name = "tourOperatorNumber") String tourOperatorNumber,
                                   @RequestParam(name = "isDirectPayment") Boolean isDirectPayment,
                                   @RequestParam(name = "electronicAct", required = false) Boolean electronicAct,
                                   @RequestParam(name = "paperAct", required = false) Boolean paperAct,
                                   Model model){
        Tour tourById = tourService.findTourById(tourId);
        if (tourById != null){
            Accounting accounting = Accounting.of(tourById,tpaNumber,tpgNumber,tourOperatorNumber,isDirectPayment);
            if (electronicAct != null){
                accounting.setElectronicAct(electronicAct);
            }
            if (paperAct != null){
                accounting.setPaperAct(paperAct);
            }
            accountingService.saveAccounting(accounting);
            model.addAttribute("accounting", accounting);
            return "accounting/showAccounting";
        } else {
            model.addAttribute("tourId", tourId);
            return "accounting/error/invalidTourId";
        }
    }

    @RequestMapping("/getAccountingById")
    public String findAccountingById(@RequestParam(name = "id") int id,
                                     Model model){
        Accounting accountingById = accountingService.findAccountingById(id);
        model.addAttribute("accounting", accountingById);
        return "accounting/showAccounting";
    }

    @RequestMapping("/getAccountingByTour")
    public String findAccountingByTour(@RequestParam(name = "id") int id, Model model){
        Tour tourById = tourService.findTourById(id);
        if (tourById == null){
            model.addAttribute("tourId", id);
            return "accounting/error/invalidTourId";
        } else {
            Accounting accountingByTour = accountingService.findAccountingByTour(tourById);
            model.addAttribute("accounting", accountingByTour);
            return "accounting/showAccounting";
        }
    }

    @RequestMapping("/getAccountingByTourist")
    public String findAccountingByTourist(@RequestParam(name = "lastName") String lastName, Model model){
        List<Accounting> accountingByTouristLastName = accountingService.findAccountingByTouristLastName(lastName);
        model.addAttribute("allAccountings", accountingByTouristLastName);
        return "accounting/showAllAccountings";
    }

    @RequestMapping("/getOpenedAccountings")
    public String findOpenedAccounting(Model model){
        List<Accounting> openedAccountings = accountingService.findOpenedAccounting();
        model.addAttribute("allAccountings", openedAccountings);
        return "accounting/showAllAccountings";
    }

    @RequestMapping("/getAccountingsByDate")
    public String findAccountingByDate(@RequestParam(name = "year") int year,
                                       @RequestParam(name = "month") int month,
                                       Model model){
        List<Accounting> accountingsByDate = accountingService.findAccountingByDate(year, month);
        model.addAttribute("allAccountings", accountingsByDate);
        return "accounting/showAllAccountings";
    }

    @RequestMapping("/receivedElectronicActs")
    public String updateElectronicActs(@RequestParam(name = "id") int id, Model model){
        Accounting accountingById = accountingService.findAccountingById(id);
        accountingById.setElectronicAct(true);
        accountingService.saveAccounting(accountingById);
        model.addAttribute("accounting",accountingById);
        return "accounting/showAccounting";
    }

    @RequestMapping("/receivedPaperActs")
    public String updatePaperActs(@RequestParam(name = "id") int id, Model model){
        Accounting accountingById = accountingService.findAccountingById(id);
        accountingById.setPaperAct(true);
        accountingService.saveAccounting(accountingById);
        model.addAttribute("accounting",accountingById);
        return "accounting/showAccounting";
    }

    @RequestMapping(value = "/accounting", method = GET)
    public String accountingMenu(Model model){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userLoggedIn = authentication.getName();
        model.addAttribute("userLoggedIn", userLoggedIn);
        return "accounting/accounting";
    }
}
