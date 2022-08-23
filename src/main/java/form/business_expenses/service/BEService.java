/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package form.business_expenses.service;
import form.business_expenses.model.BEModel;
import form.business_expenses.repository.BERepository;
import org.springframework.stereotype.Service;
/**
 *
 * @author HP
 */
@Service
public class BEService {
   
    private final BERepository beRepository;
    public BEService(BERepository beRepository){
        this.beRepository=beRepository;
    }
    public BEModel addIncome(Float revenue, Float expenses, String month){
        if(revenue==null && expenses==null && month==null){
            return null;
        }
        else{
            BEModel usersModel=new BEModel();
            usersModel.setRevenue(revenue);
            usersModel.setExpenses(expenses);
            usersModel.setMonth(month);
            usersModel.setNetincome(revenue,expenses);
            usersModel.setProfitmargin(revenue);
            return beRepository.save(usersModel);
        }
    }
    public BEModel retrieveRecord(String month){
       return beRepository.findByMonth(month).orElse(null);
       
    }
}
