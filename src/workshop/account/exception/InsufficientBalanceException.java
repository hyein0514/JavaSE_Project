package workshop.account.exception;

public class InsufficientBalanceException extends Exception {
	private int currentBalance;
	
	public InsufficientBalanceException(String errMessage, int currentBalance) {
		super(errMessage);
		this.currentBalance = currentBalance;
	}

	public int getCurrentBalance() {
		return currentBalance;
	}

}
