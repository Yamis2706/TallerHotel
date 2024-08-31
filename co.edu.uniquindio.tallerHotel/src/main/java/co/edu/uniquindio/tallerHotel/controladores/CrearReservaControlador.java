package co.edu.uniquindio.tallerHotel.controladores;

import co.edu.uniquindio.tallerHotel.controladores.observador.Observador;
import co.edu.uniquindio.tallerHotel.model.Cliente;
import co.edu.uniquindio.tallerHotel.model.Reserva;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.fxml.FXML;

import javax.swing.*;


/** Clase que representa el controlador de la vista CrearReserva
 */

public class CrearReservaControlador {

    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtCedula;

    @FXML
    private DatePicker txtFechaIngreso;

    @FXML
    private DatePicker txtFechaSalida;

    @FXML
    private TextField txtCantidadPersonas;

    @FXML
    private Button btnLiberar;

    @FXML
    private Button btnCrear;

    @FXML
    private Button btnBuscar;

    private Observador observador;
    private int numeroHabitacion;
    private final ControladorPrincipal controladorPrincipal;

    public CrearReservaControlador(){
        controladorPrincipal = ControladorPrincipal.getInstance();
    }



    /** Método que inicializa los datos de la vista.
     */

    public void inicializarDatos(int numeroHabitacion, Observador observador){
        this.numeroHabitacion = numeroHabitacion;
        this.observador = observador;
        cargarDatos();
    }



    /** Método que crea una reserva con los datos ingresados.
     */

    public void crearReserva(){
        try {
            Reserva reserva =
                    controladorPrincipal.crearReserva(txtNombre.getText(), txtCedula.getText(),
                            txtFechaIngreso.getValue(), txtFechaSalida.getValue(), numeroHabitacion,
                            Integer.parseInt(txtCantidadPersonas.getText()));
                    controladorPrincipal.mostrarAlerta("La reserva ha sido creada " +
                    "correctamente. El valor a pagar es : $" + reserva.getValorTotal() + "pesos",
                    Alert.AlertType.INFORMATION);
                    observador.actualizar(numeroHabitacion, true);
                    controladorPrincipal.cerrarVentana(txtCedula);
        } catch (Exception e){
            controladorPrincipal.mostrarAlerta(e.getMessage(),
                    Alert.AlertType.ERROR);
        }
    }




    /** Método que busca un cliente por la cédula.
     */

    public void buscarCliente(ActionEvent actionEvent){
        Cliente cliente =
                controladorPrincipal.buscarCliente(txtCedula.getText());
        if(cliente != null){
            txtNombre.setText(cliente.getNombre());
            txtCedula.setText(cliente.getCedula());
        }
    }



    /** Método que carga los datos de la reserva en la vista, si la
     * habitación ya está reservada.
     */

    public void cargarDatos(){
        Reserva reserva = controladorPrincipal.obtenerReserva(numeroHabitacion);

        if(reserva != null){
            btnCrear.setDisable(true);
            btnBuscar.setDisable(true);
            btnLiberar.setDisable(false);
            txtNombre.setText(reserva.getCliente().getNombre());
            txtCedula.setText(reserva.getCliente().getCedula());
            txtFechaIngreso.setValue(reserva.getFechaIngreso());
            txtFechaSalida.setValue(reserva.getFechaSalida());
            txtCantidadPersonas.setText(String.valueOf(reserva.getCantidadPersonas()));
        }
    }


    /** Método que se encarga de liberar la habitación seleccionada.
     */

    public void liberarHabitacion(ActionEvent actionEvent){
        controladorPrincipal.liberarHabitacion(numeroHabitacion);
        controladorPrincipal.mostrarAlerta("La habitación quedó disponible",
                Alert.AlertType.INFORMATION);
        observador.actualizar(numeroHabitacion, false);
        controladorPrincipal.cerrarVentana(txtCedula);
    }
}
