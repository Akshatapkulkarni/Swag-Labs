package genericUtilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzerImplementation implements IRetryAnalyzer
{

	@Override
	public boolean retry(ITestResult result)
	{
		int count = 0;
		int retryCount = 3;
		if(count<retryCount)
		{
			count++;
			return true;//retry execution
		}
		return false;//not retry execution
	}
	
}
