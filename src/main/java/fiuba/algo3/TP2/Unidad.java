package fiuba.algo3.TP2;

public abstract class Unidad {
    protected int costo;
    protected int vida;
    //protected Ubicacion ubicacion;

    public int getCosto(){
        return costo;
    }

    public int getPuntosVida(){
        return vida;
    }

    public void recibirDanio(int danio) {
        if (vida <= 0) {
            throw new fiuba.algo3.TP2.UnidadEstaMuertaException();
        }
        vida -= danio;
    }
}

