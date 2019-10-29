import static org.junit.jupiter.api.Assertions.fail;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.junit.jupiter.api.Test;

import junit.framework.Assert;

class DateTimeTwoTest 
{

	DateTimeTwo dtt = new DateTimeTwo();
	SimpleDateFormat sdf = new SimpleDateFormat("EEEE");
	Date tenth, eighteenth;
	
	@SuppressWarnings("deprecation")
	@Test 
	void daysOfCurrentMonthTest()
	{
		@SuppressWarnings("unused")
		Calendar now = Calendar.getInstance();
		dtt.daysOfCurrentMonth();
		tenth = dtt.getTenth();
		eighteenth = dtt.getEighteenth();
		System.out.println(tenth);
		System.out.println(eighteenth);
		String expected = "The tenth day of this month is Thursday and the eightnnth is Friday" ;
		String actual = "The tenth day of this month is " + sdf.format(tenth) + " and the eightnnth is " + sdf.format(eighteenth);
		Assert.assertEquals(expected, actual);
		
	}
	
	@SuppressWarnings("deprecation")
	@Test
	void daysOfAnyMonthTest()
	{
		dtt.daysOfAnyMonth(10,2019);
		int year = 2019;
		int month = 10;
		Calendar cal = Calendar.getInstance();
		cal.set(year,month,0);
		int max = cal.getActualMaximum(Calendar.DATE);
		Date tenth = new Date(month+"/15/"+year);
		Date eighteenth = new Date(month+"/"+max+"/"+year);

		
		String expected = String.format("For the year (%d) and the month (%d), the fifteenth day is %s and the last day is %s",year,month,sdf.format(tenth),dtt.getLastDay());
		String actual = String.format("For the year ("+year+") and the month ("+month+"), the fifteenth day is " + sdf.format(dtt.getFifteenth()) + " and the last day is " + dtt.getLastDay()); 		
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	void test() 
	{
		fail("Not yet implemented");
	}

}
