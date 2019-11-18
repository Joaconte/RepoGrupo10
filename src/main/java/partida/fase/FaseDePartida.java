package partida.fase;

import pieza.Pieza;

public interface FaseDePartida{

    //Metodos abstractos implementados por las subclases

    public void moverUnidadEnTablero(Pieza pieza, int numeroFila, int numeroColumna);
    public void terminarMiTurno();
    public String darNombreDeFase();

}