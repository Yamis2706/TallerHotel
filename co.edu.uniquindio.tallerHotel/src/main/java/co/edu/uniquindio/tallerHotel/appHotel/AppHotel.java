package co.edu.uniquindio.tallerHotel.appHotel;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Clase principal de la AppHotel que inicia la Interfaz de Usuario
 */


public class AppHotel extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        FXMLLoader loader = new FXMLLoader(AppHotel.class.getResource(
                "/inicio.fxml"));
        Parent parent = loader.load();

        Scene scene = new Scene(parent);
        stage.setScene(scene);
        stage.setTitle("Hotel Sueño Hermoso");
        stage.setResizable(false);
        stage.show();

    }

    public static void main(String[] args){
        launch(AppHotel.class, args);
    }
}
