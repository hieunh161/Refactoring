package vn.com.ndd.payroll;

import org.junit.Assert;
import org.junit.Test;

public class PayCalculatorTest {

	private void assertPay(double expectPay, double actualPay){
		Assert.assertEquals(expectPay, actualPay, 0.001);
	}
	
	@Test(expected = RuntimeException.class)
	public void shouldThrowExceptionWhenInvalidMinusValue() {
		PayCalculator.calculate(-0.1, 0, true);
	}

	@Test(expected = RuntimeException.class)
	public void shouldThrowExceptionWhenInvalidBiggerThan80() {
		PayCalculator.calculate(80.1, 0, true);
	}

	@Test
	public void shouldBe0WhenWorkHourIs0() {
		assertPay(0, PayCalculator.calculate(0, 10, true));
		assertPay(0, PayCalculator.calculate(0, 10, false));
	}
	
	@Test
	public void shouldCalculateOvertimeWhenWorkHoursGreaterThan40() {
		assertPay(550, PayCalculator.calculate(50, 10, true));
		assertPay(500, PayCalculator.calculate(50, 10, false));
	}
}
