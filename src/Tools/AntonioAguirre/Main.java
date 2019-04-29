package Tools.AntonioAguirre;

import Tools.AntonioAguirre.v0.Estadistica;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        Estadistica.csvFile(
                "Data/in/Plan_Actuaciones.csv",
                "data/out",
                ';',
                '"');

    }
}
