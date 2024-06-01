/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examen_p1_jg_v2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class VehiculoDAO {

    public VehiculoDAO() {}

    //- Consultar todos los vehículos.
    public static void printVehiculoDetails() {
        String query = "SELECT * FROM Vehiculo;";
        
        try (Connection conn = examen_p1_jg_v2.DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            
            while (rs.next()) {
                int id_vehiculo = rs.getInt("id_vehiculo");
                String tipo = rs.getString("tipo");
                String marca = rs.getString("marca");
                int potencia = rs.getInt("potencia"); // getInt per a un valor enter
                String fecha_compra = rs.getString("fecha_compra");

                System.out.println("Id_vehiculo: " + id_vehiculo + ", tipo: " + tipo + ", marca: " + marca + ", potencia: " + potencia + ", fecha_compra: " + fecha_compra);
            }
        } catch (SQLException e) {
            System.out.println("Oh, oh... Error al consultar los vehiculos.");
            e.printStackTrace();
        }
    }
        
    //    - Consultar un vehículo por su ID.
    
    public static Vehiculo getVehiculoById(int id_vehiculo) {
        String query = "SELECT * FROM Vehiculo WHERE id_vehiculo = ?;";
        
        try (Connection conn = examen_p1_jg_v2.DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            
            pstmt.setInt(1, id_vehiculo);
            try (ResultSet rs = pstmt.executeQuery()) {
                if(rs.next()) {
                    String tipo = rs.getString("tipo");
                    String marca = rs.getString("marca");
                    int potencia = rs.getInt("potencia");
                    String fecha_compra = rs.getString("fecha_compra");
                    
                    return new Vehiculo(id_vehiculo, tipo, marca, potencia, fecha_compra);
                }
            }
        } catch (SQLException e) {
            System.out.println("Oh, oh... Error al consultar el vehiculo por ID.");
            e.printStackTrace();
        }
        
        return null; // retornar null si no es troba cap registre
    }
    
    //    - Insertar un nuevo vehículo.

    public static void insertVehiculo(int id_vehiculo, String tipo, String marca, int potencia, String fecha_compra) {
        String query = "INSERT INTO Vehiculo (id_vehiculo, tipo, marca, potencia, fecha_compra) VALUES (?, ?, ?, ?, ?);";
        
        try (Connection conn = examen_p1_jg_v2.DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            
            pstmt.setInt(1, id_vehiculo);
            pstmt.setString(2, tipo);
            pstmt.setString(3, marca);
            pstmt.setInt(4, potencia);
            pstmt.setString(5, fecha_compra);

            pstmt.executeUpdate();
            
            System.out.println("Se ha creado el vehiculo: " + tipo + " de la marca: " + marca);
        } catch (SQLException e) {
            System.out.println("Oh, oh... Error al crear el vehiculo nuevo.");
            e.printStackTrace();
        }
    }
      
//    - Eliminar un vehículo por su ID.
    
    public static void deleteVehiculoById(int id_vehiculo) {
        String query = "DELETE FROM Vehiculo WHERE id_vehiculo = ?;";
        
        try (Connection conn = examen_p1_jg_v2.DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            
            pstmt.setInt(1, id_vehiculo);
            int affectedRows = pstmt.executeUpdate();
            
            if (affectedRows > 0) {
               System.out.println("El vehicle amb ID " + id_vehiculo + " ha sigut eliminat.");
            }else {
               System.out.println("no s'ha trobat cap vehicle amb ID " + id_vehiculo + ".");
            }
        }catch (SQLException e) {
                    System.out.println("Oh, oh... Error a l'eliminar el vehicle.");
                    e.printStackTrace();
        }
    }
    
//    - Actualizar los datos de un vehículo.
    public static void updateMarcaVehiculo(int id_vehiculo, String nuevaMarca) {
        String query = "UPDATE Vehiculo SET marca = ? WHERE id_vehiculo = ?;";
        
        try (Connection conn = examen_p1_jg_v2.DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            
            pstmt.setString(1, nuevaMarca);
            pstmt.setInt(2, id_vehiculo);
            
            int affectedRows = pstmt.executeUpdate();
            
            if (affectedRows > 0) {
               System.out.println("S'ha actualitzat la marca del vehicle amb ID " + id_vehiculo + ".");
            }else {
               System.out.println("no s'ha trobat cap vehicle amb ID " + id_vehiculo + ".");
            }
        }catch (SQLException e) {
                    System.out.println("Oh, oh... Error a l'actualitzar la marca del vehicle.");
                    e.printStackTrace();
        }
    }
    
//    - Obtener la potencia media según el tipo de vehículo.
    public static double obtenerPotenciaMediaPortipo(String tipo) {
        String query = "SELECT AVG(potencia) AS potencia_media FROM Vehiculo WHERE tipo = ?;";
        double potenciaMedia = 0.0;
        
        try (Connection conn = examen_p1_jg_v2.DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            
            pstmt.setString(1, tipo);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    potenciaMedia = rs.getDouble("potencia_media");
                }
            }
        }catch (SQLException e) {
            System.out.println("Oh, oh... Error al obtener la potencia media por tipo de vehiculo");
            e.printStackTrace();
        }
        
        return potenciaMedia;
    }
    
//    - Obtener la potencia máxima según el tipo de vehículo.
    public static int obtenerPotenciaMaximaPorTipo(String tipo) {
        String query = "SELECT MAX(potencia) AS potencia_maxima FROM Vehiculo WHERE tipo = ?;";
        int potenciaMaxima = 0;
        
        try (Connection conn = examen_p1_jg_v2.DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            
            pstmt.setString(1, tipo);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    potenciaMaxima = rs.getInt("potencia_maxima");
                }
            }
        }catch (SQLException e) {
            System.out.println("Oh, oh... Error al obtener la potencia maxima por tipo de vehiculo");
            e.printStackTrace();
        }
        
        return potenciaMaxima;
    }
}

