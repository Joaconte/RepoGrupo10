package fase;

import pieza.Pieza;

public interface FaseDePartida{

    //Metodos abstractos implementados por las subclases

    public void moverUnidadEnTablero(Pieza pieza, int posicionFila, int posicionColumna);
    public void terminarMiTurno();
    public String darNombreDeFase();

}