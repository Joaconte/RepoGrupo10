package partida.fase;

import jugador.Jugador;
import pieza.tipos.JineteNoAsediadoException;
import pieza.Pieza;
import pieza.tipos.*;
import tablero.Tablero;

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
    public void atacar(Pieza atacante, Pieza atacada, Tablero tablero) {
        atacante.atacar(atacada,tablero);
    }



    //Colocacion y movimiento

    @Override
    public void agregarNuevaUbicacionAFicha(Jugador jugadorEnTurno, Pieza pieza, int posicionX, int posicionY) {
        //fase ortiva.
    }


}