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
    static final IModoAtaque ATAQUE = new AtaqueVariable();


    public Jinete(int equipo, int posX, int posY){
        super(COSTO, VIDA_MAXIMA, equipo, MOVIMIENTO,  MODO_CURACION, ATAQUE,DANIO_CUERPO, DANIO_MEDIO,DANIO_DISTANCIA, posX, posY);
    }


    @Override
    public void atacar(Pieza atacada, Tablero tablero) throws UnidadEstaMuertaException, DistanciaDeAtaqueInvalidaException, PiezaAliadaNoAtacableException {
        if(!this.esEnemigo(atacada)){ throw new PiezaAliadaNoAtacableException();}
        obtenerModoDeAtaque(tablero, atacada);
        ATAQUE.atacar(this, atacada ,this.ubicacion.getDistanciaAOtroPunto(atacada.getUbicacion()));
    }

    @Override
    public String getNombre(){ return "Jinete";}


    public void obtenerModoDeAtaque(Tablero tablero, Pieza atacada) {
        List<Pieza> piezas = tablero.getPiezasAdyacentes(this.ubicacion);
        int aliados=0;
        int enemigos=0;
        for (int i=0; i <piezas.size(); i++ ){
            Pieza pieza = piezas.get(i);
            if ((!pieza.esEnemigo(this)) && (pieza.getNombre() == "Infanteria")){ aliados++;}
            else if (pieza.esEnemigo(this)) { enemigos++;}
        }
        setModo(aliados, enemigos, this.ubicacion.getDistanciaAOtroPunto(atacada.getUbicacion()));
    }

    public void setModo(int aliados, int enemigos, int distancia){
        if ((aliados>0 && distancia>2) || enemigos==0){  ATAQUE.setModoAtaque(new AtaqueMedio()); }
        else {ATAQUE.setModoAtaque(new AtaqueCuerpoACuerpo());}
    }

}
