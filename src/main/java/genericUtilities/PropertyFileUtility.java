package genericUtilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
/**
 * This class consists of generic method related to property file
 */

public class PropertyFileUtility 
{
	
	/**
	 * This method is used to read data from property File and return the value
	 * @param input
	 * @return
	 * @throws IOException
	 */
	public String readDataFromPropertyFile(String input) throws IOException

	{
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		Properties p = new Properties();
		p.load(fis);
		String value = p.getProperty(input);
		return value;
	}
}
