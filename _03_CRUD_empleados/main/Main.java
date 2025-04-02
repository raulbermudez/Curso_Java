package Practicas._03_CRUD_empleados.main;

import Practicas._03_CRUD_empleados.model.Empleados;
import Practicas._03_CRUD_empleados.repository.EmpleadosRepository;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        EmpleadosRepository repository = new EmpleadosRepository();
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("Menú de opciones:");
            System.out.println("1. Ver todos los empleados");
            System.out.println("2. Ver empleado por ID");
            System.out.println("3. Añadir empleado");
            System.out.println("4. Editar empleado");
            System.out.println("5. Eliminar empleado");
            System.out.println("6. Salir");
            System.out.print("Elige una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    verTodosLosEmpleados(repository);
                    break;
                case 2:
                    verEmpleadoPorId(repository, scanner);
                    break;
                case 3:
                    añadirEmpleado(repository, scanner);
                    break;
                case 4:
                    editarEmpleado(repository, scanner);
                    break;
                case 5:
                    eliminarEmpleado(repository, scanner);
                    break;
                case 6:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Inténtalo de nuevo.");
            }
        } while (opcion != 6);
    }

    private static void verTodosLosEmpleados(EmpleadosRepository repository) {
        try {
            List<Empleados> empleados = repository.getAll();
            for (Empleados empleado : empleados) {
                System.out.println(empleado);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void verEmpleadoPorId(EmpleadosRepository repository, Scanner scanner) {
        System.out.print("Introduce el ID del empleado: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        try {
            Empleados empleado = repository.getEmpleadoById(id);
            if (empleado != null) {
                System.out.println(empleado);
            } else {
                System.out.println("Empleado no encontrado.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void añadirEmpleado(EmpleadosRepository repository, Scanner scanner) {
        System.out.print("Introduce el nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Introduce el apellido: ");
        String apellido = scanner.nextLine();
        System.out.print("Introduce el email: ");
        String email = scanner.nextLine();
        System.out.print("Introduce el salario: ");
        double salario = scanner.nextDouble();
        scanner.nextLine();

        try {
            repository.addEmpleado(nombre, apellido, email, salario);
            System.out.println("Empleado añadido exitosamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void editarEmpleado(EmpleadosRepository repository, Scanner scanner) {
        System.out.print("Introduce el ID del empleado a editar: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Introduce el nuevo nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Introduce el nuevo apellido: ");
        String apellido = scanner.nextLine();
        System.out.print("Introduce el nuevo email: ");
        String email = scanner.nextLine();
        System.out.print("Introduce el nuevo salario: ");
        double salario = scanner.nextDouble();
        scanner.nextLine();

        try {
            repository.editEmpleado(id, nombre, apellido, email, salario);
            System.out.println("Empleado editado exitosamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void eliminarEmpleado(EmpleadosRepository repository, Scanner scanner) {
        System.out.print("Introduce el ID del empleado a eliminar: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        try {
            repository.deleteEmpleado(id);
            System.out.println("Empleado eliminado exitosamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
