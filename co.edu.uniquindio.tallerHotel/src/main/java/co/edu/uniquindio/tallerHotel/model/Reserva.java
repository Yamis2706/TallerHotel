package co.edu.uniquindio.tallerHotel.model;

import co.edu.uniquindio.tallerHotel.model.enums.EstadoReserva;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.time.LocalDate;

@AllArgsConstructor
@Getter
@Setter
@ToString

public class Reserva {

    private Cliente cliente;
    private LocalDate fechaIngreso;
    private LocalDate fechaSalida;
    private Habitacion habitacion;
    private EstadoReserva estadoReserva;
    private int cantidadPersonas;
    private String codigo;
    private float valorTotal;

}
