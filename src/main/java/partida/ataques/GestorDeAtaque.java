package partida.ataques;

import jugador.Jugador;
import pieza.Pieza;
import pieza.ataque.PiezaAtacante;
import pieza.tipos.Catapulta;
import pieza.tipos.Infanteria;
import pieza.tipos.Jinete;

public class GestorDeAtaque {

    private boolean jugadorYaAtaco = false;
    private RangoDeAtaque rangoDeAtaque;
    int distanciaMediaMaxima = 5;
    int distanciaCercanaMaxima = 2;
    int distanciaMaxima = 20;

    /*------------Setters-------------*/

    public void setJugadorYaAtaco(boolean jugadorYaAtaco) {
        this.jugadorYaAtaco = jugadorYaAtaco;
    }
    public void setRangoDeAtaque(RangoDeAtaque rangoDeAtaque) {
        this.rangoDeAtaque = rangoDeAtaque;
    }

   /*------------Ataques -------------*/


    public void atacar(Catapulta atacante, Pieza atacada) throws PiezaAtacadaEnRangoIncorrectoException{
        try{
            this.definirRango(atacante, atacada);
            this.rangoDeAtaque.atacar(atacante,atacada);
            this.setJugadorYaAtaco(true);}
        catch (RangoDeDistanciaInvalidoException e){}
    }

    public void atacar(Infanteria atacante, Pieza atacada) throws PiezaAtacadaEnRangoIncorrectoException{
        try{
            this.definirRango(atacante, atacada);
            this.rangoDeAtaque.atacar(atacante,atacada);
            this.setJugadorYaAtaco(true);}
        catch (RangoDeDistanciaInvalidoException e){ }
    }

    public void atacar(Jinete atacante, Pieza atacada) throws PiezaAtacadaEnRangoIncorrectoException,JineteAsediadoException,JineteNoAsediadoException {
        try{
            this.definirRango(atacante, atacada);
            this.rangoDeAtaque.atacar(atacante,atacada);
            this.setJugadorYaAtaco(true);}
        catch (RangoDeDistanciaInvalidoException e){}
    }


    /* ------ Calculos De Distancia -------*/

    private boolean esAtaqueADistancia(int distanciaEntrePiezas){
        return (distanciaEntrePiezas>distanciaMediaMaxima && distanciaEntrePiezas<distanciaMaxima);
    }
    private boolean esAtaqueCuerpoACuerpo(int distanciaEntrePiezas){
        return (distanciaEntrePiezas<=distanciaCercanaMaxima && distanciaEntrePiezas >0);
    }
    private boolean esAtaqueMedio(int distanciaEntrePiezas) {
        return (distanciaEntrePiezas>distanciaCercanaMaxima && distanciaEntrePiezas<=distanciaMediaMaxima);
    }
    private int getDistanciaEntreAtacantes(PiezaAtacante atacante, Pieza atacada){
        return atacante.getUbicacion().getDistanciaAOtroPunto(atacada.getUbicacion());
    }


   /* ------ Definir Rango -----------*/

    public void definirRango(PiezaAtacante atacante, Pieza atacada) throws RangoDeDistanciaInvalidoException {

       int distanciaEntrePiezas = this.getDistanciaEntreAtacantes(atacante, atacada);

       if (esAtaqueADistancia(distanciaEntrePiezas)){
           setRangoDeAtaque(new RangoLargo());
       }
       else if (esAtaqueCuerpoACuerpo(distanciaEntrePiezas)){
           setRangoDeAtaque(new RangoCorto());
       }
       else if (esAtaqueMedio(distanciaEntrePiezas)){
           setRangoDeAtaque(new RangoMedio());
       }
       else throw new RangoDeDistanciaInvalidoException();
   }

}
