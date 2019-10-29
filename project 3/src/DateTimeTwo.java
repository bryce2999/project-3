import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.TreeMap;

public class DateTimeTwo
{
	private ArrayList<String> yearArray = new ArrayList<String>();
	private HashMap<String,Integer> yearMap = new HashMap<String,Integer>();

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

	private HashMap<String,Integer> dateMap;
	
	public void compareYear() throws IOException, ParseException 
	{
		
		// TODO Auto-generated method stub
		String[] s;
		BufferedReader br;
		Calendar cal = Calendar.getInstance();
		Date now = cal.getTime();
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy", Locale.ENGLISH);

		//System.out.println("******"+System.getProperty("user.dir"));

		br = new BufferedReader(new FileReader("/Users/BEJ0118/Documents/CS2334/Project 3/res/Dates.txt"));
		String dateDot;
		dateMap = new HashMap<String,Integer>();
		dateDot = br.readLine();
		while(dateDot != null)
		{
			//special character '.' requires operator to split
			String[] split = dateDot.split("\\.");			
			String yearString = new String(split[2]);
			//creating the date as a string with /  instead of . 
			String date = split[0]+"/"+split[1]+"/"+split[2];
			String dateTwo = split[2]+"-"+split[0]+"-"+split[1];
			yearArray.add(dateTwo);
			Date readDate = sdf.parse(date);
			Date dateNow = now;
			int[] monthDayYear = {};
			monthDayYear = getDateDiff(readDate,dateNow);
			String month;
			String day;
			int year = Integer.parseInt(split[2]);
			month = monthDayYear[0]+"";
			day = monthDayYear[1]+"";
			//decide leap year and print
			if (((year % 100 == 0) && (year % 400 == 0) || (year%4 == 0)) && year != 1900)
		       System.out.println(split[2] + " is a leap year, and Difference: " + monthDayYear[2] + " years, " + monthDayYear[0] + " months, and " + monthDayYear[1] + " days.");
		    else
			   System.out.println(split[2] + " is not a leap year, and Difference: " +monthDayYear[2] + " years, " + monthDayYear[0] + " months, and " + monthDayYear[1] + " days.");
			dateDot = br.readLine();
		}
		br.close();	
	}
	
	
	
	public static int[] getDateDiff(Date dateOne, Date dateTwo) 
	{
        
		//setting up calendar variables for starting and enging date for calculation
		Calendar fromDate=Calendar.getInstance();
        Calendar toDate=Calendar.getInstance();
        fromDate.setTime(dateOne);
        toDate.setTime(dateTwo);
        //i variable neccessary for calculation
        int i = 0;
        //vars to hold year,month,day vals
        int year,month,day;

        //setting the i variable
        if (fromDate.get(Calendar.DAY_OF_MONTH) > toDate.get(Calendar.DAY_OF_MONTH)) 
        {
            i =fromDate.getActualMaximum(Calendar.DAY_OF_MONTH);
        }
        
         // calc day
        if (i != 0) {
            day = (toDate.get(Calendar.DAY_OF_MONTH) + i) - fromDate.get(Calendar.DAY_OF_MONTH);
            i = 1;
        } else {
            day = toDate.get(Calendar.DAY_OF_MONTH) - fromDate.get(Calendar.DAY_OF_MONTH);
        }

        // calc month
        if ((fromDate.get(Calendar.MONTH) + i) > toDate.get(Calendar.MONTH)) {
            month = (toDate.get(Calendar.MONTH) + 12) - (fromDate.get(Calendar.MONTH) + i);
            i = 1;
        } else {
            month = (toDate.get(Calendar.MONTH)) - (fromDate.get(Calendar.MONTH) + i);
            i = 0;
        }

        // calc year
        year = toDate.get(Calendar.YEAR) - (fromDate.get(Calendar.YEAR) + i);
        return new int[] {month,day,year};
    }
	
	public void dateHashMap() throws IOException, ParseException 
	{
		for(Integer i = 0; i < 10; i++)
		{
			yearMap.put(yearArray.get(i),i);
		}
		for(String date : yearMap.keySet())
		{
			System.out.println(date+":"+ yearMap.get(date));
		}
	}

	public void dateHashMapSorted() 
	{
		
		TreeMap<String,Integer> sortedMap = new TreeMap<String,Integer>(yearMap);
		for(String date : sortedMap.keySet())
		{
			System.out.println(date+":"+ yearMap.get(date));
		}		
	}

	public String getLast() 
	{
		// TODO Auto-generated method stub
		return lastDay;
	}

}
