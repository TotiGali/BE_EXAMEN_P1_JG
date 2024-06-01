/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package examen_p1_jg_v2;

//import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
//import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 *
 * @author jordi
 */
public class EXAMEN_P1_JG_V2 {

    public static void main(String[] args) {
        
        //    1- Consultar todos los veh�culos.
        VehiculoDAO.printVehiculoDetails();
        
        //    2- Consultar un veh�culo por su ID = 1.
        int id_buscar = 1;
        Vehiculo vehiculo = VehiculoDAO.getVehiculoById(id_buscar);
        
        if (vehiculo != null) {
            System.out.println("Vehicle trobat: " + vehiculo.getTipo() + " de la marca " + vehiculo.getMarca());
        }else {
            System.out.println("No s'ha trobat cap vehicle amb ID " + id_buscar);
        }
    
        //    3- Insertar un nuevo veh�culo.  Metode desactivat per no generar error al crear un vehicle ja creat
        //VehiculoDAO.insertVehiculo(6, "coche", "Shelby", 650, "2020-01-01");
        
        //    4- Eliminar un veh�culo por su ID.
        //int id_eliminar = 1;
        //VehiculoDAO.deleteVehiculoById(id_eliminar);
    
        //    5- Actualizar los datos de un veh�culo.
        //int idVehiculo = 3;
        // nuevaMarca = "Cobra";
        //VehiculoDAO.updateMarcaVehiculo(idVehiculo, nuevaMarca);

        //    6- Obtener la potencia media seg�n el tipo de veh�culo.
        String tipoVehiculo = "coche";
        double potenciaMedia = VehiculoDAO.obtenerPotenciaMediaPortipo(tipoVehiculo);
        System.out.println("La potencia media de los veh�culos tipo: " + tipoVehiculo + " es: " + potenciaMedia + " CV.");

        //    7- Obtener la potencia m�xima seg�n el tipo de veh�culo.
        String tipoVehiculo2 = "coche";
        int potenciaMaxima = VehiculoDAO.obtenerPotenciaMaximaPorTipo(tipoVehiculo2);
        System.out.println("La potencia maxima de los veh�culos tipo: " + tipoVehiculo2 + " es: " + potenciaMaxima + " CV.");
        
    }

}
