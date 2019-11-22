package pieza.tipos;

import pieza.Pieza;
import pieza.UnidadEstaMuertaException;
import pieza.ataque.*;
import pieza.movimiento.IModoMovimiento;
import pieza.movimiento.SeMueveEnTodasDirecciones;
import pieza.sanacion.IModoSanacion;
import pieza.sanacion.SanacionNormal;
import tablero.Tablero;

public class Jinete extends PiezaAtacante {
    static final int COSTO = 3;
    static final int VIDA_MAXIMA = 100;
    static final int DANIO_CUERPO = 5;
    static final int DANIO_MEDIO =0;
    static final int DANIO_DISTANCIA = 0;
    static final IModoMovimiento MOVIMIENTO = new SeMueveEnTodasDirecciones();
    static final IModoSanacion MODO_CURACION = new SanacionNormal();
    static final IModoAtaque MODO_ATAQUE = new AtaqueVariable();

    public Jinete(int equipo) {
        super(COSTO, VIDA_MAXIMA, VIDA_MAXIMA, equipo, MOVIMIENTO,  MODO_CURACION, MODO_ATAQUE,DANIO_CUERPO, DANIO_MEDIO,DANIO_DISTANCIA);
    }


    @Override
    public void atacar(Pieza atacada, Tablero tablero) throws UnidadEstaMuertaException, DistanciaDeAtaqueInvalidaException, PiezaAliadaNoAtacableException {
        if(!this.esEnemigo(atacada)){ throw new PiezaAliadaNoAtacableException();}
        obtenerModoDeAtaque(tablero);
        super.ejecutarUnModoDeAtaque(atacada);
    }


    public void obtenerModoDeAtaque(Tablero tablero) {
        boolean estaAsediado=false;
        Object[] piezas = tablero.getPiezasAdyacentes(this.ubicacion);
        if (piezas.length!=0){estaAsediado=true;}

        for (int i=0; i <piezas.length; i++ ){
            Pieza pieza = (Pieza) piezas[i];
            if ((!this.esEnemigo(pieza)) && pieza.getCosto() == 1){ estaAsediado=false; }
        }

        if (estaAsediado){ MODO_ATAQUE.setModoAtaque(new AtaqueCuerpoACuerpo()); }
        else {MODO_ATAQUE.setModoAtaque(new AtaqueMedio());}
    }



}
