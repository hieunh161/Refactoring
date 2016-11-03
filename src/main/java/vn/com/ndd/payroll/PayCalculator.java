package vn.com.ndd.payroll;

public class PayCalculator {
	private static final double OVERTIME_BONUS_RATE = 0.5;
	private static final int OVERTIME_LIMIT = 80;
	private static final int OVERTIME_THRESHOLD = 40;

	public static double calculate(double hours, double rate,
			boolean isHourlyWorker) {
		if (hours < 0 || hours > OVERTIME_LIMIT) {
			throw new RuntimeException("Hours out of range: " + hours);
		}

		if (isHourlyWorker) {
			double overTime = Math.max(0, hours - OVERTIME_THRESHOLD);
			return hours * rate + overTime * rate * OVERTIME_BONUS_RATE;
		} else {
			return hours * rate;
		}
	}
}
