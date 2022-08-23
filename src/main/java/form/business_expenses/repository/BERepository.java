/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package form.business_expenses.repository;
import form.business_expenses.model.BEModel;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
/**
 *
 * @author HP
 */
public interface BERepository extends JpaRepository <BEModel, Integer>{
    Optional<BEModel> findByMonth(String month);
    
} 
