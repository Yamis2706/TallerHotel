package co.edu.uniquindio.tallerHotel.controladores;

import co.edu.uniquindio.tallerHotel.model.Cliente;
import co.edu.uniquindio.tallerHotel.model.Habitacion;
import co.edu.uniquindio.tallerHotel.model.Hotel;
import co.edu.uniquindio.tallerHotel.model.Reserva;
import co.edu.uniquindio.tallerHotel.model.service.ServicioHabitacion;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
@Setter

/**Clase que representa el Controlador Principal de la AppHotel
 *
 */

public class ControladorPrincipal implements ServicioHabitacion{

    @Getter
    private final Hotel hotel;
    public  static ControladorPrincipal INSTANCIA;

    private ControladorPrincipal(){
        hotel = new Hotel();
    }

    public static ControladorPrincipal getInstance(){
        if (INSTANCIA == null){
            INSTANCIA = new ControladorPrincipal();
        }
        return INSTANCIA;
    }

    @Override
    public Cliente buscarCliente(String cedula) {
        return hotel.buscarCliente(cedula);
    }

    @Override
    public Habitacion buscarHabitacion(int numeroHabitacion){
        return hotel.buscarHabitacion(numeroHabitacion);
    }

    @Override
    public Reserva crearReserva(String nombre, String cedula,
                                LocalDate fechaIngreso, LocalDate fechaSalida
            , int numeroHabitacion, int cantidadPersonas) throws Exception{
        return hotel.crearReserva(nombre, cedula, fechaIngreso, fechaSalida,
                numeroHabitacion, cantidadPersonas);
    }

    @Override
    public Reserva obtenerReserva(int codigoHabitacion){
        return hotel.obtenerReserva(codigoHabitacion);
    }

    @Override
    public void liberarHabitacion(int numero){
        hotel.liberarHabitacion(numero);
    }

    public void mostrarAlerta(String mensaje, Alert.AlertType tipo){
        Alert alert = new Alert(tipo);
        alert.setTitle("Alerta Hotel");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

    public FXMLLoader navegar(String nombreVista, String titulo){
        try {
            FXMLLoader loader =
                    new FXMLLoader(getClass().getResource(nombreVista));
            Parent root = loader.load();

            //Creamos la escena
            Scene scene = new Scene(root);

            //Creamos un nuevo escenario
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setResizable(false);
            stage.setTitle(titulo);

            //Mostramos la nueva ventana
            stage.show();

            return loader;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public void cerrarVentana(Node node){
        Stage stage = (Stage) node.getScene().getWindow();
        stage.close();
    }
}
