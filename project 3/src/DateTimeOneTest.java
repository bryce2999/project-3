import static org.junit.jupiter.api.Assertions.fail;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;

import org.junit.jupiter.api.Test;

import junit.framework.Assert;

class DateTimeOneTest 
{
	DateTimeOne dto = new DateTimeOne();
	Calendar cal = new GregorianCalendar();
	
	@Test
	void getValueOfSecondTest()
	{
		int expected = cal.SECOND;
		int actual = dto.getValueOfSecond();
		Assert.assertEquals(expected, actual);
	}

	// date/time format ==> Current Date/Time: 10/08/2019 03:03 PM
	@Test
	void dateTimeNowTest()
	{
		Date date = cal.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		String expected = "Current Date/Time: " + (sdf.format(date)) + dto.getAmPm();
		String actual = dto.getDateTimeNow();
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	void timeAtOtherZonesTest()
	{
		//setup
	    SimpleDateFormat sdf2 = new SimpleDateFormat("MM/dd/yyyy HH:mm"
	    		);
		String[] expected = new String[3];
		Calendar now = Calendar.getInstance();
		Date dateNow = now.getTime();
		Calendar GMT = Calendar.getInstance();
		
		//expected GMT zone 
		GMT.setTime(dateNow);
	    GMT.add(Calendar.HOUR_OF_DAY, 5);
	    
	    //exepected BST zone
	    Calendar BST = Calendar.getInstance();
	    BST.setTime(dateNow);
	    BST.add(Calendar.HOUR_OF_DAY, 1);
	    
	    //excpected CST zone
	    Calendar CST = Calendar.getInstance();
	    CST.setTime(dateNow);
	    
	    //add expected zones to expected array
	    expected[0] = sdf2.format(GMT.getTime());
	    expected[1] = sdf2.format(BST.getTime());
	    expected[2] = sdf2.format(CST.getTime());
	    
	    //actual array, from dateTimeOne.timeAtOtherZones();
	    String[] actual = new String[3];
	    HashMap<String, String> actualTimes = dto.getTimeZoneMap();
	    actual[0] = (actualTimes.get("GMT"));
	    actual[1] = (actualTimes.get("BST"));
	    actual[2] = (actualTimes.get("CST"));

	    
	    //assertion of equality
	    for(int i = 0; i < 3; i++)
	    Assert.assertEquals(expected[i], actual[i]);
	}
	
	@Test 
	void timeZoneHashMapTest()
	{
		//setup 
		Calendar now = Calendar.getInstance();
		Date dateNow = now.getTime();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		HashMap<String, String> expected = new HashMap<String,String>();
		HashMap<String, String> actual = new HashMap<String,String>();
		String GMTTime;
		String BSTTime;
		String CSTTime;
		
		//expected keys
		String GMTKey = "GMT";
		String BSTKey = "BST";
		String CSTKey = "CST";
		
		//expected timezones
		Calendar GMT = Calendar.getInstance();
		Calendar BST = Calendar.getInstance();
		Calendar CST = Calendar.getInstance();
		
		//setting zones
		GMT.setTime(dateNow);
		GMT.add(Calendar.HOUR_OF_DAY, 5);
		BST.setTime(dateNow);
		BST.add(Calendar.HOUR_OF_DAY, 1);
		CST.setTime(dateNow);
		
		//filling expected array
		expected.put(GMTKey, sdf.format(GMT.getTime()));
		expected.put(BSTKey, sdf.format(BST.getTime()));
		expected.put(CSTKey, sdf.format(CST.getTime()));

		//actual hashmap 
		actual = dto.getDateTimeMap();
		
		//assertion of equality 
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	void test() 
	{
		fail("Not yet implemented");
	}

}
