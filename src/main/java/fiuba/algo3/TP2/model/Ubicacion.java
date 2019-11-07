package fiuba.algo3.TP2.model;

public class Ubicacion {

    private int posicionX;
    private int posicionY;

    public Ubicacion( int posicionX, int posicionY ){
        this.posicionX = posicionX;
        this.posicionY = posicionY;
    }

    public int darPosicionEnX (){
        return posicionX;
    }

    public int darPosicionEnY (){
        return posicionY;
    }
}
