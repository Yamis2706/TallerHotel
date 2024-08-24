package co.edu.uniquindio.tallerHotel.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@ToString


public class Cliente {
    private String nombre;
    private String cedula;
    private int reserva;
}
