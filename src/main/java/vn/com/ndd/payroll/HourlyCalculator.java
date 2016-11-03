package vn.com.ndd.payroll;

public class HourlyCalculator extends PayCalculator {
	public HourlyCalculator() {
		super();
	}

	public double calculatePay(double hours, double rate) {
		double overTime = Math.max(0, hours - OVERTIME_THRESHOLD);
		return hours * rate + overTime * rate * OVERTIME_BONUS_RATE;
	}
}
