package modelo.pieza.tipos;

import modelo.jugador.UbicacionInvalidaException;
import modelo.pieza.Pieza;
import modelo.pieza.Ubicacion;
import modelo.tablero.DesplazamientoInvalidoException;
import modelo.tablero.Tablero;
import modelo.tablero.casilla.NoHayUnidadEnPosicionException;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

public class Batallon {
    private AnalizadorDeBatallon analizadorDeBatallon = new AnalizadorDeBatallon();
    private ArrayList<Pieza> soldados;

    public Batallon(ArrayList<Pieza> piezas) throws NoSirvenParaBatallonException {
        if (!analizadorDeBatallon.formanBatallon(piezas)) {
            throw new NoSirvenParaBatallonException();
        }
        soldados = piezas;
    }

    public ArrayList<Pieza> ordenarMovimiento(Tablero tablero, Ubicacion ubicacionInicial, Ubicacion ubicacionFinal) {
        ArrayList<Pieza> ordenados = new ArrayList<>();
        ArrayList<Pieza> soldadosSeguidores = new ArrayList<>(soldados);

        int variacionX = ubicacionFinal.getPosicionEnX() - ubicacionInicial.getPosicionEnX();
        int variacionY = ubicacionFinal.getPosicionEnY() - ubicacionInicial.getPosicionEnX();

        //Saco al elegido como primero.
        soldadosSeguidores.stream()
                .filter(p -> (p.getUbicacion().getPosicionEnX() == ubicacionFinal.getPosicionEnX()) && (p.getUbicacion().getPosicionEnY() == ubicacionFinal.getPosicionEnY()))
                .forEach(p -> {
                    soldadosSeguidores.remove(p);
                    ordenados.add(p);
                });
        //Saco el que es imposible mover (no existe direccion)
        soldadosSeguidores.stream()
                .filter(p -> !tablero.existePosicion(p.getUbicacion().getPosicionEnY() + variacionY, p.getUbicacion().getPosicionEnX() + variacionX))
                .forEach(soldadosSeguidores::remove);
        //Ordeno
        soldadosSeguidores.stream()
                .filter(p -> tablero.casillaEstaOcupada(p.getUbicacion().getPosicionEnY() + variacionY, p.getUbicacion().getPosicionEnX() + variacionX))
                .forEach(p -> {
                    soldadosSeguidores.remove(p);
                    soldadosSeguidores.add(p);
                });
        ordenados.addAll(soldadosSeguidores);
        return ordenados;
    }

    public void desplazaBatallonEnOrden(Tablero tablero, Ubicacion ubicacionInicial, Ubicacion ubicacionFinal) {
        ArrayList<Pieza> ordenValido = ordenarMovimiento(tablero, ubicacionInicial, ubicacionFinal);

        int variacionX = ubicacionFinal.getPosicionEnX() - ubicacionInicial.getPosicionEnX();
        int variacionY = ubicacionFinal.getPosicionEnY() - ubicacionInicial.getPosicionEnX();

        ordenValido.forEach(p -> {
            if (!tablero.casillaEstaOcupada(p.getUbicacion().getPosicionEnX() + variacionX, p.getUbicacion().getPosicionEnY() + variacionY)) {
                try { tablero.moverUnidad(p.getUbicacion(), new Ubicacion(p.getUbicacion().getPosicionEnX() + variacionX, p.getUbicacion().getPosicionEnY() + variacionY));
                } catch (NoHayUnidadEnPosicionException | DesplazamientoInvalidoException | NoSePuedeMoverException | UbicacionInvalidaException e) {
                    e.printStackTrace(); }
            }
        });
    }



    public boolean siguenContiguos(){
        return analizadorDeBatallon.estanContiguos(soldados);
    }


    public boolean contiene(Ubicacion ubicacionInicial) {
        AtomicBoolean contiene= new AtomicBoolean(false);
        soldados.forEach(p ->{ if (p.getUbicacion().getDistanciaAOtroPunto(ubicacionInicial)==0) { contiene.set(true); } });
        return contiene.get();
    }
}