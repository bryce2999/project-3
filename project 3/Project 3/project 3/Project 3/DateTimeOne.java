import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class DateTimeOne extends MesoDateTimeOneAbstract
{

	private Calendar now = new GregorianCalendar();
	private int currSec = Calendar.SECOND;
	private HashMap<String,String> timeZoneMap = new HashMap<String,String>();
    private String AmPm = new String();
    private Calendar GMT, CST, BST;
    private String timeOnServer;
    private HashMap<String,String> dateTimeMap;
    private String dateTimeNow;
    
	Date date;
	
	@Override
	int getValueOfSecond() 
	{
		currSec = Calendar.SECOND;
		return currSec;
	}

	
//	Current Date/Time: 10/08/2019 03:03 PM

	@Override
	void dateTimeNow() 
	{
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		date = now.getTime();
        if (now.get(Calendar.AM_PM) == Calendar.PM) 
        {
        	AmPm = "PM";
        }
        if (now.get(Calendar.AM_PM) == Calendar.AM) 
        {
        	AmPm = "AM";
        }
       System.out.println(String.format("Current Date/Time: %s %s",sdf.format(date), AmPm));
       dateTimeNow = String.format("Current Date/Time: %s %s",sdf.format(date), AmPm);
	}

	public String getAmPm()
	{
		date = now.getTime();
        if (now.get(Calendar.AM_PM) == Calendar.PM) 
        {
        	AmPm = "PM";
        }
        if (now.get(Calendar.AM_PM) == Calendar.AM) 
        {
        	AmPm = "AM";
        }
		return new String(AmPm);
	}
	@Override
	void sleepForFiveSec() 
	{
		try {
			wait(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	void dateTimeOfOtherCity() 
	{
		//compute other timezones by adding or subtracting from CST(current time zone
		//set date
		date = now.getTime();
		//zones
		String[] zones = new String[3];
		
		//time only format
	    SimpleDateFormat sdf2 = new SimpleDateFormat("HH:mm");

		//date time format
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		timeOnServer = ("Time on Server: " + sdf2.format(now.getTime()));
		//gmt
		GMT = Calendar.getInstance();
		GMT.setTime(date);
	    GMT.add(Calendar.HOUR_OF_DAY, 5);
	    //bst
	    BST = Calendar.getInstance();
	    BST.setTime(date);
	    BST.add(Calendar.HOUR_OF_DAY, 1);
	    //cst zone
	    CST = now;
	    
	    //time at zones
	    String GMTTime = sdf2.format(GMT.getTime());
	    String BSTTime = sdf2.format(BST.getTime());
	    String CSTTime = sdf2.format(CST.getTime());

	    zones[0] = GMTTime;
	    zones[1] = BSTTime;
	    zones[2] = CSTTime;
	    
	    
		   
		   System.out.println("GMT: " + zones[0]);
		   System.out.println("BST (90E): " + zones[1]);
		   System.out.println("CST (90W): " + zones[2]);
		
	}
	
	
	@SuppressWarnings("rawtypes")
	@Override
	public void timeZoneHashMap() 
	{
		date = now.getTime();

				//gmt
				GMT = Calendar.getInstance();
				GMT.setTime(date);
			    GMT.add(Calendar.HOUR_OF_DAY, 5);
			    //bst
			    BST = Calendar.getInstance();
			    BST.setTime(date);
			    BST.add(Calendar.HOUR_OF_DAY, 11);
			    //cst zone
			    CST = now;
		
		//timeAtOtherZones();
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm");
		
	    String GMTDateTime = new String(sdf.format(GMT.getTime()));
	    String BSTDateTime = new String(sdf.format(BST.getTime()));
	    String CSTDateTime = new String(sdf.format(now.getTime()));

	    timeZoneMap.put("GMT", GMTDateTime);
	    timeZoneMap.put("BST", BSTDateTime);
	    timeZoneMap.put("CST", CSTDateTime);
	   
	    //get hashmap with three original keys
	    HashMap<String,String> dateTimeMap = timeZoneMap;
	    //add two fictitional key
	    dateTimeMap.put("AST","10/01/2020 19:59");
	    dateTimeMap.put("ZST","11/05/2018 19:59");

	    //sort first hashmap according to keys using a sorted TreeMap
	    TreeMap<String, String> sortedMap = new TreeMap<String,String>(dateTimeMap);
	    sortedMap.putAll(dateTimeMap);

	    //print style one
	    System.out.println("\nPrint Style 1:");
	    for (Entry<String, String> e : sortedMap.entrySet()) 
	    {  
            System.out.println(e.getKey() +  " " + e
            		.getValue()); 
	    } 
	    
	    //declare second hashmap 
	    HashMap<String, String> newMap = new HashMap<String,String>();
	    //assignt hasmap calues
	    newMap.put(timeZoneMap.get("GMT"),"GMT");
	    newMap.put(timeZoneMap.get("BST"),"BST");
	    newMap.put(timeZoneMap.get("CST"),"CST");
	    newMap.put(timeZoneMap.get("AST"),"AST");
	    newMap.put(timeZoneMap.get("ZST"),"ZST");
	    
	    //print style three
	    System.out.println("Print Style 3");
	    
	    //print newMap 
	    System.out.println(timeZoneMap.get("GMT"));
	    System.out.println(timeZoneMap.get("BST"));
	    System.out.println(timeZoneMap.get("CST"));
	    System.out.println(timeZoneMap.get("AST"));
	    System.out.println(timeZoneMap.get("ZST"));
	    
	    //print style three
	    System.out.println("Print Style 5: Final sorted Array");
	    TreeMap<String,String> sortedNewMapDec = new TreeMap<String,String>(Collections.reverseOrder());
	    sortedNewMapDec.put(timeZoneMap.get("GMT"),"GMT");
	    sortedNewMapDec.put(timeZoneMap.get("BST"),"BST");
	    sortedNewMapDec.put(timeZoneMap.get("CST"),"CST");
	    sortedNewMapDec.put(timeZoneMap.get("AST"),"AST");
	    sortedNewMapDec.put(timeZoneMap.get("ZST"),"ZST");
	    
		Set set = sortedNewMapDec.entrySet();
	    Iterator it = set.iterator();
	    
	    while (it.hasNext()) 
	    { 
            Map.Entry me = (Map.Entry)it.next(); 
            System.out.println(me.getKey());
        }
	}
	    /*
	    //list setup
	    System.out.println("Print Style 4:");
        DateTimeFormatter arrayPattern = new DateTimeFormatterBuilder().parseCaseInsensitive().appendPattern("MM/dd/yyyy HH:mm").toFormatter(Locale.ENGLISH);
        ArrayList<LocalDateTime> dateArray = new ArrayList<LocalDateTime>();
        dateArray.add(LocalDateTime.parse(dateTimeMap.get("GMT"),arrayPattern));
        dateArray.add(LocalDateTime.parse(dateTimeMap.get("BST"),arrayPattern));
        dateArray.add(LocalDateTime.parse(dateTimeMap.get("CST"),arrayPattern));
        dateArray.add(LocalDateTime.parse(dateTimeMap.get("AST"),arrayPattern));
        dateArray.add(LocalDateTime.parse(dateTimeMap.get("ZST"),arrayPattern));
        for(int i = 0; i < dateArray.size(); i++)
        System.out.println(dateArray.get(i));
	  	}
		*/

	String getTimeOnServer()
	{
		SimpleDateFormat sdf2 = new SimpleDateFormat("HH:mm");
		timeOnServer = ("Time on Server: " + sdf2.format(now.getTime()));
		return timeOnServer;
	}
	
	@Override
	void dateTimeDifferentZone() 
	{
		date = now.getTime();

		GMT = Calendar.getInstance();
		GMT.setTime(date);
	    GMT.add(Calendar.HOUR_OF_DAY, 5);
	    //bst
	    BST = Calendar.getInstance();
	    BST.setTime(date);
	    BST.add(Calendar.HOUR_OF_DAY, 1);
	    //cst zone
	    CST = now;
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
	    String GMTDateTime = new String(sdf.format(GMT.getTime()));
	    String BSTDateTime = new String(sdf.format(BST.getTime()));
	    String CSTDateTime = new String(sdf.format(now.getTime()));

	    timeZoneMap.put("GMT", GMTDateTime);
	    timeZoneMap.put("BST", BSTDateTime);
	    timeZoneMap.put("CST", CSTDateTime);
	   
	    //get hashmap with three original keys
	    dateTimeMap = timeZoneMap;
	    //print three original keys
	    System.out.println("GMT: " + dateTimeMap.get("GMT"));
	    System.out.println("BST: " + dateTimeMap.get("BST"));
	    System.out.println("CST: " + dateTimeMap.get("CST"));
	}   
	
	HashMap<String,String> getDateTimeMap()
	{
		dateTimeDifferentZone();
		return dateTimeMap;
	}
	
	HashMap<String,String> getTimeZoneMap()
	{
		timeZoneHashMap();
		return timeZoneMap;
	}
	
	Date getDate()
	{
		return now.getTime();
	}


	public String getDateTimeNow() 
	{
		dateTimeNow();
		return dateTimeNow;
	}
	
}