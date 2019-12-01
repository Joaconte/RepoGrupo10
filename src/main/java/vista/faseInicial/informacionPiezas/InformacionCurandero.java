package vista.faseInicial.informacionPiezas;

import modelo.pieza.tipos.Curandero;

public class InformacionCurandero extends InformacionPieza {

    Curandero curandero;

    public InformacionCurandero(){

        super("curandero");
        curandero = new Curandero();
        mostrarAtributos();
    }

    public int getCostoPieza(){

        return curandero.getCosto();
    }

    public int getVidaPieza(){

        return curandero.getVidaMaxima();
    }

}