package helpers;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
public class CSVWriter
{
	private AppConfig appConfig = new AppConfig();
	
	public void writeCsvEntry(String text, String text2) throws IOException {

		String filePath = appConfig.getSetting("metricsOutputPath");
		File myFile = new File(filePath);
		
		// only creates a file if it doesn't already exist
		myFile.createNewFile();
		
		FileOutputStream f = new FileOutputStream(filePath, true);
		byte[] byteArr = (text + "," + text2 + "\r\n").getBytes(); // converting string into byte array
		f.write(byteArr);
		f.close();
	}	
}
