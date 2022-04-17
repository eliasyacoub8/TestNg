package testng;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoanTest {
	//no need for main method but the test case as a method itself

	@BeforeTest(alwaysRun=true)
	public void method1() {
		
		System.out.println("Inside Before Test");
	
	
	}
	@Test(groups= {"Sanity"}, priority=0)
	public void HomeLoanTest() {
		
		System.out.println("Inside HomeLoan Test");
	
	
	}
	@Test(enabled=true,priority=1)
	public void CarLoanTest() {
		
		System.out.println("Inside CarLoan Test");
	
	
	}


}
