package vista.faseInicial.informacionPiezas;

import modelo.pieza.tipos.Jinete;

public class InformacionJinete extends InformacionPieza {

    Jinete jinete;

    public InformacionJinete(){
        super("jinete");
        jinete = new Jinete();
        mostrarAtributos();
    }

    public int getCostoPieza(){

        return jinete.getCosto();
    }

    public int getVidaPieza(){

        return jinete.getVidaMaxima();
    }

}