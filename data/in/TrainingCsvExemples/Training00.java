 

/*
 * Training00.java             
 *
 * Copyright 2010 Joaquim Laplana, Mònica Ramírez Arceda
 * This is free software, licensed under the GNU General Public License v3.
 * See http://www.gnu.org/licenses/gpl.html for more information.
 *
 */

import library.textfiles.Reader;
import library.textfiles.Files;

/**
 * Modela mètodes per processar fitxers de text estructurats CSV
 * Taules de la base Training
 * 
 * @author Joaquim Laplana, Mònica Ramírez arceda
 * @version 06/03/2010
 */
public class Training00 {

    /**
     * Determina la mitjana aritmètica de les vendes.
     * 
     * @return La mitjana aritmètica de les vendes
     */
    public static double mitjanaVendes() {
        Reader r = new Reader("repventas.dat");
        int nRegistres = 0;
        double suma = 0;
        double mitjana = 0;
        String registreLlegit = r.readLine(); // Per saltar els títols del camps
        registreLlegit = r.readLine();
        while (registreLlegit != null) {
            String[] camps = registreLlegit.split("\\s+");
            double vendes = Double.parseDouble(camps[9]);
            nRegistres++;
            suma += vendes;
            registreLlegit = r.readLine();
        }
        mitjana = suma / nRegistres;
        r.close();
        return mitjana;
    }

    /**
     * Compta els representants tals que les seves vendes superen la mitjana
     * aritmètica de les vendes.
     * 
     * @return El nombre de representants tals que les seves vendes superen la
     *         mitjana aritmètica de les vendes
     */
    public static int comptaRepSuperenMitjanaVendes() {
        Reader r = new Reader("repventas.dat");
        int nRegistres = 0;
        double mitjanaVendes = mitjanaVendes();
        String registreLlegit = r.readLine(); // Per saltar els títols del camps
        registreLlegit = r.readLine();
        while (registreLlegit != null) {
            String[] camps = registreLlegit.split("\\s+");
            double vendes = Double.parseDouble(camps[9]);
            if (mitjanaVendes < vendes) {
                nRegistres++;
            }
            registreLlegit = r.readLine();
        }
        r.close();
        return nRegistres;
    }

    /**
     * Compta les oficines que han superat els seus objectius de vendes.
     * 
     * @return El nombre d'oficines han superat els seus objectius de vendes
     */
    public static int comptaVendesSuperenObjectius() {
        Reader r = new Reader("oficinas.dat");
        int nRegistres = 0;
        String registreLlegit = r.readLine(); // Per saltar els títols del camps
        registreLlegit = r.readLine();
        while (registreLlegit != null) {
            String[] camps = registreLlegit.split("\\s+");
            double objectius = Double.parseDouble(camps[4]);
            double vendes = Double.parseDouble(camps[5]);
            if (objectius < vendes) {
                nRegistres++;
            }
            registreLlegit = r.readLine();
        }
        r.close();
        return nRegistres;
    }

    /**
     * Determina el valor de l'stock dels productes d'un determinat fabricant
     * identificat per IDFABRICANT.
     * 
     * @param idFabricant L'ID del fabricant
     * @return El valor de l'stock dels productes del fabricant
     */
    public static double calculaValorStock(String idFabricant) {
        Reader r = new Reader("productos.dat");
        double valorStock = 0;
        String registreLlegit = r.readLine(); // Per saltar els títols del camps
        registreLlegit = r.readLine();
        while (registreLlegit != null) {
            String[] camps = registreLlegit.split("\\s+");
            if (camps[0].equals(idFabricant)) {
                valorStock += Double.parseDouble(camps[3])
                        * Double.parseDouble(camps[4]);
            }
            registreLlegit = r.readLine();
        }
        r.close();
        return valorStock;
    }

    /**
     * Determina el nom del client que ha fet la comanda de més valor.
     * 
     * @return El nom del client que ha fet la comanda de més valor
     */
    public static String nomClientMaximaComanda() {
        Reader r = new Reader("pedidos.dat");
        double valorComandaMax = 0; // Valor de la comanda mes alta
        String idClientComandaMax = ""; // Identificador del client que ha fet
                                        // la comanda de més valor
        String nomClientComandaMax = ""; // Nom client que ha fet la comanda
                                         // demés valor
        String registreLlegit = r.readLine(); // Per saltar els títols del camps
        registreLlegit = r.readLine();
        while (registreLlegit != null) {
            String[] camps = registreLlegit.split("\\s+");
            if (valorComandaMax < Double.parseDouble(camps[7])) {
                valorComandaMax = Double.parseDouble(camps[7]);
                idClientComandaMax = camps[2];
            }
            registreLlegit = r.readLine();
        }
        r.close();

        // Per cercar el client que ha fet la comanda més alta
        r = new Reader("clientes.dat");
        registreLlegit = r.readLine(); // Per saltar el títols dels camps
        registreLlegit = r.readLine();
        while (registreLlegit != null) {
            String[] camps = registreLlegit.split("\\s+");
            if (camps[0].equals(idClientComandaMax)) {
                nomClientComandaMax = camps[1];
                break;
            }
            registreLlegit = r.readLine();
        }
        r.close();
        return nomClientComandaMax;
    }

    /**
     * Genera el fitxer repventas2.dat amb els registes del fitxer repventes.dat
     * ordenat per l'edat dels representants de vendes.
     */
    public static void ordenarRepVentesPerEdad() {
        Files.createOrderedCsvFile("repventas.dat", "repventas2.dat", 3, 1,
                "\\s+");
    }

    /**
     * Genera el fitxer repventas3.dat amb els registes del fitxer repventes.dat
     * ordenat per la data d'ingrés a l'empresa.
     */
    public static void ordenarRepVentesPerDataIngres() {
        Files.createOrderedCsvFile("repventas.dat", "repventas3.dat", 6, 3,
                "\\s+");
    }
}
