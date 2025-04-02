package Practicas._03_CRUD_empleados.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnectionExample {
    private static final String URL = "jdbc:mysql://localhost:puerto/nombre_base_de_datos";
    private static final String USER = "usuario";
    private static final String PASSWORD = "contraseña";

    public static void main(String[] args) {
        Connection connection = null;
        try{
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Conxión establecida exitosamente");
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}