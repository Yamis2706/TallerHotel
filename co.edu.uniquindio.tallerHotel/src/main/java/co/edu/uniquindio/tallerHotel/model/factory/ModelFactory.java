package co.edu.uniquindio.tallerHotel.model.factory;

import co.edu.uniquindio.tallerHotel.model.service.ISalonEvento;

public class ModelFactory implements ISalonEvento {

    private static ModelFactory modelFactory;

    public static ModelFactory getInstance(){
        if(modelFactory == null){
            modelFactory = new ModelFactory();
        }

        return modelFactory;
    }
    
    
    @Override
    public String reservar() {
        return "";
    }
}
