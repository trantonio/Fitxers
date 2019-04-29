package AntonioAguirre;

import Tools.AntonioAguirre.AguirreAntonio.v7.Accidentes;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Lectura implements Comparable<Lectura>{

    File file1 = new File ("data/in/Plan_Actuaciones.csv");
    String splitBy= ";";
    String line ="";
    int numColum;

    boolean oneLine= false;

    public Lectura() {

        try(BufferedReader br= new BufferedReader(new FileReader(file1))){

            while((line = br.readLine())!=null){
                int i =0;
                if(oneLine) {
                    if (!line.isEmpty()) {
                        String[] lineArray = line.split(splitBy);
                        if(lineArray.length==numColum){
                            new Accidentes(lineArray);
                        }else{
                            System.err.println("Le Falta el ultimo argumento");
                        }
                    }
                }else {
                    i++;
                    if(i>=4) {
                        String[] la = line.split(splitBy);
                        numColum = la.length;
                        oneLine = true;
                    }
                }
                System.out.println(line);
            }

        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public int compareTo(Lectura o) {
        return 0;
    }
}



