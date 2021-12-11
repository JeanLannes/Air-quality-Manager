import java.util.*;

public class Sensors{
	private String code;
	private String cityLocation;
	private String streetLocation;
	private String type;
	private String[] valuesToReturn;
	ArrayList<Values> listOfValuesObjects = new ArrayList<Values>();

	public Sensors(String code, String cityLocation, String streetLocation, String type){
		this.code=code;
		this.cityLocation=cityLocation;
		this.streetLocation=streetLocation;
		this.type=type;
	}

	public String getCode(){
		return code;
	}

	public String getCityLocation(){
		return cityLocation;
	}

	public String getStreetLocation(){
		return streetLocation;
	}

	public String getType(){
		return type;
	}

	public void addValues(String day, String month, String year, String data){
		int intDay=Integer.parseInt(day);
		int intMonth=Integer.parseInt(month);
		int intYear=Integer.parseInt(year);
		int intData=Integer.parseInt(data);
		listOfValuesObjects.add(new Values(intDay, intMonth, intYear, intData));
	}

	public String[] ValueSortMax(int max){
		int j=1;
		for (int i=0; i<listOfValuesObjects.size();i++) {
			if( listOfValuesObjects.get(i).getData()>=max){
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