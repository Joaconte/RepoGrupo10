package mock;

import model.Ubicacion;
import model.Unidad;

public class UnidadMock extends Unidad {

    private int vida;
    private int costo;
    private Ubicacion ubicacion;

    public UnidadMock(){}
    public UnidadMock(int costo){
        this.costo = costo;
    }

    @Override
    public int getCosto() {
        return costo;
    }
}
