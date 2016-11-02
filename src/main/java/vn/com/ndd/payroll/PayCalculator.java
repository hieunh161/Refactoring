package vn.com.ndd.payroll;

public class PayCalculator {
	public static float calculate(double hours, double rate,
			boolean isHourlyWorker) {
		if (hours < 0 || hours > 80) {
			throw new RuntimeException("Hours out of range: " + hours);
		}
		float wages = 0;

		if (hours > 40) {
			double overTimeHours = hours - 40;
			if (isHourlyWorker) {
				wages += (overTimeHours * 1.5) * rate;
			} else {
				wages += overTimeHours * rate;
			}
			hours -= overTimeHours;
		}
		wages += hours * rate;
		return wages;
	}
}
