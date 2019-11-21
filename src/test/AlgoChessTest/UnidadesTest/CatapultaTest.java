package AlgoChessTest.UnidadesTest;

import model.AlgoChess.Equipos.Equipo;
import model.AlgoChess.Tablero.Casillero;
import model.AlgoChess.Unidades.Catapulta;
import model.AlgoChess.Unidades.Curandero;
import model.AlgoChess.Unidades.Soldado;
import org.junit.Test;
import org.junit.Assert;

import static org.mockito.Mockito.mock;


public class CatapultaTest {

    @Test
    public void atacoCincoVecesASoldadoMurioDevuelveTrue() {
        int i = 0;
        Equipo equipoMock = mock(Equipo.class);
        Catapulta catapulta = new Catapulta (equipoMock);
        Soldado soldado = new Soldado (equipoMock);
        while (i<10) {
            catapulta.atacar(soldado);
            i++;
        }
        Assert.assertTrue(soldado.murio());

    }

    @Test
    public void atacoTresVecesACuranderoMurioDevuelveFalse() {
        int i = 0;
        Equipo equipoMock = mock(Equipo.class);
        Catapulta catapulta = new Catapulta (equipoMock);
        Curandero curandero = new Curandero (equipoMock);
        while (i<3) {
            catapulta.atacar(curandero);
            i++;
        }
        Assert.assertFalse(curandero.murio());
    }

    @Test
    public void atacoCuatroVecesACuranderoMurioDevuelveTrue() {
        int i = 0;
        Equipo equipoMock = mock(Equipo.class);
        Catapulta catapulta = new Catapulta (equipoMock);
        Curandero curandero = new Curandero (equipoMock);
        while (i<4) {
            catapulta.atacar(curandero);
            i++;
        }
        Assert.assertTrue(curandero.murio());
    }

    @Test
    public void sufreDanioLetalMurioDevuelveTrue () {
        Equipo equipoMock = mock(Equipo.class);
        Catapulta catapulta = new Catapulta (equipoMock);
        catapulta.sufrirDanio(51);
        Assert.assertTrue(catapulta.murio());
    }

    @Test
    public void sufreDanioNoLetalMurioDevuelveFalse () {
        Equipo equipoMock = mock(Equipo.class);
        Catapulta catapulta = new Catapulta (equipoMock);
        catapulta.sufrirDanio(48);
        Assert.assertFalse (catapulta.murio());
    }


}
