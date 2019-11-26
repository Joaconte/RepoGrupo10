package pieza.movimiento;

public class Izquierda extends Direccion {
    static final int DESPLAZAMIENTO_X = -1;
    static final int DESPLAZAMIENTO_Y = 0;

    public Izquierda(){
        super(DESPLAZAMIENTO_X,DESPLAZAMIENTO_Y);
    }
}
