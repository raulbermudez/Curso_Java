package Practicas._01_Coche;

public class Main {
    public static void main(String[] args) throws IllegalArgumentException {
        Coche coche = new Coche("Audi", "A3-RED" , 1900, 0);
        System.out.println(coche.mostrarDetalles());
        coche.conducir(-10.00);
        System.out.println(coche.mostrarDetalles());
    }

}
