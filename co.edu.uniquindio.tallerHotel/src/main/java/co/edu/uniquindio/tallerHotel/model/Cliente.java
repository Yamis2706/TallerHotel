package co.edu.uniquindio.tallerHotel.model;

import lombok.*;

import java.util.ArrayList;

@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder


public class Cliente {
    private String nombre;
    private String cedula;
    private ArrayList<Reserva> reservas;

}