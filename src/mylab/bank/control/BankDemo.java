package mylab.bank.control;

import mylab.bank.entity.*;
import mylab.bank.exception.*;

public class BankDemo {

    public static void main(String[] args) {

        Bank bank = new Bank();

        try {

            System.out.println("=== 계좌 생성 ===");

            SavingsAccount acc1 = bank.createSavingsAccount("홍길동", 10000, 3.0);
            CheckingAccount acc2 = bank.createCheckingAccount("김철수", 20000, 5000);
            SavingsAccount acc3 = bank.createSavingsAccount("이영희", 30000, 2.0);

            bank.printAllAccounts();

            System.out.println("\n=== 입금/출금 테스트 ===");

            bank.deposit(acc1.getAccountNumber(), 5000);
            bank.withdraw(acc2.getAccountNumber(), 3000);

            System.out.println("\n=== 이자 적용 테스트 ===");
            acc1.applyInterest();

            System.out.println("\n=== 계좌 이체 테스트 ===");

            bank.transfer(acc3.getAccountNumber(), acc2.getAccountNumber(), 5000);

            bank.printAllAccounts();

            bank.withdraw(acc2.getAccountNumber(), 6000);

            bank.findAccount("AC9999");

        } catch (Exception e) {
            System.out.println("예외 발생: " + e.getMessage());
        }
    }
}