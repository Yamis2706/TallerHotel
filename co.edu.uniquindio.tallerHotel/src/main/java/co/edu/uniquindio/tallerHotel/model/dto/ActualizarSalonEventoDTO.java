package co.edu.uniquindio.tallerHotel.model.dto;

import co.edu.uniquindio.tallerHotel.model.enums.EstadoReserva;

public record ActualizarSalonEventoDTO(
        int idSalon,
        int capacidad,
        EstadoReserva estadoReserva,
        String descripcion) {

}
