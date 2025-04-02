package Practicas._02_Biblioteca;
/*
* Clase Biblioteca:

Atributos privados: nombre (String), libros (ArrayList), usuarios (ArrayList).
Constructor que inicialice nombre, libros y usuarios como listas vacías.
Métodos para añadir y eliminar libros y usuarios.
Method buscarLibroPorTitulo: Recibe un titulo y devuelve el libro correspondiente si existe.
Method buscarUsuarioPorId: Recibe un id y devuelve el usuario correspondiente si existe.
Method mostrarLibrosDisponibles: Imprime los detalles de todos los libros disponibles en la biblioteca.
*/

import java.util.ArrayList;

public class Biblioteca {
    private String nombre;
    private ArrayList<Libro> libros;
    private ArrayList<Usuario> usuarios;

    public Biblioteca(String nombre) {
        this.setNombre(nombre);
        this.libros = new ArrayList<>();
        this.usuarios = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre.length() >= 2){
            this.nombre = nombre;
        } else{
            throw new IllegalArgumentException("El nombre de la libreria tiene que tener al menos 2 caracteres");
        }
    }

    public void annadirLibro(Libro libro){
        this.libros.add(libro);
    }

    public void eliminarLibro(Libro libro){
        this.libros.remove(libro);
    }

    public void annadirUsuario(Usuario usuario){
        this.usuarios.add(usuario);
    }

    public void eliminarUsuario(Usuario usuario){
        this.usuarios.remove(usuario);
    }

    public Libro buscarLibroporTitulo(String nombre_libro){
        for (int i = 0; i < this.libros.size(); i++) {
            if (this.libros.get(i).getTitulo().equals(nombre_libro)){
                System.out.println(this.libros.get(i).mostrarDetalles());
                return this.libros.get(i);
            }
        }
        System.out.println("No se encontró ningun libro con ese titulo");
        Libro nadaLibro = new Libro();
        return nadaLibro;
    }

    public void buscarUsuarioPorId(String id){
        for (int i = 0; i < this.usuarios.size(); i++) {
            if (this.usuarios.get(i).getId().equals(id)){
                System.out.println(this.usuarios.get(i).mostrarUsuario());
                return;
            }
        }
        System.out.println("No se encontró ningun usuario con ese id");
    }

    public void mostrarLibrosDisponibles(){
        int contador = 1;
        for (Libro libro : this.libros) {
            if (libro.isDisponible()) {
                System.out.println(contador + ".- " + libro.mostrarDetalles());
            }
            contador++;
        }
    }
}
