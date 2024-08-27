package co.edu.uniquindio.tallerHotel.model;

import co.edu.uniquindio.tallerHotel.model.constante.TamanoMatriz;
import co.edu.uniquindio.tallerHotel.model.enums.EstadoReserva;
import co.edu.uniquindio.tallerHotel.model.enums.TipoHabitacion;
import co.edu.uniquindio.tallerHotel.model.service.ServicioHabitacion;
import lombok .Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.UUID;

/** Esta clase representa un Hotel con sus habitaciones, reservas y clientes
 * asociados.
 */

@Getter
@Setter
@AllArgsConstructor

public class Hotel implements ServicioHabitacion {

    private final Habitacion[][] habitaciones;
    private final ArrayList<Reserva> reservas;
    private final ArrayList<Cliente> clientes;


    public Hotel(){
        this.habitaciones = new Habitacion[TamanoMatriz.FILAS][TamanoMatriz.COLUMNAS];
        this.reservas = new ArrayList<>();
        this.clientes = new ArrayList<>();
        inicializarHabitaciones();
    }


    /** Método que inicializa las habitaciones con valores por defecto y los
     * almacena en la matriz de habitaciones.
     */

    private void inicializarHabitaciones(){
        for (int i = 0; i < habitaciones[0].length; i++){
            habitaciones[0][i] = new Habitacion(150)
        }
    }


}
