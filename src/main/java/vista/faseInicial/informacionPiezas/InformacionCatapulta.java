package vista.faseInicial.informacionPiezas;

import modelo.pieza.tipos.Catapulta;

public class InformacionCatapulta extends InformacionPieza {

    Catapulta catapulta;

    public InformacionCatapulta(){
        catapulta = new Catapulta();
        super.initialize("catapulta");
    }

    public int getCostoPieza(){

        return catapulta.getCosto();
    }

    public int getVidaPieza(){

        return catapulta.getVidaMaxima();
    }
}