package model;

public abstract class Unidad {

    private int vida;
    private int costo;
    private Ubicacion ubicacion;

    void Unidad(){}
    void Unidad(Ubicacion ubicacion){
        this.ubicacion = ubicacion;
    }

    //-----------GETTERS-----------//
    public int getCosto(){
        return costo;
    }
    public int getVida(){
        return vida;
    }
    public Ubicacion getUbicacion(){
        return ubicacion;
    }


}
