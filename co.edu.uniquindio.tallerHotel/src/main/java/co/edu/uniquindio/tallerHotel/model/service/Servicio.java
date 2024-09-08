package co.edu.uniquindio.tallerHotel.model.service;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString

public abstract class Servicio implements Consumible {
    String nombreServicio;


    @Override
    public String consumir() {
        return "";
    }
}
