package pieza;

import org.junit.Test;
import pieza.ataque.DistanciaDeAtaqueInvalidaException;
import pieza.tipos.Catapulta;
import pieza.tipos.Jinete;


import static org.junit.Assert.assertEquals;

public class JineteTest {
    @Test
    public void test01JineteTieneCosto1() {
        Jinete jinete = new Jinete(1);
        assertEquals(3, jinete.getCosto());
    }

    @Test
    public void test02JineteIniciaCon100PuntosDeVida() {
        Jinete jinete = new Jinete(1);
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
    public void test04JineteAtacaADistanciaYSaca15PuntosDeVida() throws UnidadEstaMuertaException, DistanciaDeAtaqueInvalidaException {
        Jinete jinete = new Jinete(1);
        jinete.setUbicacion(new Ubicacion (1,1));
        Catapulta oponente = new Catapulta(2);
        oponente.setUbicacion(new Ubicacion (4,4));
        oponente.enZonaAliada();
        double vida= oponente.getPuntosVida();
        jinete.setModoMedio();
        jinete.ejecutarUnModoDeAtaque(oponente);
        assertEquals(vida-15,oponente.getPuntosVida(),0);
    }

    @Test
    public void test05JineteAtacaCuerpoACuerpoYSaca5PuntosDeVida() throws UnidadEstaMuertaException, DistanciaDeAtaqueInvalidaException {
        Jinete jinete = new Jinete(1);
        jinete.setUbicacion(new Ubicacion (1,1));
        Catapulta oponente = new Catapulta(2);
        oponente.setUbicacion(new Ubicacion (2,1));
        oponente.enZonaAliada();
        double vida= oponente.getPuntosVida();
        jinete.setModoCuerpoCuerpo();
        jinete.ejecutarUnModoDeAtaque(oponente);
        assertEquals(vida-5,oponente.getPuntosVida(),0);
    }

    @Test
    public void test06JineteAlternaAtaquesSacando5_15_5PuntosDeVida() throws UnidadEstaMuertaException, DistanciaDeAtaqueInvalidaException {

        Jinete jinete = new Jinete(1);
        jinete.setUbicacion(new Ubicacion (1,1));
        Catapulta oponente = new Catapulta(2);
        oponente.setUbicacion(new Ubicacion (2,2));

        double vida= oponente.getPuntosVida();

        oponente.enZonaAliada();

        jinete.setModoCuerpoCuerpo();
        jinete.ejecutarUnModoDeAtaque(oponente);
        assertEquals(vida-5,oponente.getPuntosVida(),0.0);

        jinete.setModoMedio();
        oponente.setUbicacion(new Ubicacion (4,4));
        jinete.ejecutarUnModoDeAtaque(oponente);
        assertEquals(vida-5-15,oponente.getPuntosVida(),0.0);

        jinete.setModoCuerpoCuerpo();
        oponente.setUbicacion(new Ubicacion (2,1));
        jinete.ejecutarUnModoDeAtaque(oponente);
        assertEquals(vida-5-15-5,oponente.getPuntosVida(),0.0);
    }


}
