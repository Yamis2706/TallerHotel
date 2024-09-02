package co.edu.uniquindio.tallerHotel.model.service;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString

public class Servicio {
    private String spa;
    private String restaurante;
    private String limpieza;

    public Servicio(String spa, String restaurante, String limpieza) {
        this.spa = spa;
        this.restaurante = restaurante;
        this.limpieza = limpieza;
    }


}
