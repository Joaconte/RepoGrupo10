package pieza.tipos;

import pieza.Pieza;
import pieza.ataque.PiezaAtacante;

public class Jinete extends PiezaAtacante {
    static final int COSTO = 3;
    static final int VIDA_MAXIMA = 100;
    static final int DANIO_CUERPO = 5;
    static final int DANIO_MEDIO = 15;
    static final int DANIO_DISTANCIA = 0;
    private int cantidadEnemigosCerca = 0;
    private int cantidadAliadosCerca = 0;
    private boolean estaAsediado=false;

    public Jinete() {
        super.setVida_Maxima(VIDA_MAXIMA);
        super.setVida(VIDA_MAXIMA);
        super.setCosto(COSTO);
        super.enZonaAliada();
        super.puedeCurarse();
        super.setModoAtaqueCuerpoCuerpo();
        super.setModoAtaqueMedio();
        super.setDanioCuerpoCuerpo(DANIO_CUERPO);
        super.setDanioMedio(DANIO_MEDIO);
        super.setDanioADistancia(DANIO_DISTANCIA);
        super.puedeMoverse();
    }

    public void analizarCercanias(Pieza piezaQueAsedia){
        this.cantidadEnemigosCerca += Boolean.compare(this.esEnemigo(piezaQueAsedia),true);
        this.cantidadAliadosCerca += Boolean.compare((!this.esEnemigo(piezaQueAsedia) && piezaQueAsedia.getCosto()==1),true);
    }

    public void confirmarModo(){
        super.setModoAtaqueMedio();
        estaAsediado=false;
        if (cantidadEnemigosCerca >0 && cantidadAliadosCerca == 0){
            super.setModoAtaqueCuerpoCuerpo();
            estaAsediado=true;
        }
    }

    public void setearEstados(){
        this.cantidadAliadosCerca = 0;
        this.cantidadEnemigosCerca = 0;
        this.estaAsediado = false;
    }

    public boolean esAsediado(){
        confirmarModo();
        return estaAsediado;
    }
}

