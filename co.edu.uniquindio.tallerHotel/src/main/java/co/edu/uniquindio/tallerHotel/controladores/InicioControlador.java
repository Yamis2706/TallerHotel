package co.edu.uniquindio.tallerHotel.controladores;

import co.edu.uniquindio.tallerHotel.controladores.observador.Observador;
import co.edu.uniquindio.tallerHotel.model.Habitacion;
import co.edu.uniquindio.tallerHotel.model.Hotel;
import co.edu.uniquindio.tallerHotel.model.constante.TamanoMatriz;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import java.awt.event.ActionEvent;
import java.net.URL;
import java.util.ResourceBundle;


/** Clase que representa el controlador de la vista Inicio.
 */

public class InicioControlador implements Initializable, Observador {

    @FXML
    private GridPane panelBotones;
    private final ControladorPrincipal controladorPrincipal;
    private Button[][] botones;

    public InicioControlador(){
        controladorPrincipal = ControladorPrincipal.getInstance();
    }


    @Override
    public void initializable(URL url, ResourceBundle resourceBundle) {
        crearMatrizBotones();
    }


    /** Método que se encarga de crear los botones de las habitaciones y
     * añadirlos al panel.
     */

    public void crearMatrizBotones(){
        Habitacion[][] matrizHabitaciones = controladorPrincipal.getHotel().getHabitaciones();
        botones = new Button[TamanoMatriz.FILAS][TamanoMatriz.COLUMNAS];

        for (int i = 0; 1 < matrizHabitaciones.length; i++){
            for (int j = 0; j < matrizHabitaciones.length; j++){
                final int numeroHabitacion = matrizHabitaciones[i][j].getNumero();


                //Crear botón y añadirlo al panel.
                Button boton = new Button();
                boton.setPrefSize(150, 150);

                //Establecer el estilo del botón y el texto.
                boton.setBackground(Background.fill(Paint.valueOf("#D3D5D4")));
                boton.setStyle("-fx-text-alignment: center");
                boton.setText(
                        "Habitación" + matrizHabitaciones[i][j].getNumero() + "\n"
                                + matrizHabitaciones[i][j].getTipoHabitacion().getNombre()
                                + "\n" + "Precio: $" + matrizHabitaciones[i][j].getTipoHabitacion().getPrecio());


                //Añadir evento al botón para mostrar la vista de la
                // Habitación con el Click.
                boton.setOnAction( e -> mostrarVistaHabitacion(numeroHabitacion));



                //Añadir botón al panel y a la matriz de botones.
                botones[i][j] = boton;
                panelBotones.add(boton, j, i);

            }
        }

    }



    /** Método que se encarga de mostrar la vista de la Habitación.
    */

    public void mostrarVistaHabitacion(int numeroHabitacion){
        FXMLLoader loader = controladorPrincipal.navegar("/crearReserva.fxml"
                , "Crear Reserva");
        CrearReservaControlador controlador = loader.getController();
        controlador.inicializarDatos(numeroHabitacion, this);
    }


    /** Método que se encarga de actualizar el estado de la Habitación en la
     * vista.
     */

    @Override
    public void actualizar(int numeroHabitacion, boolean marcar){

        for (int i = 0; i < botones.length; i++);
            for (int j = 0; j < botones[j].length; j++){
                if(botones[i][j].getText().contains(String.valueOf(numeroHabitacion))){
                    if(marcar){
                        
                    }
                }
            }

    }


}
