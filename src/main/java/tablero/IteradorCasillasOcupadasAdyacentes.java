package tablero;

import pieza.Ubicacion;

import java.util.ArrayList;
import java.util.List;

public class IteradorCasillasOcupadasAdyacentes extends IteradorDeAdyacencias {

    private ArrayList<Casilla> listadoDeCasillaOcupadas;
    private ArrayList<Ubicacion> siguientesUbicaciones;
    private int cantidadColumnas =20;
    private int cantidadFilas = 20;

     /*----------Inicializadores-----------*/

    public IteradorCasillasOcupadasAdyacentes(){
        this.listadoDeCasillaOcupadas = new ArrayList<>();
        this.siguientesUbicaciones = new ArrayList<>();
    }

    /*----------------Setter y Getter- -----------*/

    public  ArrayList<Ubicacion> getSiguientesUbicaciones(){ return this.siguientesUbicaciones;}

    public void setCantidadFilas(int cantidadFilas){this.cantidadFilas = cantidadFilas;}

    public void setCantidadColumnas(int cantidadColumnas){this.cantidadColumnas = cantidadColumnas;}

    /*----------------Busqueda--------------*/

    public ArrayList<Casilla> buscarCasillasOcupadasAdyacentes(Ubicacion ubicacion, List<Columna> columnas, Casilla casilla){
        listadoDeCasillaOcupadas.clear();
        ArrayList<Casilla> resultado = buscarOcupadasYAdyacentes(ubicacion, columnas, casilla);
        desmarcarCasillasVisitadas();
        return resultado;
    }

    public ArrayList<Casilla> buscarOcupadasYAdyacentes(Ubicacion ubicacion, List<Columna> columnas, Casilla casillaActual){
        casillaActual.setFueRevisada(true);
        this.actualizarSiguienteUbicaciones(ubicacion);

        for (int i = 0; i<siguientesUbicaciones.size() ; i++){
            Ubicacion ubicacionSiguiente = siguientesUbicaciones.get(i);
            Casilla casillaSiguiente = getCasillaMedianteUbicacion(ubicacionSiguiente,columnas);
             if (estaOcupadaLaCasilla(casillaSiguiente) && !fueVisitada(casillaSiguiente)){
                IteradorCasillasOcupadasAdyacentes iterador = new IteradorCasillasOcupadasAdyacentes();
                iterador.setCantidadFilas(cantidadFilas);
                iterador.setCantidadColumnas(cantidadColumnas);
                listadoDeCasillaOcupadas.addAll(iterador.buscarOcupadasYAdyacentes(ubicacionSiguiente,columnas,casillaSiguiente));
            }
        }
        listadoDeCasillaOcupadas.add(casillaActual);;
        return  listadoDeCasillaOcupadas;
    }


    /*----------------Ubicacion--------------*/


    public void actualizarSiguienteUbicaciones(Ubicacion ubicacion) {
        this.siguientesUbicaciones.clear();
        this.posicionActualEnX = ubicacion.getPosicionEnX();
        this.posicionActualEnY = ubicacion.getPosicionEnY();

        this.siguientesUbicaciones.add(getUbicacionAlEste());
        this.siguientesUbicaciones.add(getUbicacionAlOeste());
        this.siguientesUbicaciones.add(getUbicacionAlNoreste());
        this.siguientesUbicaciones.add(getUbicacionAlNoroeste());
        this.siguientesUbicaciones.add(getUbicacionAlSureste());
        this.siguientesUbicaciones.add(getUbicacionAlSuroeste());
        this.siguientesUbicaciones.add(getUbicacionAlSur());
        this.siguientesUbicaciones.add(getUbicacionAlNorte());

        for (int posicionEnLista=this.siguientesUbicaciones.size()-1; posicionEnLista>-1; posicionEnLista--){
            Ubicacion ubicacionSiguiente = (this.siguientesUbicaciones.get(posicionEnLista));
            if (!esValidaLaUbicacion(ubicacionSiguiente)){this.siguientesUbicaciones.remove(posicionEnLista);}
        }
    }

    public boolean esValidaLaUbicacion(Ubicacion ubicacion){
        boolean esCorrectaPosicionEnX = (ubicacion.getPosicionEnX()>(0) && ubicacion.getPosicionEnX()< cantidadColumnas +1);
        boolean esCorrectaPosicionEnY = (ubicacion.getPosicionEnY()>(0) && ubicacion.getPosicionEnY()< cantidadFilas +1);
        return (esCorrectaPosicionEnX && esCorrectaPosicionEnY);
    }

    /*-----------------Obtencion-Casillas--------------*/

    public Casilla getCasillaMedianteUbicacion(Ubicacion ubicacion, List<Columna> columnas) {
        int posicionColumna = ubicacion.getPosicionEnX();
        int posicionEnFila = ubicacion.getPosicionEnY();
        return columnas.get(posicionColumna-1).getCasilla(posicionEnFila);
    }

    public boolean estaOcupadaLaCasilla(Casilla casilla){
        return (casilla.getEstado() == "Ocupada");
    }

    public boolean fueVisitada(Casilla casilla){
        return casilla.getFueRevisada();
    }

    public void desmarcarCasillasVisitadas(){
        for (int posicionEnLista=0; posicionEnLista<listadoDeCasillaOcupadas.size(); posicionEnLista++){
            listadoDeCasillaOcupadas.get(posicionEnLista).setFueRevisada(false);
        }
    }
}
