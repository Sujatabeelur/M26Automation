package genericUtilities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class JavaUtility {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	

	}
	/**
	 * This method will return the current date in a specific format
	 * @return
	 */
	
	public String getSystemDateInFormat(){
		Date d=new Date();
		
		SimpleDateFormat sf = new SimpleDateFormat("dd-MM-yyyy-hh-mm-ss");
		String date = sf.format(d);
		return date;
		
	}
}
