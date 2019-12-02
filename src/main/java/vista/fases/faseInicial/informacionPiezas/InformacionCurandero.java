package vista.fases.faseInicial.informacionPiezas;

import modelo.pieza.tipos.Curandero;

public class InformacionCurandero extends InformacionPieza {

    Curandero curandero;

    public InformacionCurandero(){

        super("curandero");
        curandero = new Curandero();
        mostrarAtributos(curandero);
    }

}