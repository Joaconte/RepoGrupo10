package modelo.partida.fase;

import modelo.pieza.ataque.PiezaAliadaNoAtacableException;
import modelo.jugador.Jugador;
import modelo.pieza.UnidadEstaMuertaException;
import modelo.pieza.ataque.DistanciaDeAtaqueInvalidaException;
import modelo.pieza.ataque.PiezaAtacante;
import modelo.pieza.Pieza;
import modelo.tablero.Tablero;

public class FaseMedia implements FaseDePartida{

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
    public void atacar(PiezaAtacante atacante, Pieza atacada, Tablero tablero) throws UnidadEstaMuertaException, DistanciaDeAtaqueInvalidaException, PiezaAliadaNoAtacableException {
        atacante.atacar(atacada,tablero);
    }



}