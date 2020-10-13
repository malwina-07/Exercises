package Zadanie05;

import java.time.LocalDate;

public class Runner {
    public static void main(String[] args) throws NoMemberSelectedException {

        Customer cusotmer01 = new Customer("Ryszard");

        System.out.println(cusotmer01);
        System.out.println(cusotmer01.isMember());
        System.out.println(cusotmer01);
        cusotmer01.setTypeOfMember(MemberType.GOLD);
        System.out.println(cusotmer01);

        Visit c01 = new Visit(cusotmer01, LocalDate.now());
        c01.setServiceExpense(100.0);
        c01.setProductExpense(10.0);
        System.out.println(c01.getTotalExpense());

        System.out.println("* - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - *");
        Customer cusotmer02 = new Customer("Zbigniew");
        cusotmer02.isMember();
        cusotmer02.setTypeOfMember(MemberType.PREMIUM);
        System.out.println(cusotmer02);

        Visit c02 = new Visit(cusotmer02, LocalDate.now());
        c02.setServiceExpense(100.0);
        c02.setProductExpense(10.0);
        System.out.println(c02.getTotalExpense());

        System.out.println("* - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - *");
        Customer cusotmer03 = new Customer("Bartłomiej");
        cusotmer03.isMember();
        cusotmer03.setTypeOfMember(MemberType.SILVER);
        System.out.println(cusotmer03);

        Visit c03 = new Visit(cusotmer03,LocalDate.now());
        c03.setServiceExpense(100.0);
        c03.setProductExpense(10.0);
        System.out.println(c03.getTotalExpense());
        System.out.println("* - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - *");

        Customer customer04 = new Customer("Romek");
        System.out.println(customer04);
//        customer04.setTypeOfMember(MemberType.PREMIUM);
        Visit c04 = new Visit(customer04,LocalDate.now());
        c04.setServiceExpense(100);
        c04.setProductExpense(10);
        System.out.println(c04.getTotalExpense());

    }
}
