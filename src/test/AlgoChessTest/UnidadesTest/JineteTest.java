package AlgoChessTest.UnidadesTest;

import model.AlgoChess.Equipos.Equipo;
import model.AlgoChess.Unidades.Curandero;
import model.AlgoChess.Unidades.Jinete;
import model.AlgoChess.Unidades.Soldado;
import org.junit.Assert;
import org.junit.Test;

import static org.mockito.Mockito.mock;

public class JineteTest {

    @Test
    public void atacoCuranderoCatorceVecesMurioDevuelveFalse() {
        Equipo equipoMock = mock(Equipo.class);

        int i = 0;

        Jinete jinete = new Jinete (equipoMock);
        Curandero curandero = new Curandero (equipoMock);
        while (i<14) {
            jinete.atacar(curandero);
            i++;
        }
        Assert.assertFalse(curandero.murio());
    }

    @Test
    public void atacoCuranderoQuinceVecesMurioDevuelveTrue() {
        Equipo equipoMock = mock(Equipo.class);
        int i = 0;
        Jinete jinete = new Jinete (equipoMock);
        Curandero curandero = new Curandero (equipoMock);
        while (i<15) {
            jinete.atacar(curandero);
            i++;
        }
        Assert.assertTrue(curandero.murio());
    }

    @Test
    public void atacoSoldadoVeinteVecesMurioDevuelveTrue() {
        Equipo equipoMock = mock(Equipo.class);
        int i = 0;
        Jinete jinete = new Jinete (equipoMock);
        Soldado soldado = new Soldado (equipoMock);
        while (i<20) {
            jinete.atacar(soldado);
            i++;
        }
        Assert.assertTrue(soldado.murio());
    }

    @Test
    public void sufreDanioLetalMurioDevuelveTrue () {
        Equipo equipoMock = mock(Equipo.class);
        Jinete jinete = new Jinete (equipoMock);
        jinete.sufrirDanio(103);
        Assert.assertTrue(jinete.murio());
    }

    @Test
    public void sufreDanioNoLetalMurioDevuelveFalse () {
        Equipo equipoMock = mock(Equipo.class);
        Jinete jinete = new Jinete (equipoMock);
        jinete.sufrirDanio(78);
        Assert.assertFalse (jinete.murio());
    }

}
