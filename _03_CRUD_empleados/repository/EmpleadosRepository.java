package Practicas._03_CRUD_empleados.repository;

import Practicas._03_CRUD_empleados.model.Empleados;
import Practicas._03_CRUD_empleados.util.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmpleadosRepository {
    private Connection obtenerConexion(){
        return DatabaseConnection.getConexion();
    }

    // Obtener todos los empleados de la base de datos
    public List<Empleados> getAll() throws SQLException {
        List<Empleados> empleados = new ArrayList<Empleados>();
        try(Connection myConn = obtenerConexion();
            Statement myStamt = myConn.createStatement();
            ResultSet myRes = myStamt.executeQuery("SELECT * FROM empleados")) {
            while (myRes.next()){
                Empleados e = crearEmpleado(myRes);
                empleados.add(e);
            }
        }
        return empleados;
    }

    //Obtener un empleado por su id
    public Empleados getEmpleadoById(Integer id) throws SQLException {
        Empleados empleado = null;
        try(Connection myConn = obtenerConexion();
            PreparedStatement myStamt = myConn.prepareStatement("SELECT * FROM empleados WHERE id=?")){
            myStamt.setInt(1, id);
            try(ResultSet myRes = myStamt.executeQuery()){
                if (myRes.next()){
                    empleado = crearEmpleado(myRes);
                }
            }
        }
        return empleado;
    }

    // Almacenar un empleado en la base de datos
    public void addEmpleado(String nombre, String apellido, String email, double salario) throws SQLException {
        try(Connection myConn = obtenerConexion();
        PreparedStatement myStamt = myConn.prepareStatement("INSERT INTO empleados(nombre, apellido, email, salario)" +
                " VALUES(?,?,?,?)")){
            myStamt.setString(1, nombre);
            myStamt.setString(2, apellido);
            myStamt.setString(3, email);
            myStamt.setDouble(4, salario);
            myStamt.executeUpdate();
        }
    }

    public void editEmpleado(Integer id, String nombre, String apellido, String email, double salario) throws SQLException{
        try(Connection myConn = obtenerConexion();
            PreparedStatement myStamt = myConn.prepareStatement("UPDATE empleados SET nombre=?, apellido=?, email=?, salario=? WHERE id=?")){
            myStamt.setString(1, nombre);
            myStamt.setString(2, apellido);
            myStamt.setString(3, email);
            myStamt.setDouble(4, salario);
            myStamt.setInt(5, id);
            myStamt.executeUpdate();
        }
    }

    public void deleteEmpleado(Integer id) throws SQLException {
        try(Connection myConn = obtenerConexion();
            PreparedStatement myStamt = myConn.prepareStatement("DELETE FROM empleados WHERE id=?")){
            myStamt.setInt(1, id);
            myStamt.executeUpdate();
        }
    }

    // Crear una instancia de empleados
    private Empleados crearEmpleado(ResultSet myRes) throws SQLException {
        Empleados e = new Empleados();
        e.setNombre(myRes.getString("nombre"));
        e.setApellido(myRes.getString("apellido"));
        e.setEmail(myRes.getString("email"));
        e.setSalario(myRes.getFloat("salario"));

        return e;
    }
}
