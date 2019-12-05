package modelo.pieza.movimiento;

import modelo.pieza.Ubicacion;

public abstract class Direccion {
    private int desplazamientoEnX;
    private int desplazamientoEnY;

    public Direccion(int desplazamientoEnX, int desplazamientoEnY) {
        this.desplazamientoEnX = desplazamientoEnX;
        this.desplazamientoEnY = desplazamientoEnY;
    }

    public int getDesplazamientoEnX() {
        return desplazamientoEnX;
    }

    public int getDesplazamientoEnY() {
        return desplazamientoEnY;
    }

    public Ubicacion mover(Ubicacion ubicacion) {
        return ubicacion.desplazar(this.desplazamientoEnX, this.desplazamientoEnY);
    }
}
