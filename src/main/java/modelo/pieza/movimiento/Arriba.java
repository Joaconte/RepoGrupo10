package modelo.pieza.movimiento;

public class Arriba extends Direccion{
    static final int DESPLAZAMIENTO_X = 0;
    static final int DESPLAZAMIENTO_Y = -1;
    public Arriba(){
        super(DESPLAZAMIENTO_X,DESPLAZAMIENTO_Y);
    }
}
