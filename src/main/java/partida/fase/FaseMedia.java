package partida.fase;

import jugador.Jugador;
import partida.ataques.GestorDeAtaque;
import partida.ataques.JineteAsediadoException;
import partida.ataques.JineteNoAsediadoException;
import partida.ataques.PiezaAtacadaEnRangoIncorrectoException;
import pieza.Pieza;
import pieza.tipos.*;

public class FaseMedia implements FaseDePartida{

    private GestorDeAtaque gestorDeAtaque = new GestorDeAtaque();
    private boolean jugadorYaAtacoOCuro = false;
    private boolean jugadorYaMovio = false;
    private boolean jugadorPasoTurno =false;

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

    //Ataques o cura
    @Override
    public void atacar(Infanteria atacante, Pieza atacada) throws PiezaAtacadaEnRangoIncorrectoException {
        gestorDeAtaque.atacar(atacante,atacada);
    }

    @Override
    public void atacar(Catapulta atacante, Pieza atacada) throws PiezaAtacadaEnRangoIncorrectoException {
        gestorDeAtaque.atacar(atacante,atacada);
    }

    @Override
    public void atacar(Jinete atacante, Pieza atacada) throws PiezaAtacadaEnRangoIncorrectoException, JineteAsediadoException, JineteNoAsediadoException {
        gestorDeAtaque.atacar(atacante,atacada);
    }

    //Colocacion y movimiento
    @Override
    public void comprarUnaTropa(int costo, Jugador jugadorEnTurno) {
        //fase ortiva.
    }

    @Override
    public void agregarNuevaUbicacionAFicha(Jugador jugadorEnTurno, Pieza pieza, int posicionX, int posicionY) {
        //fase ortiva.
    }


}