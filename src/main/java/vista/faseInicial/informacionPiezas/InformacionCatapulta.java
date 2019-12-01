package vista.faseInicial.informacionPiezas;

import modelo.pieza.tipos.Catapulta;

public class InformacionCatapulta extends InformacionPieza {

    Catapulta catapulta;

    public InformacionCatapulta(){

        super("catapulta");
        catapulta = new Catapulta();
        mostrarAtributos();
    }

    public int getCostoPieza(){

        return catapulta.getCosto();
    }

    public int getVidaPieza(){

        return catapulta.getVidaMaxima();
    }
}