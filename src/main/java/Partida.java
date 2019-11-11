import fase.*;
import tablero.Tablero;

public class Partida{
    private FaseDePartida miFase = new FaseInicial();
    private Tablero tableroDePartida = new Tablero();
   // private Jugador jugadorIzquierdo = new Jugador(); //¿Los guardamos asi?
  //  private Jugador jugadorDerecho = new Jugador();


    //---------------Metodos de Fase------------
    public void cambiarFaseDePartida(FaseDePartida miNuevaFase){
        this.miFase = miNuevaFase;
    }

    public void moverUnidadEnTablero(String unaPosicionInicial, String unaPosicionFinal){ //por ahora String esta puesta por poner algo.
        miFase.moverUnidadEnTablero(unaPosicionInicial,unaPosicionFinal);
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
