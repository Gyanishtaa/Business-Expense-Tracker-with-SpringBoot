/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package form.business_expenses.model;

import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="business_expenses")

public class BEModel {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    Integer id; 
    Float revenue;
    Float expenses;
    String month;
    Float netincome;
    Float profitmargin;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Float getRevenue() {
        return revenue;
    }

    public void setRevenue(Float revenue) {
        this.revenue = revenue;
    }

    public Float getExpenses() {
        return expenses;
    }

    public void setExpenses(Float expenses) {
        this.expenses = expenses;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }
    public Float getNetincome()
    {
        return netincome;
    }
    public void setNetincome(Float revenue,Float expenses)
    {
        this.netincome=revenue-expenses;
    }

    public Float getProfitmargin() {
        return profitmargin;
    }

    public void setProfitmargin(Float revenue){

        this.profitmargin = (this.netincome/revenue)*100;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BEModel that = (BEModel) o;
        return Objects.equals(id, that.id) && Objects.equals(revenue, that.revenue) && Objects.equals(expenses, that.expenses) && Objects.equals(month, that.month);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, revenue, expenses, month);
    }

    @Override
    public String toString() {
        return "UsersModel{" +
                "id=" + id +
                ", revenue='" + revenue + '\'' +
                ", expenses='" + expenses + '\'' +
                ", month='" + month + '\'' +
                '}';
    }
}
