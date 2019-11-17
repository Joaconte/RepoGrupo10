package tablero;

import pieza.Ubicacion;

public abstract class IteradorDeAdyacencias {

    protected int posicionActualEnY;
    protected int posicionActualEnX;


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
        Ubicacion ubicacion = new Ubicacion (posicionActualEnX+1,posicionActualEnY+1);
        return ubicacion;
    }

    public Ubicacion getUbicacionActual(){
        Ubicacion ubicacion = new Ubicacion (posicionActualEnX,posicionActualEnY);
        return ubicacion;
    };

}
