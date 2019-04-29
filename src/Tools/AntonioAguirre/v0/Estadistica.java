package Tools.AntonioAguirre.v0;


import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class Estadistica {

	int [] a;
	static ArrayList<Equipment> accidentes= new ArrayList<>();


	public static String minMax (){
	    double oldPrice = 0;
	    double minPrice = 0;
	    double maxPrice = 0;
        for (int j = 0; j <Equipment.equipment.size() ; j++) {
            if(oldPrice<Equipment.equipment.get(j).getPrecio()){
                maxPrice = Equipment.equipment.get(j).getPrecio();
            }else if( oldPrice>Equipment.equipment.get(j).getPrecio()){
                minPrice = Equipment.equipment.get(j).getPrecio();
            }
        }

        return ""+minPrice +'\t' + maxPrice;
	}
	public static boolean csvFile(String inputFile, 
			String outputDirectory,
			char fieldSeparator, char charToSurroundField) throws IOException {
		String line;
		boolean oneLine = false;
		boolean oneTime = false;
		int numColum = 0;
		Equipment equipment;
		String oldId = "";
		int events = 1;


        File logFile = null;
		BufferedWriter writer = null;

		try (BufferedReader br = new BufferedReader(new FileReader(inputFile))) {
			int n = 0;
			while ((line = br.readLine()) != null) {
				if (oneLine) {
					if (!line.isEmpty()) {
						String [] lineArray;

						lineArray = line.split("" + fieldSeparator);
						if(lineArray.length==numColum){
							new Equipment(lineArray);
						}
					}
					//Nos aseguramos que empieze a leer en la cuarta linea
				} else {
						String[] la = line.split("" + fieldSeparator);
						numColum = la.length;
						oneLine = true;

				}
			}
            Collections.sort(Equipment.equipment);

            for(int i =0; i<Equipment.equipment.size();i++) {
                System.out.println("" + Equipment.equipment.get(i).getId());
            }
            System.out.println("------------------------");


            for(int i =0; i<Equipment.equipment.size();i++){
                if(!oldId.equals(Equipment.equipment.get(i).getId())){
                    System.out.print(""+ Equipment.equipment.get(i).getId() + '\t' + minMax() );
                    if(oneTime){


                    }else{
                        logFile = new File(outputDirectory + "/" + "Estadistica.txt");
                        writer = new BufferedWriter(new FileWriter(logFile));
                        writer.write('\n');
                        oneTime=true;
                    }
                    oldId=Equipment.equipment.get(i).getId();
                    System.out.println(+events);
                    events = 1;
                    //Muestra donde guarda los archivos
//					System.out.println(logFile.getCanonicalPath());
                }else{
                    ++events;
                    // Comprovar loq ue hacia la version 1
                    writer.write(""+ Equipment.equipment.get(i).getId() + '\t' +events);

//                    System.out.println(""+ Equipment.equipment.get(i).getId() + '\t' +events);
                }


            }
		} catch (IOException e) {
			e.printStackTrace();
		}





		return true;
	}

}
