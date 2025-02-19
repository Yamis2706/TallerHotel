package co.edu.uniquindio.tallerHotel.model;

import lombok.*;

import java.util.Collection;

@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder


public class Cliente {
    private String nombre;
    private String cedula;

    public Collection<Reserva> getReservas() {
        return java.util.List.of();
    }
}