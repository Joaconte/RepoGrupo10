package pieza.movimiento;

import pieza.Ubicacion;

public interface IModoMovimiento {
    void moverUnidad(Ubicacion actual, Ubicacion miNuevaUbicacion) throws NoSePuedeMoverException;

    Ubicacion arriba(Ubicacion actual) throws NoSePuedeMoverException;

    Ubicacion abajo(Ubicacion actual) throws NoSePuedeMoverException;

    Ubicacion derecha(Ubicacion actual) throws NoSePuedeMoverException;

    Ubicacion izquierda(Ubicacion actual) throws NoSePuedeMoverException;
}
