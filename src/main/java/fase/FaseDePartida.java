package fase;

public interface FaseDePartida{

    //Metodos abstractos implementados por las subclases

    public void moverUnidadEnTablero(String unaPosicionInicial, String unaPosicionFinal); //por ahora String esta puesta por poner algo.
    public void terminarMiTurno();
    public String darNombreDeFase();

}