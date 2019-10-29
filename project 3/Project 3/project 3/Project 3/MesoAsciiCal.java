
public class MesoAsciiCal extends MesoAsciiAbstract 
{
	private MesoStation station;
	private String stID;
	public MesoAsciiCal(MesoStation mesoStation) 
	{
		station = mesoStation;
		stID = mesoStation.getStID();
	}

	@Override
	public int calAverage() 
	{
		int sum = 0;
		double avg = 0;
		int average = 0;
		final int ID_LENGTH = 4;
		char[] stationChars = new char[ID_LENGTH];
		for(int i = 0; i < ID_LENGTH; i++)
		{
			stationChars[i] = station.getStID().charAt(i);
			sum += stationChars[i];
		}
		avg = sum / 4.0;
		int floor = (int) Math.floor(avg);
		int ceil = (int) Math.ceil(avg);
		
		if((avg - floor) > 0)
		{
			average = ceil;
		}
		else
		{
			average = floor;
		}
		return average;
	}

   
}