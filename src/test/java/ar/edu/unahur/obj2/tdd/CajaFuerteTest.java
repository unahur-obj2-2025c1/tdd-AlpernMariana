package ar.edu.unahur.obj2.tdd;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;


public class CajaFuerteTest {

    private CajaFuerte caja = new CajaFuerte();

    @Test
    public void queLaCajaFuerteEsteAbiertaAlCrearse(){
       assertTrue(caja.estaAbierta());
    }

    @Test
    public void queSePuedaCerrarLaCajaFuerteConUnCodigo(){
        caja.cerrar(1234);
        assertFalse(caja.estaAbierta());
    }

    @Test
    public void queSePuedaAbrirLaCajaFuerteConElCodigoCorrecto(){
        caja.cerrar(1234);
        caja.abrir(1234);
        assertTrue(caja.estaAbierta());
    }

    @Test
    public void queNoSeAbraLaCajaFuerteConElCodigoIncorrecto(){
        caja.cerrar(1234);
        caja.abrir(4321);
        assertFalse(caja.estaAbierta());
    }

    @Test
    public void queNoSePuedeCambiarElCodigoUnaVezCerradaLaCaja(){
        caja.cerrar(1234);
        caja.cerrar(5678);
        caja.abrir(1234);
        assertTrue(caja.estaAbierta());
    }
    @Test
    public void queSeBloqueaLuegoDeTresIntentosFallidos(){
        caja.cerrar(1234);
        caja.abrir(2345);
        caja.abrir(3456);
        caja.abrir(4567);
        assertTrue(caja.estaBloqueada());
    }
    @Test
    public void queLuegoDeBloqueadaNoPuedaAbrirse(){
        caja.cerrar(1234);
        caja.abrir(2345);
        caja.abrir(3456);
        caja.abrir(4567);
        caja.abrir(1234);
        assertFalse(caja.estaAbierta());
        assertTrue(caja.estaBloqueada());
    }
    @Test
    public void queSeReseteanLosIntentosFallidosTrasAperturaCorrecta(){
        caja.cerrar(1234);
        caja.abrir(2345);
        caja.abrir(3456);
        caja.abrir(1234);
        caja.cerrar(1234);
        caja.abrir(4567);
        assertFalse(caja.estaBloqueada());
    }
}
