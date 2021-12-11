/**
 * Object management class Values
 * @author Tom Durand
 * @version 0.2.1
 */
public class Values extends Sensors{
	private int day;
	private int month;
	private int year;
	private int data;

	
	/*
	 * Builds the Values object 
	 */
	public Values(String code, String cityLocation, String streetLocation, String type, int day, int month, int year, int data){
		super(code, cityLocation, streetLocation, type);
		this.day=day;
		this.month=month;
		this.year=year;
		this.data=data;
	}

	/*
	 * Returns the day of the sensor analysis
	 * @return code
	 */
	public int getDay(){
		return day;
	}

	/*
	 * Returns the month of the sensor analysis
	 * @return code
	 */
	public int getMonth(){
		return month;
	}

	/*
	 * Returns the year of the sensor analysis
	 * @return code
	 */
	public int getYear(){
		return year;
	}

	/*
	 * Returns the amount of particle collected by the sensor
	 * @return code
	 */
	public int getData(){
		return data;
	}

	/*
	 * Display all the information about a value
	 * @param index
	 * @return code
	 */
	public void display(int index){
		System.out.println("Valeur n°" + index + " : " + day + "/" + month + "/" + year + "  -  Data : " + data);
	}

}