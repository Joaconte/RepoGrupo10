package modelo.pieza;

public class Ubicacion {

    private int posicionEnX;
    private int posicionEnY;

    public Ubicacion(int posicionEnX, int posicionEnY) {
        this.posicionEnX = posicionEnX;
        this.posicionEnY = posicionEnY;
    }

    public int getPosicionEnX() {
        return posicionEnX;
    }

    public int getPosicionEnY() {
        return posicionEnY;
    }

    public void setPosicionEnX(int x){
        posicionEnX = x; }

    public void setPosicionEnY(int y){
        posicionEnY = y; }

    public int getDistanciaAOtroPunto(Ubicacion otraUbicacion){
        int otraPosEnY = otraUbicacion.getPosicionEnY();
        int otraPosEnX = otraUbicacion.getPosicionEnX();
        int posibleDistancia = Math.max (posicionEnX-otraPosEnX, otraPosEnX-posicionEnX);
        int posibleDistancia2 = Math.max(posicionEnY-otraPosEnY, otraPosEnY-posicionEnY);
        return Math.max(posibleDistancia, posibleDistancia2);
    }

    public Ubicacion desplazar(int despX, int despY) {
        return new Ubicacion(this.posicionEnX + despX, this.posicionEnX + despY);
    }
}