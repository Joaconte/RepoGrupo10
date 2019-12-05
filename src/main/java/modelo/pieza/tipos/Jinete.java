package modelo.pieza.tipos;

import modelo.pieza.Pieza;
import modelo.pieza.UnidadEstaMuertaException;
import modelo.pieza.ataque.*;
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
    static final IModoSanacion MODO_CURACION = new SanacionNormal();
    static final IModoAtaqueVariable ATAQUE = new AtaqueVariable();
    String sonidoAtaque;


    public Jinete(int equipo, int posX, int posY){
        super(COSTO, VIDA_MAXIMA, equipo,   MODO_CURACION, ATAQUE,DANIO_CUERPO, DANIO_MEDIO,DANIO_DISTANCIA, posX, posY);
    }

    public Jinete(){
        super(COSTO, VIDA_MAXIMA, 0,   MODO_CURACION, ATAQUE,DANIO_CUERPO, DANIO_MEDIO,DANIO_DISTANCIA, 0, 0);
    }


    @Override
    public void atacar(Pieza atacada, Tablero tablero) throws UnidadEstaMuertaException, DistanciaDeAtaqueInvalidaException, PiezaAliadaNoAtacableException {
        obtenerModoDeAtaque(tablero);
        super.atacar(atacada, tablero);
    }


    public void obtenerModoDeAtaque(Tablero tablero) {
        List<Pieza> piezas = tablero.getPiezasAdyacentesDentroDeRadio(this.ubicacion,2);
        long aliados=piezas.stream().filter(pieza -> !pieza.esEnemigo(this)&& pieza.esRefuerzoDeJinete()).count();
        long enemigos=piezas.stream().filter(pieza -> pieza.esEnemigo(this)).count();
        setModo(aliados, enemigos);
    }

    public void setModo(long aliados, long enemigos){
        if ((aliados>0) || enemigos==0){
            ATAQUE.setModoDeAtaque(new AtaqueMedio());
            sonidoAtaque = "flecha";
        }
        else {
            ATAQUE.setModoDeAtaque(new AtaqueCuerpoACuerpo());
            sonidoAtaque = "espada";
        }
    }

    @Override
    public String getSonidoAtaque(){return sonidoAtaque;}


    @Override
    public boolean esRefuerzoDeJinete() {
        return false;
    }
}
