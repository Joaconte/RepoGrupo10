package pieza.ataque;

import pieza.Pieza;

public class PiezaAtacante extends Pieza {
    private int danioCuerpoCuerpo;
    private int danioMedio;
    private int danioDistancia;

    private IModoAtaque modoAtaque;

    public void setDanioCuerpoCuerpo(int danio){
        danioCuerpoCuerpo = danio;
    }

    public void setDanioMedio(int danio){
        danioMedio = danio;
    }

    public void setDanioADistancia(int danio){
        danioDistancia = danio;
    }

    public int getDanioCuerpoCuerpo(){
        return danioCuerpoCuerpo;
    }

    public int getDanioMedio(){
        return danioMedio;
    }

    public int getDanioDistancia(){
        return danioDistancia;
    }

    public void setModoAtaqueCuerpoCuerpo(){
        modoAtaque = new AtaqueCuerpoACuerpo();
    }

    public void setModoAtaqueMedio(){
        modoAtaque = new AtaqueMedio();
    }

    public void setModoAtaqueADistancia(){
        modoAtaque = new AtaqueADistancia();
    }

    public void atacar(Pieza oponente){
        modoAtaque.atacar(this,oponente);
    }
}
