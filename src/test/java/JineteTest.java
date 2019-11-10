package test;

import fiuba.algo3.TP2.model.*;
import fiuba.algo3.TP2.model.Unidad;
import fiuba.algo3.TP2.model.Ubicacion;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class JineteTest {
    @Test
    public void test01JineteTieneCosto1() {
        Jinete jinete = new Jinete();
        assertEquals(3, jinete.getCosto());
    }

    @Test
    public void test02JineteIniciaCon100PuntosDeVida() {
        Jinete jinete = new Jinete();
        assertEquals(100, jinete.getPuntosVida(),0.05);
    }

   /* @Test
    public void test03JineteSeMueveCorrectamenteACualquierDireccionQueMePasen() {
        Jinete jinete = new Jinete();
        int cualquierDireccion = 999;

        Ubicacion miNuevaUbicacion = Mockito.mock(Ubicacion.class);
        Mockito.when(miNuevaUbicacion.darPosicionEnX()).thenReturn(cualquierDireccion);
        Mockito.when(miNuevaUbicacion.darPosicionEnY()).thenReturn(cualquierDireccion*2);
        jinete.moverUnidad(miNuevaUbicacion);
        Ubicacion ubicacionModificada = jinete.getUbicacion();

        assertEquals(cualquierDireccion,ubicacionModificada.darPosicionEnX());
        assertEquals(cualquierDireccion*2,ubicacionModificada.darPosicionEnY());
    }*/

    @Test
    public void test04JineteAtacaADistanciaYSaca15PuntosDeVida() {
        Jinete jinete = new Jinete();
        Catapulta oponente = new Catapulta();
        double vida= oponente.getPuntosVida();
        jinete.setModoAtaqueADistancia();
        jinete.atacar(oponente);
        assertEquals(vida-15,oponente.getPuntosVida(),0.05);
    }

    @Test
    public void test05JineteAtacaCuerpoACuerpoYSaca5PuntosDeVida() {
        Jinete jinete = new Jinete();
        Catapulta oponente = new Catapulta();
        double vida= oponente.getPuntosVida();
        jinete.setModoAtaqueMele();
        jinete.atacar(oponente);
        assertEquals(vida-5,oponente.getPuntosVida(),0.05);
    }

    @Test
    public void test06JineteAlternaAtaquesSacando5_15_5PuntosDeVida() {
        Jinete jinete = new Jinete();
        Catapulta oponente = new Catapulta();
        double vida= oponente.getPuntosVida();
        jinete.setModoAtaqueMele();
        jinete.atacar(oponente);
        assertEquals(vida-5,oponente.getPuntosVida(),0.05);

        vida -= 5;
        jinete.setModoAtaqueADistancia();
        jinete.atacar(oponente);
        assertEquals(vida-15,oponente.getPuntosVida(),0.05);

        vida-=15;
        jinete.setModoAtaqueMele();
        jinete.atacar(oponente);
        assertEquals(vida-5,oponente.getPuntosVida(),0.05);
    }


}
