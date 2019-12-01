package vista.faseInicial.informacionPiezas;

import modelo.pieza.tipos.Curandero;

public class InformacionCurandero extends InformacionPieza {

    Curandero curandero;

    public InformacionCurandero(){
        curandero = new Curandero();
        super.initialize("curandero");
    }

    public int getCostoPieza(){

        return curandero.getCosto();
    }

    public int getVidaPieza(){

        return curandero.getVidaMaxima();
    }

}