package modelo.pieza.movimiento;

import modelo.pieza.Ubicacion;

public class SeMueveEnTodasDirecciones implements IModoMovimiento {
    /* obtener dimension del tablero para ver limites */
    /* Devuelve la ubicacion nueva */
    @Override
    public void moverUnidad(Ubicacion actual, Ubicacion miNuevaUbicacion) {
        actual = new Ubicacion(miNuevaUbicacion.getPosicionEnX(),miNuevaUbicacion.getPosicionEnY());
    }

    @Override
    public Ubicacion arriba(Ubicacion actual) {
        return new Ubicacion (actual.getPosicionEnX(), actual.getPosicionEnY()-1);
    }

    @Override
    public Ubicacion abajo(Ubicacion actual) {
        return new Ubicacion (actual.getPosicionEnX(), actual.getPosicionEnY()+1);
    }

    @Override
    public Ubicacion derecha(Ubicacion actual) {
        return new Ubicacion (actual.getPosicionEnX()+1, actual.getPosicionEnY());
    }

    @Override
    public Ubicacion izquierda(Ubicacion actual) {
        return new Ubicacion (actual.getPosicionEnX()-1, actual.getPosicionEnY());
    }

    @Override
    public Ubicacion arribaIzquierda(Ubicacion actual) {
        return new Ubicacion (actual.getPosicionEnX()-1, actual.getPosicionEnY()-1);
    }

    @Override
    public Ubicacion abajoIzquierda(Ubicacion actual) {
        return new Ubicacion (actual.getPosicionEnX()-1, actual.getPosicionEnY()+1);
    }

    @Override
    public Ubicacion arribaDerecha(Ubicacion actual) {
        return new Ubicacion (actual.getPosicionEnX()+1, actual.getPosicionEnY()-1);
    }

    @Override
    public Ubicacion abajoDerecha(Ubicacion actual) {
        return new Ubicacion (actual.getPosicionEnX()+1, actual.getPosicionEnY()+1);
    }
}
