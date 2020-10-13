package Zadanie05;

import java.time.LocalDate;

public class Visit extends DiscountRate {
    private Customer customer;
    private LocalDate date;
    private double serviceExpense;
    private double productExpense;

    public Visit(Customer customer, LocalDate date) {
        this.customer = customer;
        this.date = date;
    }

    public Visit(Customer customer) {
        this.customer = customer;
    }

    public Visit(String name, LocalDate date) {
        super();
        this.date = date;
    }

    public double getServiceExpense() {
        return serviceExpense;
    }

    public void setServiceExpense(double expense) {
        this.serviceExpense = expense;
    }

    public double getProductExpense() {
        return productExpense;
    }

    public void setProductExpense(double productExpense) {
        this.productExpense = productExpense;
    }

    public double getTotalExpense() {
        if (customer.type != null) {
            serviceExpense -= serviceExpense * getServiceDiscountRate(customer.type);
            productExpense -= productExpense * getProductDiscountRate(customer.type);
        }
        return serviceExpense + productExpense;
    }
}
