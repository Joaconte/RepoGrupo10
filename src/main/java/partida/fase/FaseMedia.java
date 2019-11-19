package partida.fase;

import jugador.Jugador;
import partida.ataques.JineteAsediadoException;
import partida.ataques.JineteNoAsediadoException;
import partida.ataques.PiezaAtacadaEnRangoIncorrectoException;
import pieza.Pieza;
import pieza.tipos.Catapulta;
import pieza.tipos.Infanteria;
import pieza.tipos.Jinete;

public class FaseMedia implements FaseDePartida{

    //Metodo que permite que una ficha se ubique en una casilla adyacente vacia, del tablero.
    @Override
    public void moverUnidadEnTablero(Pieza pieza, int numeroColumna, int numeroFila){
        //Construir
    }

    //Metodo que permite indicar que el jugador termina con las acciones de su turno.
    @Override
    public void terminarMiTurno(){
        //Construir?
    }

    //Metodo para pedir a fase su nombre
    @Override
    public String darNombreDeFase(){
        return "Fase Media";
    }

    @Override
    public void atacar(Infanteria atacante, Pieza atacada, Jugador jugadorEnTurno) throws PiezaAtacadaEnRangoIncorrectoException {

    }

    @Override
    public void atacar(Catapulta atacante, Pieza atacada, Jugador jugadorEnTurno) throws PiezaAtacadaEnRangoIncorrectoException {

    }

    @Override
    public void atacar(Jinete atacante, Pieza atacada, Jugador jugadorEnTurno) throws PiezaAtacadaEnRangoIncorrectoException, JineteAsediadoException, JineteNoAsediadoException {

    }


    public void setDanio(Pieza atacante, Pieza atacada, Jugador jugadorEnTurno) {
        int columnaEnDondeEstaLaPiezaAtacada = atacada.getUbicacion().getPosicionEnX();
        boolean sonEnemigas = atacada.esEnemigo(atacante);
        boolean estaEnElSectorDelJugadorAtacante = jugadorEnTurno.getSector().esDelSector(columnaEnDondeEstaLaPiezaAtacada);
        if (estaEnElSectorDelJugadorAtacante && sonEnemigas){ atacada.enZonaEnemiga();}
        else {atacada.enZonaAliada();}
    }
}