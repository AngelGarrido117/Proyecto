/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author garri
 */
public class profesor {
private String nombre, genero, respuesta;
private int edad, opcion;   

    public String getNombre() {
        return nombre;
    }

    public String getGenero() {
        return genero;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public int getEdad() {
        return edad;
    }

    public int getOpcion() {
        return opcion;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setOpcion(int opcion) {
        this.opcion = opcion;
    }

 public void guardar(){
        try {
        Connection c = Conexion.conectar(); // usamos tu clase Conexion

        if (c != null) {
            // Verificar si el nombre ya existe (clave primaria)
            PreparedStatement check = c.prepareStatement("SELECT * FROM profesor WHERE nombre = ?");
            check.setString(1, getNombre());
            ResultSet rs = check.executeQuery();

            if (rs.next()) {
                respuesta = "El nombre '" + getNombre() + "' ya está registrado.";
            } else {
                // Insertar nueva persona
                PreparedStatement ps = c.prepareStatement("INSERT INTO profesor VALUES (?, ?, ?)");
                ps.setString(1, getNombre());
                ps.setInt(2, getEdad());
                ps.setString(3, getGenero());

                ps.executeUpdate();
                ps.close();

                respuesta = "Profesor agregado correctamente.<br><a href='index.html'>Regresar</a>";
            }

            rs.close();
            check.close();
            c.close();

        } else {
            respuesta = "No hay conexión a la base.";
        }

    } catch (Exception e) {
        respuesta = "Error de ejecución en alta(): " + e.getMessage();
    }   
        
    }
    
    public void eliminar(){
    try {
        Connection c = Conexion.conectar(); // usamos tu clase Conexion
        
        if (c != null) {
            PreparedStatement check = c.prepareStatement("SELECT * FROM profesor WHERE nombre = ?");
            check.setString(1, getNombre());
            ResultSet rs = check.executeQuery();
            
            if (rs.next()) {
                PreparedStatement ps = c.prepareStatement("DELETE FROM profesor WHERE nombre = ?");
                ps.setString(1, getNombre());
                ps.executeUpdate();
                ps.close();
                
                respuesta = "profesor eliminado correctamente.<br><a href='index.html'>Regresar</a>";
            } else {
                respuesta = "No se encontró al profesor con el nombre '" + getNombre() + "'.";
            }
            
            rs.close();
            check.close();
            c.close();
            
        } else {
            respuesta = "No hay conexión a la base.";
        }
        
    } catch (Exception e) {
        respuesta = "Error de ejecución en baja(): " + e.getMessage();
    }
}

    
    public void consulta(){
    try {
        Connection c = Conexion.conectar();
        
        if (c != null) {
            PreparedStatement ps = c.prepareStatement("SELECT * FROM profesor WHERE nombre = ?");
            ps.setString(1, getNombre());
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                // Cargar los datos en los atributos del objeto
                this.edad = rs.getInt("edad");
                this.genero = rs.getString("genero");
                
                respuesta = "Profesor encontrado:<br>" +
                           "Nombre: " + getNombre() + "<br>" +
                           "Edad: " + this.edad + "<br>" +
                           "Genero: " + this.genero + "<br>" +
                           "<a href='index.html'>Regresar</a>";
            } else {
                respuesta = "No se encontró al aprofesor con el nombre '" + getNombre() + "'.";
            }
            
            rs.close();
            ps.close();
            c.close();
            
        } else {
            respuesta = "No hay conexión a la base.";
        }
        
    } catch (Exception e) {
        respuesta = "Error de ejecución en consulta(): " + e.getMessage();
    }
}

    
    public void modifica(){
        
        
    }

}




