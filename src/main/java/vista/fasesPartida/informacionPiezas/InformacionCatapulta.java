package vista.fasesPartida.informacionPiezas;

import modelo.pieza.tipos.Catapulta;

public class InformacionCatapulta extends InformacionPieza {

    Catapulta catapulta;

    public InformacionCatapulta(){

        super("catapulta");
        catapulta = new Catapulta();
        mostrarAtributos(catapulta);
    }

}