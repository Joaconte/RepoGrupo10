package tablero;

import pieza.Pieza;
import pieza.Ubicacion;

import java.util.ArrayList;
import java.util.List;

public class BuscadorDePiezasAdyacentes extends IteradorDeAdyacencias {
    private List<Columna> listadoDeColumnas;
    private List<Pieza> listadoDePiezasEncontradas;
    private List<Ubicacion> siguientesUbicaciones = new ArrayList<Ubicacion>();
    private Casilla casillaActual;


    public BuscadorDePiezasAdyacentes(Casilla casillaActual, List<Pieza> lista, List<Columna> columnas){
        this.listadoDePiezasEncontradas = lista;
        this.listadoDeColumnas = columnas;
        this.casillaActual =  casillaActual;
    }

    public List<Pieza> realizarLaBusqueda(){
        Ubicacion ubicacionActual = getUbicacionActual();
        listadoDePiezasEncontradas = pedirPiezaACasilla(casillaActual);
        obtenerSiguientesUbicacionesValidas();

        for (int posicionEnLista=0; posicionEnLista<siguientesUbicaciones.size(); posicionEnLista++) {
            Ubicacion ubicacionSiguiente = (siguientesUbicaciones.get(posicionEnLista));
            Casilla casillaSiguiente = getCasillaMedianteUbicacion(ubicacionSiguiente);
            if (!fueVisitada(casillaSiguiente) && estaOcupadaLaCasilla(casillaSiguiente)) {
                BuscadorDePiezasAdyacentes nuevaBusqueda = new BuscadorDePiezasAdyacentes(casillaSiguiente, listadoDePiezasEncontradas, listadoDeColumnas);
                listadoDePiezasEncontradas=nuevaBusqueda.realizarLaBusqueda();
            }
        }
        return listadoDePiezasEncontradas;
    }

    public boolean esValidaLaUbicacion(Ubicacion ubicacion){
        boolean esCorrectaPosicionEnX = ubicacion.getPosicionEnX()>(0) && ubicacion.getPosicionEnX()<21;
        boolean esCorrectaPosicionEnY = ubicacion.getPosicionEnY()>(0) && ubicacion.getPosicionEnY()<21;
        return (esCorrectaPosicionEnX && esCorrectaPosicionEnY);
    }

    public Casilla getCasillaMedianteUbicacion(Ubicacion ubicacion) {
        int posicionColumna = ubicacion.getPosicionEnX();
        int posicionEnFila = ubicacion.getPosicionEnY();
        return listadoDeColumnas.get(posicionColumna-1).getCasilla(posicionEnFila);
    }


    public boolean estaOcupadaLaCasilla(Casilla casilla){
        return (casilla.getEstado() == "Ocupada");
    }

    public boolean fueVisitada(Casilla casilla){
        return casilla.getFueRevisada();
    }


    public List <Pieza> pedirPiezaACasilla(Casilla casilla) {
        return casilla.getContenido(listadoDePiezasEncontradas);
    }

    public void obtenerSiguientesUbicacionesValidas() {
        siguientesUbicaciones.add(getUbicacionAlEste());
        siguientesUbicaciones.add(getUbicacionAlOeste());
        siguientesUbicaciones.add(getUbicacionAlNoreste());
        siguientesUbicaciones.add(getUbicacionAlNoroeste());
        siguientesUbicaciones.add(getUbicacionAlSureste());
        siguientesUbicaciones.add(getUbicacionAlSuroeste());
        siguientesUbicaciones.add(getUbicacionAlSur());
        siguientesUbicaciones.add(getUbicacionAlNorte());

        for (int posicionEnLista=0; posicionEnLista<siguientesUbicaciones.size(); posicionEnLista++){
            Ubicacion ubicacionSiguiente = (siguientesUbicaciones.get(posicionEnLista));
            if (!esValidaLaUbicacion(ubicacionSiguiente)){siguientesUbicaciones.remove(posicionEnLista);}
        }
    }
}
