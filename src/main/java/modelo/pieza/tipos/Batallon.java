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

        ArrayList<Pieza> soldados = new ArrayList<>(this.soldados);
        ArrayList<Pieza> listadoAuxiliar = new ArrayList<>();

        int variacionX = ubicacionFinal.getPosicionEnX() - ubicacionInicial.getPosicionEnX();
        int variacionY = ubicacionFinal.getPosicionEnY() - ubicacionInicial.getPosicionEnY();

        //Saco al elegido como primero. (Puede ser cualquiera de los 3)
        soldados.stream().filter(p -> p.getUbicacion().esIgual(ubicacionInicial)).forEach(listadoAuxiliar::add);
        soldados.remove(listadoAuxiliar.get(0));

        //quito los que se mueven a direcciones inexistentes. (diagonales)
        soldados.stream().filter(p->tablero.existePosicion(p.getUbicacion().getPosicionEnY()+variacionY,p.getUbicacion().getPosicionEnX()+variacionX)==true)
                .forEach(p->listadoAuxiliar.add(p));
        soldados.clear();
        soldados.add(listadoAuxiliar.get(0));
        listadoAuxiliar.remove(0);


        listadoAuxiliar.stream().filter(p->( tablero.casillaEstaOcupada(p.getUbicacion().getPosicionEnX()+variacionX,p.getUbicacion().getPosicionEnY()+variacionY) == false))
                .forEach(soldados::add);
        listadoAuxiliar.stream().filter(p ->! soldados.contains(p)).forEach(soldados::add);
        return soldados;
    }

    public void desplazaBatallonEnOrden(Tablero tablero, Ubicacion ubicacionInicial, Ubicacion ubicacionFinal) {
        ArrayList<Pieza> ordenValido = ordenarMovimiento(tablero, ubicacionInicial, ubicacionFinal);

        int variacionX = ubicacionFinal.getPosicionEnX() - ubicacionInicial.getPosicionEnX();
        int variacionY = ubicacionFinal.getPosicionEnY() - ubicacionInicial.getPosicionEnY();

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