package co.edu.uniquindio.tallerHotel.model;

import co.edu.uniquindio.tallerHotel.model.Servicio;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString


public class ServicioHabitacion extends Servicio{
    public ServicioHabitacion(String spa, String restaurante, String limpieza) {
        super(spa, restaurante, limpieza);
    }
}
