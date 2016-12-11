package project.controller;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
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

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * Created by slava23 on 12/11/2016.
 */

@Controller
@Data
@RequiredArgsConstructor
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

    @RequestMapping(value = "/accounting", method = GET)
    public String accountingMenu(Model model){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userLoggedIn = authentication.getName();
        model.addAttribute("userLoggedIn", userLoggedIn);
        return "accounting/accounting";
    }
}
