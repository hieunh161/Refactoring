package vn.com.ndd.payroll;

public abstract class PayCalculator {
	protected static final double OVERTIME_BONUS_RATE = 0.5;
	protected static final int OVERTIME_LIMIT = 80;
	protected static final int OVERTIME_THRESHOLD = 40;
	
	public final double calculate(double hours, double rate){
		validateHours(hours);
		return calculatePay(hours, rate);
	}
	
	public abstract double calculatePay(double hours, double rate);
	
	protected void validateHours(double hours) {
		if (hours < 0 || hours > OVERTIME_LIMIT) {
			throw new RuntimeException("Hours out of range: " + hours);
		}
	}
}
