package co.edu.uniquindio.tallerHotel.model;

import co.edu.uniquindio.tallerHotel.model.enums.TipoHabitacion;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@AllArgsConstructor
@Getter
@Setter
@ToString

public class Habitacion {
    public int numero;
    public TipoHabitacion tipoHabitacion;
    public float precio;

}
