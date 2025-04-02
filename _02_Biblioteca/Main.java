package Practicas._02_Biblioteca;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {
    static Usuario usuario = new Usuario();


    public static void main(String[] args) {
        Biblioteca biblioteca = crearBiblioteca("Biblioteca de la Inspiración");
        System.out.println("Bienvenido a " + biblioteca.getNombre());

        nuevoLibro(biblioteca,"El Quijote", "Miguel de Cervantes",  "123456789112",  true);
        nuevoLibro(biblioteca,"Cien Años de Soledad", "Gabriel García Márquez",  "98765432112",  true);
        nuevoLibro(biblioteca,"1984", "George Orwell",  "112233445566",  true);
        nuevoLibro(biblioteca,"Orgullo y Prejuicio", "Jane Austen",  "223344556677",  true);
        nuevoLibro(biblioteca,"Matar a un Ruiseñor", "Harper Lee",  "334455667788",  true);

        int opcion = 0;
        do{
            Scanner sc = new Scanner(System.in);
            mostrarMenu();
            opcion = sc.nextInt();

            switch (opcion){
                case 1:
                    biblioteca.mostrarLibrosDisponibles();
                    break;
                case 2:
                    pedirUsuario(getUsuario());
                    break;
                case 3:
                    reservarLibro(biblioteca);
                    break;
                case 4:
                    devolverLibro(biblioteca);
                    break;
                default:
                    break;
            }
        } while (opcion != 5);

        System.out.println("Gracias por pasarte por la libreria. Nos vemos pronto :)");
    }

    public static void pedirUsuario(Usuario usuario){
        Usuario user = getUsuario();
        Scanner scU = new Scanner(System.in);
        System.out.println("Dime tu nombre de usuario: ");
        String nombre = scU.nextLine();
        System.out.println("Dime un id para asignartelo: ");
        String id = scU.nextLine();
        user.setNombre(nombre);
        user.setId(id);
    }

    public static void reservarLibro(Biblioteca biblioteca){
        if (usuario.getNombre() == null){
            System.out.println("Lo siento tienes que crear un usuario antes de reservar un libro");
        } else{
            biblioteca.mostrarLibrosDisponibles();
            System.out.println("Dime el nombre del libro que quieres añadir");
            Scanner scL = new Scanner(System.in);
            String nombreLibro = scL.nextLine();
            usuario.prestarLibro(biblioteca.buscarLibroporTitulo(nombreLibro));
        }
    }

    public static void devolverLibro(Biblioteca biblioteca){
        if (usuario.getNombre() == null){
            System.out.println("Lo siento tienes que tener un usuario antes de devolver un libro");
        } else{
            System.out.println(usuario.mostrarLibrosPrestados());
            System.out.println("Dime el nombre del libro que quieres devolver");
            Scanner scL = new Scanner(System.in);
            String nombreLibro = scL.nextLine();
            usuario.devolverLibro(biblioteca.buscarLibroporTitulo(nombreLibro));
        }
    }

    public static void mostrarMenu(){
        System.out.println("\n¿Qué quieres hacer?");
        System.out.println("1. Ver todos los libros disponibles");
        System.out.println("2. Crear un usuario");
        System.out.println("3. Reservar un libro");
        System.out.println("4. Devolver un libro");
        System.out.println("5. Salir\n");
    }

    public static Biblioteca crearBiblioteca(String nombre){
        Biblioteca biblioteca = new Biblioteca(nombre);
        return biblioteca;
    }

    public static void nuevoLibro(Biblioteca biblioteca, String titulo, String autor, String isbn, boolean disponible){
        Libro libro1 = new Libro(titulo, autor, isbn, disponible);
        biblioteca.annadirLibro(libro1);
    }

    public static Usuario getUsuario() {
        return usuario;
    }

}
