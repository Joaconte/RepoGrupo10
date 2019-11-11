package pieza.movimiento;

import pieza.Ubicacion;

public class SeMueveEnTodasDirecciones implements IModoMovimiento {

    @Override
    public void moverUnidad(Ubicacion actual, Ubicacion miNuevaUbicacion) {
        actual = new Ubicacion(miNuevaUbicacion.darPosicionEnX(),miNuevaUbicacion.darPosicionEnY());
    }
}
