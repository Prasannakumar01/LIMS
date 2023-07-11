package insurancePractice;

import org.NewaInsurance_GenrericUtilities.BaseClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNG_practise extends BaseClass{
	@BeforeSuite
	public void m0() {
		System.out.println("m0");
	}
	
	@BeforeClass
	public void m1() {
		System.out.println("m1");
	}
	@BeforeMethod
	public void m2() {
		System.out.println("m2");
	}
	@BeforeTest
	public void m3() {
		System.out.println("m3");
	}
	@Test(enabled=false)
	public void m4() {
		System.out.println("m4");
	}
	@Test
	public void m5() {
	 System.out.println("m5");
	}
	@AfterMethod
	public void m9()
	{
		System.out.println("m9");
	}
	
    @AfterClass
	public void m6() {
		System.out.println("m6");
		
	}
	@AfterTest
	public void m7() {
		System.out.println("m7");
	}
	@AfterSuite
	public void m8() {
		System.out.println("m8");
	}
	
	

}
