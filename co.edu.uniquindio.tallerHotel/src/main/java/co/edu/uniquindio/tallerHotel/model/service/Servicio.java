package co.edu.uniquindio.tallerHotel.model.service;

import co.edu.uniquindio.tallerHotel.model.Cliente;
import co.edu.uniquindio.tallerHotel.model.Habitacion;
import co.edu.uniquindio.tallerHotel.model.Reserva;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;


@Getter
@Setter
@ToString

public  class Servicio implements Consumible {
    String nombreServicio;

    Cliente buscarCliente(String cedula) {
        return null;
    }

    Habitacion buscarHabitacion(int numero) {
        return null;
    }

    Reserva crearReserva(String cedula, String nombre, String correo,
                         LocalDate fechaInicio, LocalDate fechaFin,
                         int numeroHabitacion, int cantidadPersonas) throws Exception {
        return null;
    }

    Reserva obtenerReserva(int codigoHabitacion) {
        return null;
    }

    void liberarHabitacion(int numero) {

    }


    @Override
    public String consumir() {
        return "";
    }

    public String reservar() {
        return null;
    }
}
