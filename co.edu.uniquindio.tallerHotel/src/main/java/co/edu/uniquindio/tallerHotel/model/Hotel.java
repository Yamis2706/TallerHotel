package co.edu.uniquindio.tallerHotel.model;

import co.edu.uniquindio.tallerHotel.model.enums.EstadoReserva;
import co.edu.uniquindio.tallerHotel.model.enums.TipoHabitacion;
import co.edu.uniquindio.tallerHotel.model.service.ServicioHabitacion;

import lombok .Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.UUID;

/** Clase que representa un Hotel con sus habitaciones, reservas y clientes
 * asociados.
 */

@Getter
@Setter
@AllArgsConstructor

public class Hotel implements ServicioHabitacion {

    private final Habitacion[][] habitaciones;
    private final ArrayList<Reserva> reservas;
    private final ArrayList<Cliente> clientes;


    /**
     * Método que inicializa las habitaciones con valores por defecto y los
     * almacena en la matriz de habitaciones.
     */

    private void inicializarHabitaciones() {
        for (int i = 0; i < habitaciones[0].length; i++) {
            habitaciones[0][i] = new Habitacion(150 + (i + 1),
                    TipoHabitacion.SENCILLA, 150.000F);
        }

        for (int i = 1; i <= 2; i++) {
            for (int j = 0; j < habitaciones[0].length; j++) {
                habitaciones[i][j] = new Habitacion((i + 1) * 200 + (j + 1),
                        TipoHabitacion.DOBLE, 280.000F);
            }
        }

        for (int i = 0; i < habitaciones[0].length; i++) {
            habitaciones[3][i] = new Habitacion(400 + (i + 1),
                    TipoHabitacion.SUITE, 450.000F);
        }
    }


    /**
     * Método que busca un cliente por su cédula en la lista de clientes
     */


    public Cliente buscarCliente(String cedula) {

        for (Cliente cliente : clientes) {
            if (cliente.getCedula().equals(cedula)) {
                return cliente;
            }
        }
        return null;
    }


    /**
     * Método para crear un cliente y lo almacena en la lista de clientes
     */

    private Cliente crearCliente(String nombre, String cedula) throws Exception {

        if (nombre == null || nombre.isBlank()) {
            throw new Exception("El nombre es obligatorio");
        }

        if (cedula == null || cedula.isBlank()) {
            throw new Exception("La cédula es obligatoria");
        }

        if (buscarCliente(cedula) != null) {
            throw new Exception("El cliente ya existe");
        }

        Cliente cliente = Cliente.builder()
                .nombre(nombre)
                .cedula(cedula)
                .build();

        clientes.add(cliente);
        return cliente;
    }



    /**
     * Método que busca una habitación por su número en la matriz de habitaciones
     */


    public Habitacion buscarHabitacion(int numero ){
        for(int i = 0; i < habitaciones.length; i++){
            for(int j = 0; j < habitaciones[i].length; j++){
                if(habitaciones[i][j].getNumero() == numero){
                    return habitaciones[i][j];
                }
            }
        }
        return null;
    }


    public Reserva crearReserva(String nombre, String cedula, LocalDate fechaEntrada,
                                LocalDate fechaSalida, int numeroHabitacion, int cantidadPersonas) throws Exception {
        Cliente cliente = buscarCliente(cedula);
        Habitacion habitacion = buscarHabitacion(numeroHabitacion);

        if (cliente == null) {
            throw new Exception("No hay registro de un cliente con la cédula " +
                    "proporcionada");
        }

        if (habitacion == null) {
            throw new Exception("No se encuentra una habitación con el número proporcionado");
        }

        for (Reserva reservaExistente : reservas) {
            if (reservaExistente.getHabitacion().getNumero() == numeroHabitacion
                    && reservaExistente.getEstadoReserva() == EstadoReserva.ACTIVA) {
                throw new Exception("La habitación ya está reservada para las" +
                        " fechas seleccionadas");
            }
        }

        float valorTotal = habitacion.getPrecio() * (fechaSalida.toEpochDay() - fechaEntrada.toEpochDay());
        Reserva reserva = new Reserva(cliente, fechaEntrada, fechaSalida, habitacion, cantidadPersonas,
                UUID.randomUUID().toString(), EstadoReserva.ACTIVA, valorTotal);
        reservas.add(reserva);

        habitacion.setDisponible(false);
        cliente.getReservas().add(reserva);

        return reserva;
    }



    /**
     * Método que obtiene una reserva por el número de la habitación
     */
    @Override
    public Reserva obtenerReserva(int codigoHabitacion){
        for(Reserva reserva : reservas){
            if(reserva.getHabitacion().getNumero() == codigoHabitacion && reserva.getEstadoReserva()
                    == EstadoReserva.ACTIVA ){
                return reserva;
            }
        }
        return null;
    }



    /**
     * Método que libera una habitación por su número
     */
    @Override
    public void liberarHabitacion(int numero){
        Habitacion habitacion = buscarHabitacion(numero);
        Reserva reserva = obtenerReserva(numero);

        if(reserva != null){
            reserva.setEstadoReserva(EstadoReserva.FINALIZADA);
        }

        if(habitacion != null){
            habitacion.setDisponible(true);
        }
    }

}
