package modelo.pieza.movimiento;

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

    public boolean esIgual(Ubicacion ubicacion) { return (this.posicionEnX==ubicacion.getPosicionEnX() && this.posicionEnY==ubicacion.getPosicionEnY()); }


    public int getDistanciaAOtroPunto(int otraPosEnX, int otraPosEnY) {
        int posibleDistancia = Math.max (posicionEnX-otraPosEnX, otraPosEnX-posicionEnX);
        int posibleDistancia2 = Math.max(posicionEnY-otraPosEnY, otraPosEnY-posicionEnY);
        return Math.max(posibleDistancia, posibleDistancia2);
    }

    public Ubicacion desplazarA(int posFinalX, int posFinalY) {
        return new Ubicacion(posFinalX,posFinalY);
    }

    public int getDistanciaAOtroPunto(Ubicacion ubicacion) {
        return ubicacion.getDistanciaAOtroPunto(posicionEnX,posicionEnY);
    }

    public int getVariacionEnX(int posicionX) {
        return posicionX - this.posicionEnX;
    }

    public int getVariacionEnY(int posicionY) {
        return posicionY - this.posicionEnY;
    }

    public Ubicacion desplazarPorVariacion(int variacionX, int variacionY) {
        return new Ubicacion(posicionEnX + variacionX, posicionEnY + variacionY);
    }
}