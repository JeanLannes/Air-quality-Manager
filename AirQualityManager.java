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

	public class exportData{

		
	}

	public static void main(String[] args) throws IOException {

		int choice, cond=0;
		Scanner readKeyboard = new Scanner(System.in);	
		ArrayList<String> listOfSensors = new ArrayList<String>();
		listOfSensors = importSensors();
		ArrayList<String> listOfValues = new ArrayList<String>();
		listOfValues = importValues();


		do{
			System.out.println("******** MENU ********\n  1- \n  2-  \n  3- \n  4- \n  5- \n  6- \n  10- Quitter\n**********************");
			choice=readKeyboard.nextInt();	
			switch(choice){
				case 1: System.out.println(listOfSensors.get(1));
						System.out.println(listOfSensors.get(2));
						System.out.println(listOfValues.get(1));
						System.out.println(listOfValues.get(2));
						break;
				case 2:
						break;
				case 10:System.out.println("\n * AU REVOIR *\n");
						cond++;
						break;
				default:System.out.println("\n * VALEUR INCORRECTE *\n");
			}
		} while(cond==0);

	}
}
