/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examen_p1_jg_v2;

//import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author jordi
 */
public class Vehiculo {
    
    private int id_vehiculo;
    private String tipo;
    private String marca;
    private int potencia;
    private String fecha_compra;
    public static List<Vehiculo> todosVehiculos = new ArrayList<>();

    public Vehiculo(int id_vehiculo, String tipo, String marca, int potencia, String fecha_compra){
            this.id_vehiculo = id_vehiculo;
            this.tipo = tipo;
            this.marca = marca;
            this.potencia = potencia;
            this.fecha_compra = fecha_compra;
            todosVehiculos.add(this);
    }

    //SETTERS I GETTERS

    public int getId_vehiculo() {
        return id_vehiculo;
    }

    public void setId_vehiculo(int id_vehiculo) {
        this.id_vehiculo = id_vehiculo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getPotencia() {
        return potencia;
    }

    public void setPotencia(int potencia) {
        this.potencia = potencia;
    }

    public String getFecha_compra() {
        return fecha_compra;
    }

    public void setFecha_compra(String fecha_compra) {
        this.fecha_compra = fecha_compra;
    }

    public static List<Vehiculo> getTodosVehiculos() {
        return todosVehiculos;
    }

    public static void setTodosVehiculos(List<Vehiculo> todosVehiculos) {
        Vehiculo.todosVehiculos = todosVehiculos;
    }
    
    
    //METODOS
    
    //Metode per crear un vehicle nou
     public static Vehiculo crearVehiculo(int id_vehiculo, String tipo, String marca, int potencia, String fecha_compra) {
        VehiculoDAO.insertVehiculo(id_vehiculo, tipo, marca, potencia, fecha_compra);
        return new Vehiculo(id_vehiculo, tipo, marca, potencia, fecha_compra);
    }
    
    
}
