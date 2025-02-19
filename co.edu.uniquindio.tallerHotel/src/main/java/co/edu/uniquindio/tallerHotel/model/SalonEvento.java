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

public class SalonEvento {


    public int idSalon;
    public int capacidad;
    public EstadoReserva estadoReserva;
    public String descripcion;

    public SalonEvento() {

    }

    public void setDisponible(boolean b) {

    }

}
