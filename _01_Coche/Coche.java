package Practicas._01_Coche;

/*
* Crea una clase llamada Coche que represente un coche. La clase debe tener los siguientes atributos privados:

marca (String)
modelo (String)
año (int)
kilometraje (double)
Además, la clase debe incluir los siguientes métodos públicos:

Constructor: Un constructor que inicialice todos los atributos.
Getters y Setters: Métodos para obtener y establecer los valores de los atributos.
Méthod mostrarDetalles: Un méthod que imprima en consola los detalles del coche.
Méthod conducir: Un méthod que reciba un parámetro kilometros (double) y aumente el kilometraje del coche en esa cantidad.*/
public class Coche {
    private String marca;
    private String modelo;
    private int anno;
    private double kilometraje;

    public Coche(String marca, String modelo, int anno, double kilometraje) throws IllegalArgumentException {
        this.setMarca(marca);
        this.setModelo(modelo);
        this.setAnno(anno);
        this.setKilometraje(kilometraje);
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public int getAnno() {
        return anno;
    }

    public double getKilometraje() {
        return kilometraje;
    }

    public void setModelo(String modelo) throws IllegalArgumentException {
        if (modelo.length() >= 5){
            this.modelo = modelo;
        } else{
            throw new IllegalArgumentException("El cohe no se instancio debido a que la longitud del modelo tiene que ser minimo de 5 caracteres");
        }

    }

    public void setAnno(int anno) throws IllegalArgumentException {
        if (anno >= 1886){
            this.anno = anno;
        } else{
            throw new IllegalArgumentException("No se pudo instanciar el coche, debido a que en el año proporcionado no existian los coches");
        }
    }

    public void setKilometraje(double kilometraje) throws IllegalArgumentException {
        if (kilometraje >= 0){
            this.kilometraje = kilometraje;
        } else{
            throw new IllegalArgumentException("El coche no se instancio debido a que se introdujo un kilometraje negativo");
        }
    }

    public void setMarca(String marca) throws IllegalArgumentException {
        if (marca.length() >= 3){
            this.marca = marca;
        } else{
            throw new IllegalArgumentException("No se instancio el coche debido a que la longitud de la marca es menor de 3 caracteres");
        }
    }

    public String mostrarDetalles(){
        return "El cohe de: " + this.getMarca() + ", modelo: " + this.getModelo() + ".Del año: " + this.getAnno() +
                " tiene " + this.getKilometraje() + " kilometros";
    }

    public void conducir(double kilometros) throws IllegalArgumentException {
        if (kilometros > 0){
            this.kilometraje += kilometros;
        } else{
            throw new IllegalArgumentException("No puedes conducir kilometros negativos");
        }
    }
}
