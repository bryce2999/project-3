import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateTimeTwo
{
	
	private Date tenth;
	public Date getTenth() {
		return tenth;
	}
	
	Date fifteenth;

	public Date getFifteenth() {
		return fifteenth;
	}

	private Date eighteenth;
	public Date getEighteenth() {
		return eighteenth;
	}
	String lastDay;
	

	public String getLastDay() {
		return lastDay;
	}

	public void daysOfCurrentMonth() 
	{
		// TODO Auto-generated method stub
		tenth = null;
	    eighteenth = null;

		try {
			tenth = new SimpleDateFormat("MM/dd/yyy").parse("10/10/2019");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			eighteenth = new SimpleDateFormat("MM/dd/yyy").parse("10/18/2019");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		SimpleDateFormat sdf = new SimpleDateFormat("EEEE");
		System.out.println("The tenth day of this month is " + sdf.format(tenth).toUpperCase() + " and eighteenth is " + sdf.format(eighteenth).toUpperCase());
		
	}

	public void daysOfAnyMonth(int i, int j) 
	{
		Calendar cal = Calendar.getInstance();
		int year = j;
		int month = i;
		cal.set(year, month,0);
		try {
		 fifteenth = new SimpleDateFormat("MM/dd/yyyy").parse(i+"/15/"+j);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String date  = ((i+"/15/"+j));
		SimpleDateFormat asdf = new SimpleDateFormat("MM/dd/yyyy");
		Date cd;
		try {
			cd = asdf.parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Calendar c = Calendar.getInstance();
		c.setTime(fifteenth);
		c.set(Calendar.DAY_OF_MONTH, c.getActualMaximum(Calendar.DAY_OF_MONTH));
		

		SimpleDateFormat sdf = new SimpleDateFormat("EEEE");
		
		System.out.println(String.format("For the year (%d) and month (%d), the fifteenth day is %s and the last day is %s",year,month,sdf.format(fifteenth).toUpperCase(),sdf.format(c.getTime()).toUpperCase()));
		lastDay = sdf.format(c.getTime());
	}

	public void compareYear() 
	{
		// TODO Auto-generated method stub
		String[] s = new String[10];
		BufferedReader br = null;
		try {
			 br = new BufferedReader(new FileReader("Dates.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			s = br.readLine().split(".");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("lol");
		}
		
		for(int i = 0; i < 30; i++)
			System.out.println(s[i]);
	}

	public void dateHashMap() 
	{
		// TODO Auto-generated method stub
		
	}

	public void dateHashMapSorted() 
	{
		// TODO Auto-generated method stub
		
	}

	public String getLast() 
	{
		// TODO Auto-generated method stub
		return lastDay;
	}

}
