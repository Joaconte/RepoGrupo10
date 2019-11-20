package pieza.ataque;

import pieza.Pieza;
import pieza.tipos.Catapulta;
import pieza.tipos.Infanteria;
import pieza.tipos.Jinete;

public class GestorDeAtaque {

    private int distanciaCercanaMaxima=2;
    private int distanciaMediaMaxima=5;


    public void atacar(Catapulta atacante, Pieza atacada) {
        int distanciaEntreAtacantes = getDistanciaEntreAtacantes(atacante,atacada);
        if (estanMuyLejos(distanciaEntreAtacantes))
            atacante.atacar(atacada);
    }

    public void atacar(Infanteria atacante, Pieza atacada) {
        int distanciaEntreAtacantes = getDistanciaEntreAtacantes(atacante,atacada);
        if (estanMuyCerca(distanciaEntreAtacantes))
            atacante.atacar(atacada);
    }

    public void atacar(Jinete atacante, Pieza atacada, boolean estaApoyado) {
        int distanciaEntreAtacantes = getDistanciaEntreAtacantes(atacante,atacada);
        if (estaApoyado && !estanMuyCerca(distanciaEntreAtacantes) && !estanMuyLejos(distanciaEntreAtacantes)){
            atacante.setModoAtaqueMedio();
            atacante.atacar(atacada);
        }
        else if (!estaApoyado && estanMuyCerca(distanciaEntreAtacantes)){
            atacante.setModoAtaqueCuerpoCuerpo();
            atacante.atacar(atacada);
        }

    }

    private boolean estanMuyLejos(int distanciaReal){
        return distanciaReal>distanciaMediaMaxima;
    }

    private boolean estanMuyCerca(int distanciaReal){
        return distanciaReal<=distanciaCercanaMaxima;
    }

    private int getDistanciaEntreAtacantes(PiezaAtacante atacante, Pieza atacada){
        return atacante.getUbicacion().getDistanciaAOtroPunto(atacada.getUbicacion());
    }


}
