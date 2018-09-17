package nl.isential.training.calculator.dto;

public class CalculatorResponseDto {

	private boolean success = false;
	
	private int amount;

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}
	
}
