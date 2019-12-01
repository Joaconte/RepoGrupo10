package vista.faseInicial.informacionPiezas;

import modelo.pieza.tipos.Jinete;

public class InformacionJinete extends InformacionPieza {

    Jinete jinete;

    public InformacionJinete(){
        jinete = new Jinete();
        super.initialize("jinete");
    }

    public int getCostoPieza(){

        return jinete.getCosto();
    }

    public int getVidaPieza(){

        return jinete.getVidaMaxima();
    }

}