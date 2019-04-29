package Tools.AntonioAguirre.v0;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;

public class Equipment implements Comparable<Equipment> {


    String id;

    double precio;
    static ArrayList<Equipment> equipment = new ArrayList<>();

    public Equipment(String [] line) {
        this.id = line[3];
        this.precio = parseDouble(line[9]);
        equipment.add(this);


    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public static ArrayList<Equipment> getEsdeveniments() {
        return equipment;
    }

    public static void setEsdeveniments(ArrayList<Equipment> esdeveniments) {
        Equipment.equipment = esdeveniments;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Equipment equipment = (Equipment) o;
        return id == equipment.id &&
                Double.compare(equipment.precio, precio) == 0;
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, precio);
    }

    @Override
    public int compareTo(Equipment o) {
        if( o.id.compareTo(this.id)>0){
            return -1;
        }else if ( o.id.compareTo(this.id)== 0){
        return 0;
        }
        return 1;
    }


//    public Equipment(String[] linea) {
//        //Comprobamos que todos los datos que necesitamos esten llenos
//        if(linea[2].isEmpty()||linea[8].isEmpty()||linea[11].isEmpty()||linea[13].isEmpty()){
//            this.nombre = "Sin Nombre";
//
//            this.diaSem = "Sin dia";
//            this.hora = 0;
//            this.causa = "Sin causa";
//        }else {
//            this.nombre = linea[2];
//            this.diaSem = linea[8];
//            this.hora = parseInt(linea[11]);
//            this.causa = linea[13];
//
//        }
//        esdeveniments.add(this);
//    }

//    @Override
//    public int compareTo(Equipment o) {
//        if( o.nombre.compareTo(this.nombre)>0){
//            return -1;
//        }else if ( o.nombre.compareTo(this.nombre)== 0){
//        return 0;
//        }
//        return 1;
//    }
//    @Override
//    public int compareTo(AguirreAntonio.v4.Accidentes o) {
//        return nombre.compareTo(o.nombre);
//    }
}
