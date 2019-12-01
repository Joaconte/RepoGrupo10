package vista.faseInicial.informacionPiezas;

import modelo.pieza.tipos.Infanteria;

public class InformacionInfanteria extends InformacionPieza {

    Infanteria infanteria;

    public InformacionInfanteria(){
        infanteria = new Infanteria();
        super.initialize("infanteria");
    }

    public int getCostoPieza(){

        return infanteria.getCosto();
    }

    public int getVidaPieza(){

        return infanteria.getVidaMaxima();
    }


}