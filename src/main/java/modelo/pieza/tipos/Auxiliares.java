package modelo.pieza.tipos;

import modelo.pieza.Pieza;


public class Auxiliares {
    public boolean son3Aliados(Pieza p1, Pieza p2, Pieza p3){
        return ((!p1.esEnemigo(p2))&(!p1.esEnemigo(p3))&(!p2.esEnemigo(p3)));
    }

    public boolean los3SonDeInfanteria(Pieza p1, Pieza p2, Pieza p3){
        return(p1.getClass() == Infanteria.class)&(p2.getClass()== Infanteria.class)&(p3.getClass()== Infanteria.class);
    }

    public boolean estanContiguos(Pieza p1, Pieza p2, Pieza p3){
        int distanciaP1aP2 = p1.getUbicacion().getDistanciaAOtroPunto(p2.getUbicacion());
        int distanciaP1aP3 = p1.getUbicacion().getDistanciaAOtroPunto(p3.getUbicacion());
        int distanciaP2aP3 = p2.getUbicacion().getDistanciaAOtroPunto(p3.getUbicacion());
        int distanciaTotal = distanciaP1aP2+distanciaP1aP3+distanciaP2aP3;
        return (distanciaTotal<=4);
    }

    public boolean sonAliadosDeInfanteria(Pieza p1, Pieza p2, Pieza p3){
        return ((son3Aliados(p1,p2,p3))&(los3SonDeInfanteria(p1,p2,p3)));
    }

    public boolean formanBatallon(Pieza pieza1, Pieza pieza2, Pieza pieza3){
        return (sonAliadosDeInfanteria(pieza1,pieza2,pieza3)) & (estanContiguos(pieza1,pieza2,pieza3));
    }

}
