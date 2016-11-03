package vn.com.ndd.payroll;

import org.junit.Assert;
import org.junit.Test;

public class PayCalculatorTest {
	PayCalculator hourlyWorker = new PayCalculator(true);
	PayCalculator nonHourlyWoker = new PayCalculator(false);
	
	private void assertPay(double expectPay, double actualPay){
		Assert.assertEquals(expectPay, actualPay, 0.001);
	}
	
	@Test(expected = RuntimeException.class)
	public void shouldThrowExceptionWhenInvalidMinusValue() {
		hourlyWorker.calculate(-0.1, 0);
	}

	@Test(expected = RuntimeException.class)
	public void shouldThrowExceptionWhenInvalidBiggerThan80() {
		hourlyWorker.calculate(80.1, 0);
	}

	@Test
	public void shouldBe0WhenWorkHourIs0() {
		assertPay(0, hourlyWorker.calculate(0, 10));
		assertPay(0, nonHourlyWoker.calculate(0, 10));
	}
	
	@Test
	public void shouldNotCalculateOvertimeWhenWorkRegularHours() {
		assertPay(300, hourlyWorker.calculate(30, 10));
		assertPay(300, nonHourlyWoker.calculate(30, 10));
	}
	
	@Test
	public void shouldCalculateOvertimeWhenWorkHoursGreaterThan40() {
		assertPay(550, hourlyWorker.calculate(50, 10));
		assertPay(500, nonHourlyWoker.calculate(50, 10));
	}
}
