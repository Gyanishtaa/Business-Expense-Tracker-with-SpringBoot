/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package form.business_expenses.controller;
import form.business_expenses.model.BEModel;
import form.business_expenses.service.BEService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author HP
 */
@Controller
public class BEController {
    private final BEService beService;

    public BEController(BEService beService) {
        this.beService = beService;
    }

    @GetMapping("/add")
    public String getAddIncomePage(Model model){
        model.addAttribute("addRequest",new BEModel());
        return "add_entry";
    }
    
    @GetMapping("/retrieve")
    public String getRetrieveRecordPage(Model model)
    {
        model.addAttribute("retrieveRequest",new BEModel());
        return "retrieve_entry";
    }
    @PostMapping("/add")
    public String add(@ModelAttribute BEModel beModel){
        System.out.println("add request: "+beModel);
        BEModel retrieved=beService.retrieveRecord(beModel.getMonth());
        if(retrieved==null) {
            BEModel addentrytodatabase = beService.addIncome(beModel.getRevenue(), beModel.getExpenses(), beModel.getMonth());
            return addentrytodatabase == null ? "error_page" : "redirect:/add";
        }
        else {
            return "error_page1";
        }
    }

    @PostMapping("/retrieve")
    public String retrieve(@ModelAttribute BEModel beModel, Model model){
        System.out.println("retrieve request: "+ beModel);
        BEModel retrieved=beService.retrieveRecord(beModel.getMonth());
        if(retrieved!=null){
            model.addAttribute("idattr",retrieved.getId());
            model.addAttribute("monthattr",retrieved.getMonth());
            model.addAttribute("revenueattr",retrieved.getRevenue());
            model.addAttribute("expensesattr",retrieved.getExpenses());
            model.addAttribute("netincattr",retrieved.getNetincome());
            model.addAttribute("profmarattr",retrieved.getProfitmargin());
        return "display_record" ;
        } else {
            return "error_page";
        }
    }
}
