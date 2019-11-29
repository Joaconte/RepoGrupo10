package modelo.pieza.tipos;

import modelo.pieza.Pieza;
import modelo.pieza.UnidadEstaMuertaException;
import modelo.pieza.ataque.*;
import modelo.pieza.movimiento.IModoMovimiento;
import modelo.pieza.movimiento.SeMueveEnTodasDirecciones;
import modelo.pieza.sanacion.IModoSanacion;
import modelo.pieza.sanacion.SanacionNormal;
import modelo.tablero.Tablero;

import java.util.List;

public class Jinete extends PiezaAtacante {
    static final int COSTO = 3;
    static final int VIDA_MAXIMA = 100;
    static final int DANIO_CUERPO = 5;
    static final int DANIO_MEDIO =15;
    static final int DANIO_DISTANCIA = 0;
    static final IModoMovimiento MOVIMIENTO = new SeMueveEnTodasDirecciones();
    static final IModoSanacion MODO_CURACION = new SanacionNormal();
    static final IModoAtaqueVariable ATAQUE = new AtaqueVariable();


    public Jinete(int equipo, int posX, int posY){
        super(COSTO, VIDA_MAXIMA, equipo, MOVIMIENTO,  MODO_CURACION, ATAQUE,DANIO_CUERPO, DANIO_MEDIO,DANIO_DISTANCIA, posX, posY);
    }


    @Override
    public void atacar(Pieza atacada, Tablero tablero) throws UnidadEstaMuertaException, DistanciaDeAtaqueInvalidaException, PiezaAliadaNoAtacableException {
        if(!this.esEnemigo(atacada)){ throw new PiezaAliadaNoAtacableException();}
        obtenerModoDeAtaque(tablero, atacada);
        ATAQUE.atacar(this, atacada);
    }


    public void obtenerModoDeAtaque(Tablero tablero, Pieza atacada) {
        // usar stream() como en otro lado
        List<Pieza> piezas = tablero.getPiezasAdyacentes(this.ubicacion);
        int aliados=0;
        int enemigos=0;
        for (int i=0; i <piezas.size(); i++ ){
            Pieza pieza = piezas.get(i);
            if ((!pieza.esEnemigo(this)) && (pieza.esRefuerzoDeJinete())){ aliados++;}
            else if (pieza.esEnemigo(this)) { enemigos++;}
        }
        setModo(aliados, enemigos);
    }

    public void setModo(int aliados, int enemigos){
        if ((aliados>0) || enemigos==0){  ATAQUE.setModoDeAtaque(new AtaqueMedio()); }
        else {ATAQUE.setModoDeAtaque(new AtaqueCuerpoACuerpo());}
    }

    @Override
    public boolean esRefuerzoDeJinete() {
        return false;
    }
}
