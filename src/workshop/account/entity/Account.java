package workshop.account.entity;
import workshop.account.exception.InsufficientBalanceException;

public class Account {
	private String custId;
	private String acctId;
	private int balance;
	
	//Default Constructor 
	public Account() {
		System.out.println(this.getClass().getName() + " 기본생성자 호출됨");
	}
	

	//Constructor Overloading 
	public Account(String custId, String acctId) {
		setCustId(custId);
		setAcctId(acctId);
	}
	
	//setter method 
//	public void setBalance(int balance) {
//		this.balance = balance;
//	}
	
	public void setAcctId(String acctId) {
		this.acctId = acctId;
	}


	public void setCustId(String custId) {
		this.custId = custId;
	}

	//getter method 
	public String getCustId() {
		return custId;
	}

	public String getAcctId() {
		return acctId;
	}

	public int getBalance() {
		return balance;
	}
	
	//입금
	public void deposit(int amount) {
		//this.balance = this.balance + amount;
		this.balance += amount;
	}
	//출금
	public void withdraw(int amount) throws InsufficientBalanceException {
		if(amount > balance) {
			throw new InsufficientBalanceException("잔액이 부족합니다. 현재 잔액은 = ",balance);
		}
		this.balance -= amount;
	}
	
	// 메서도 재정의 (오버라이딩)
	@Override
	public String toString() {
		return "Account[고객번호 = " + custId + ", "
				+ "계좌번호 = "+ acctId + ", 잔액 = "
				+ balance  + "]";
	}
	
	
}