package fiuba.algo3.TP2.model;

public class SeMueveEnTodasDirecciones implements IModoMovimiento {

    @Override
    public void moverUnidad(Ubicacion actual,Ubicacion miNuevaUbicacion) {
        actual = new Ubicacion(miNuevaUbicacion.darPosicionEnX(),miNuevaUbicacion.darPosicionEnY());
    }
}
