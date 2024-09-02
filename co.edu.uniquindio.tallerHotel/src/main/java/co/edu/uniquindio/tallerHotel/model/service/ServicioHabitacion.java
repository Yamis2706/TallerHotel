package co.edu.uniquindio.tallerHotel.model.service;



public class ServicioHabitacion implements Consumible {


    private String servicio;
    private String bebida;
    private String alimento;


    public ServicioHabitacion(String servicio, String bebida, String alimento) {


        this.servicio = servicio;
        this.bebida = bebida;
        this.alimento = alimento;
    }

    public ServicioHabitacion() {
    }
}