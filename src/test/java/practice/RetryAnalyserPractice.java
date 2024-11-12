package practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RetryAnalyserPractice 
{
	@Test(retryAnalyzer = genericUtilities.RetryAnalyzerImplementation.class)
	
	public void sample()
	{
		Assert.fail();
		System.out.println("hi");
	}

}
