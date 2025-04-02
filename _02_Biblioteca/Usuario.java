package Practicas._02_Biblioteca;
/*
* Clase Usuario:

Atributos privados: nombre (String), id (String), librosPrestados (ArrayList).
Constructor que inicialice nombre e id, y que inicialice librosPrestados como una lista vacía.
Getters y setters para nombre e id.
Method prestarLibro: Recibe un objeto Libro y lo añade a librosPrestados si está disponible, y llama al method prestar del libro.
Method devolverLibro: Recibe un objeto Libro, lo elimina de librosPrestados y llama al method devolver del libro.
Method mostrarLibrosPrestados: Imprime los detalles de todos los libros prestados por el usuario.
*/

import java.util.ArrayList;

public class Usuario {
    private String nombre;
    private String id;
    private ArrayList<Libro> librosPrestados;
    public Usuario(){
        this.librosPrestados = new ArrayList<>();
    }
    public Usuario(String nombre, String id) {
        this.setNombre(nombre);
        this.setId(id);
        this.librosPrestados = new ArrayList<>(); // Creamos una lista vacia
        System.out.println("\nUsuario creado con exito");
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        if (nombre.length() >= 2){
            this.nombre = nombre;

        } else{
            throw new IllegalArgumentException("No se pudo crear la instancia de usuario, debido a que el nombre tiene que tener 2 caracteres minimo");
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        if (!id.isEmpty()){
            this.id = id;
        } else{
            throw new IllegalArgumentException("No se pudo crear la instancia de usuario debido a que el id esta vacio");
        }
    }

    public void prestarLibro(Libro libro){
        if (libro.isDisponible()){
            this.librosPrestados.add(libro);
            libro.prestar();
        }
    }

    public void devolverLibro(Libro libro){
        if (this.librosPrestados.contains(libro)){
            this.librosPrestados.remove(libro);
            libro.devolver();
        } else{
            System.out.println("Lo siento: " + libro.mostrarDetalles() + " no lo tienes prestado");
        }
    }

    public String mostrarLibrosPrestados(){
        String lPrestados = "";
        for (int i = 0; i < this.librosPrestados.size(); i++) {
            lPrestados += this.librosPrestados.get(i).mostrarDetalles() + "\n";
        }
        return lPrestados;
    }

    public String mostrarUsuario(){
        String libros = this.mostrarLibrosPrestados();
       return "El usuario: " + this.nombre + " con id: " + this.id + " tiene los siguientes libros prestados: " + libros;
    }
}
