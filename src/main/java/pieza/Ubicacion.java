package pieza;

public class Ubicacion {

    private int posicionX;
    private int posicionY;

    public Ubicacion( int posicionX, int posicionY ){
     this.posicionX = posicionX;
     this.posicionY = posicionY;
    }

    public int getPosicionX(){return posicionX; }
    public int getPosicionY(){return posicionY; }

    public int darPosicionEnX (){
        return posicionX;
    }

    public int darPosicionEnY (){
        return posicionY;
    }

}