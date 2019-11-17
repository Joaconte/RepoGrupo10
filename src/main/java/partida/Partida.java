package partida;
import partida.fase.*;
import tablero.Tablero;
import pieza.Pieza;

public class Partida{
    private FaseDePartida miFase = new FaseInicial();
    private Tablero tableroDePartida = new Tablero();
   // private Jugador jugadorIzquierdo = new Jugador(); //¿Los guardamos asi?
  //  private Jugador jugadorDerecho = new Jugador();


    //---------------Metodos de Fase------------
    public void cambiarFaseDePartida(FaseDePartida miNuevaFase){
        this.miFase = miNuevaFase;
    }

    public void moverUnidadEnTablero(Pieza pieza, int unaPosicionInicial, int unaPosicionFinal){ //por ahora String esta puesta por poner algo.
        miFase.moverUnidadEnTablero(pieza, unaPosicionInicial,unaPosicionFinal);
    }

    public void terminarMiTurno(){
        miFase.terminarMiTurno();
    }

    public String darNombreDeFase(){
        return miFase.darNombreDeFase();
    }

    //Metodos para Jugadores

    public void agregarJugadores() {
        //¿Construir?
    }


}
