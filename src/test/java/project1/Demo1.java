package project1;

import java.security.PublicKey;

import org.testng.annotations.Test;

public class Demo1 {

	@Test (priority = 1-1)
	
	public void SampleOne() {
		System.out.println("Mohith");
	}
	
	@Test (priority = 1)
	public void SampleTwo() {
		System.out.println("Reddy");
	}

}
