import java.util.*;

public class Values{
	private int day;
	private int month;
	private int year;
	private int data;

	public Values(int day, int month, int year, int data){
		this.day=day;
		this.month=month;
		this.year=year;
		this.data=data;
	}

	public int getDay(){
		return day;
	}

	public int getMonth(){
		return month;
	}

	public int getYear(){
		return year;
	}

	public int getData(){
		return data;
	}

	public void display(int index){
		System.out.println("Valeur n°" + index + " : " + day + "/" + month + "/" + year + "  -  Data : " + data);
	}

}