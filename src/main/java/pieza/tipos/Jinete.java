package pieza.tipos;

import pieza.Pieza;
import pieza.UnidadEstaMuertaException;
import pieza.ataque.*;
import pieza.movimiento.IModoMovimiento;
import pieza.movimiento.SeMueveEnTodasDirecciones;
import pieza.sanacion.IModoSanacion;
import pieza.sanacion.SanacionNormal;
import tablero.Tablero;

import java.util.ArrayList;
import java.util.List;

public class Jinete extends PiezaAtacante {
    static final int COSTO = 3;
    static final int VIDA_MAXIMA = 100;
    static final int DANIO_CUERPO = 5;
    static final int DANIO_MEDIO =15;
    static final int DANIO_DISTANCIA = 0;
    static final IModoMovimiento MOVIMIENTO = new SeMueveEnTodasDirecciones();
    static final IModoSanacion MODO_CURACION = new SanacionNormal();
    static final IModoAtaque ATAQUE = new AtaqueVariable();

    public Jinete(int equipo) {
        super(COSTO, VIDA_MAXIMA, VIDA_MAXIMA, equipo, MOVIMIENTO,  MODO_CURACION, ATAQUE,DANIO_CUERPO, DANIO_MEDIO,DANIO_DISTANCIA);
    }


    @Override
    public void atacar(Pieza atacada, Tablero tablero) throws UnidadEstaMuertaException, DistanciaDeAtaqueInvalidaException, PiezaAliadaNoAtacableException {
        if(!this.esEnemigo(atacada)){ throw new PiezaAliadaNoAtacableException();}
        obtenerModoDeAtaque(tablero);
        ATAQUE.atacar(this, atacada ,this.ubicacion.getDistanciaAOtroPunto(atacada.getUbicacion()));
    }


    public void obtenerModoDeAtaque(Tablero tablero) {
        boolean estaAsediado=false;
        List<Pieza> piezas = tablero.getPiezasAdyacentes(this.ubicacion);

        if (piezas.size()!=0){estaAsediado=true;}
        for (int i=0; i <piezas.size(); i++ ){
            Pieza pieza = (Pieza) piezas.get(i);
            if ((!this.esEnemigo(pieza)) && pieza.getCosto() == 1){ estaAsediado=false; }
        }
        if (estaAsediado){  setModoCuerpoCuerpo(); }
        else {setModoMedio();}
    }

    public void setModoMedio(){
        ATAQUE.setModoAtaque(new AtaqueMedio());
    }

    public void setModoCuerpoCuerpo(){
        ATAQUE.setModoAtaque(new AtaqueCuerpoACuerpo());
    }


}
