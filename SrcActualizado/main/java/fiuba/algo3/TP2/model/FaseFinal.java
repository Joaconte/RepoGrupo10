package fiuba.algo3.TP2.model;

public class FaseFinal implements FaseDePartida{

    //Metodo que no introduce cambio.
    @Override
    public void moverUnidadEnTablero(String unaPosicionInicial, String unaPosicionFinal){
        //Construir o no
    }

    //Metodo que permite indicar que el jugador ya vio los resultados.
    @Override
    public void terminarMiTurno(){
        //Construir?
    }

    //Metodo para pedir a fase su nombre
    @Override
    public String darNombreDeFase(){
        return "Fase Final";
    }
}