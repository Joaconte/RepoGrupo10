package pieza.ataque;

import pieza.Pieza;

public class PiezaAtacante extends Pieza {
    private int danioMele;
    private int danioDistancia;

    private IModoAtaque modoAtaque;

    public void setDanioMelee(int danio){
        danioMele = danio;
    }

    public void setDanioADistancia(int danio){
        danioDistancia = danio;
    }

    public int getDanioMele(){
        return danioMele;
    }

    public int getDanioDistancia(){
        return danioDistancia;
    }

    public void setModoAtaqueMele(){
        modoAtaque = new AtaqueCuerpoACuerpo();
    }
    public void setModoAtaqueADistancia(){
        modoAtaque = new AtaqueADistancia();
    }
    public void atacar(Pieza oponente){
        modoAtaque.atacar(this,oponente);
    }
}
