package vista.faseInicial.informacionPiezas;

import modelo.pieza.tipos.Infanteria;

public class InformacionInfanteria extends InformacionPieza {

    Infanteria infanteria;

    public InformacionInfanteria(){
        super("infanteria");
        infanteria = new Infanteria();;
        mostrarAtributos();
    }

    public int getCostoPieza(){

        return infanteria.getCosto();
    }

    public int getVidaPieza(){

        return infanteria.getVidaMaxima();
    }


}