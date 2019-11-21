package AlgoChessTest.UnidadesTest;

import model.AlgoChess.Equipos.Equipo;
import model.AlgoChess.Unidades.Curandero;
import model.AlgoChess.Unidades.Soldado;
import org.junit.Test;
import org.junit.Assert;

import static org.mockito.Mockito.mock;

public class CuranderoTest {

    //Habria que hacer que no pueda curar mas de la vida maxima//
    //Tambien deberia ser imposible revivir a piezas, una vez que mueren son eliminadas//
    @Test
    public void MatoUnSoldadoYLoCuroMurioDevuelveFalse() {

        Equipo equipoMock = mock(Equipo.class);
        int i = 0;
        Soldado soldado1 = new Soldado(equipoMock);
        Soldado soldado2 = new Soldado(equipoMock);
        while (i < 10) {
            soldado1.atacar(soldado2);
            i++;
        }
        Curandero curandero = new Curandero(equipoMock);
        Assert.assertTrue(soldado2.murio());
        curandero.atacar(soldado2);
        Assert.assertFalse(soldado2.murio());
    }


    @Test
    public void sufreDanioLetalMurioDevuelveTrue() {
        Equipo equipoMock = mock(Equipo.class);
        Curandero curandero = new Curandero(equipoMock);
        curandero.sufrirDanio(77);
        Assert.assertTrue(curandero.murio());
    }

    @Test
    public void sufreDanioNoLetalMurioDevuelveFalse() {
        Equipo equipoMock = mock(Equipo.class);
        Curandero curandero = new Curandero(equipoMock);
        curandero.sufrirDanio(74);
        Assert.assertFalse(curandero.murio());
    }
}