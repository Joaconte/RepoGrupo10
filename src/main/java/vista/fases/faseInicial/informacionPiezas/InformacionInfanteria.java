package vista.fases.faseInicial.informacionPiezas;

import modelo.pieza.tipos.Infanteria;

public class InformacionInfanteria extends InformacionPieza {

    Infanteria infanteria;

    public InformacionInfanteria(){

        super("infanteria");
        infanteria = new Infanteria();;
        mostrarAtributos(infanteria);
    }

}