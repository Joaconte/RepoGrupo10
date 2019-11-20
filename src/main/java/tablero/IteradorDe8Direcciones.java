package tablero;

import pieza.Ubicacion;

import java.util.ArrayList;

public abstract class IteradorDe8Direcciones {

    protected int posicionActualEnY;
    protected int posicionActualEnX;
    protected ArrayList<Ubicacion> siguientesUbicaciones = new ArrayList<>();
    protected int cantidadColumnas =20;
    protected int cantidadFilas = 20;


    public Ubicacion getUbicacionAlNorte(){
        Ubicacion ubicacion = new Ubicacion(posicionActualEnX,posicionActualEnY+1);
        return ubicacion;
    }

    public Ubicacion getUbicacionAlSur(){
        Ubicacion ubicacion = new Ubicacion(posicionActualEnX,posicionActualEnY-1);
        return ubicacion;
    }

    public Ubicacion getUbicacionAlEste(){
        Ubicacion ubicacion = new Ubicacion(posicionActualEnX+1,posicionActualEnY);
        return ubicacion;
    }

    public Ubicacion getUbicacionAlOeste(){
        Ubicacion ubicacion = new Ubicacion(posicionActualEnX-1,posicionActualEnY);
        return ubicacion;
    }

    public Ubicacion getUbicacionAlNoroeste(){
        Ubicacion ubicacion = new Ubicacion (posicionActualEnX-1,posicionActualEnY+1);
        return ubicacion;
    }

    public Ubicacion getUbicacionAlNoreste(){
        Ubicacion ubicacion = new Ubicacion (posicionActualEnX+1,posicionActualEnY+1);
        return ubicacion;
    }

    public Ubicacion getUbicacionAlSuroeste(){
        Ubicacion ubicacion = new Ubicacion (posicionActualEnX-1,posicionActualEnY-1);
        return ubicacion;
    }

    public Ubicacion getUbicacionAlSureste(){
        Ubicacion ubicacion = new Ubicacion (posicionActualEnX+1,posicionActualEnY-1);
        return ubicacion;
    }

    public Ubicacion getUbicacionActual(){
        Ubicacion ubicacion = new Ubicacion (posicionActualEnX,posicionActualEnY);
        return ubicacion;
    };

    public void registrarSiguientesUbicaciones(Ubicacion ubicacion) {
        posicionActualEnX = ubicacion.getPosicionEnX();
        posicionActualEnY = ubicacion.getPosicionEnY();

        siguientesUbicaciones.add(getUbicacionAlEste());
        siguientesUbicaciones.add(getUbicacionAlOeste());
        siguientesUbicaciones.add(getUbicacionAlNoreste());
        siguientesUbicaciones.add(getUbicacionAlNoroeste());
        siguientesUbicaciones.add(getUbicacionAlSureste());
        siguientesUbicaciones.add(getUbicacionAlSuroeste());
        siguientesUbicaciones.add(getUbicacionAlSur());
        siguientesUbicaciones.add(getUbicacionAlNorte());

        for (int i=this.siguientesUbicaciones.size()-1; i>-1; i--){
            Ubicacion ubicacionSiguiente = (this.siguientesUbicaciones.get(i));
            if (!esValidaLaUbicacion(ubicacionSiguiente)){this.siguientesUbicaciones.remove(i);}
        }
    }

    public boolean esValidaLaUbicacion(Ubicacion ubicacion){
        boolean esCorrectaPosicionEnX = (ubicacion.getPosicionEnX()>(0) && ubicacion.getPosicionEnX()< cantidadColumnas +1);
        boolean esCorrectaPosicionEnY = (ubicacion.getPosicionEnY()>(0) && ubicacion.getPosicionEnY()< cantidadFilas +1);
        return (esCorrectaPosicionEnX && esCorrectaPosicionEnY);
    }

    public void setCantidadFilas(int cantidadFilas){this.cantidadFilas = cantidadFilas;}

    public void setCantidadColumnas(int cantidadColumnas){this.cantidadColumnas = cantidadColumnas;}

    public  ArrayList<Ubicacion> getSiguientesUbicaciones(){ return this.siguientesUbicaciones;}

}
