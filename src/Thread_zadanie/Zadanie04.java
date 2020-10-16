package Thread_zadanie;

import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Zadanie04 {
    public static void main(String[] args) {

        Random random = new Random();
        BankAccount bankAccount1 = new BankAccount(100, 321);
        BankAccount bankAccount2 = new BankAccount(100, 123);
        int randomAmount = 43;

        var bankLock = new ReentrantLock();
        Condition sufficientFunds = bankLock.newCondition();

        Thread thread01 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                bankLock.lock();
                try {
                    while (bankAccount1.getAmount() < randomAmount)
                        sufficientFunds.await();
                    Thread.sleep(1000);

                    System.out.println(bankAccount1.toString() + " Saldo: " + bankAccount1.transferTo(bankAccount2, randomAmount));
                    sufficientFunds.signalAll();
                } catch (InterruptedException | InvalidTransferException e) {
                    e.printStackTrace();
                } finally {
                    bankLock.unlock();
                }
            }
        });
        Thread thread02 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                bankLock.lock();
                try {
                    while (bankAccount2.getAmount() < randomAmount)
                        sufficientFunds.await();
                    Thread.sleep(1000);
                    System.out.println(bankAccount2.toString() + "Saldo: " + bankAccount2.transferTo(bankAccount1, randomAmount));
                    sufficientFunds.signalAll();
                } catch (InterruptedException | InvalidTransferException e) {
                    e.printStackTrace();
                } finally {
                    bankLock.unlock();
                }

            }

        });

        thread01.start();
        thread02.start();
    }
}


class BankAccount {
    double amount;
    int id;

    public BankAccount(double amount, int id) {
        this.amount = amount;
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "[ ID= " + id +
                " amount=" + amount +
                ']';
    }

    public double addAmount(double amount) {
        this.amount += amount;
        return this.amount;
    }

    public double removeAmount(double amount) throws InvalidTransferException {

        if (amount > this.amount) {
            throw new InvalidTransferException("Amount exceeded balance");
        }
        this.amount -= amount;
        return this.amount;
    }

    double transferTo(BankAccount to, double amount) throws InvalidTransferException {
        if (amount <= this.amount) {
            this.amount -= amount;
            to.addAmount(amount);
        } else {
            throw new InvalidTransferException("No monay");
        }
        return this.amount;
    }

}

class InvalidTransferException extends Exception {
    InvalidTransferException(String messaga) {
        super(messaga);
    }
}

