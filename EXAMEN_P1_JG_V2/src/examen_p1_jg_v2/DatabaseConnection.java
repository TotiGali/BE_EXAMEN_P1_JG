/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examen_p1_jg_v2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author jordi
 */
public class DatabaseConnection {
    
    private static final String URL = "jdbc:mysql://localhost:3306/BE_EXAMEN_JG";
    private static final String USER = "root";
    private static final String PASSWORD = "BicipresiBench2029";
    
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
        
}
