module co.edu.uniquindio.tallerHotel {
    requires javafx.controls;
    requires javafx.fxml;
    requires static lombok;

    opens co.edu.uniquindio.tallerHotel to javafx.fxml;
    exports co.edu.uniquindio.tallerHotel;

    opens co.edu.uniquindio.tallerHotel.controladores;
    exports co.edu.uniquindio.tallerHotel.controladores;

}