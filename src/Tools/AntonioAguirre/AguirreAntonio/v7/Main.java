package Tools.AntonioAguirre.AguirreAntonio.v7;



import java.io.File;

public class Main {

	static File a = new File("data/out/.");
	static String [] archivos = a.list();

	public static void main(String[] args) {

		for(String s : archivos){
			File aActual = new File (a.getPath(),s);
			aActual.delete();
		}

		CausesAccidentsTransit.csvFile(
				"data/in/clients.csv",
				"data/out",
				"No hi ha causa mediata",
				';',
				'"');

		
	}

}
