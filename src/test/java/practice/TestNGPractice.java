package practice;

import org.testng.annotations.Test;



public class TestNGPractice 
{
	@Test (invocationCount = 2,threadPoolSize = 3, enabled = true ,dependsOnMethods = "Login")
	
	public void sampleTest()
	{
		System.out.println("hi");
	}
	
	@Test
	public void Login()
	{
		System.out.println("Hello");
	}
	
	@Test(priority = 0)
	public void method1()
	{
		System.out.println("From method 1");
	}
	@Test(priority = 1)
	public void method2()
	{
		System.out.println("From method 2");
	}
}
