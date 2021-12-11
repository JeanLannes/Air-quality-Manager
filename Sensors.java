import java.util.*;

/**
 * Object management class Sensors
 * @author Tom Durand
 * @version 0.2.1
 */
public class Sensors{
	private String code;
	private String cityLocation;
	private String streetLocation;
	private String type;
	private static String[] valuesToReturn;
	static ArrayList<Values> listOfValuesObjects = new ArrayList<Values>();

	/*
	 * Builds the Sensor object 
	 * @param code
	 * @param cityLocation
	 * @param streetLocation
	 * @param type
	 */
	public Sensors(String code, String cityLocation, String streetLocation, String type){
		this.code=code;
		this.cityLocation=cityLocation;
		this.streetLocation=streetLocation;
		this.type=type;
	}

	/*
	 * Returns the code identifying the sensor
	 * @return code
	 */
	public String getCode(){
		return code;
	}

	/*
	 * Returns the city name of the sensor
	 * @return cityLocation
	 */
	public String getCityLocation(){
		return cityLocation;
	}

	/*
	 * Returns the street name of the sensor 
	 * @return streetLocation
	 */
	public String getStreetLocation(){
		return streetLocation;
	}

	/*
	 * Returns the particle type of the sensor 
	 * @return type
	 */
	public String getType(){
		return type;
	}

	/*
	 * Adds Values objects to the listOfValuesObjects
	 * @param day
	 * @param month
	 * @param year
	 * @param data
	 */
	public void addValues(String day, String month, String year, String data){
		int intDay=Integer.parseInt(day);
		int intMonth=Integer.parseInt(month);
		int intYear=Integer.parseInt(year);
		int intData=Integer.parseInt(data);
		listOfValuesObjects.add(new Values(code, cityLocation, streetLocation, type, intDay, intMonth, intYear, intData));
	}

	public void check()
	{
		for (int i=0; i<listOfValuesObjects.size(); i++) {
			listOfValuesObjects.get(i).display(i+1);
		}
	}

	/*
	 * Sorts the objects Values whose particle concentration is higher than the one indicated by the user
	 * After sorting, the method returns a tab with the following information:
	 * "code;day;month;year;data"
	 * @param maxUser
	 * @return valuesToReturns
	 */
	public static String[] ValueSortMax(int maxUser){
		int j=1;
		for (int i=0; i<listOfValuesObjects.size();i++) {
			if( listOfValuesObjects.get(i).getData()>=maxUser){
				listOfValuesObjects.get(i).display(j);
				j++;
			}
			valuesToReturn = new String[j];
			for (int k=0; k<j;k++) {
				valuesToReturn[k]= listOfValuesObjects.get(k).getDay() + ";" + listOfValuesObjects.get(k).getMonth() + ";" + listOfValuesObjects.get(k).getYear() + ";" + listOfValuesObjects.get(k).getData();
			}
		}
		return valuesToReturn;
	}
}


