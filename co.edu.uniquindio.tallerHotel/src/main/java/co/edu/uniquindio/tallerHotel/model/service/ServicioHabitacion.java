package co.edu.uniquindio.tallerHotel.model.service;


import co.edu.uniquindio.tallerHotel.model.Cliente;
import co.edu.uniquindio.tallerHotel.model.Habitacion;
import co.edu.uniquindio.tallerHotel.model.Reserva;
import java.time.LocalDate;



public interface ServicioHabitacion  {

    Cliente buscarCliente(String cedula);

    Habitacion buscarHabitacion(int numero);

    Reserva crearReserva(String nombre, String cedula,
                         LocalDate fechaEntrada, LocalDate fechaSalida,
                         int numeroHabitacion, int cantidadPersonas) throws Exception;

    Reserva obtenerReserva(int codigoHabitacion);

    void liberarHabitacion(int numero);



}