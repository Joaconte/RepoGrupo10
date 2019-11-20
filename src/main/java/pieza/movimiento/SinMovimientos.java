package pieza.movimiento;

import pieza.Ubicacion;

public class SinMovimientos implements IModoMovimiento {
    @Override
    public void moverUnidad(Ubicacion actual, Ubicacion miNuevaUbicacion) throws NoSePuedeMoverException{
        throw new NoSePuedeMoverException();
    }

    @Override
    public Ubicacion arriba(Ubicacion actual) throws NoSePuedeMoverException {
        throw new NoSePuedeMoverException();
    }

    @Override
    public Ubicacion abajo(Ubicacion actual) throws NoSePuedeMoverException {
        throw new NoSePuedeMoverException();
    }

    @Override
    public Ubicacion derecha(Ubicacion actual) throws NoSePuedeMoverException {
        throw new NoSePuedeMoverException();
    }

    @Override
    public Ubicacion izquierda(Ubicacion actual) throws NoSePuedeMoverException {
        throw new NoSePuedeMoverException();
    }

    @Override
    public Ubicacion arribaIzquierda(Ubicacion actual) throws NoSePuedeMoverException {
        throw new NoSePuedeMoverException();
    }

    @Override
    public Ubicacion abajoIzquierda(Ubicacion actual) throws NoSePuedeMoverException {
        throw new NoSePuedeMoverException();
    }

    @Override
    public Ubicacion arribaDerecha(Ubicacion actual) throws NoSePuedeMoverException {
        throw new NoSePuedeMoverException();
    }

    @Override
    public Ubicacion abajoDerecha(Ubicacion actual) throws NoSePuedeMoverException {
        throw new NoSePuedeMoverException();
    }
}
