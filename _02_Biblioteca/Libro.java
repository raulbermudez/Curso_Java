package Practicas._02_Biblioteca;
/*Clase Libro:

Atributos privados: titulo (String), autor (String), isbn (String), disponible (boolean).
Constructor que inicialice todos los atributos.
Getters y setters para todos los atributos.
Method prestar: Cambia el estado de disponible a false.
Method devolver: Cambia el estado de disponible a true.
Method mostrarDetalles: Imprime los detalles del libro.
*/

public class Libro {
    private String titulo;
    private String autor;
    private String isbn;
    private boolean disponible;

    public Libro() {
    }

    public Libro(String titulo, String autor, String isbn, boolean disponible) {
        this.setTitulo(titulo);
        this.setAutor(autor);
        this.setIsbn(isbn);
        this.setDisponible(disponible);
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        if (titulo.length() >= 3){
            this.titulo = titulo;
        } else{
            throw new IllegalArgumentException("La instancia de libro no se pudo crear debido a que la longitud del titulo tiene que ser minimo de 3 caracteres");
        }
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        if (autor.length() >= 2){
            this.autor = autor;
        } else{
            throw new IllegalArgumentException("La instancia de libro no se pudo crear, la longitud del nombre del autor tiene que ser minimo de 2 caracteres");
        }
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        if (isbn.length() != 13) {
            this.isbn = isbn;
        } else {
            throw new IllegalArgumentException("La instancia del libro no se pudo crear, la longitud del isbn tiene que ser de 13 caracteres");
        }
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public void prestar(){
        this.disponible = false;
    }

    public void devolver(){
        this.disponible = true;
    }

    public String mostrarDetalles(){
        return "El titulo del libro es: " + this.getTitulo() + ", su autor es: " + this.autor + ", el isbn es: " +
                this.isbn + " y su disponibilidad es: " + this.disponible;
    }
}
