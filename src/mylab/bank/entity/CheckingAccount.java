package mylab.bank.entity;

import mylab.bank.exception.InsufficientBalanceException;
import mylab.bank.exception.WithdrawalLimitExceededException;

public class CheckingAccount extends Account {
	
	private double withdrawalLimit;

    public CheckingAccount(String accountNumber, String ownerName, double balance, double withdrawalLimit) {
        super(accountNumber, ownerName, balance);
        this.withdrawalLimit = withdrawalLimit;
    }
    
    @Override
    public void withdraw(double amount) throws InsufficientBalanceException {

        if (amount > withdrawalLimit) {
            throw new WithdrawalLimitExceededException(
                    "출금 한도를 초과했습니다. 한도: " + withdrawalLimit + "원");
        }

        super.withdraw(amount);
    }
    
    @Override
    public String toString() {
        return "계좌번호: " + accountNumber +
                ", 소유자: " + ownerName +
                ", 잔액: " + balance +
                "원, 출금 한도: " + withdrawalLimit + "원";
    }

}
