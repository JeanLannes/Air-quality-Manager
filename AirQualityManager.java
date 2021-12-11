import java.io.*;
import java.util.*;

public class AirQualityManager{

	public static ArrayList<String> importSensors() throws IOException
	{
		String line;
		ArrayList<String> capteursData = new ArrayList<String>();
		try {
			FileReader capteursReader = new FileReader("capteurs.csv");
			BufferedReader capteurs = new BufferedReader(capteursReader);
			while((line=capteurs.readLine()) != null) {
				capteursData.add(line);
			}
			capteursReader = new FileReader("capteurs.csv");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}		
		return capteursData;
	}

	public static ArrayList<String> importValues() throws IOException
	{
		String line;
		ArrayList<String> valeursData = new ArrayList<String>();
		try {
			FileReader valeursReader = new FileReader("valeurs.csv");
			BufferedReader valeurs = new BufferedReader(valeursReader);
			while((line=valeurs.readLine()) != null) {
				valeursData.add(line);
			}
			valeursReader = new FileReader("valeurs.csv");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}		
		return valeursData;
	}

	public static void main(String[] args) throws IOException {

		int choice, cond=0;
		int sensorCriticalRate;
		Scanner readKeyboard = new Scanner(System.in);
		
		ArrayList<String> listOfSensorsData = new ArrayList<String>();
		listOfSensorsData = importSensors();
		ArrayList<String> listOfValuesData = new ArrayList<String>();
		listOfValuesData = importValues();

		ArrayList<Sensors> listOfSensorsObjects = new ArrayList<Sensors>();

		for (int i=0;i<listOfSensorsData.size();i++) {
			String[] tempTab = listOfSensorsData.get(i).split(";");
			listOfSensorsObjects.add(new Sensors(tempTab[0], tempTab[1], tempTab[2], tempTab[3]));
		}

		for (int i=0;i<listOfValuesData.size();i++) {
			String[] tempTab = listOfValuesData.get(i).split(";");
			for (int j=0;j<listOfSensorsObjects.size();j++) {
				
					listOfSensorsObjects.get(j).addValues(tempTab[1], tempTab[2], tempTab[3], tempTab[5]);
			}
		}


		do{

			System.out.println("******** Which sensor do you want to access? ********\n  1- " + listOfSensorsObjects.get(0).getCode() + "\n  2- " + listOfSensorsObjects.get(1).getCode() + "\n  3- " + listOfSensorsObjects.get(2).getCode() + "\n  4- " + listOfSensorsObjects.get(3).getCode() + "\n  5- " + listOfSensorsObjects.get(4).getCode() + "\n*****************************************************");
			choice=readKeyboard.nextInt();	
			if (choice>=1 && choice<=5) {
				cond++;
				choice--;

				System.out.println("Please enter the critical level.\n");
				sensorCriticalRate = readKeyboard.nextInt();
				System.out.println("Critical level : " + sensorCriticalRate);
				String[] tab = Sensors.ValueSortMax(sensorCriticalRate);

				 try {
				      FileWriter fw = new FileWriter("CriticalData.txt");
				      for (int i=0;i<tab.length;i++) {
				      		fw.write(tab[i]);
				      }
				      fw.close();
				      System.out.println("Success.");
				} catch (IOException e) {
				      e.printStackTrace();
				}
			}

		} while(cond==0);
	}
}

