package vn.com.ndd.payroll;

public class ContractorCalculator extends PayCalculator {
	public ContractorCalculator() {
		super();
	}
	
	public double calculatePay(double hours, double rate) {
		return hours * rate;
	}
}
