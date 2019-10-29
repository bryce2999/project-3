import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class MesoEquivalent 
{

	private static final int ID_LENGTH = 4;
	private ArrayList<MesoStation> stations = new ArrayList<MesoStation>();
	private ArrayList<Integer> stationAvg = new ArrayList<Integer>();
	private HashMap<String,Integer> stationMap = new HashMap<String,Integer>();
	private String thisId ;
	public MesoEquivalent(String stId) 
	{
		// TODO Auto-generated constructor stub
		thisId = stId;
	}

	public HashMap<String, Integer> calAsciiEqual() throws IOException 
	{
		MesoAsciiCal msc = new MesoAsciiCal(new MesoStation(thisId));
		Read("Mesonet.txt");
		for(int i = 0; i < stations.size(); i++)
		{
			//TODO Create a hashmap from values
			//System.out.println(stations.get(i).getStID() + " : " + stationAvg.get(i));
			if(stationAvg.get(i) == msc.calAverage())
			stationMap.put(stations.get(i).getStID(),stationAvg.get(i));
		}
		System.out.println(stationMap);
		return new HashMap<String,Integer>(stationMap);
	}
	

	 private void Read(String filename) throws IOException
	   {
		 	boolean start = false;
		 	String end = "YUKO";
		    String string = "";
		    String ID = ""; 
		    MesoStation station = null;
		    MesoAsciiCal cal;
	    	BufferedReader br = new BufferedReader(new FileReader(filename));
	    	for(int i = 0; i < 3; i++)
	 	    {
	 	    	br.readLine();
	 	    }
	    	
			while((string = br.readLine()) != null)
			{
				for(int i = 0; i < string.length(); i++)
				{
					if(!(Character.isWhitespace(string.charAt(i)) && !Character.isDigit(string.charAt(i))))
					{
						ID += string.charAt(i);
					}
					if(ID.equals("YUKO"))
					{
						break;
					}
				}
				ID = ID.substring(0,4);
				cal = new MesoAsciiCal(new MesoStation(ID));
				stationAvg.add(cal.calAverage());
				station = new MesoStation(ID);
			    stations.add(station);
			    ID = "";
			} 
			br.close();
	   }
}
