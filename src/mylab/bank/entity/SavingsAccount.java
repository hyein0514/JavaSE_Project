package mylab.bank.entity;

public class SavingsAccount extends Account{
	private double interestRate; //이자율
	
	public SavingsAccount(String accountNumber, String ownerName, double balance, double interestRate) {
        super(accountNumber, ownerName, balance);
        this.interestRate = interestRate;
    }
	
	public void applyInterest() {
		double interest = balance * interestRate / 100;
		deposit(interest);
		System.out.println("이자 " + interest + "원이 적용되었습니다. 현재 잔액: " + balance + "원");
	}
	
	@Override
    public String toString() {
        return "계좌번호: " + accountNumber +
                ", 소유자: " + ownerName +
                ", 잔액: " + balance +
                "원, 이자율: " + interestRate + "%";
    }
}
